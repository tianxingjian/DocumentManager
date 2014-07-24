package com.sanbao.it.action;

import java.io.File;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.service.UploadFile;
import com.sanbao.it.service.impl.UploadServiceImpl;

public class UploadAction extends ActionSupport {

	/**
	 * @author Angelo
	 */
	private static final long serialVersionUID = 1L;

	// 封装上传文件域的属性
	private File file;
	// 封装上传文件类型的属性
	private String fileContentType;
	// 封装上传文件名的属性
	private String fileFileName;
	// 接受依赖注入的属性
	private String savePath;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		String realpath = getSavePath();
		System.out.println("realpath: " + realpath);
		if (file != null) {
			File savefile = new File(new File(realpath), fileFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(file, savefile);
			ActionContext.getContext().put("message", "文件上传成功");
		}
		// 在数据库中存储对应的文件信息
		Document doc = new Document();
		doc.setAuthor("admin");
		doc.setCategory("it");
		doc.setDocumentId(String.valueOf(System.currentTimeMillis() / 1000));
		doc.setDownloadcount(0);
		// doc.setFilename(fileFileName.substring(0,
		// fileFileName.lastIndexOf(".")));
		doc.setFilename(fileFileName);
		doc.setFiletype(getType(fileContentType));
		doc.setUploadtime(new Date(System.currentTimeMillis()));
		UploadFile upload = new UploadServiceImpl();
		upload.saveFile(doc);
		return "success";
	}

	private static String getType(String type) {
		System.out.println(type);
		switch (type) {
		case "application/zip":
			return "zip";
		case "application/excel":
		case "application/vnd.ms-excel":
			return "excel";
		case "application/pdf":
			return "pdf";
		case "application/msword":
			return "doc";
		case "application/vnd.ms-powerpoint":
			return "ppt";
		case "text/plain":
			return "txt";
		case "application/octet-stream":
			return "txt";
		default:
			return "";
		}
	}
}

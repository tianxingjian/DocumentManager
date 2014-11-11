package com.sanbao.it.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanbao.it.service.UpdateFile;
import com.sanbao.it.service.impl.UpdateServiceImpl;

public class DeleteAction extends ActionSupport {

	/**
	 * @author Angelo
	 */
	private static final long serialVersionUID = 1L;

	private String documentId;

	private String savePath;

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String execute() throws IOException {
		// 删除数据库中文件信息
		UpdateFile delete = new UpdateServiceImpl();
		delete.deleteFile(documentId);

		// 删除服务器中相应文件
		String realpath = getSavePath();
		System.out.println("delete realpath: " + realpath);
		File file = new File(new File(realpath), documentId);
		FileUtils.deleteQuietly(file);
		return SUCCESS;
	}

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(
				this.savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

}

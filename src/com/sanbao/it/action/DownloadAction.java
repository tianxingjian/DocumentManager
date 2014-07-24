package com.sanbao.it.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.service.SearchFile;
import com.sanbao.it.service.UpdateFile;
import com.sanbao.it.service.impl.SearchServiceImpl;
import com.sanbao.it.service.impl.UpdateServiceImpl;

public class DownloadAction extends ActionSupport {

	/**
	 * @author Angelo
	 */
	private static final long serialVersionUID = 1L;

	private String documentId;

	private String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public InputStream getDownloadFile() throws Exception {
		SearchFile search = new SearchServiceImpl();
		Document doc = search.searchById(documentId);
		filename = doc.getFilename();
		InputStream in = ServletActionContext.getServletContext()
				.getResourceAsStream("/Document/" + filename);
		//转码，解决下载界面中文不显示问题
		filename = new String(filename.getBytes("gb2312"), "iso8859-1");
		//下载次数加一
		doc.setDownloadcount(doc.getDownloadcount() + 1);
		UpdateFile update = new UpdateServiceImpl();
		update.updateFile(doc);
		return in;
	}

	public String execute() {
		return SUCCESS;
	}

}

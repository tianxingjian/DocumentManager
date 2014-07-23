package com.sanbao.it.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.service.ShowFile;
import com.sanbao.it.service.impl.ShowServiceImpl;

public class ShowAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Document> documents;

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public String execute() {
		ShowFile show = new ShowServiceImpl();
		documents = show.showDocument();
		return SUCCESS;
	}
}

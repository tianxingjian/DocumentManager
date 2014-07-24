package com.sanbao.it.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.service.SearchFile;
import com.sanbao.it.service.impl.SearchServiceImpl;

public class SearchAction extends ActionSupport {
	/**
	 * @author Angelo
	 */
	private static final long serialVersionUID = 1L;
	private String docname;

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	private List<Document> documents;

	

	public String execute() {
		SearchFile search = new SearchServiceImpl();
		setDocuments(search.searchByName(docname));
		return SUCCESS;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

}

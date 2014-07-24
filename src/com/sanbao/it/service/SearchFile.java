package com.sanbao.it.service;

import java.util.List;

import com.sanbao.it.ORM.Document;

public interface SearchFile {
	public Document searchById(String documentId);
	
	public List<Document> searchByName(String filename);
}

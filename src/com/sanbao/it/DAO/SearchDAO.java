package com.sanbao.it.DAO;

import java.util.List;

import com.sanbao.it.ORM.Document;

public interface SearchDAO {
	public Document searchById(String documentId);
	
	public List<Document> searchByName(String filename);
}

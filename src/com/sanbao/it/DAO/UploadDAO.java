package com.sanbao.it.DAO;

import com.sanbao.it.ORM.Document;

public interface UploadDAO {
	public void saveDocument(Document doc);
	
	public void updateDocument(Document doc);
}

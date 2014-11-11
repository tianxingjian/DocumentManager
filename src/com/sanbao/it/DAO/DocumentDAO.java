package com.sanbao.it.DAO;

import com.sanbao.it.ORM.Document;

public interface DocumentDAO {
	public void saveDocument(Document doc);

	public void updateDocument(Document doc);

	public void deleteDocument(String documentId);
}

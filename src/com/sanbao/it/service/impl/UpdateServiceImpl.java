package com.sanbao.it.service.impl;

import com.sanbao.it.DAO.DocumentDAO;
import com.sanbao.it.DAO.impl.DocumentDAOImpl;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.service.UpdateFile;

public class UpdateServiceImpl implements UpdateFile {

	@Override
	public void updateFile(Document doc) {
		DocumentDAO update = new DocumentDAOImpl();
		update.updateDocument(doc);
	}

	@Override
	public void deleteFile(String documentId) {
		DocumentDAO delete = new DocumentDAOImpl();
		delete.deleteDocument(documentId);
		
	}

}

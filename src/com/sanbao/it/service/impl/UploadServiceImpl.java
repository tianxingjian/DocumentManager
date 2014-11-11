package com.sanbao.it.service.impl;

import com.sanbao.it.DAO.DocumentDAO;
import com.sanbao.it.DAO.impl.DocumentDAOImpl;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.service.UploadFile;

public class UploadServiceImpl implements UploadFile {

	@Override
	public void saveFile(Document doc) {
		DocumentDAO upload = new DocumentDAOImpl();
		upload.saveDocument(doc);
	}

}

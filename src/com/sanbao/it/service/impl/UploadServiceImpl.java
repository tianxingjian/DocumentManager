package com.sanbao.it.service.impl;

import com.sanbao.it.DAO.UploadDAO;
import com.sanbao.it.DAO.impl.UploadDAOImpl;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.service.UploadFile;

public class UploadServiceImpl implements UploadFile {

	@Override
	public void saveFile(Document doc) {
		UploadDAO upload = new UploadDAOImpl();
		upload.saveDocument(doc);
	}

}

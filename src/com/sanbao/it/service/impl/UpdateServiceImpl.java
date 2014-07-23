package com.sanbao.it.service.impl;

import com.sanbao.it.DAO.UploadDAO;
import com.sanbao.it.DAO.impl.UploadDAOImpl;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.service.UpdateFile;

public class UpdateServiceImpl implements UpdateFile {

	@Override
	public void updateFile(Document doc) {
		UploadDAO update = new UploadDAOImpl();
		update.updateDocument(doc);
	}

}

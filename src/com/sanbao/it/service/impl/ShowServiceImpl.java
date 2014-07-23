package com.sanbao.it.service.impl;

import java.util.List;

import com.sanbao.it.DAO.ShowDAO;
import com.sanbao.it.DAO.impl.ShowDAOImpl;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.service.ShowFile;

public class ShowServiceImpl implements ShowFile {

	@Override
	public List<Document> showDocument() {
		ShowDAO show = new ShowDAOImpl();
		return show.getDocument();
	}

}

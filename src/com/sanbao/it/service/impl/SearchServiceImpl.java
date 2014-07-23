package com.sanbao.it.service.impl;

import com.sanbao.it.DAO.SearchDAO;
import com.sanbao.it.DAO.impl.SearchDAOImpl;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.service.SearchFile;

public class SearchServiceImpl implements SearchFile {

	@Override
	public Document searchById(String documentId) {
		SearchDAO search = new SearchDAOImpl();
		return search.searchById(documentId);
	}

}

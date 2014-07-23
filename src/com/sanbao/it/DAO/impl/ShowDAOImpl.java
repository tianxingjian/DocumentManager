package com.sanbao.it.DAO.impl;

import java.util.List;

import org.hibernate.Query;

import com.sanbao.it.DAO.ShowDAO;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.util.HibernateUtil;

public class ShowDAOImpl implements ShowDAO {

	@Override
	public List<Document> getDocument() {
		org.hibernate.Session session = HibernateUtil.openSession();
		String hql = "from Document order by documentId desc, filename asc";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Document> list = query.list();

		return list;
	}

}

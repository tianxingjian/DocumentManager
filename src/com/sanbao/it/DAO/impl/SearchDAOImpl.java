package com.sanbao.it.DAO.impl;

import java.util.List;

import org.hibernate.Query;

import com.sanbao.it.DAO.SearchDAO;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.util.HibernateUtil;

public class SearchDAOImpl implements SearchDAO {

	@Override
	public Document searchById(String documentId) {
		org.hibernate.Session session = HibernateUtil.openSession();
		String hql = "from Document where documentId=:id";
		Query query = session.createQuery(hql);
		query.setString("id", documentId);
		@SuppressWarnings("unchecked")
		List<Document> list = query.list();
		return list.get(0);
	}

	@Override
	public List<Document> searchByName(String filename) {
		org.hibernate.Session session = HibernateUtil.openSession();
		String hql = "from Document where filename like :name order by filename";
		Query query = session.createQuery(hql);
		query.setString("name", "%"+filename +"%");
		@SuppressWarnings("unchecked")
		List<Document> list = query.list();
		return list;
	}

}

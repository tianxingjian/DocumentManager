package com.sanbao.it.DAO.impl;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.sanbao.it.DAO.DocumentDAO;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.util.HibernateUtil;

public class DocumentDAOImpl implements DocumentDAO {

	@Override
	public void saveDocument(Document doc) {
		// 开启session,与HttpSession完全没有任何关系，相当于一个数据库连接对象
		org.hibernate.Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		// 开启事务
		try {
			// 插入
			session.save(doc);
			tx.commit();
		} catch (Exception ex) {
			if (null != tx) {
				tx.rollback();
				// 失败回滚
			}

		} finally {
			// 关闭session
			HibernateUtil.close(session);
		}

	}

	@Override
	public void updateDocument(Document doc) {
		// 开启session,与HttpSession完全没有任何关系，相当于一个数据库连接对象
		org.hibernate.Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		// 开启事务
		try {
			// 插入
			session.update(doc);
			tx.commit();
		} catch (Exception ex) {
			if (null != tx) {
				tx.rollback();
				// 失败回滚
			}

		} finally {
			// 关闭session
			HibernateUtil.close(session);
		}

	}

	@Override
	public void deleteDocument(String documentId) {
		// 开启session,与HttpSession完全没有任何关系，相当于一个数据库连接对象
		org.hibernate.Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete Document as d where d.documentId=?";
		Query query = session.createQuery(hql);
		query.setString(0, documentId);
		// 开启事务
		try {
			// 插入
			query.executeUpdate();
			tx.commit();
		} catch (Exception ex) {
			if (null != tx) {
				tx.rollback();
				// 失败回滚
			}

		} finally {
			// 关闭session
			HibernateUtil.close(session);
		}

	}

}

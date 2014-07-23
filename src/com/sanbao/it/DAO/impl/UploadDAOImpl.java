package com.sanbao.it.DAO.impl;

import org.hibernate.Transaction;

import com.sanbao.it.DAO.UploadDAO;
import com.sanbao.it.ORM.Document;
import com.sanbao.it.util.HibernateUtil;

public class UploadDAOImpl implements UploadDAO {

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

}

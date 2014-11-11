package com.sanbao.it.DAO.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sanbao.it.DAO.UserDAO;
import com.sanbao.it.ORM.User;
import com.sanbao.it.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public User getUser(String user_id) {
		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("user_id", user_id));
		User user = (User)criteria.uniqueResult();
		HibernateUtil.close(session);
		return user;
	}

}

package com.sanbao.it.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	// private HibernateUtil() {
	// }

	static {
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session openSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

	public static void close(Session session) {
		if (session != null) {
			session.close();
		}
	}
}

package com.hibernate.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	
	static SessionFactory sessionFactory;
	static Configuration configuration;
	static {
		try {
			configuration=new Configuration();
			configuration.configure();
			sessionFactory=configuration.buildSessionFactory();
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
	public static void closeSession(Session s) {
		s.close();
	}

}

package com.hibernate.operations;

import org.hibernate.Session;


import com.hibernate.model.Emp;
import com.hibernate.utility.HibernateUtility;

public class SelectOperation {
	public static void main(String[] args) {
		Session session=null;
		try {
			session =HibernateUtility.getSession();
			Emp e=session.get(Emp.class, 1);
			System.out.println(e);
			e=session.get(Emp.class, 1);
			System.out.println(e);
			session.evict(e);
			e=session.get(Emp.class, 1);
			System.out.println(e);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		HibernateUtility.closeSession(session);
	}
}

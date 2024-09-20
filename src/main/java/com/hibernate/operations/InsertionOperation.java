package com.hibernate.operations;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Emp;
import com.hibernate.utility.HibernateUtility;

public class InsertionOperation {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		try {
			session =HibernateUtility.getSession();
			transaction=session.beginTransaction();
			  Emp emp=new Emp();
			  emp.setName("dhoni");
				session.persist(emp);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		transaction.commit();		
		
		HibernateUtility.closeSession(session);
	}
}

package com.hibernate.operations;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Emp;
import com.hibernate.utility.HibernateUtility;

public class DeleteOperation {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session=HibernateUtility.getSession();
			transaction=session.beginTransaction();
			Emp e=session.get(Emp.class, 3);
			System.out.println(e.getId());
			session.delete(e);
			flag=true;
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
		}
		HibernateUtility.closeSession(session);
	}

}

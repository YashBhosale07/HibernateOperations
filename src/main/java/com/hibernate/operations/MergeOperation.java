package com.hibernate.operations;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Emp;
import com.hibernate.utility.HibernateUtility;

public class MergeOperation {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session=HibernateUtility.getSession();
			transaction=session.beginTransaction();
			Emp e=session.get(Emp.class, 1);
			transaction.commit();
			session.close();
			e.setName("kohli");
			session=HibernateUtility.getSession();
			transaction=session.beginTransaction();
			session.merge(e);
			transaction.commit();
			session.close();
			flag=true;
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				HibernateUtility.closeSession(session);
			}else {
				System.out.println("Error happened");
			}
		}
	}
}

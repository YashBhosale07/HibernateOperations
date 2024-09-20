package com.hibernate.operations;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Emp;
import com.hibernate.utility.HibernateUtility;

public class RefreshOperation {
	public static void main(String[] args) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		try {
			session=HibernateUtility.getSession();
			transaction=session.beginTransaction();
			Emp e=session.get(Emp.class, 0);
			System.out.println("Before modification:");
			System.out.println(e.getId());
			System.out.println(e.getName());
			e.setName("dhoni");
			session.update(e);
			transaction.commit();
			System.in.read();
			System.out.println("After modification:");
			System.out.println(e.getId());
			System.out.println(e.getName());
			flag=true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		}finally {
//			if(flag) {
//				transaction.commit();
//			}else {
//				transaction.rollback();
//			}
		}
		HibernateUtility.closeSession(session);
		
		
	}
}

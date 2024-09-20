package com.hibernate.operations;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Emp;
import com.hibernate.utility.HibernateUtility;

public class SaveOrUpdateOperation {
	
	public static void main(String[] args) {
		Session sesion=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			sesion=HibernateUtility.getSession();
			transaction=sesion.beginTransaction();
			Emp emp=new Emp();
			emp.setId(3);
			emp.setName("dhoni");
			sesion.saveOrUpdate(emp);
			flag=true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
			}else {
				transaction.rollback();
				System.out.println("Cannot perform operation");
			}
		}
		HibernateUtility.closeSession(sesion);
	}	
	
}

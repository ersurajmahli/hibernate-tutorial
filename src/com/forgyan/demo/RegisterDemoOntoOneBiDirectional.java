package com.forgyan.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.forgyan.entity.PrimaryDetails;
import com.forgyan.entity.Register;

public class RegisterDemoOntoOneBiDirectional {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Register.class)
										.addAnnotatedClass(PrimaryDetails.class)
										.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		save(factory, session);

	}
	public static void save(SessionFactory factory, Session session) {	
		try {
			
			session.beginTransaction();
			
			// create objects of Register & PrimaryDetails
			Register reg = new 
					Register("Sanju", "Mahli", "sanjumahli@gmail.com", "123Password");
			PrimaryDetails pDetails = new
					PrimaryDetails("9730121509", "9770752456", "MP00/123432");
			
			// associates the objects
			reg.setPrimaryDetails(pDetails);
			pDetails.setRegister(reg);
			
			// it will save objects of Register & PrimaryDetails
			session.save(pDetails);
			
			
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
	public static void delete(SessionFactory factory, Session session) {
		try {
			session.beginTransaction();
			
			Register register = session.get(Register.class, 5);
			System.out.println("Deleteing Register "+register);
			session.delete(register);
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}
}

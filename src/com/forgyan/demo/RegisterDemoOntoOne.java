package com.forgyan.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.forgyan.entity.AddressDetails;
import com.forgyan.entity.PrimaryDetails;
import com.forgyan.entity.Register;

public class RegisterDemoOntoOne {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Register.class)
										.addAnnotatedClass(PrimaryDetails.class)
										.addAnnotatedClass(AddressDetails.class)
										.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		save(factory, session);

	}
	public static void save(SessionFactory factory, Session session) {	
		try {
			
			// create objects of Register & PrimaryDetails
			Register reg = new 
					Register("Shashi", "Mahli", "shashi.mahli@gmail.com", "123Password");
			PrimaryDetails pDetails = new
					PrimaryDetails("9930121509", "9790752456", "MP00/123432");
			
			// associates the objects
			//reg.setRegisterId(6);
			pDetails.setRegister(reg);
			
			session.beginTransaction();
			
			// it will save objects of Register & PrimaryDetails
			session.save(pDetails);
			
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}
	
	public static void delete(SessionFactory factory, Session session) {
		try {
			session.beginTransaction();
			
			PrimaryDetails details = session.get(PrimaryDetails.class, 1);
			System.out.println(details);
			session.delete(details);
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}
}

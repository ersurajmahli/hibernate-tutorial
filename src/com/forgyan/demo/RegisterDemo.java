package com.forgyan.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.forgyan.entity.Register;
import com.forgyan.entity.manytoone.AddressDetails;
import com.forgyan.entity.onetoone.PrimaryDetails;

public class RegisterDemo {

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
			
			// Create a Register Object
			System.out.println("Createing a Register object");
			Register register = new Register("Kapil", "Choudhary", "kapil.ch@forgyan.com", "1234Pass");
			
			// start a transaction
			session.beginTransaction();
			
			// save the Register object
			System.out.println("Saving the Object..");
			session.save(register);
			
			System.out.println("Saved object :"+register);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}

	public static void read(SessionFactory factory, Session session) {
		try {
			session.beginTransaction();
			
			// retrieve data 
			Register reg = session.get(Register.class, 4);
			
			System.out.println("Get object :"+reg);
			
			// commit the transaction
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

	public static void readAll(SessionFactory factory, Session session) {
		try {
			
			session.beginTransaction();
			
			// retrieve data 
			List<Register> reg = session.createQuery("from Register r where lastName='Mahli'").list();
			
			System.out.println("Get object :"+reg);
			
			// commit the transaction
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

	public static void update(SessionFactory factory, Session session) {
		try {
			session.beginTransaction();

			//Register reg = session.get(Register.class, 4);
			
			//reg.setEmailId("kapil.ch@gmail.com");
			
			session.createQuery("update Register s set s.emailId='kapil.ch@yahoo.com' where s.id=5").executeUpdate();
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

	public static void delete(SessionFactory factory, Session session) {
		try {
			session.beginTransaction();
			//Register reg = session.get(Register.class, 4);
			//session.delete(reg);
			session.createQuery("delete from Register where id=5").executeUpdate();
			
			session.getTransaction().commit();
		}catch (Exception e) {
			factory.close();
		}
		
	}
}

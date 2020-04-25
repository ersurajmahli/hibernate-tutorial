package com.forgyan.demo;

import java.lang.Thread.State;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.forgyan.entity.AddressDetails;
import com.forgyan.entity.Degree;
import com.forgyan.entity.PrimaryDetails;
import com.forgyan.entity.Register;

public class OneToMantBiDirectionalDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory =  new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Register.class)
				.addAnnotatedClass(PrimaryDetails.class)
				.addAnnotatedClass(AddressDetails.class)
				.addAnnotatedClass(Degree.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		delete(factory, session);

	}
	
	public static void save(SessionFactory factory, Session session) {
		try {
			session.beginTransaction();
			Register register = session.get(Register.class, 19);
			System.out.println(register);
			
			Degree degree1 = new Degree("12th", "HSE", "12-03-2009", "12-05-2011", "2nd", "JNV Lohardaga", "CBSE");
			register.addDegree(degree1);
			//session.save(register);
			System.out.println("Adress :"+register.getAddressDetails());
			System.out.println("Primary :"+register.getPrimaryDetails());
			
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}
	
	public static void delete(SessionFactory factory, Session session) {
		try {
			session.beginTransaction();
			Register register = session.get(Register.class, 19);
			session.delete(register);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}

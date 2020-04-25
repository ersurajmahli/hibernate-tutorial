package com.forgyan.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.forgyan.entity.AddressDetails;
import com.forgyan.entity.PrimaryDetails;
import com.forgyan.entity.Register;

public class RegisterDemonManyToOne {
	
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
		read(factory, session);
	}
	
	public static void save(SessionFactory factory, Session session) {
		try {
			
			AddressDetails address = new AddressDetails("HN 46, Opa", "Lohardaga", "Jharkhand", "835213", "06526-456001", "06526-456001", "Y");
			AddressDetails address1 = new AddressDetails("HN 47, Opawa", "Lohardaga", "Jharkhand", "835213", "06526-456001", "06526-456001", "Y");
			
			//Register register = new Register("Munshi", "Mahli", "munshi.mahli@gmail.com", "$$9090mN");
		
			
			// System.out.println("Reg :"+obj);
			session.beginTransaction();
			 
			Register register = session.get(Register.class, 19);
			
			register.add(address);
			register.add(address1);
			//register.add(address);
			session.save(address);
			session.save(address1);
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
	}
	
	public static void read(SessionFactory factory, Session session){
		try {
		
			session.beginTransaction();
			
			Query<Register> query = session.createQuery("select r from Register r JOIN FETCH r.addressDetails "
					+ "WHERE r.registerId=:id", Register.class);
			
			query.setParameter("id", 19);
			
			
			Register register = query.getSingleResult();
			System.out.println(register);
			//Register register = session.get(Register.class, 19);
			
			//System.out.println("AddressDetails :"+register.getAddressDetails());
			
			session.getTransaction().commit();
			System.out.println("AddressDetails :"+register.getAddressDetails());
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
	}
}

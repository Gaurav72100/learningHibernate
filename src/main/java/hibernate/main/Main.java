package hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import Config.JavaBasedConfig;
import hibernate.entity.Employee;


public class Main {

	public static void main(String[] args) {
		
		Employee emp = new Employee("Mukesh","male",20000);
		
		//Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		   SessionFactory sessionfactory= cfg.buildSessionFactory();
//		  Session session = sessionfactory.openSession();
//		  
		
		/*
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata data = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory sf = data.buildSessionFactory();
		Session session = sf.openSession();
		  Transaction transaction = session.beginTransaction();
		  session.persist(emp);
		  transaction.commit();
		  System.out.println("Executed successfully");
		  */
		
		SessionFactory sf = JavaBasedConfig.getSessionFactory();
		Session session = sf.openSession();
		session.persist(emp);
		session.beginTransaction().commit();
		sf.close();
		System.out.println("Successful");
	}
}

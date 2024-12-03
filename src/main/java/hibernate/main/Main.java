package hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate.entity.Employee;


public class Main {

	public static void main(String[] args) {
		
		//Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		   SessionFactory sessionfactory= cfg.buildSessionFactory();
//		  Session session = sessionfactory.openSession();
//		  
		
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata data = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory sf = data.buildSessionFactory();
		Session session = sf.openSession();
		  session.beginTransaction().commit();;
		  System.out.println("Executed successfully");
		  
		  // Hibernate Query Language
		  
//		  Query q1= session.createQuery("from Employee");
//		  List list =  q1.list();
//		  System.out.println(list);
		  
		  Query q2 = session.createQuery("select max(name) from Empoyee",Employee.class);
		  List<Integer> list1 = q2.list();
		  System.out.println(list1.get(0));
		  
	}
}

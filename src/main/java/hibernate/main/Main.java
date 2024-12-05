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
		//Transaction txt= session.beginTransaction();
		session.beginTransaction().commit();
		  
		 
		  
		  // Hibernate Query Language
		  
		  Query q1= session.createQuery("from Employee");
		  List list =  q1.list();
		  System.out.println(list);
		  
//		  Query q2 = session.createQuery("Select sum(salary) from Empoyee",Employee.class);
//		  List<Integer> list1 = q2.list();
//		  System.out.println(list1.get(0));
		  
//		  How to record with pagination
//		  Query q3 = session.createQuery("from Employee");
//		  q3.setFirstResult(2);
//		  q3.setMaxResults(3);
//		  List list = q3.list();
//		  System.out.println(list);
		  
		  //How to update Query 
		  
//		  Query q4 = session.createQuery("Update Employee set gender =:n where id=:i");
//		  q4.setParameter("n", "female");
//		  q4.setParameter("i","105" );
//		  int status = q4.executeUpdate();// to update query firstly you will to begin transaction then commit at last
//		  System.out.println(status);
		  
//		  txt.commit();
		
		// HQL delete QUERY
		
//		Query q5 = session.createQuery("delete from Employee where id=101");
//		q5.executeUpdate();// to delete query firstly you will to begin transaction then commit at last
//		System.out.println("Executed successfully");
//		  txt.commit();
//		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	}
}

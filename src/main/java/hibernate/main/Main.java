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
import jakarta.persistence.TypedQuery;


public class Main {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata data = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = data.getSessionFactoryBuilder().build();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
	
	
    	TypedQuery<Employee> query = session.createNamedQuery("getEmployeeByName" ,Employee.class);
    	query.setParameter("name", "Amit");    	List<Employee> list = query.getResultList(); 	
   	    System.out.println(list);  
    	
//		Query<Employee> query2 = session.createNamedQuery("findEmployeeById");
//		query2.setParameter("id","101");
//		List<Employee> list1= query2.getResultList();
//		System.out.println(list1);
//				System.out.println("Successfully");
		trans.commit();
		session.close();
		sf.close();
	}
}

package hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Address;
import hibernate.entity.Employee;


public class Main {

	public static void main(String[] args) {
		
	    SessionFactory sf = HibernateUtil.getSessionFactory();
	    Session s1 = sf.openSession();
	    
	   save(s1);
	   Employee em =  s1.get(Employee.class, 1);
	   
		System.out.println(em);
		Address ad = s1.get(Address.class, 1);
		System.out.println(ad);
		System.out.println(ad.getEmployee());

	}
	private static void save(Session s1) {
		Transaction txt = s1.beginTransaction();
    	
    	Employee emp = new Employee();
    	emp.setFirstName("Rahul");
    	emp.setLastName("Singh");
    	
    	Address add = new Address("BudhEnclave","Noida");
    	emp.setAddress(add);
    	add.setEmployee(emp);
    	
    	s1.persist(emp);
    	s1.persist(add);
    	
    	s1.close();
        txt.commit();
	}
}

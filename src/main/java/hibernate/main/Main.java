package hibernate.main;

import java.util.ArrayList;
import java.util.List;

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
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		save(session);
		Employee em = session.get(Employee.class, 1);
		System.out.println(em);
		System.out.println(em.getAddress());
		
		System.out.println("-------------BiDirectional--------------");
		Address adrs = session.get(Address.class, 3);
		System.out.println(adrs);
		System.out.println(adrs.getEmployee());
		
		 
	}
	public static void save(Session session) {
		Transaction txt = session.beginTransaction();
		
		Employee emp = new Employee();
		emp.setName("Pinku Sharma");
		emp.setGender("Male");
		Address add = new Address("KholaPuri","Ahmedabad");
		Address add1 = new Address("KholaPuri1","Ahmedabad");
		Address add2 = new Address("KholaPuri2","Ahmedabad");
		Address add3 = new Address("KholaPuri3","Ahmedabad");
		Address add4 = new Address("KholaPuri4","Ahmedabad");
		
		add.setEmployee(emp);
		add1.setEmployee(emp);
		add2.setEmployee(emp);
		add3.setEmployee(emp);
		add4.setEmployee(emp);
		
		session.persist(add);
		session.persist(add1);
		session.persist(add2);
		session.persist(add3);
		session.persist(add4);
		
		List<Address> addrs = new ArrayList<>();
		addrs.add(add);
		addrs.add(add1);
		addrs.add(add2);
		addrs.add(add3);
		addrs.add(add4);
		
		emp.setAddress(addrs);
		session.persist(emp);
		txt.commit();
		System.out.println("Executed Successfully");
		
		
	}
}

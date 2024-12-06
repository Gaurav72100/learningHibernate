package hibernate.main;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
     static 	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
     static     Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
     static    SessionFactory buld =null;
     
     public static SessionFactory getSessionFactory() {
    	 if(buld==null) {
    		 buld = meta.getSessionFactoryBuilder().build();
    	 }
    	 return buld;
     }
}

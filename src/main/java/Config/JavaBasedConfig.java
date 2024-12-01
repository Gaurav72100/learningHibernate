package Config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class JavaBasedConfig {

	public static SessionFactory getSessionFactory() {
		Properties prop = new Properties();
		prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		prop.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/gaurav");
		prop.put(Environment.USER, "root");
		prop.put(Environment.PASS, "578038");
		prop.put(Environment.HBM2DDL_AUTO, "create");
		prop.put(Environment.SHOW_SQL, "true");
		prop.put(Environment.FORMAT_SQL, "true");
		
		StandardServiceRegistry ssr= new StandardServiceRegistryBuilder().applySettings(prop).build();
		MetadataSources meta = new MetadataSources(ssr);
		meta.addAnnotatedClassName("hibernate.entity.Employee");
		
		return meta.buildMetadata().buildSessionFactory();
	}
}

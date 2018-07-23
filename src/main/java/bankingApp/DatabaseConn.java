package bankingApp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DatabaseConn {
	
	private static SessionFactory sf;

	public static SessionFactory getSessionFactory () {
		
		if(sf==null) {

		Configuration con = new Configuration().configure();

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

		sf = con.buildSessionFactory(reg);
		}
		
		return sf;
	}
	
	

}

package persistence;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Stock;

public class HibernateConfiguration {

	private Session session;
	private SessionFactory factory;
	File mappingDir = new File("resources/hibernateMapping");

	public void initHibernate()  {
		
		
		factory = new Configuration().configure("hibernate.cfg.xml").addDirectory(mappingDir).buildSessionFactory();

		// Create session
		session = factory.getCurrentSession();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public void openSession() {
		if (session.isOpen()) {
			System.out.println("open session");
			session.beginTransaction();
		}

	}

	public void shutDownSession() {
		if (session.isOpen()) {
			session.getTransaction().commit();
			factory.close();

		}

	}
}

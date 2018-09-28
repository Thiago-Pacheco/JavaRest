package br.desafio.thiago.rest.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory = criarSessoes();
	
	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}
	
	private static SessionFactory criarSessoes() {
		
		try {
			
			Configuration configuration = new Configuration().configure();
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
			
			return factory;
			
		} catch (Throwable e) {
			
			System.err.println("Fabrica nao criada");
			
			throw new ExceptionInInitializerError(e);
		}
		
	}
}

package br.com.droid.persistencia.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static HibernateUtil hibernateUtil;
	private SessionFactory factory;
	
	@SuppressWarnings("deprecation")
	private HibernateUtil() {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public static HibernateUtil getInstance(){
		if(hibernateUtil == null){
			try{
			hibernateUtil = new HibernateUtil();
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		return hibernateUtil;
	}
	
	public Session obterSession(){
		return factory.openSession();
	}

}


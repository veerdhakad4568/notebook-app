/*package com.mynotebook.app.utill;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernetUtilConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	public SessionFactory getSessionFactory() {
		SessionFactory sessionFactory= entityManagerFactory.unwrap(SessionFactory.class);
		if(sessionFactory==null)
		{
			throw new NullPointerException("Session is not getting created");
		}
		return sessionFactory;
		
	}
}
*/
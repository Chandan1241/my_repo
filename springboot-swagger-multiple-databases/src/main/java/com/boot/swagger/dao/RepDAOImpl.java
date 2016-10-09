package com.boot.swagger.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RepDAOImpl implements IRepDAO {

	private SessionFactory sessionFactory1;
	private SessionFactory sessionFactory2;

	@Qualifier("databaseEntityManagerFactory1")
	@Autowired
	private EntityManagerFactory databaseEMF1;

	@Qualifier("databaseEntityManagerFactory2")
	@Autowired
	private EntityManagerFactory databaseEMF2;

	@PostConstruct
	public void setUpSession() {
		// not necessary to use sessionFactory, because already entity manager
		// factory is available we can go with it.
		this.sessionFactory1 = databaseEMF1.unwrap(SessionFactory.class);
		this.sessionFactory2 = databaseEMF2.unwrap(SessionFactory.class);
	}

	@Transactional(transactionManager = "databaseTransactionManager1")
	public void insertData() {
		// insert and update logic
		// dummy code
		sessionFactory1.openSession().save(Object.class);
		sessionFactory2.openSession().save(Object.class);
	}

}

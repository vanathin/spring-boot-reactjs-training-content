package com.bank.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.model.Account;

@Component
public class JpaAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("bank");

	private EntityManagerFactory emf;

	@Autowired
	public JpaAccountRepository(EntityManagerFactory emf) {
		logger.info("JpaAccountRepository instance created...");
		this.emf = emf;
	}

	public Account loadAccount(String num) {
		// ..
		EntityManager em = emf.createEntityManager();
		logger.info("loading account " + num);
		Account account = em.find(Account.class, num);
		em.close();
		return account;
	}

	public void updateAccount(Account account) {
		logger.info("updating account ");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(account);
		em.getTransaction().commit();
		em.close();
		// ..
	}

}

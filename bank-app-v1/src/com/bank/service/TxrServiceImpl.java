package com.bank.service;

import org.apache.log4j.Logger;

import com.bank.model.Account;
import com.bank.repository.JdbcAccountRepository;

/*
 * 
 *  design & performance issues
 *  --------------------------
 *  
 *  - tight-coupling b/w dependent & dependency
 *     ==> can't extend with new features easily
 *  - too many duplicate dependency instances are created & discarded
 *     ==> memory/resource use high / slow	
 *  - unit-testing not possible
 *     ==> bug/dev slow	
 * 
 * 		
 * 	 reason for these issues ?
 * 
 * 		==> dependent itself creating it's own dependency
 * 
 * 	 Soln:
 * 
 * 		==> don't create , do lookup on factory
 * 
 * 
 * 	 limitation on factory-lookup :
 * 
 * 		==> factory-location tight-coupling
 * 
 * 	 best-soln :
 * 
 * 		=> don't create/lookup , get/inject-by third-party ( Inversion of Control )
 * 
 * 
 * 
 *
 *
 
 ---------------------------------------------
 OO principles
 ---------------------------------------------
    Single Responsibility Principle
	Open for extension/Closed for modification Principle
	Liskov Substitution Principle
	Interface Segregation Principle
	Dependency Inversion
---------------------------------------------

---------------------------------------------
OO principles
---------------------------------------------

	- creational
	- structural
	- behavior

---------------------------------------------

 *   
 *   
 * 
 */

public class TxrServiceImpl {
	
	private static Logger logger=Logger.getLogger("bank");
	
	public TxrServiceImpl() {
		logger.info("TxrService instance created..");
	}

	public void transfer(double amount, String fromAccNum, String toAccNum) {

		logger.info("Txr initiated..");
		
		JdbcAccountRepository accountRepository = new JdbcAccountRepository();

		// ..
		// load accounts
		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);

		// debit & credit

		// update accounts
		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);
		
		logger.info("Txr finished..");

	}

}

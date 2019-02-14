package com.bank.service;

import org.apache.log4j.Logger;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;

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
 * 		how to implement IOC ?
 * 
 * 			- constructor DI
 * 			- setter
 * 			- field
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

public class TxrServiceImpl implements TxrService {

	private static Logger logger = Logger.getLogger("bank");

	private AccountRepository accountRepository;

	public TxrServiceImpl(AccountRepository accountRepository) {
		logger.info("TxrService instance created..");
		this.accountRepository = accountRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bank.service.TxrService#transfer(double, java.lang.String,
	 * java.lang.String)
	 */
	public void transfer(double amount, String fromAccNum, String toAccNum) {

		logger.info("Txr initiated..");

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

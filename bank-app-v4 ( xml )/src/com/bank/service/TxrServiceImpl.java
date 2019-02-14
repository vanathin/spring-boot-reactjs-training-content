package com.bank.service;

import org.apache.log4j.Logger;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;

public class TxrServiceImpl implements TxrService {

	private static Logger logger = Logger.getLogger("bank");

	private AccountRepository accountRepository;

	public TxrServiceImpl(AccountRepository accountRepository) {
		logger.info("TxrService instance created..");
		this.accountRepository = accountRepository;
	}

	public void transfer(double amount, String fromAccNum, String toAccNum) {

		logger.info("Txr initiated..");

		// ..
		// load accounts
		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);

		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		// update accounts

//		System.out.println(fromAccount);
//		System.out.println(toAccount);

		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);

		logger.info("Txr finished..");

	}

}

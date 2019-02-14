package com.bank;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.repository.AccountRepository;
import com.bank.repository.JdbcAccountRepository;
import com.bank.repository.JpaAccountRepository;
import com.bank.service.TxrService;
import com.bank.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// --------------------------------------
		// init / boot
		// --------------------------------------

		System.out.println("=====================");

		ConfigurableApplicationContext ac = null;
		ac = new ClassPathXmlApplicationContext("bank-app.xml");

		System.out.println("=====================");

		// -------------------------------------
		// use
		// -------------------------------------

		System.out.println("=====================");

		TxrService txrService = ac.getBean(TxrService.class);
		txrService.transfer(100.00, "1", "2");
		System.out.println();
		txrService.transfer(100.00, "2", "1");

		System.out.println("=====================");

		// -------------------------------------
		// destroy
		// -------------------------------------
		// ..

		System.out.println("=====================");
		ac.close();
		System.out.println("=====================");

	}
}

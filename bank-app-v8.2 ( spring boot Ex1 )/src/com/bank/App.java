package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bank.config.BankAppConfiguration;
import com.bank.config.CustomConfigProperties;
import com.bank.service.TxrService;

public class App {

	public static void main(String[] args) {

		// --------------------------------------
		// init / boot
		// --------------------------------------

		System.out.println("=====================");

		ConfigurableApplicationContext ac = null;
		ac = SpringApplication.run(BankAppConfiguration.class, args);

		System.out.println("=====================");

		// -------------------------------------
		// use
		// -------------------------------------

		System.out.println("=====================");

		TxrService txrService = ac.getBean(TxrService.class);
		txrService.transfer(100.00, "1", "2");
		System.out.println();
//		txrService.transfer(100.00, "2", "1");

		CustomConfigProperties properties = ac.getBean(CustomConfigProperties.class);
		System.out.println(properties.getValue());

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

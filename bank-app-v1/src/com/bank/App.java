package com.bank;

import com.bank.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// --------------------------------------
		// init / boot
		// --------------------------------------

		System.out.println("=====================");

		TxrServiceImpl txrService = new TxrServiceImpl();

		System.out.println("=====================");

		// -------------------------------------
		// use
		// -------------------------------------

		System.out.println("=====================");

		txrService.transfer(100.00, "1", "2");
		System.out.println();
		txrService.transfer(100.00, "2", "1");

		System.out.println("=====================");

		// -------------------------------------
		// destroy
		// -------------------------------------
		// ..

		System.out.println("=====================");

		System.out.println("=====================");

	}
}

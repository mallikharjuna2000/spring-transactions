package com.codegnan.SpringTrnsactions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codegnan.dao.TransactionDao;

public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringConfig.xml");
		TransactionDao transactionDao = (TransactionDao) applicationContext.getBean("transactionDao");
		String status = transactionDao.transferFunds("abc123", "xyz123", 5000);
		System.out.println(status);

	}
}

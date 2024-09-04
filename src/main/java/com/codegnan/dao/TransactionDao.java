package com.codegnan.dao;

public interface TransactionDao {
	public String transferFunds(String fromAccount, String toAccount, int transferAmt);
}

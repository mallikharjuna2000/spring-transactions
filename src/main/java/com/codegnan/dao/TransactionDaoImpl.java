package com.codegnan.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TransactionDaoImpl implements TransactionDao {
	private JdbcTemplate jdbcTemplate;
	private DataSourceTransactionManager dataSourceTransactionManager;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDataSourceTransactionManager(DataSourceTransactionManager dataSourceTransactionManager) {
		this.dataSourceTransactionManager = dataSourceTransactionManager;
	}

	@Transactional
	@Override
	public String transferFunds(String fromAccount, String toAccount, int transferAmt) {
		String status = "";
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
		try {
			int rowCount1 = jdbcTemplate.update(
					"update account set BALANCE = BALANCE - " + transferAmt + " where ACCNO = '" + fromAccount + "'");
			//float f = 100 / 0;
			int rowCount2 = jdbcTemplate.update(
					"update account set BALANCE = BALANCE + " + transferAmt + " where ACCNO = '" + toAccount + "'");
			dataSourceTransactionManager.commit(transactionStatus);
			System.out.println(rowCount1 + "," + rowCount2);
			if (rowCount1 == 1 && rowCount2 == 1) {
				status = "Transaction SUCCESS";
			} else {
				status = "Transaction FAILURE";
			}

		} catch (Exception exception) {
			dataSourceTransactionManager.rollback(transactionStatus);
			status = "TRANSACTION FAILURE";
			exception.printStackTrace();
		}
		return status;

	}
}

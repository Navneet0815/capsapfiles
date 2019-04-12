package com.cg.bank.service;

import java.sql.SQLException;

public interface IAccService {
	
	public void createAccount(String name,long mobile,String addr,double balance,String mailid) throws ClassNotFoundException, SQLException;
	public void showBal(long accno) throws ClassNotFoundException, SQLException;
	public void deposit(long accno,double depamt) throws ClassNotFoundException, SQLException;
	public void withdraw(long accno,double withamt) throws ClassNotFoundException, SQLException;
	public void fundTransfer(long accno,long accno2,double tramt) throws SQLException, ClassNotFoundException;
	//public void printTransactions();
	public void printtransactions(long accno) throws ClassNotFoundException, SQLException;

}

package com.cg.bank.service;

import java.sql.SQLException;

import com.cg.bank.persistence.AccDaoImpl;

public class AccServiceImpl implements IAccService {
	AccDaoImpl dao=new AccDaoImpl();

	@Override
	public void createAccount(String name, long mobile, String addr,double balance,String mailid)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dao.createAccount(name, mobile, addr, balance, mailid);
		
	}

	@Override
	public void showBal(long accno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dao.showBal(accno);
	}

	@Override
	public void deposit(long accno, double depamt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dao.deposit(accno, depamt);
	}

	@Override
	public void withdraw(long accno, double withamt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dao.withdraw(accno, withamt);
	}

	@Override
	public void fundTransfer(long accno, long accno2, double tramt) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		dao.fundTransfer(accno, accno2, tramt);
	}

	@Override
	public void printtransactions(long accno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dao.printtransactions(accno);
	}

}

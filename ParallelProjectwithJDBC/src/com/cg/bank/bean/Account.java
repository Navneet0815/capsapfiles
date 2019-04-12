package com.cg.bank.bean;

import java.time.LocalDate;

public class Account {
	
	private String name;
	private long mobile;
	 private String addr;
	private long accno;
	private String mailid;
	private double balance;
	private LocalDate d;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getD() {
		return d;
	}
	public void setD(LocalDate d) {
		this.d = d;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", mobile=" + mobile + ", addr=" + addr + ", accno=" + accno + ", mailid="
				+ mailid + ", balance=" + balance + ", d=" + d + "]";
	}
}

package com.cg.bank.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.cg.bank.service.AccServiceImpl;

public class BankAccount {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AccServiceImpl service =new AccServiceImpl();
		while(true) {
			System.out.println("1 for inserting values");
			System.out.println("2 for show balance");
			System.out.println("3 for depositing");
			System.out.println("4 for withdrawing");
			System.out.println("5 for fund transfer");
			System.out.println("6 for printtransactions");
			System.out.println("choose your option");
			
		Scanner sc=new Scanner(System.in);
		int opt=sc.nextInt();
		switch(opt) {
		case 1:
			System.out.println("enter name");
			String name=sc.next();
			/*System.out.println("enter account number");
			long accno=sc.nextLong();
			String accnos=accno+"";
			String regEx="[1-9]{6}";
			while(!accnos.matches(regEx)) {
				System.out.println("enter valid account number");
				 accno=sc.nextLong();
				 accnos=accno+"";
				
			}*/
			System.out.println("enter mobile number");
			long mobile=sc.nextLong();
			String mobilenos=mobile+"";
			String regEx1="(91|0)?[6-9][0-9]{9}";
			while(!mobilenos.matches(regEx1)) {
				System.out.println("enter valid mobile number");
				 mobile=sc.nextLong();
				 mobilenos= mobile+"";
				
			}
			System.out.println("enter address");
			String addr=sc.next();
			System.out.println("enter the opening balance");
			double balance=sc.nextDouble();
			System.out.println("enter mailid");
			String mailid=sc.next();
			String regEx2="[a-zA-Z0-9]+[@][a-zA-Z0-9]+([.][a-zA-Z]+)+";
			while(!(mailid.matches(regEx2))) {
				System.out.println("enter valid mailid");
				 mailid=sc.next(); 
				
			}
			
			service.createAccount(name, mobile, addr,balance,mailid);
			System.out.println("name is"+name);
			//System.out.println("account number is"+accno);
			System.out.println("mobile number is"+mobile);
			System.out.println("address is"+addr);
			System.out.println("the opening balance is"+balance);
			System.out.println("the mail id is"+mailid);
			
			break;
		case 2:
			System.out.println("enter account number");
			long accno=sc.nextLong();
			service.showBal(accno);
			break;
		case 3:
			System.out.println("enter the amount to be deposited");
			double depamt=sc.nextDouble();
			System.out.println("enter account number");
			accno=sc.nextLong();
			service.deposit(accno, depamt);
			break;
		case 4:
			System.out.println("enter the amount to be withdrawn");
			double withamt=sc.nextDouble();
			System.out.println("enter account number");
			accno=sc.nextLong();
			service.withdraw(accno, withamt);
			break;
		case 5:
			System.out.println("enter the first account no");
			accno=sc.nextLong();
			System.out.println("enter the second account no");
			 long accno2=sc.nextLong();
			System.out.println("enter the amount to be transferred");
			double tramt=sc.nextDouble();
			service.fundTransfer(accno, accno2, tramt);
			break;
		case 6:
			System.out.println("enter account number to see all details");
			accno=sc.nextLong();
			service.printtransactions(accno);
			break;
			
		}
	}
	}
}

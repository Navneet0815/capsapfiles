package com.cg.bank.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import com.cg.bank.exception.BankException;
import com.cg.bank.util.ConnectionFactory;
import com.khan.exception.AkBankException;

public class AccDaoImpl implements IAccountDao {

	Connection con = null;
	PreparedStatement ps = null;

	public void getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String password = "Capgemini123";
		con = DriverManager.getConnection(url, user, password);
	}

	@Override
	public void createAccount(String name, long mobile, String addr, double balance, String mailid)
			throws BankException {
		// TODO Auto-generated method stub
		con = ConnectionFactory.getSigtonObj().getConnection();
		try {
			ps = con.prepareStatement(QueryMapping.INSERT_QUERY);

			// ps.setLong(1, accno);
			ps.setString(1, name);
			ps.setLong(2, mobile);
			ps.setString(3, addr);
			ps.setDouble(4, balance);
			ps.setString(5, mailid);
			ps.executeUpdate();
			System.out.println("row inserted");
			con.close();
		} catch (Exception e) {
			throw new BankException("coudn't run query. " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				throw new BankException("problem in connection closing!!!!");
			}
		}
	}

	@Override
	public void showBal(long accno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		getConnection();
		ps = con.prepareStatement(QueryMapping.SELECT_QUERY);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getLong(1) + " ");
			System.out.print(rs.getString(2) + " ");
			System.out.print(rs.getLong(3) + " ");
			System.out.print(rs.getString(4) + " ");
			System.out.println(rs.getDouble(5));
		}
		con.close();
	}

	@Override
	public void deposit(long accno, double depamt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		getConnection();
		ps = con.prepareStatement(QueryMapping.UPDATE_QUERY_DEPOSIT);
		ps.setDouble(1, depamt);
		ps.setLong(2, accno);
		ps.executeUpdate();
		System.out.println("money deposited");

		ps = con.prepareStatement(QueryMapping.PRINT_TRANS);
		ps.setLong(1, accno);
		String s1 = "credited " + depamt;
		ps.setString(2, s1);

		ps.setDate(3, Date.valueOf(LocalDate.now()));
		String s = LocalTime.now() + "";
		ps.setString(4, s);
		ps.executeUpdate();
		con.close();
	}

	@Override
	public void withdraw(long accno, double withamt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		getConnection();
		ps = con.prepareStatement(QueryMapping.UPDATE_QUERY_WITHDRAW);
		ps.setDouble(1, withamt);
		ps.setLong(2, accno);
		ps.executeUpdate();
		System.out.println("money withdrawn");

		ps = con.prepareStatement(QueryMapping.PRINT_TRANS);
		ps.setLong(1, accno);
		String s1 = "debited " + withamt;
		ps.setString(2, s1);
		ps.setDate(3, Date.valueOf(LocalDate.now()));
		String s = LocalTime.now() + "";
		ps.setString(4, s);
		ps.executeUpdate();
		con.close();
	}

	@Override
	public void fundTransfer(long accno, long accno2, double tramt) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		getConnection();
		ps = con.prepareStatement(QueryMapping.UPDATE_QUERY_WITHDRAW);
		ps.setDouble(1, tramt);
		ps.setLong(2, accno);
		ps.executeUpdate();
		ts = con.prepareStatement(QueryMapping.UPDATE_QUERY_DEPOSIT);
		ts.setDouble(1, tramt);
		ts.setLong(2, accno2);

		ts.executeUpdate();

		ps = con.prepareStatement(QueryMapping.PRINT_TRANS);
		ps.setLong(1, accno);
		String s1 = "transferred  " + tramt + " to " + accno2;
		ps.setString(2, s1);
		ps.setDate(3, Date.valueOf(LocalDate.now()));
		String s = LocalTime.now() + "";
		ps.setString(4, s);
		ps.executeUpdate();

		ps = con.prepareStatement(QueryMapping.PRINT_TRANS);
		ps.setLong(1, accno2);
		String s2 = "got amount  " + tramt + " from " + accno;
		ps.setString(2, s2);
		ps.setDate(3, Date.valueOf(LocalDate.now()));
		String s3 = LocalTime.now() + "";
		ps.setString(4, s3);
		ps.executeUpdate();
		con.close();

	}

	@Override
	public void printtransactions(long accno) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		getConnection();
		ps = con.prepareStatement();
		ps.setLong(1, accno);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getLong(1) + " ");
			System.out.print(rs.getString(2) + " ");
			System.out.print(rs.getDate(3) + " ");
			System.out.print(rs.getString(4) + " ");

		}
		con.close();

	}
}

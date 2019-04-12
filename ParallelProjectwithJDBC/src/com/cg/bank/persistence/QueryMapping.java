package com.cg.bank.persistence;

public class QueryMapping {
	
	public static final String INSERT_QUERY="INSERT INTO account VALUES(accno_seq.nextval,?,?,?,?,?)";
	public static final String SELECT_QUERY="SELECT * FROM account";
	public static final String UPDATE_QUERY_DEPOSIT="UPDATE account SET balance=balance+? WHERE accno=?";
	public static final String TRANS_INSERT_VAL="INSERT INTO print VALUES(?,?,?,?,?)";
	public static final String UPDATE_QUERY_WITHDRAW="UPDATE account SET balance=balance-? WHERE accno=?";
    public static final String PRINT_TRANS="SELECT * FROM print WHERE accno=?";
}

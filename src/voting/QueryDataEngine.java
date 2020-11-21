package voting;

import java.sql.*;

public class QueryDataEngine {
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	public QueryDataEngine() {
		try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/salba/Documents/CIS452 Databases/VotingRecordProject/voting.db");
          stmt = connection.createStatement();
          System.out.println("Connection successful");
        }
        catch(SQLException e)
        {
        	System.err.println(e.getMessage());
        }
	}
	
	public void queryVote(FieldList fieldList) {
		try {
			String queryText = "select * from HSall_votes where ";
			String op = "=";
			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				queryText = queryText + fieldList.fields.get(i) + op + fieldList.values.get(i);
			}
			rs = stmt.executeQuery(queryText);
			rs.close();
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void queryRollcall(FieldList fieldList) {
		try {
			String queryText = "select * from HSall_rollcalls where ";
			String op = "=";
			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				queryText = queryText + fieldList.fields.get(i) + op + fieldList.values.get(i);
			}
			rs = stmt.executeQuery(queryText);
			rs.close();
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void queryMember(FieldList fieldList) {
		try {
			String queryText = "select * from HSall_members where ";
			String op = "=";
			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				queryText = queryText + fieldList.fields.get(i) + op + fieldList.values.get(i);
			}
			rs = stmt.executeQuery(queryText);
			rs.close();
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void queryParty(FieldList fieldList) {
		try {
			String queryText = "select * from HSall_parties where ";
			String op = "=";
			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				queryText = queryText + fieldList.fields.get(i) + op + fieldList.values.get(i);
			}
			rs = stmt.executeQuery(queryText);
			rs.close();
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public ResultSet getResultSet() {
		return rs;
	}
	
	public void finishQuerying() {
		try {
		connection.close();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}

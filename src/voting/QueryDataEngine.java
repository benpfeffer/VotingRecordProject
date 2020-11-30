package voting;

import java.sql.*;
import java.util.ArrayList;

public class QueryDataEngine {
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	public QueryDataEngine() {
		try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\salba\\Documents\\CIS452 Databases\\VotingRecordProject\\voting.db");
          stmt = connection.createStatement();
          System.out.println("Connection successful");
        }
        catch(SQLException e)
        {
        	System.err.println(e.getMessage());
        }
	}
	
	public void queryTable(FieldList fieldList, String table, String join) {	
		try {
			String queryText = "select * from " + table + " ";
			if(join != null) {
				switch(table) {
				//Search members based on another table
				case "HSall_members":
					switch(join) {
					case "HSall_parties":
						queryText += "inner join HSall_parties using(congress, chamber, party_code) ";
						break;
					case "HSall_rollcalls":
						queryText += "inner join HSall_votes using(congress, chamber, icpsr) inner join HSall_rollcalls using(congress, chamber, rollnumber) ";
						break;
					case "HSall_votes":
						queryText += "inner join HSall_votes using(congress, chamber, icpsr) ";
						break;
					}
					break;
				case "HSall_parties":
					switch(join) {
					case "HSall_members":
						queryText += "inner join HSall_members using(congress, chamber, party_code) ";
						break;
					case "HSall_rollcalls":
						queryText += "inner join HSall_rollcalls using(congress, chamber) ";
						break;
					case "HSall_votes":
						queryText += "inner join HSall_votes using(congress, chamber) ";
						break;
					}
					break;
				case "HSall_rollcalls":
					switch(join) {
					case "HSall_members":
						queryText += "inner join HSall_votes using(congress, chamber, icpsr) inner join HSall_rollcalls using(congress, chamber, rollnumber) ";
						break;
					case "HSall_parties":
						queryText += "inner join HSall_rollcalls using(congress, chamber) ";
						break;
					case "HSall_votes":
						queryText += "inner join HSall_votes using(congress, chamber, rollnumber) ";
						break;
					}
					break;
				case "HSall_votes":
					switch(join) {
					case "HSall_members":
						queryText += "inner join HSall_votes using(congress, chamber, icpsr) ";
						break;
					case "HSall_parties":
						queryText += "inner join HSall_votes using(congress, chamber) ";
						break;
					case "HSall_rollcalls":
						queryText += "inner join HSall_votes using(congress, chamber, rollnumber) ";
						break;
					}
					break;
				}
			}
			//Detect if rollnumber needs to be included for the date
			for(int i = 0; i < fieldList.size(); i++) {
				if((fieldList.fields.get(i).equals("startDate") || fieldList.fields.get(i).equals("startDate")) && join != "HSall_rollcalls" && table != "HSall_rollcalls") {
					queryText += "inner join HSall_rollcalls using(congress, chamber) ";
					break;
				}
			}
			queryText += "where ";
			String op = "=";

			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				if(fieldList.fields.get(i).equals("startDate"))
					queryText = queryText + "date" + ">" + fieldList.values.get(i);
				else if(fieldList.fields.get(i).equals("endDate"))
					queryText = queryText + "date" + "<" + fieldList.values.get(i);
				else
					queryText = queryText + fieldList.fields.get(i) + op + fieldList.values.get(i);
				System.out.println(queryText);
			}
			rs = stmt.executeQuery(queryText);
			//rs.close();
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	/*
	public void queryVote(FieldList fieldList) {
		try {
			String queryText = "select * from HSall_votes where ";
			String op = "=";
			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				queryText = queryText + fieldList.fields.get(i) + op + fieldList.values.get(i);
				System.out.println(queryText);
			}
			rs = stmt.executeQuery(queryText);
			//rs.close();
			
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
				System.out.println(queryText);
			}
			rs = stmt.executeQuery(queryText);
			//rs.close();
			
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
				System.out.println(queryText);
			}
			rs = stmt.executeQuery(queryText);
			//rs.close();
			
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
				System.out.println(queryText);
			}
			rs = stmt.executeQuery(queryText);
			//rs.close();
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	///////Adding 2 table connections
	public void queryMemberXParty(FieldList fieldList, String tableOne, String tableTwo) {
		try {
			String queryText = "select * from HSall_"+tableOne+" m, HSall_"+tableTwo+" p where m.party_code = p.party_code and m.chamber = p.chamber and m.congress = p.congress and ";
			String op = "=";
			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				queryText = queryText + "m.";
				queryText = queryText + fieldList.fields.get(i) + op + fieldList.values.get(i);
				System.out.println(queryText);
			}
			rs = stmt.executeQuery(queryText);
			//rs.close();
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void queryMemberXRollcall(FieldList fieldList, String tableOne, String tableTwo) {
		try {
			String queryText = "select * from HSall_"+tableOne+" m, HSall_"+tableTwo+" r where m.congress = r.congress and m.chamber = r.chamber and ";
			String op = "=";
			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				queryText = queryText + "m.";
				queryText = queryText + fieldList.fields.get(i) + op + fieldList.values.get(i);
				System.out.println(queryText);
			}
			rs = stmt.executeQuery(queryText);
			//rs.close();
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void queryMemberXVote(FieldList fieldList, String tableOne, String tableTwo) {
		try {
			String queryText = "select * from HSall_"+tableOne+" m, HSall_"+tableTwo+" v where m.congress = v.congress and m.chamber = v.chamber and m.icpsr = v.icpsr and ";
			String op = "=";
			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				queryText = queryText + "m.";
				queryText = queryText + fieldList.fields.get(i) + op + fieldList.values.get(i);
				System.out.println(queryText);
			}
			rs = stmt.executeQuery(queryText);
			//rs.close();
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void queryPartyXRollcall(FieldList fieldList, String tableOne, String tableTwo) {
		try {
			String queryText = "select * from HSall_"+tableOne+" m, HSall_"+tableTwo+" v where m.congress = v.congress and m.chamber = v.chamber and ";
			String op = "=";
			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				queryText = queryText + "m.";
				queryText = queryText + fieldList.fields.get(i) + op + fieldList.values.get(i);
				System.out.println(queryText);
			}
			rs = stmt.executeQuery(queryText);
			//rs.close();
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void queryPartyXVote(FieldList fieldList, String tableOne, String tableTwo) {
		try {
			String queryText = "select * from HSall_"+tableOne+" m, HSall_"+tableTwo+" v where m.congress = v.congress and m.chamber = v.chamber and ";
			String op = "=";
			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				queryText = queryText + "m.";
				queryText = queryText + fieldList.fields.get(i) + op + fieldList.values.get(i);
				System.out.println(queryText);
			}
			rs = stmt.executeQuery(queryText);
			//rs.close();
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void queryRollcallXVote(FieldList fieldList, String tableOne, String tableTwo) {
		try {
			String queryText = "select * from HSall_"+tableOne+" m, HSall_"+tableTwo+" v where m.congress = v.congress and m.chamber = v.chamber and m.rollnumber = v.rollnumber and ";
			String op = "=";
			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				queryText = queryText + "m.";
				queryText = queryText + fieldList.fields.get(i) + op + fieldList.values.get(i);
				System.out.println(queryText);
			}
			rs = stmt.executeQuery(queryText);
			//rs.close();
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/////////////end 2 table connections
	
	*/
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
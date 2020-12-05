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
			String partialPath = System.getProperty("user.dir");
			String connPath = "jdbc:sqlite:" + partialPath + "/voting/voting.db";
			connection = DriverManager.getConnection(connPath);
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
					queryText = queryText + "date" + ">=" + "\"" + fieldList.values.get(i) + "\"";
				else if(fieldList.fields.get(i).equals("endDate"))
					queryText = queryText + "date" + "<=" + "\"" + fieldList.values.get(i) + "\"";
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
	
	public void queryAll(String tbl) {
		try {
			String queryText = "select * from " + tbl;
			rs = stmt.executeQuery(queryText);
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public int queryCount(String congress, String chamber) {
		try {
			String queryText = "SELECT COUNT(*) AS rowcount FROM HSall_rollcalls where congress = "
      	          + congress + " and chamber = " + "\"" + chamber + "\"";
			rs = stmt.executeQuery(queryText);
			rs.next();
    		int count = rs.getInt("rowcount");
    	    rs.close();
    	    return(count);
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			return(-1);
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
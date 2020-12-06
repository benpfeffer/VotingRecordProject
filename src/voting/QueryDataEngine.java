/*
 * This class queries the database based on any valid input.
 * 
 */

package voting;

import java.sql.*;

public class QueryDataEngine {
	//Initialize variables
	private Connection connection;
	private PreparedStatement stmt;
	private ResultSet rs;
	//Create connection to database
	public QueryDataEngine() {
		try
        {
			String partialPath = System.getProperty("user.dir");
			String connPath = "jdbc:sqlite:" + partialPath + "/voting.db";
			connection = DriverManager.getConnection(connPath);
			System.out.println("Connection successful");
        }
        catch(SQLException e)
        {
        	System.err.println(e.getMessage());
        }
	}
	
	//Query a table in the database
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

			//Include date range in query
			for(int i = 0; i < fieldList.size(); i++) {
				if(i > 0) queryText = queryText + " and ";
				if(fieldList.fields.get(i).equals("startDate"))
					queryText = queryText + "date" + ">=" + "\"" + fieldList.values.get(i) + "\"";
				else if(fieldList.fields.get(i).equals("endDate"))
					queryText = queryText + "date" + "<=" + "\"" + fieldList.values.get(i) + "\"";
				else
					queryText = queryText + fieldList.fields.get(i) + op + "?";
			}
			
			//Prepare statement to send
			stmt = connection.prepareStatement(queryText);
			
			//Add input to query (while preventing SQL injections)
			int c = 1;
			for(int i = 0; i < fieldList.size(); i++) {
				if(fieldList.fields.get(i).equals("startDate") || fieldList.fields.get(i).equals("endDate")) continue;
				String criterion = fieldList.values.get(i);
				stmt.setString(c, criterion);
				c++;
			}
			
			//Execute query
			rs = stmt.executeQuery();
						
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	//Query all columns in a table
	public void queryAll(String tbl) {
		try {
			String queryText = "select * from " + tbl;
			stmt = connection.prepareStatement(queryText);
			rs = stmt.executeQuery();
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	//Get the number of rows in a query
	public int queryCount(String congress, String chamber) {
		try {
			String queryText = "SELECT COUNT(*) AS rowcount FROM HSall_rollcalls where congress = "
      	          + congress + " and chamber = " + "\"" + chamber + "\"";
			stmt = connection.prepareStatement(queryText);
			rs = stmt.executeQuery();
			rs.next();
    		int count = rs.getInt("rowcount");
    	    rs.close();
    	    return(count);
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			return(-1);
		}
	}
	
	//Get the result set
	public ResultSet getResultSet() {
		return rs;
	}
	
	//Close query connection
	public void finishQuerying() {
		try {
		connection.close();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
import java.sql.*;

public class QueryDataEngine {
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	public QueryDataEngine() {
		try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:/Users/benjaminpfeffer/Downloads/voting/voting.db");
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
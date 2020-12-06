package voting;

import java.sql.*;


public class AddDataEngine {
	
	private Connection connection;
	private PreparedStatement stmt;
	public AddDataEngine() {
		try
        {
          // create a database connection
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
	
	public void addVote(String congress, String chamber, String rollnumber, String icpsr, String cast_code) {
		try {
			String queryString = "insert into HSall_votes values(?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, congress);
			stmt.setString(2, chamber);
			stmt.setString(3, rollnumber);
			stmt.setString(4, icpsr);
			stmt.setString(5, cast_code);
			stmt.executeUpdate();
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void addRollcall(String congress, String chamber, String rollnumber, String date, String session, String clerk_rollnumber, String bill_number, String vote_result, String vote_desc, String vote_question, String dtl_desc) {
		try {
			String queryString = "insert into HSall_rollcalls(congress, chamber, rollnumber, date, session, clerk_rollnumber, bill_number, vote_result, vote_desc, vote_question, dtl_desc) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, congress);
			stmt.setString(2, chamber);
			stmt.setString(3, rollnumber);
			stmt.setString(4, date);
			stmt.setString(5, session);
			stmt.setString(6, clerk_rollnumber);
			stmt.setString(7, bill_number);
			stmt.setString(8, vote_result);
			stmt.setString(9, vote_desc);
			stmt.setString(10, vote_question);
			stmt.setString(11, dtl_desc);
			stmt.executeUpdate();
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			}
	}
	
	public void addMember(String congress, String chamber, String icpsr, String state_icpsr, String district_code, String state_abbrev, String party_code, String bioname, String bioguide_id, String born) {
		try {
			String queryString = "insert into HSall_members(congress, chamber, icpsr, state_icpsr, district_code, state_abbrev, party_code, bioname, bioguide_id, born) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, congress);
			stmt.setString(2, chamber);
			stmt.setString(3, icpsr);
			stmt.setString(4, state_icpsr);
			stmt.setString(5, district_code);
			stmt.setString(6, state_abbrev);
			stmt.setString(7, party_code);
			stmt.setString(8, bioname);
			stmt.setString(9, bioguide_id);
			stmt.setString(10, born);
			stmt.executeUpdate();
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			}
	}
	
	public void addParty(String congress, String chamber, String party_code, String party_name, String n_members) {
		try {
			String queryString = "insert into HSall_parties(congress, chamber, party_code, party_name, n_members) values(?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, congress);
			stmt.setString(2, chamber);
			stmt.setString(3, party_code);
			stmt.setString(4, party_name);
			stmt.setString(5, n_members);
			stmt.executeUpdate();
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			}
	}
}
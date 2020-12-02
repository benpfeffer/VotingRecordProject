package voting;

import java.sql.*;

public class AddDataEngine {
	
	private Connection connection;
	private Statement stmt;
	public AddDataEngine() {
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
	
	public void addVote(String congress, String chamber, String rollnumber, String icpsr, String cast_code) {
		try {
		stmt.executeUpdate("insert into HSall_votes values(" + congress + ", \"" + chamber + "\", " + rollnumber + ", " + icpsr + ", " + cast_code + ")");
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void addRollcall(String congress, String chamber, String rollnumber, String date, String session, String clerk_rollnumber, String bill_number, String vote_result, String vote_desc, String vote_question, String dtl_desc) {
		try {
			stmt.executeUpdate("insert into HSall_rollcalls(congress, chamber, rollnumber, date, session, clerk_rollnumber, bill_number, vote_result, vote_desc, vote_question, dtl_desc) values(" + 
		congress + ", \"" + 
		chamber + "\", " + 
		rollnumber + ", \"" + 
		date + "\", " +
		session + ", " +
		clerk_rollnumber + ", \"" +
		bill_number + "\", \"" + 
		vote_result + "\", \"" + 
		vote_desc + "\", \"" + 
		vote_question + "\", \"" + 
		dtl_desc + "\")");
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			}
	}
	
	public void addMember(String congress, String chamber, String icpsr, String state_icpsr, String district_code, String state_abbrev, String party_code, String bioname, String bioguide_id, String born) {
		try {
			stmt.executeUpdate("insert into HSall_members(congress, chamber, icpsr, state_icpsr, district_code, state_abbrev, party_code, bioname, bioguide_id, born) values(" + 
		congress + ", \"" + 
		chamber + "\", " + 
		icpsr + ", " + 
		state_icpsr + ", " + 
		district_code + ", \"" + 
		state_abbrev + "\", " +
		party_code + ", \"" +
		bioname + "\", " + 
		bioguide_id + ", \"" +
		born + "\")");
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			}
	}
	
	public void addParty(String congress, String chamber, String party_code, String party_name, String n_members) {
		try {
			stmt.executeUpdate("insert into HSall_parties(congress, chamber, party_code, party_name, n_members) values(\"" + 
		congress + "\", \"" + 
		chamber + "\", \"" + 
		party_code + "\", \"" + 
		party_name + "\", \"" + 
		n_members + "\")");
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			}
	}
}
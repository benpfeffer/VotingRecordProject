package voting;
import java.sql.*;


public class AddDataEngine {
	
	private Connection connection;
	private Statement stmt;
	public AddDataEngine() {
		try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/salba/Documents/CIS452 Databases/VotingRecordProject/voting.sqlite");
          stmt = connection.createStatement();
          System.out.println("Connection successful");
        }
        catch(SQLException e)
        {
        	System.err.println(e.getMessage());
        }
	}
	
	public void addVote(int congress, String chamber, int rollnumber, int icpsr, int cast_code) {
		try {
		stmt.executeUpdate("insert into HSall_votes values(" + Integer.toString(congress) + ", " + chamber + ", " + Integer.toString(rollnumber) + ", " + Integer.toString(icpsr) + ", " + Integer.toString(cast_code) + ")");
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void addRollcall(int congress, String chamber, int rollnumber, String date, int session, int clerk_rollnumber, String bill_number, String vote_result, String vote_desc, String vote_question, String dtl_desc) {
		try {
			stmt.executeUpdate("insert into HSall_rollcalls(chamber, rollnumber, date, session, clerk_rollnumber, bill_number, vote_result, vote_desc, vote_question, dtl_desc) values(" + 
		Integer.toString(congress) + ", " + 
		chamber + ", " + 
		Integer.toString(rollnumber) + ", " + 
		date + ", " +
		Integer.toString(session) + ", " +
		Integer.toString(clerk_rollnumber) + ", " +
		bill_number + ", " + 
		vote_result + ", " + 
		vote_desc + ", " + 
		vote_question + ", " + 
		dtl_desc);
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			}
	}
	
	public void addMember(int congress, String chamber, int icpsr, int state_icpsr, int district_code, String state_abbrev, int party_code, int occupancy, int last_means, String bioname, String bioguide_id, int born, int died, int number_of_votes, int number_of_errors) {
		try {
			stmt.executeUpdate("insert into HSall_members(congress, chamber, icpsr, state_icpsr, district_code, state_abbrev, party_code, occupancy, last_means, bioname, bioguide_id, born, died, number_of_votes, number_of_errors) values(" + 
		Integer.toString(congress) + ", " + 
		chamber + ", " + 
		Integer.toString(icpsr) + ", " + 
		Integer.toString(state_icpsr) + ", " + 
		Integer.toString(district_code) + ", " + 
		state_abbrev + ", " +
		Integer.toString(party_code) + ", " +
		Integer.toString(occupancy) + ", " +
		Integer.toString(last_means) + ", " +
		bioname + ", " + 
		bioguide_id + ", " + 
		Integer.toString(number_of_votes) + ", " + 
		Integer.toString(number_of_errors));
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			}
	}
	
	public void addParty(int congress, String chamber, int party_code, String party_name, int n_members) {
		try {
			stmt.executeUpdate("insert into HSall_members values(" + 
		Integer.toString(congress) + ", " + 
		chamber + ", " + 
		Integer.toString(party_code) + ", " + 
		party_name + ", " + 
		Integer.toString(n_members));
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			}
	}
}

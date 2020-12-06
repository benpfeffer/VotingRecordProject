/*
 * AUTHORS:
 * 		Ben Pfeffer
 * 		Sal Balkus
 * 
 * This class runs the GUI that allows you to enter and query data to and from the Congressional Voting Database.
 * 
 */

package voting;

import java.awt.EventQueue;

//Initialize GUI object
public class VotingRecordDB {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                MainMenu start = new MainMenu();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}

}


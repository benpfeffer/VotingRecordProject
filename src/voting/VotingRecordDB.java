package voting;

import java.awt.EventQueue;


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


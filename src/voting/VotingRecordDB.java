import javax.swing.*;  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
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


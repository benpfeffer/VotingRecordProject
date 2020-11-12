import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;


import javax.swing.*;  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class first extends JFrame {

private JPanel contentPane;
private final Action action = new SwingAction();
private final Action action_1 = new SwingAction();

/**
 * Launch the application.
 */
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                first frame = new first();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

/**
 * Create the frame.
 */
public first() {
      JFrame f=new JFrame();//creating instance of JFrame  
		//title page buttons
		JButton b1=new JButton("Enter Data");//creating instance of JButton  
		b1.setBounds(60,350,390,100);//x axis, y axis, width, height 
      b1.setFont(new Font("Sans-serif", Font.PLAIN, 32));
      JButton b2=new JButton("Query Data");//creating instance of JButton  
		b2.setBounds(490,350,390,100);//x axis, y axis, width, height 
      b2.setFont(new Font("Sans-serif", Font.PLAIN, 32));

		//add title
		JLabel title = new JLabel("Congressional Voting Database", JLabel.CENTER);
		title.setBounds(40,200,880,80);
		title.setFont(new Font("Sans-serif", Font.PLAIN, 48));
		title.setOpaque(true);
	    title.setBackground(new Color(255, 255, 255));
      		          
		f.add(b1);//adding button in JFrame  
      f.add(b2);//adding button in JFrame  
		f.add(title); //adding title
		f.setSize(960,720);//960 width and 720 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible
      
      
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
    b1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        second_add second = new second_add();  
        second.setVisible(true); 
        f.setVisible(false); // Hide previous frame
      }
    });
    
    b2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        seventh_add seventh = new seventh_add();  
        seventh.setVisible(true); 
        f.setVisible(false); // Hide previous frame
      }
    });



}
private class SwingAction extends AbstractAction {
    public SwingAction() {
        putValue(NAME, "Next");
        putValue(SHORT_DESCRIPTION, "Some short description");
    }
    public void actionPerformed(ActionEvent e) {
        new second_add();
    }
}
}
package voting;

import javax.swing.*;  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

public class MainMenu extends JFrame {
	private JPanel contentPane;
	
	public MainMenu(){
		
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
      
      
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			EnterDataMenu enterDataMenu = new EnterDataMenu();  
			enterDataMenu.setVisible(true); 
			f.dispose(); // Hide previous frame
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BasicSearch basicSearch = new BasicSearch();  
				basicSearch.setVisible(true); 
				f.dispose(); // Hide previous frame
				}
			});
		}
		
	}
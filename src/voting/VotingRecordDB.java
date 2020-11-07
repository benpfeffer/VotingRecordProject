package voting;

import javax.swing.*;  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


public class VotingRecordDB {
	public static void main(String[] args) {
		JFrame f=new JFrame();//creating instance of JFrame  
		//example button
		JButton b=new JButton("click");//creating instance of JButton  
		b.setBounds(130,100,100,40);//x axis, y axis, width, height 
		//add title
		JLabel title = new JLabel("Congressional Voting Database", JLabel.CENTER);
		title.setBounds(40,10,880,80);
		title.setFont(new Font("Sans-serif", Font.PLAIN, 48));
		title.setOpaque(true);
	    title.setBackground(new Color(255, 255, 255));
		          
		f.add(b);//adding button in JFrame  
		f.add(title); //adding title
		f.setSize(960,720);//960 width and 720 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
	}

}

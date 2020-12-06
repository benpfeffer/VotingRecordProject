package voting;

import javax.swing.*;  
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class AddNewVote extends JFrame {
	private JPanel contentPane;
    //private final Action action = new SwingAction();
    public static String outCong = "None";
    public static String outChamb = "None";
    public static String outRollNum = "None";
    public static String outIcp = "None";
    public static String outCast = "None";
    
    public AddNewVote() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0, 960, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //back button
        JButton menu = new JButton("Menu");//creating instance of JButton  
	      menu.setBounds(40,40,120,30);//x axis, y axis, width, height 
        menu.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        contentPane.add(menu);
        menu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
              MainMenu start = new MainMenu();
              f1.dispose();        

        }
          });

        
        //add title
  		JLabel title = new JLabel("Congressional Voting Database", JLabel.CENTER);
  		title.setBounds(40,40,880,160);
  		title.setFont(new Font("Sans-serif", Font.PLAIN, 48));
  		title.setOpaque(true);
  	    title.setBackground(new Color(255, 255, 255));
        contentPane.add(title);


        JLabel t = new JLabel("Select an option to begin entering data", JLabel.CENTER);
        t.setBounds(350,220,570,460);
  		t.setFont(new Font("Sans-serif", Font.PLAIN, 24));
  		t.setOpaque(true);
        t.setBackground(new Color(255, 255, 255));
        contentPane.add(t);

        JButton addVote=new JButton("Add New Vote");//creating instance of JButton  
	      addVote.setBounds(40,220,290,100);//x axis, y axis, width, height 
        addVote.setFont(new Font("Sans-serif", Font.PLAIN, 28));
        addVote.setBackground(new Color(255, 235, 153));
        addVote.setOpaque(true);
        addVote.setBorderPainted(false);
        contentPane.add(addVote);
        
        
        JButton addRollcall=new JButton("Add New Rollcall");//creating instance of JButton  
	       addRollcall.setBounds(40,340,290,100);//x axis, y axis, width, height 
        addRollcall.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        contentPane.add(addRollcall);
        addRollcall.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
              AddNewRollcall addNewRollcall = new AddNewRollcall();
              addNewRollcall.setVisible(true);
              f1.dispose();        }
          });
          
        JButton addMember=new JButton("Add New Member");//creating instance of JButton  
	       addMember.setBounds(40,460,290,100);//x axis, y axis, width, height 
        addMember.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        contentPane.add(addMember);
        addMember.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	   JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
              AddNewMember addNewMember = new AddNewMember();
              addNewMember.setVisible(true);
              f1.dispose();           }
          });
          
        JButton addParty=new JButton("Add New Party");//creating instance of JButton  
	       addParty.setBounds(40,580,290,100);//x axis, y axis, width, height 
        addParty.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        contentPane.add(addParty);
        addParty.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	   JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
              AddNewParty addNewParty = new AddNewParty();
              addNewParty.setVisible(true);
              f1.dispose();           }
          });
		
        

        
        
        JLabel cong = new JLabel("Congress", JLabel.CENTER);
        cong.setBounds(400,275,100,50);
        cong.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        cong.setOpaque(true);
        cong.setBackground(new Color(255, 255, 255));

        JLabel chamb = new JLabel("Chamber", JLabel.CENTER);
        chamb.setBounds(400,335,100,50);
        chamb.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        chamb.setOpaque(true);
        chamb.setBackground(new Color(255, 255, 255));

        JLabel rNum = new JLabel("Roll Number", JLabel.CENTER);
        rNum.setBounds(375,395,150,50);
        rNum.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        rNum.setOpaque(true);
        rNum.setBackground(new Color(255, 255, 255));

        JLabel icp = new JLabel("ICPSR", JLabel.CENTER);
        icp.setBounds(400,455,100,50);
        icp.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        icp.setOpaque(true);
        icp.setBackground(new Color(255, 255, 255));

        JLabel cast = new JLabel("Cast Code", JLabel.CENTER);
        cast.setBounds(400,515,100,50);
        cast.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        cast.setOpaque(true);
        cast.setBackground(new Color(255, 255, 255));

        JLabel notifier = new JLabel("<html><center>To create new database entry, please fill in all fields and press the \"Enter Date\" button. Be sure to press the ENTER key after typing in a text box. </center></html>", JLabel.CENTER);
        notifier.setBounds(410,595,230,70);
        notifier.setFont(new Font("Sans-serif", Font.PLAIN, 12));
        notifier.setOpaque(true);
        notifier.setBackground(new Color(255, 255, 255));

        JTextField congressFill = new JTextField(20);
        congressFill.setBounds(550,275,290,50);
        congressFill.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		outCong = congressFill.getText();
        	}
        });


        String[] chambers = { "None", "Senate", "House", "President" };
        JComboBox chamberDropdown = new JComboBox(chambers);
        chamberDropdown.setSelectedIndex(0);
        chamberDropdown.setBounds(550,335,290,50);
        String selectedChamber = (String)chamberDropdown.getSelectedItem();
        chamberDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedChamber = (String)chamberDropdown.getSelectedItem();
        		outChamb = selectedChamber;
        	}
        });

        
        JTextField rollNumDropdown = new JTextField(20);
        rollNumDropdown.setBounds(550,395,290,50);
        String selectedRollNum = (String)rollNumDropdown.getText();
        rollNumDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedRollNum = (String)rollNumDropdown.getText();
        		outRollNum = selectedRollNum;
        	}
        });

        JTextField icpDropdown = new JTextField(20);
        icpDropdown.setBounds(550,455,290,50);
        String selectedIcp = (String)icpDropdown.getText();
        icpDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedIcp = (String)icpDropdown.getText();
        		outIcp = selectedIcp;
        	}
        });

        String[] castCodes = { "None", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        JComboBox castCodeDropdown = new JComboBox(castCodes);
        castCodeDropdown.setSelectedIndex(0);
        castCodeDropdown.setBounds(550,515,290,50);
        String selectedCastCode = (String)castCodeDropdown.getSelectedItem();
        castCodeDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedCastCode = (String)castCodeDropdown.getSelectedItem();
        		outCast = selectedCastCode;
        	}
        });

        JButton enterDataOne=new JButton("Enter Data");//creating instance of JButton  
        enterDataOne.setBounds(650,595,215,50);//x axis, y axis, width, height 
        enterDataOne.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        contentPane.add(enterDataOne);
        enterDataOne.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(outCong!="None" && outChamb!="None" && outRollNum!="None" && outIcp!="None" && outCast!="None"){
        			//Add the data to the database using SQL
        			AddDataEngine dataEngine = new AddDataEngine();
        			dataEngine.addVote(outCong, outChamb, outRollNum, outIcp, outCast);
        			notifier.setText("Entered data.");
        		}else{
        			notifier.setText("Fill in all fields.");
        		}
        	}
        });


        JLabel t1 = new JLabel();
        t1.setBounds(350,220,570,460);
        t1.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        t1.setOpaque(true);
        t1.setBackground(new Color(255, 255, 255));
        contentPane.add(cong);
        contentPane.add(chamb);
        contentPane.add(rNum);
        contentPane.add(icp);
        contentPane.add(cast);
        contentPane.add(notifier);
        contentPane.add(congressFill);
        contentPane.add(chamberDropdown);
        contentPane.add(rollNumDropdown);
        contentPane.add(icpDropdown);
        contentPane.add(castCodeDropdown);
        contentPane.add(t1);



        t1.setVisible(true); 
        t.setVisible(false); // Hide previous frame

    }
}
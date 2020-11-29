package voting;

import javax.swing.*;  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class AddNewVote extends JFrame {
	private JPanel contentPane;
    private JTextField txtTypeYourQuestion;
    private JTextField txtQuestionWeight;
    private JTextField txtEnter;
    private JTextField txtEnter_1;
    private JTextField txtValue;
    private JTextField txtValue_1;
    //private final Action action = new SwingAction();
    public static String outCong = "None";
    public static String outChamb = "None";
    public static String outRollNum = "None";
    public static String outIcp = "None";
    public static String outCast = "None";
    
    public AddNewVote() {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0, 960, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //back button
        JButton menu = new JButton("Menu");//creating instance of JButton  
	      menu.setBounds(40,40,75,50);//x axis, y axis, width, height 
        menu.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        contentPane.add(menu);
        menu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
              MainMenu start = new MainMenu();
              start.setVisible(true);
              contentPane.setVisible(false);
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

        JLabel voteNum = new JLabel("Vote Number: ######", JLabel.CENTER);
        voteNum.setBounds(410,595,215,50);
        voteNum.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        voteNum.setOpaque(true);
        voteNum.setBackground(new Color(255, 255, 255));
        voteNum.setBorder(blackline);

        String[] congresses = { "None", "Congress1", "Congress2", "Congress3", "Congress4", "Congress5" };
        JComboBox congressDropdown = new JComboBox(congresses);
        congressDropdown.setSelectedIndex(0);
        congressDropdown.setBounds(550,275,290,50);
        String selectedCongress = (String)congressDropdown.getSelectedItem();
        congressDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedCongress = (String)congressDropdown.getSelectedItem();
        		outCong = selectedCongress;
        		System.out.println(selectedCongress);
        	}
        });


        String[] chambers = { "None", "Chamber1", "Chamber2", "Chamber3", "Chamber4", "Chamber5" };
        JComboBox chamberDropdown = new JComboBox(chambers);
        chamberDropdown.setSelectedIndex(0);
        chamberDropdown.setBounds(550,335,290,50);
        String selectedChamber = (String)chamberDropdown.getSelectedItem();
        chamberDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedChamber = (String)chamberDropdown.getSelectedItem();
        		outChamb = selectedChamber;
        		System.out.println(selectedChamber);
        	}
        });

        String[] rollNums = { "None", "1", "2", "3", "4", "5" };
        JComboBox rollNumDropdown = new JComboBox(rollNums);
        rollNumDropdown.setSelectedIndex(0);
        rollNumDropdown.setBounds(550,395,290,50);
        String selectedRollNum = (String)rollNumDropdown.getSelectedItem();
        rollNumDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedRollNum = (String)rollNumDropdown.getSelectedItem();
        		outRollNum = selectedRollNum;
        		System.out.println(selectedRollNum);
        	}
        });

        String[] icps = { "None", "icp1", "icp2", "icp3", "icp4", "icp5" };
        JComboBox icpDropdown = new JComboBox(icps);
        icpDropdown.setSelectedIndex(0);
        icpDropdown.setBounds(550,455,290,50);
        String selectedIcp = (String)icpDropdown.getSelectedItem();
        icpDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedIcp = (String)icpDropdown.getSelectedItem();
        		outIcp = selectedIcp;
        		System.out.println(selectedIcp);
        	}
        });

        String[] castCodes = { "None", "Code1", "Code2", "Code3", "Code4", "Code5" };
        JComboBox castCodeDropdown = new JComboBox(castCodes);
        castCodeDropdown.setSelectedIndex(0);
        castCodeDropdown.setBounds(550,515,290,50);
        String selectedCastCode = (String)castCodeDropdown.getSelectedItem();
        castCodeDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedCastCode = (String)castCodeDropdown.getSelectedItem();
        		outCast = selectedCastCode;
        		System.out.println(selectedCastCode);
        	}
        });

        JButton enterDataOne=new JButton("Enter Data");//creating instance of JButton  
        enterDataOne.setBounds(650,595,215,50);//x axis, y axis, width, height 
        enterDataOne.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        contentPane.add(enterDataOne);
        enterDataOne.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(outCong!="None" && outChamb!="None" && outRollNum!="None" && outIcp!="None" && outCast!="None"){
        			System.out.println("Entered data.");
        		}else{
        			System.out.println("Fill in all fields.");
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
        contentPane.add(voteNum);
        contentPane.add(congressDropdown);
        contentPane.add(chamberDropdown);
        contentPane.add(rollNumDropdown);
        contentPane.add(icpDropdown);
        contentPane.add(castCodeDropdown);
        contentPane.add(t1);



        t1.setVisible(true); 
        t.setVisible(false); // Hide previous frame

    }
}
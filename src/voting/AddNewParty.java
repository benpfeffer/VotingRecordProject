/*
 * This class displays the Add New Party section and allows for user input in the GUI.
 * 
 */

package voting;

import javax.swing.*;  
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.Random;

public class AddNewParty extends JFrame {
	private JPanel contentPane;
    public static String partyInput = "None";
    public static String outChamb = "None";
    public static String outCongress = "None";
    public static String outCode = "1";
    public static String members = "0";


    public AddNewParty() {
    	//Set up the outline of the GUI
        Border blackline = BorderFactory.createLineBorder(Color.black);
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
              f1.dispose();        }
          });

        
        //add title
  		JLabel title = new JLabel("Congressional Voting Database", JLabel.CENTER);
  		title.setBounds(40,40,880,160);
  		title.setFont(new Font("Sans-serif", Font.PLAIN, 48));
  		title.setOpaque(true);
  	    title.setBackground(new Color(255, 255, 255));
        contentPane.add(title);

        //Initialize default pane to use later
        JLabel t1 = new JLabel();
        t1.setBounds(350,220,570,460);
        t1.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        t1.setOpaque(true);
        t1.setBackground(new Color(255, 255, 255));

        //Add default pane
        JLabel t = new JLabel("Select an option to begin entering data", JLabel.CENTER);
        t.setBounds(350,220,570,460);
  		t.setFont(new Font("Sans-serif", Font.PLAIN, 24));
  		t.setOpaque(true);
        t.setBackground(new Color(255, 255, 255));
        contentPane.add(t);

        //Add Add New Vote button to switch to the Add New Vote pane
        JButton addVote=new JButton("Add New Vote");//creating instance of JButton  
	       addVote.setBounds(40,220,290,100);//x axis, y axis, width, height 
        addVote.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        contentPane.add(addVote);
        addVote.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
              AddNewVote addNewVote = new AddNewVote();
              addNewVote.setVisible(true);
              f1.dispose();        }
          });

        //Add Add New Rollcall button to switch to the Add New Rollcall pane
        JButton addRollcall=new JButton("Add New Rollcall");//creating instance of JButton  
        addRollcall.setBounds(40,340,290,100);//x axis, y axis, width, height 
        addRollcall.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        contentPane.add(addRollcall);
        addRollcall.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
        		AddNewRollcall addNewRollcall = new AddNewRollcall();
        		addNewRollcall.setVisible(true);
        		f1.dispose();        	}
        });

        //Add Add New Member button to switch to the Add New Member pane
        JButton addMember=new JButton("Add New Member");//creating instance of JButton  
        addMember.setBounds(40,460,290,100);//x axis, y axis, width, height 
        addMember.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        contentPane.add(addMember);
        addMember.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
        		AddNewMember addNewMember = new AddNewMember();
        		addNewMember.setVisible(true);
        		f1.dispose();        	}
        });

        //Add Add New Party button for looks only
        JButton addParty=new JButton("Add New Party");//creating instance of JButton  
        addParty.setBounds(40,580,290,100);//x axis, y axis, width, height 
        addParty.setFont(new Font("Sans-serif", Font.PLAIN, 28));
        addParty.setBackground(new Color(255, 235, 153));
        addParty.setOpaque(true);
        addParty.setBorderPainted(false);
        contentPane.add(addParty);

        //Add input labels
        //Party Name
        JLabel pName = new JLabel("Party Name", JLabel.CENTER);
        pName.setBounds(400,275,100,50);
        pName.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        pName.setOpaque(true);
        pName.setBackground(new Color(255, 255, 255));

        //Chamber
        JLabel chamb = new JLabel("Chamber", JLabel.CENTER);
        chamb.setBounds(400,345,100,50);
        chamb.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        chamb.setOpaque(true);
        chamb.setBackground(new Color(255, 255, 255));

        //Congress
        JLabel cong = new JLabel("Congress", JLabel.CENTER);
        cong.setBounds(375,405,150,50);
        cong.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        cong.setOpaque(true);
        cong.setBackground(new Color(255, 255, 255));
        
        //Number of members
        JLabel memb = new JLabel("No. of Members", JLabel.CENTER);
        memb.setBounds(375,455,150,60);
        memb.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        memb.setOpaque(true);
        memb.setBackground(new Color(255, 255, 255));
        
        //Notifier
        JLabel notifier = new JLabel("<html><center>To create new database entry, please fill in all fields and press the \"Enter Date\" button. Be sure to press the ENTER key after typing in a text box. </center></html>", JLabel.CENTER);
        notifier.setBounds(375,530,500,50);
        notifier.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        notifier.setOpaque(true);
        notifier.setBackground(new Color(255, 255, 255));
      
        //Generate new party code and add it
        QueryDataEngine queryEngine = new QueryDataEngine();
        queryEngine.queryAll("HSall_parties");
        ResultSet rs = queryEngine.getResultSet();
        ArrayList<String> codeList = new ArrayList<String>();
        try {
	        while (rs.next ())
	        {
	            codeList.add(rs.getString("party_code"));	            
	        }
        rs.close ();
        } catch(Exception exc) {
        	exc.printStackTrace();
        }
        Random rand = new Random();
        boolean available = false;
        while(!available) {
            outCode = Integer.toString(rand.nextInt(999));
            available = true;
            for(String item : codeList) {
            	if(item.equals(outCode))
            		available = false;
            }
        }
        String codeLabel = "Party Code: " + outCode;
        JLabel pCode = new JLabel(codeLabel, JLabel.CENTER);
        pCode.setBounds(410,595,215,50);
        pCode.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        pCode.setOpaque(true);
        pCode.setBackground(new Color(255, 255, 255));
        pCode.setBorder(blackline);

        
        //Add input objects
        //Party blank
        JTextField partyFill = new JTextField(20);
        partyFill.setBounds(550,275,290,50);
        partyFill.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		partyInput = partyFill.getText();
        		System.out.println(partyInput);
        	}
        });

        //Chamber dropdown
        String[] chambers = { "None", "Senate", "House", "President" };
        JComboBox chamberDropdown = new JComboBox(chambers);
        chamberDropdown.setSelectedIndex(0);
        chamberDropdown.setBounds(550,345,290,50);
        String selectedChamber = (String)chamberDropdown.getSelectedItem();
        chamberDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedChamber = (String)chamberDropdown.getSelectedItem();
        		outChamb = selectedChamber;
        	}
        });

        //Congress blank
        JTextField congressFill = new JTextField(20);
        congressFill.setBounds(550,405,290,50);
        congressFill.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		outCongress = congressFill.getText();
        	}
        });
        
        //Members blank
        JTextField membersFill = new JTextField(20);
        membersFill.setBounds(550,465,290,50);
        membersFill.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		members = membersFill.getText();
        	}
        });

        //Add button that allows for data to be added to database
        JButton enterDataOne=new JButton("Enter Data");//creating instance of JButton  
        enterDataOne.setBounds(650,595,215,50);//x axis, y axis, width, height 
        enterDataOne.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        contentPane.add(enterDataOne);
        enterDataOne.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(partyInput!="None" && outChamb!="None" && outCongress !="None"){        			
        			//Add the data to the database using SQL
        			AddDataEngine dataEngine = new AddDataEngine();
        			dataEngine.addParty(outCongress, outChamb, outCode, partyInput, members);
        			
        			//Generate new party code
        	        QueryDataEngine queryEngine = new QueryDataEngine();
        	        queryEngine.queryAll("HSall_parties");
        	        ResultSet rs = queryEngine.getResultSet();
        	        ArrayList<String> codeList = new ArrayList<String>();
        	        try {
        		        while (rs.next ())
        		        {
        		            codeList.add(rs.getString("party_code"));	            
        		        }
        	        rs.close ();
        	        } catch(Exception exc) {
        	        	exc.printStackTrace();
        	        }
        	        Random rand = new Random();
        	        boolean available = false;
        	        while(!available) {
        	            outCode = Integer.toString(rand.nextInt(999));
        	            available = true;
        	            for(String item : codeList) {
        	            	if(item.equals(outCode))
        	            		available = false;
        	            }
        	        }
        	        
        	        //Update fields
        			notifier.setText("Entered data.");
        	        String codeLabel = "Party Code: " + outCode;
        	        pCode.setText(codeLabel);
        			
        		}else{
        			notifier.setText("Fill in all fields.");
        		}
        	}
        });

        //Add objects to GUI panel
        contentPane.add(pName);
        contentPane.add(chamb);
        contentPane.add(cong);
        contentPane.add(memb);
        contentPane.add(pCode);
        contentPane.add(partyFill);
        contentPane.add(chamberDropdown);
        contentPane.add(congressFill);
        contentPane.add(membersFill);
        contentPane.add(notifier);
        contentPane.add(t1);



        t1.setVisible(true); 
        t.setVisible(false); // Hide previous frame

    }
}
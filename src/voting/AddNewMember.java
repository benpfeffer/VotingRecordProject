package voting;

import javax.swing.*;  
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class AddNewMember extends JFrame {
	private JPanel contentPane;
    public static String nameInput = "None";
    public static String bdInput = "None";
    public static String bioGuideInput = "None";
    public static String icpInput = "None";
    public static String outCong = "None";
    public static String outChamb = "None";
    public static String selectedDistrict = "None";    
    public static String selectedState = "None";
    public static String selectedStateIcp = "None";
    public static String selectedParty = "None";


    
    public AddNewMember() {
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
        addVote.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        contentPane.add(addVote);
        addVote.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
        		AddNewVote addNewVote = new AddNewVote();
        		addNewVote.setVisible(true);
                f1.dispose();        	}
        });


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

        JButton addMember=new JButton("Add New Member");//creating instance of JButton  
        addMember.setBounds(40,460,290,100);//x axis, y axis, width, height 
        addMember.setFont(new Font("Sans-serif", Font.PLAIN, 28));
        addMember.setBackground(new Color(255, 235, 153));
        addMember.setOpaque(true);
        addMember.setBorderPainted(false);
        contentPane.add(addMember);

        JButton addParty=new JButton("Add New Party");//creating instance of JButton  
        addParty.setBounds(40,580,290,100);//x axis, y axis, width, height 
        addParty.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        contentPane.add(addParty);
        addParty.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
        		AddNewParty addNewParty = new AddNewParty();
        		addNewParty.setVisible(true);
                f1.dispose();        	}
        });
     
        JLabel name = new JLabel("Name", JLabel.CENTER);
        name.setBounds(400,255,100,30);
        name.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        name.setOpaque(true);
        name.setBackground(new Color(255, 255, 255));

        JLabel bd = new JLabel("Birth Year", JLabel.CENTER);
        bd.setBounds(400,295,100,30);
        bd.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        bd.setOpaque(true);
        bd.setBackground(new Color(255, 255, 255));

        JLabel chamb = new JLabel("Chamber", JLabel.CENTER);
        chamb.setBounds(400,335,100,30);
        chamb.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        chamb.setOpaque(true);
        chamb.setBackground(new Color(255, 255, 255));

        JLabel state = new JLabel("State", JLabel.CENTER);
        state.setBounds(375,375,150,30);
        state.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        state.setOpaque(true);
        state.setBackground(new Color(255, 255, 255));

        JLabel district = new JLabel("District", JLabel.CENTER);
        district.setBounds(665,375,75,30);
        district.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        district.setOpaque(true);
        district.setBackground(new Color(255, 255, 255));

        JLabel cong = new JLabel("Congress", JLabel.CENTER);
        cong.setBounds(400,415,100,30);
        cong.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        cong.setOpaque(true);
        cong.setBackground(new Color(255, 255, 255));

        JLabel party = new JLabel("Party ID", JLabel.CENTER);
        party.setBounds(400,455,100,30);
        party.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        party.setOpaque(true);
        party.setBackground(new Color(255, 255, 255));

        JLabel bioGuide = new JLabel("Bio Guide ID", JLabel.CENTER);
        bioGuide.setBounds(400,495,120,30);
        bioGuide.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        bioGuide.setOpaque(true);
        bioGuide.setBackground(new Color(255, 255, 255));

        JLabel icp = new JLabel("ICPSR", JLabel.CENTER);
        icp.setBounds(400,535,100,30);
        icp.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        icp.setOpaque(true);
        icp.setBackground(new Color(255, 255, 255));
        
        JLabel notifier = new JLabel("<html><center>To create new database entry, please fill in all fields and press the \"Enter Date\" button. Be sure to press the ENTER key after typing in a text box. </center></html>", JLabel.CENTER);
        notifier.setBounds(410,595,230,70);
        notifier.setFont(new Font("Sans-serif", Font.PLAIN, 12));
        notifier.setOpaque(true);
        notifier.setBackground(new Color(255, 255, 255));


        JTextField nameBlank = new JTextField(20);
        nameBlank.setBounds(550,255,290,30);
        nameBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		nameInput = nameBlank.getText();
        		System.out.println(nameInput);
        	}
        });

        JTextField bdBlank = new JTextField(20);
        bdBlank.setBounds(550,295,290,30);
        bdBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		bdInput = bdBlank.getText();
        		System.out.println(bdInput);
        	}
        });

        String[] chambers = { "None", "Senate", "House", "President" };
        JComboBox chamberDropdown = new JComboBox(chambers);
        chamberDropdown.setSelectedIndex(0);
        chamberDropdown.setBounds(550,335,290,30);
        String selectedChamber = (String)chamberDropdown.getSelectedItem();
        chamberDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedChamber = (String)chamberDropdown.getSelectedItem();
        		outChamb = selectedChamber;
        	}
        });

        String[] states = { "None", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI","SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
        String[] state_icpsr = { "None", "41", "81", "61", "42", "71", "62", "1", "11", "43", "44", "82", "63", "21", "22", "31", "32", "51", "45", "2", "52", "3", "23", "33", "46", "34", "64", "35", "65", "4", "12", "66", "13", "47", "36", "24", "53", "72", "14", "5","48", "37", "54", "49", "67", "6", "40", "73", "56", "25", "68"};

        JComboBox stateDropdown = new JComboBox(states);
        stateDropdown.setSelectedIndex(0);
        stateDropdown.setBounds(550,375,90,30);
        selectedState = (String)stateDropdown.getSelectedItem();
        stateDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectedState = (String)stateDropdown.getSelectedItem();
        		int i = 0;
        		while(states[i] != selectedState) {
        			i++;
        		}
    			selectedStateIcp = state_icpsr[i];
        			
        	}
        });

        String[] districts = new String[56];
        for(int i = 0; i < 56; i++) {
        	districts[i] = Integer.toString(i);
        }
        JComboBox districtDropdown = new JComboBox(districts);
        districtDropdown.setSelectedIndex(0);
        districtDropdown.setBounds(750,375,90,30);
        selectedDistrict = (String)districtDropdown.getSelectedItem();
        districtDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectedDistrict = (String)districtDropdown.getSelectedItem();
        	}
        });

        //Congress Selector
        JTextField congressFill = new JTextField(20);
        congressFill.setBounds(550,415,290,30);
        congressFill.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		outCong = congressFill.getText();
        	}
        });

        JTextField partyFill = new JTextField(20);
        partyFill.setBounds(550,455,290,30);
        partyFill.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectedParty = partyFill.getText();
        	}
        });

        JTextField bioGuideBlank = new JTextField(20);
        bioGuideBlank.setBounds(550,495,290,30);
        bioGuideBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		bioGuideInput = bioGuideBlank.getText();
        	}
        });

        JTextField icpBlank = new JTextField(20);
        icpBlank.setBounds(550,535,290,30);
        icpBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		icpInput = icpBlank.getText();
        	}
        });

        JButton enterDataOne=new JButton("Enter Data");//creating instance of JButton  
        enterDataOne.setBounds(650,595,215,30);//x axis, y axis, width, height 
        enterDataOne.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        contentPane.add(enterDataOne);
        enterDataOne.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(nameInput!="None" && bdInput!="None" && bioGuideInput!="None" && outCong!="None" && outChamb!="None" && icpInput!="None"){
        			//Add the data to the database using SQL
        			AddDataEngine dataEngine = new AddDataEngine();
        			dataEngine.addMember(outCong, outChamb, icpInput, selectedStateIcp, selectedDistrict, selectedState, selectedParty, nameInput, bioGuideInput,  bdInput);
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
        contentPane.add(nameBlank);
        contentPane.add(name);
        contentPane.add(bdBlank);
        contentPane.add(bd);
        contentPane.add(chamb);
        contentPane.add(state);
        contentPane.add(district);
        contentPane.add(cong);
        contentPane.add(party);
        contentPane.add(bioGuide);
        contentPane.add(bioGuideBlank);
        contentPane.add(icp);
        contentPane.add(icpBlank);
        contentPane.add(chamberDropdown);
        contentPane.add(stateDropdown);
        contentPane.add(districtDropdown);
        contentPane.add(congressFill);
        contentPane.add(partyFill);
        contentPane.add(notifier);
        contentPane.add(t1);



        t1.setVisible(true); 
        t.setVisible(false); // Hide previous frame

    }
}
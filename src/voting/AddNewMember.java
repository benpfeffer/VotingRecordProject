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

public class AddNewMember extends JFrame {
	private JPanel contentPane;
    private JTextField txtTypeYourQuestion;
    private JTextField txtQuestionWeight;
    private JTextField txtEnter;
    private JTextField txtEnter_1;
    private JTextField txtValue;
    private JTextField txtValue_1;
    //private final Action action = new SwingAction();
    public static String nameInput = "None";
    public static String bdInput = "None";
    public static String bioGuideInput = "None";
    public static String icpInput = "None";
    public static String outCong = "None";
    public static String outChamb = "None";
    public static String outRollNum = "None";
    public static String outIcp = "None";
    public static String outCast = "None";
    
    public AddNewMember() {
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
        name.setBounds(400,245,100,50);
        name.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        name.setOpaque(true);
        name.setBackground(new Color(255, 255, 255));

        JLabel bd = new JLabel("Birthdate", JLabel.CENTER);
        bd.setBounds(400,285,100,50);
        bd.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        bd.setOpaque(true);
        bd.setBackground(new Color(255, 255, 255));

        JLabel chamb = new JLabel("Chamber", JLabel.CENTER);
        chamb.setBounds(400,325,100,50);
        chamb.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        chamb.setOpaque(true);
        chamb.setBackground(new Color(255, 255, 255));

        JLabel state = new JLabel("State", JLabel.CENTER);
        state.setBounds(375,365,150,50);
        state.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        state.setOpaque(true);
        state.setBackground(new Color(255, 255, 255));

        JLabel district = new JLabel("District", JLabel.CENTER);
        district.setBounds(665,365,75,50);
        district.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        district.setOpaque(true);
        district.setBackground(new Color(255, 255, 255));

        JLabel cong = new JLabel("Congress", JLabel.CENTER);
        cong.setBounds(400,405,100,50);
        cong.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        cong.setOpaque(true);
        cong.setBackground(new Color(255, 255, 255));

        JLabel party = new JLabel("Party", JLabel.CENTER);
        party.setBounds(400,445,100,50);
        party.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        party.setOpaque(true);
        party.setBackground(new Color(255, 255, 255));

        JLabel bioGuide = new JLabel("Bio Guide", JLabel.CENTER);
        bioGuide.setBounds(400,485,100,50);
        bioGuide.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        bioGuide.setOpaque(true);
        bioGuide.setBackground(new Color(255, 255, 255));

        JLabel icp = new JLabel("ICPSR", JLabel.CENTER);
        icp.setBounds(400,525,100,50);
        icp.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        icp.setOpaque(true);
        icp.setBackground(new Color(255, 255, 255));



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



        String[] chambers = { "None", "Chamber1", "Chamber2", "Chamber3", "Chamber4", "Chamber5" };
        JComboBox chamberDropdown = new JComboBox(chambers);
        chamberDropdown.setSelectedIndex(0);
        chamberDropdown.setBounds(550,325,290,50);
        String selectedChamber = (String)chamberDropdown.getSelectedItem();
        chamberDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedChamber = (String)chamberDropdown.getSelectedItem();
        		outChamb = selectedChamber;
        		System.out.println(selectedChamber);
        	}
        });

        String[] states = { "None", "1", "2", "3", "4", "5" };
        JComboBox stateDropdown = new JComboBox(states);
        stateDropdown.setSelectedIndex(0);
        stateDropdown.setBounds(550,365,90,50);
        String selectedState = (String)stateDropdown.getSelectedItem();
        stateDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedState = (String)stateDropdown.getSelectedItem();
        		System.out.println(selectedState);
        	}
        });

        String[] districts = { "None", "1", "2", "3", "4", "5" };
        JComboBox districtDropdown = new JComboBox(districts);
        districtDropdown.setSelectedIndex(0);
        districtDropdown.setBounds(750,365,90,50);
        String selectedDistrict = (String)districtDropdown.getSelectedItem();
        districtDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedDistrict = (String)districtDropdown.getSelectedItem();
        		System.out.println(selectedDistrict);
        	}
        });

        String[] congs = { "None", "Congress1", "Congress2", "Congress3", "Congress4", "Congress5" };
        JComboBox congDropdown = new JComboBox(congs);
        congDropdown.setSelectedIndex(0);
        congDropdown.setBounds(550,405,290,50);
        String selectedCongs = (String)congDropdown.getSelectedItem();
        congDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedCong = (String)congDropdown.getSelectedItem();
        		System.out.println(selectedCong);
        	}
        });

        String[] parties = { "None", "Dem", "Rep", "Ind", "Green", "Libertarian" };
        JComboBox partyDropdown = new JComboBox(parties);
        partyDropdown.setSelectedIndex(0);
        partyDropdown.setBounds(550,445,290,50);
        String selectedParty = (String)partyDropdown.getSelectedItem();
        partyDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedParty = (String)partyDropdown.getSelectedItem();
        		System.out.println(selectedParty);
        	}
        });

        JTextField bioGuideBlank = new JTextField(20);
        bioGuideBlank.setBounds(550,495,290,30);
        bioGuideBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		bioGuideInput = bioGuideBlank.getText();
        		System.out.println(bioGuideInput);
        	}
        });

        JTextField icpBlank = new JTextField(20);
        icpBlank.setBounds(550,535,290,30);
        icpBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		icpInput = icpBlank.getText();
        		System.out.println(icpInput);
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
        contentPane.add(congDropdown);
        contentPane.add(partyDropdown);
        contentPane.add(t1);



        t1.setVisible(true); 
        t.setVisible(false); // Hide previous frame

    }
}
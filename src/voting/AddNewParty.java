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

public class AddNewParty extends JFrame {
	private JPanel contentPane;
    private JTextField txtTypeYourQuestion;
    private JTextField txtQuestionWeight;
    private JTextField txtEnter;
    private JTextField txtEnter_1;
    private JTextField txtValue;
    private JTextField txtValue_1;
    //private final Action action = new SwingAction();
    public static String partyInput = "None";
    public static String outChamb = "None";
    public static String outRollNum = "None";
    public static String outIcp = "None";
    public static String outCast = "None";


    public AddNewParty() {
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
              f1.dispose();        }
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
              f1.dispose();        }
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
        addMember.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        contentPane.add(addMember);
        addMember.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
        		AddNewMember addNewMember = new AddNewMember();
        		addNewMember.setVisible(true);
        		f1.dispose();        	}
        });

        JButton addParty=new JButton("Add New Party");//creating instance of JButton  
        addParty.setBounds(40,580,290,100);//x axis, y axis, width, height 
        addParty.setFont(new Font("Sans-serif", Font.PLAIN, 28));
        addParty.setBackground(new Color(255, 235, 153));
        addParty.setOpaque(true);
        addParty.setBorderPainted(false);
        contentPane.add(addParty);

        JLabel pName = new JLabel("Party Name", JLabel.CENTER);
        pName.setBounds(400,275,100,50);
        pName.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        pName.setOpaque(true);
        pName.setBackground(new Color(255, 255, 255));

        JLabel chamb = new JLabel("Chamber", JLabel.CENTER);
        chamb.setBounds(400,365,100,50);
        chamb.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        chamb.setOpaque(true);
        chamb.setBackground(new Color(255, 255, 255));

        JLabel cong = new JLabel("Congress", JLabel.CENTER);
        cong.setBounds(375,455,150,50);
        cong.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        cong.setOpaque(true);
        cong.setBackground(new Color(255, 255, 255));

        JLabel pCode = new JLabel("Party Code: ####", JLabel.CENTER);
        pCode.setBounds(410,595,215,50);
        pCode.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        pCode.setOpaque(true);
        pCode.setBackground(new Color(255, 255, 255));
        pCode.setBorder(blackline);

        JTextField partyFill = new JTextField(20);
        partyFill.setBounds(550,275,290,50);
        partyFill.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		partyInput = partyFill.getText();
        		System.out.println(partyInput);
        	}
        });

        String[] chambers = { "None", "Chamber1", "Chamber2", "Chamber3", "Chamber4", "Chamber5" };
        JComboBox chamberDropdown = new JComboBox(chambers);
        chamberDropdown.setSelectedIndex(0);
        chamberDropdown.setBounds(550,365,290,50);
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
        rollNumDropdown.setBounds(550,455,290,50);
        String selectedRollNum = (String)rollNumDropdown.getSelectedItem();
        rollNumDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedRollNum = (String)rollNumDropdown.getSelectedItem();
        		outRollNum = selectedRollNum;
        		System.out.println(selectedRollNum);
        	}
        });



        JButton enterDataOne=new JButton("Enter Data");//creating instance of JButton  
        enterDataOne.setBounds(650,595,215,50);//x axis, y axis, width, height 
        enterDataOne.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        contentPane.add(enterDataOne);
        enterDataOne.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(partyInput!="None" && outChamb!="None" && outRollNum!="None"){
        			System.out.println("Entered data.");
        			System.out.println(partyInput);
        		}else{
        			System.out.println("Fill in all fields.");
        			System.out.println(partyInput);
        		}
        	}
        });


        JLabel t1 = new JLabel();
        t1.setBounds(350,220,570,460);
        t1.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        t1.setOpaque(true);
        t1.setBackground(new Color(255, 255, 255));
        contentPane.add(pName);
        contentPane.add(chamb);
        contentPane.add(cong);
        contentPane.add(pCode);
        contentPane.add(partyFill);
        contentPane.add(chamberDropdown);
        contentPane.add(rollNumDropdown);
        contentPane.add(t1);



        t1.setVisible(true); 
        t.setVisible(false); // Hide previous frame

    }
}
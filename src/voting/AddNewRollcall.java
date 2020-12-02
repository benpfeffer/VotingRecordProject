package voting;

import javax.swing.*;  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class AddNewRollcall extends JFrame {
	private JPanel contentPane;
    public static String billInput = "None";
    public static String voteResInput = "None";
    public static String sessInput = "None";
    public static String clerkInput = "None";
    public static String vDescInput = "None";
    public static String vQuestionInput = "None";
    public static String dDescInput = "None";
    public static String outCong = "None";
    public static String outChamb = "None";
    public static String outRollNum = "0";
    public static String outIcp = "None";
    public static String outCast = "None";
    public static String dateInput = "None";
    
    public AddNewRollcall() {
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
              f1.dispose();
        }
          });
        
        JButton addRollcall=new JButton("Add New Rollcall");//creating instance of JButton  
	    addRollcall.setBounds(40,340,290,100);//x axis, y axis, width, height 
        addRollcall.setFont(new Font("Sans-serif", Font.PLAIN, 28));
        addRollcall.setBackground(new Color(255, 235, 153));
        addRollcall.setOpaque(true);
        addRollcall.setBorderPainted(false);
        contentPane.add(addRollcall);
        
        JButton addMember=new JButton("Add New Member");//creating instance of JButton  
	       addMember.setBounds(40,460,290,100);//x axis, y axis, width, height 
        addMember.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        contentPane.add(addMember);
        addMember.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	   JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
              AddNewMember addNewMember = new AddNewMember();
              addNewMember.setVisible(true);
              f1.dispose();
           }
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
              f1.dispose();
           }
          });

        JLabel billN = new JLabel("Bill No.", JLabel.CENTER);
        billN.setBounds(400,240,100,30);
        billN.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        billN.setOpaque(true);
        billN.setBackground(new Color(255, 255, 255));

        JLabel voteR = new JLabel("Vote Result", JLabel.CENTER);
        voteR.setBounds(655,240,100,30);
        voteR.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        voteR.setOpaque(true);
        voteR.setBackground(new Color(255, 255, 255));

        JLabel cong = new JLabel("Congress", JLabel.CENTER);
        cong.setBounds(400,275,100,50);
        cong.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        cong.setOpaque(true);
        cong.setBackground(new Color(255, 255, 255));

        JLabel chamb = new JLabel("Chamber", JLabel.CENTER);
        chamb.setBounds(400,320,100,50);
        chamb.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        chamb.setOpaque(true);
        chamb.setBackground(new Color(255, 255, 255));

        JLabel date = new JLabel("Date", JLabel.CENTER);
        date.setBounds(375,365,150,50);
        date.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        date.setOpaque(true);
        date.setBackground(new Color(255, 255, 255));

        JLabel sess = new JLabel("Session", JLabel.CENTER);
        sess.setBounds(400,410,100,50);
        sess.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        sess.setOpaque(true);
        sess.setBackground(new Color(255, 255, 255));

        JLabel clerkNo = new JLabel("Clerk No.", JLabel.CENTER);
        clerkNo.setBounds(655,410,100,40);
        clerkNo.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        clerkNo.setOpaque(true);
        clerkNo.setBackground(new Color(255, 255, 255));

        JLabel vDesc = new JLabel("Vote Desc", JLabel.CENTER);
        vDesc.setBounds(400,450,100,40);
        vDesc.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        vDesc.setOpaque(true);
        vDesc.setBackground(new Color(255, 255, 255));
        
        JLabel vQuestion = new JLabel("Vote Question", JLabel.CENTER);
        vQuestion.setBounds(380,485,150,40);
        vQuestion.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        vQuestion.setOpaque(true);
        vQuestion.setBackground(new Color(255, 255, 255));

        JLabel dDesc = new JLabel("Detailed Desc", JLabel.CENTER);
        dDesc.setBounds(390,530,120,40);
        dDesc.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        dDesc.setOpaque(true);
        dDesc.setBackground(new Color(255, 255, 255));

        JLabel notifier = new JLabel("<html><center>To create new database entry, please fill in all fields and press the \"Enter Date\" button. Be sure to press the ENTER key after typing in a text box. </center></html>", JLabel.CENTER);
        notifier.setBounds(410,595,230,70);
        notifier.setFont(new Font("Sans-serif", Font.PLAIN, 12));
        notifier.setOpaque(true);
        notifier.setBackground(new Color(255, 255, 255));


        JTextField billNo = new JTextField(20);
        billNo.setBounds(550,240,75,30);
        billNo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		billInput = billNo.getText();
        	}
        });

        JTextField voteRes = new JTextField(20);
        voteRes.setBounds(765,240,75,30);
        voteRes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		voteResInput = voteRes.getText();
        	}
        });

        JTextField congressFill = new JTextField(20);
        congressFill.setBounds(550,280,290,30);
        congressFill.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		outCong = congressFill.getText();
        	}
        });


        String[] chambers = { "None", "Senate", "House", "President" };
        JComboBox chamberDropdown = new JComboBox(chambers);
        chamberDropdown.setSelectedIndex(0);
        chamberDropdown.setBounds(550,320,290,50);
        String selectedChamber = (String)chamberDropdown.getSelectedItem();
        chamberDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedChamber = (String)chamberDropdown.getSelectedItem();
        		outChamb = selectedChamber;
        	}
        });

      //Start Date Selector
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); 

        Date earliestDate = null, latestDate = null, targetDate = null;
        try {
             earliestDate = formatter.parse("1789-05-16");
             latestDate = formatter.parse("2099-12-31");
             targetDate = formatter.parse("2017-08-03");
        } catch(Exception e) {
        	System.out.println("Failed to parse");
        }
        
        dDescInput = "2017-08-03";
        SpinnerDateModel modelStart = new SpinnerDateModel(targetDate, earliestDate, latestDate, Calendar.DAY_OF_MONTH);
        JSpinner rollDate = new JSpinner(modelStart);
        rollDate.setEditor(new JSpinner.DateEditor(rollDate, "yyyy/mm/dd"));           
        rollDate.setBounds(550,380,200,30);
        rollDate.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dateInput = formatter.format(rollDate.getModel().getValue());
            }
        });

        JTextField sessBlank = new JTextField(20);
        sessBlank.setBounds(550,420,75,30);
        sessBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		sessInput = sessBlank.getText();
        	}
        });

        JTextField clerkBlank = new JTextField(20);
        clerkBlank.setBounds(765,420,75,30);
        clerkBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clerkInput = clerkBlank.getText();
        	}
        });

        JTextField vDescBlank = new JTextField(100);
        vDescBlank.setBounds(550,455,290,30);
        vDescBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		vDescInput = vDescBlank.getText();
        	}
        });
        
        JTextField vQuestionBlank = new JTextField(100);
        vQuestionBlank.setBounds(550,490,290,30);
        vQuestionBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		vQuestionInput = vQuestionBlank.getText();
        	}
        });

        JTextField dDescBlank = new JTextField(250);
        dDescBlank.setBounds(550,530,290,50);
        dDescBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dDescInput = dDescBlank.getText();
        	}
        });


        JButton enterDataOne=new JButton("Enter Data");//creating instance of JButton  
        enterDataOne.setBounds(650,595,215,50);//x axis, y axis, width, height 
        enterDataOne.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        contentPane.add(enterDataOne);
        enterDataOne.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println(billNo.getText());
        		if(billInput!="None" && voteResInput!="None" && sessInput!="None" && clerkInput!="None" && outCong!="None" && outChamb!="None"){
        		    AddDataEngine dataEngine = new AddDataEngine();
        		    
        		    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        		    // Need to change this so that the roll number is determined by how many roll calls have already been called for this congress
        		    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        		    outRollNum = "1";
        		    		
        			dataEngine.addRollcall(outCong, outChamb, outRollNum, dateInput, sessInput, clerkInput, billInput, voteResInput, vDescInput, vQuestionInput, dDescInput);
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
        contentPane.add(billN);
        contentPane.add(voteR);
        contentPane.add(vDesc);
        contentPane.add(vQuestion);
        contentPane.add(dDesc);
        contentPane.add(billNo);
        contentPane.add(clerkNo);
        contentPane.add(voteRes);
        contentPane.add(sessBlank);
        contentPane.add(clerkBlank);
        contentPane.add(vDescBlank);
        contentPane.add(vQuestionBlank);
        contentPane.add(dDescBlank);
        contentPane.add(cong);
        contentPane.add(chamb);
        contentPane.add(date);
        contentPane.add(sess);
        contentPane.add(notifier);
        contentPane.add(congressFill);
        contentPane.add(chamberDropdown);
        contentPane.add(rollDate);
        contentPane.add(t1);



        t1.setVisible(true); 
        t.setVisible(false); // Hide previous frame

    }
}
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.util.Arrays;

public class AdvancedSearch extends JFrame {
	private JPanel contentPane;
    private JTextField txtTypeYourQuestion;
    private JTextField txtQuestionWeight;
    private JTextField txtEnter;
    private JTextField txtEnter_1;
    private JTextField txtValue;
    private JTextField txtValue_1;
    //private final Action action = new SwingAction();
    public static String dRangeInput = "None";
    public static String fillInInput = "None";
    public static String outChamb = "None";
    public static String outCong = "None";
    public static String outIcp = "None";
    public static String outCast = "None";
    public static String selectedSsc = "None";
    
    QueryDataEngine dataEngine = new QueryDataEngine();
    
    public AdvancedSearch() {
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


        JButton bSearch=new JButton("Basic Search");//creating instance of JButton  
	      bSearch.setBounds(175,200,290,80);//x axis, y axis, width, height 
        bSearch.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        bSearch.setBorderPainted(false);
        contentPane.add(bSearch);
        bSearch.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
        	BasicSearch basicSearch = new BasicSearch();
        	basicSearch.setVisible(true);
        	f1.dispose();
        	System.out.println("Basic search");
        }
          });
        
        
        JButton aSearch=new JButton("Advanced Search");//creating instance of JButton  
	      aSearch.setBounds(470,200,310,80);//x axis, y axis, width, height 
        aSearch.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        Font btnFont = aSearch.getFont();
        Map attributes = btnFont.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        btnFont = btnFont.deriveFont(attributes);
        aSearch.setFont(btnFont);
        aSearch.setBorderPainted(false);
        contentPane.add(aSearch);

        JLabel ssc = new JLabel("Select Search Criteria", JLabel.CENTER);
        ssc.setBounds(175,275,200,50);
        ssc.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        ssc.setOpaque(true);

        JLabel fillLabel = new JLabel("Search on value :", JLabel.CENTER);
        fillLabel.setBounds(175,325,200,50);
        fillLabel.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        fillLabel.setOpaque(true);
        
        JLabel dRange = new JLabel("Date (YYYY-MM-DD) (ROLLCALL ONLY)", JLabel.CENTER);
        dRange.setBounds(175,450,350,50);
        dRange.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        dRange.setOpaque(true);

        JLabel cong = new JLabel("Congress", JLabel.CENTER);
        cong.setBounds(175,375,200,50);
        cong.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        cong.setOpaque(true);

        JLabel chamb = new JLabel("Chamber", JLabel.CENTER);
        chamb.setBounds(560,375,125,50);
        chamb.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        chamb.setOpaque(true);

        JLabel endList = new JLabel("<html>List of parties / members / votes / rollcalls. <br/> Click on a given item to display the basic search attributes.</html>", JLabel.CENTER);
        endList.setBounds(175,525,690,150);
        endList.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        endList.setOpaque(true);
        endList.setBackground(new Color(255, 255, 255));
        endList.setBorder(blackline);


        String[] sscs = { "None", "Members - congress", "Members - chamber", "Members - icpsr",
        		"Members - state_icpsr", "Members - district_code", "Members - state_abbrev", "Members - party_code", 
        		"Members - occupancy", "Members - last_means", "Members - bioname", "Members - bioguide_id",
        		"Members - born", "Members - died", "Members - dim1", "Members - dim2",
        		"Members - log_likelihood", "Members - geo_mean_probability", "Members - number_of_votes", "Members - number_of_errors", "Members - conditional",
        		"Parties - congress", "Parties - chamber", "Parties - party_code", "Parties - party_name", "Parties - n_members",
        		"Parties - dim1_median", "Parties - dim2_median", "Parties - dim1_mean", "Parties - dim2_mean",
        		"Rollcalls - congress", "Rollcalls - chamber", "Rollcalls - rollnumber", "Rollcalls - date",
        		"Rollcalls - session", "Rollcalls - clerk_rollnumber", "Rollcalls - mid_1", "Rollcalls - mid_2",
        		"Rollcalls - spread_1", "Rollcalls - spread_2", "Rollcalls - log_likelihood", "Rollcalls - bill_number",
        		"Rollcalls - vote_result", "Rollcalls - vote_desc", "Rollcalls - vote_question", "Rollcalls - dtl_desc",
        		"Votes - congress", "Votes - chamber", "Votes - rollnumber", "Votes - icpsr", "Votes - cast_code"
        		};
        JComboBox sscDropdown = new JComboBox(sscs);
        sscDropdown.setSelectedIndex(0);
        sscDropdown.setBounds(400,275,290,50);
        sscDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectedSsc = (String)sscDropdown.getSelectedItem();
        		System.out.println(selectedSsc);
        	}
        });

        JTextField fillInBlank = new JTextField(20);
        fillInBlank.setBounds(400,325,465,50);
        fillInBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		fillInInput = fillInBlank.getText();
        		System.out.println(fillInInput);
        	}
        });
        
        
        JTextField dRangeBlank = new JTextField(20);
        dRangeBlank.setBounds(600,450,265,50);
        dRangeBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dRangeInput = dRangeBlank.getText();
        		System.out.println(dRangeInput);
        	}
        });
        
        
        
        String[] chambers = { "None", "Senate", "House", "President" };
        JComboBox chamberDropdown = new JComboBox(chambers);
        chamberDropdown.setSelectedIndex(0);
        chamberDropdown.setBounds(700,375,165,50);
        String selectedChamber = (String)chamberDropdown.getSelectedItem();
        chamberDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedChamber = (String)chamberDropdown.getSelectedItem();
        		outChamb = selectedChamber;
        		System.out.println(selectedChamber);
        	}
        });

        
        FieldList congsFieldList = new FieldList();
        congsFieldList.addField("Chamber",  "\"Senate\"");
        dataEngine.queryParty(congsFieldList);
        ResultSet rs = dataEngine.getResultSet();
        int count = 0;
        String[] congList = new String[116];//length should be number of congresses +1 (for "None")
        congList[0]="None";
        try {
        while (rs.next ())
        {
            String congVal = rs.getString ("congress");
            boolean contains = Arrays.stream(congList).anyMatch(congVal::equals);
            if(!contains) {
            	++count;
            	congList[count] = congVal;
            }
            
        }
        rs.close ();
        }catch(Exception exc) {
        	exc.printStackTrace();
        }
        String[] congs = congList;
        JComboBox congDropdown = new JComboBox(congs);
        congDropdown.setSelectedIndex(0);
        congDropdown.setBounds(400,375,165,50);
        congDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		outCong = (String)congDropdown.getSelectedItem();
        		System.out.println(outCong);
        	}
        });



        JButton enterDataOne=new JButton("Search");//creating instance of JButton  
        enterDataOne.setBounds(10,560,150,100);//x axis, y axis, width, height 
        enterDataOne.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        contentPane.add(enterDataOne);
        enterDataOne.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(selectedSsc != "None" && outChamb!="None" && outCong!="None"){
        			System.out.println("Entered data.");
        			String[] tokens = selectedSsc.split(" ", -1);
        			System.out.println(tokens[0]);//gives method
        			String method = tokens[0];
        			System.out.println(tokens[2]);//gives field
        			String field1 = tokens[2].substring(0);
        			String field2 = "\"" + outChamb + "\"";
        			String field3 = outCong;
        			String field4 = "\"" + dRangeInput + "\"";
        			fillInInput = fillInInput.replace("\"", "");
        			FieldList fieldList = new FieldList();
        			if(field1.equalsIgnoreCase("chamber") || field1.equalsIgnoreCase("state_abbrev") || field1.equalsIgnoreCase("bioname") || 
        					field1.equalsIgnoreCase("bioguide_id") || field1.equalsIgnoreCase("party_name") || field1.equalsIgnoreCase("date") ||
        					field1.equalsIgnoreCase("bill_number") || field1.equalsIgnoreCase("vote_result") || field1.equalsIgnoreCase("vote_desc") ||
        					field1.equalsIgnoreCase("vote_question") || field1.equalsIgnoreCase("dtl_desc")) {//if the field is a string field (any table)
        				System.out.println("HEY");
        				fillInInput = "\"" + fillInInput + "\"";
        			}
        			if(method.equalsIgnoreCase("Members")) {
        				//send to member query
        				fieldList.addField(field1, fillInInput);
            			fieldList.addField("Chamber", field2);
            			fieldList.addField("Congress", field3);
        				System.out.println("send to member query");
        				dataEngine.queryMember(fieldList);
        				ResultSet rs = dataEngine.getResultSet();
        				try {
            		        JTable rst = new ResultSetTable(rs);
            		        rst.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            		        contentPane.remove(endList);
            		        Component[] componentList = contentPane.getComponents();
            		        for(Component c : componentList){
            		            if(c instanceof JScrollPane){
            		                contentPane.remove(c);
            		            }
            		        }
            		        JScrollPane pane = new JScrollPane(rst);
            		        pane.setBounds(175,525,690,150);
            		        contentPane.add(pane, BorderLayout.CENTER);
            		        contentPane.revalidate();
            		        contentPane.repaint();
        				}catch(Exception ex) {
        					ex.printStackTrace();
        				}
        				
        			}else if(method.equalsIgnoreCase("Parties")) {
        				System.out.println("send to party query");
        				fieldList.addField(field1, fillInInput);
            			fieldList.addField("Chamber", field2);
            			fieldList.addField("Congress", field3);
        				dataEngine.queryParty(fieldList);
        				ResultSet rs = dataEngine.getResultSet();
        				try {
            		        JTable rst = new ResultSetTable(rs);
            		        rst.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            		        contentPane.remove(endList);
            		        Component[] componentList = contentPane.getComponents();
            		        for(Component c : componentList){
            		            if(c instanceof JScrollPane){
            		                contentPane.remove(c);
            		            }
            		        }
            		        JScrollPane pane = new JScrollPane(rst);
            		        pane.setBounds(175,525,690,150);
            		        contentPane.add(pane, BorderLayout.CENTER);
            		        contentPane.revalidate();
            		        contentPane.repaint();
        				}catch(Exception ex) {
        					ex.printStackTrace();
        				}
        			}else if(method.equalsIgnoreCase("Rollcalls")) {
        				System.out.println("send to rollcall query");
        				fieldList.addField(field1, fillInInput);
            			fieldList.addField("Chamber", field2);
            			fieldList.addField("Congress", field3);
            			System.out.println(field4);
            			System.out.println(field4.length());
            			System.out.println(field4.length()>5);
            			if(field4.length()>6) {
            				fieldList.addField("date", field4);
            			}
        				dataEngine.queryRollcall(fieldList);
        				ResultSet rs = dataEngine.getResultSet();
        				try {
            		        JTable rst = new ResultSetTable(rs);
            		        rst.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            		        contentPane.remove(endList);
            		        Component[] componentList = contentPane.getComponents();
            		        for(Component c : componentList){
            		            if(c instanceof JScrollPane){
            		                contentPane.remove(c);
            		            }
            		        }
            		        JScrollPane pane = new JScrollPane(rst);
            		        pane.setBounds(175,525,690,150);
            		        contentPane.add(pane, BorderLayout.CENTER);
            		        contentPane.revalidate();
            		        contentPane.repaint();
        				}catch(Exception ex) {
        					ex.printStackTrace();
        				}
        			}else if(method.equalsIgnoreCase("Votes")) {
        				System.out.println("send to vote query");
        				fieldList.addField(field1, fillInInput);
            			fieldList.addField("Chamber", field2);
            			fieldList.addField("Congress", field3);
        				dataEngine.queryVote(fieldList);
        				ResultSet rs = dataEngine.getResultSet();
        				try {
            		        JTable rst = new ResultSetTable(rs);
            		        rst.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            		        contentPane.remove(endList);
            		        Component[] componentList = contentPane.getComponents();
            		        for(Component c : componentList){
            		            if(c instanceof JScrollPane){
            		                contentPane.remove(c);
            		            }
            		        }
            		        JScrollPane pane = new JScrollPane(rst);
            		        pane.setBounds(175,525,690,150);
            		        contentPane.add(pane, BorderLayout.CENTER);
            		        contentPane.revalidate();
            		        contentPane.repaint();
        				}catch(Exception ex) {
        					ex.printStackTrace();
        				}
        			}
        			
        			
        			
        			
        			
        			
        			
        			
        			
        			
        			
        			
        		}else{
        			System.out.println("Fill in all fields.");
        		}
        	}
        });


        contentPane.add(ssc);
        contentPane.add(fillLabel);
        contentPane.add(dRange);
        contentPane.add(chamb);
        contentPane.add(cong);
        contentPane.add(dRangeBlank);
        contentPane.add(fillInBlank);
        contentPane.add(endList);
        contentPane.add(sscDropdown);
        contentPane.add(chamberDropdown);
        contentPane.add(congDropdown);


    }
}
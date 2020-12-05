package voting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class AdvancedSearch extends JFrame {
	private JPanel contentPane;
    public static String startDate = "None";
    public static String endDate = "None";
    public static String fillInInput = "None";
    public static String outChamb = "None";
    public static String outCong = "None";
    public static String outIcp = "None";
    public static String outCast = "None";
    public static String selectedSsc = "None";
    public static String selectedTbl = "None";
    
    //Set up query engine to handle SQL queries
    QueryDataEngine dataEngine = new QueryDataEngine();
    
    public AdvancedSearch() {
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
        menu.setBounds(40,40,150,50);//x axis, y axis, width, height 
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

        //Switch to go to basic search
        JButton bSearch=new JButton("Basic Search");//creating instance of JButton  
	      bSearch.setBounds(175,200,290,60);//x axis, y axis, width, height 
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
        
        //Switch to go to advanced search
        JButton aSearch=new JButton("Advanced Search");//creating instance of JButton  
	      aSearch.setBounds(470,200,310,60);//x axis, y axis, width, height 
        aSearch.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        Font btnFont = aSearch.getFont();
        Map attributes = btnFont.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        btnFont = btnFont.deriveFont(attributes);
        aSearch.setFont(btnFont);
        aSearch.setBorderPainted(false);
        contentPane.add(aSearch);
        
        //Label to Select which variable to search
        JLabel ssc = new JLabel("Select Search Criteria", JLabel.CENTER);
        ssc.setBounds(175,275,200,50);
        ssc.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        ssc.setOpaque(true);
        
        //Label for variable search input
        JLabel fillLabel = new JLabel("Search on value :", JLabel.CENTER);
        fillLabel.setBounds(175,325,200,50);
        fillLabel.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        fillLabel.setOpaque(true);
        
        //Label for date selector
        JLabel dRange = new JLabel("Date (YYYY-MM-DD)", JLabel.CENTER);
        dRange.setBounds(175,450,250,50);
        dRange.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        dRange.setOpaque(true);

        //Label for Congress selector
        JLabel cong = new JLabel("Congress", JLabel.CENTER);
        cong.setBounds(175,375,200,50);
        cong.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        cong.setOpaque(true);

        //Label for Chamber selector
        JLabel chamb = new JLabel("Chamber", JLabel.CENTER);
        chamb.setBounds(560,375,125,50);
        chamb.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        chamb.setOpaque(true);

        //Area to display search results
        JLabel endList = new JLabel("<html>List of parties / members / votes / rollcalls. <br/> Click on a given item to display the basic search attributes.</html>", JLabel.CENTER);
        endList.setBounds(175,525,690,150);
        endList.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        endList.setOpaque(true);
        endList.setBackground(new Color(255, 255, 255));
        endList.setBorder(blackline);

        //Options for variables to search by
        String[] sscs = { "None", "Members - icpsr",
        		"Members - state_icpsr", "Members - district_code", "Members - state_abbrev", "Members - party_code", 
        		"Members - occupancy", "Members - last_means", "Members - bioname", "Members - bioguide_id",
        		"Members - born", "Members - died", "Members - number_of_votes", "Members - number_of_errors",
        		"Parties - party_code", "Parties - party_name", "Parties - n_members",
        		"Rollcalls - rollnumber",
        		"Rollcalls - session", "Rollcalls - clerk_rollnumber", "Rollcalls - bill_number",
        		"Rollcalls - vote_result", "Rollcalls - vote_question",
        		"Votes - rollnumber", "Votes - icpsr", "Votes - cast_code"
        		};
        JComboBox sscDropdown = new JComboBox(sscs);
        sscDropdown.setSelectedIndex(0);
        sscDropdown.setBounds(400,275,200,50);
        sscDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectedSsc = (String)sscDropdown.getSelectedItem();
        		System.out.println(selectedSsc);
        	}
        });
        
        //Tables to search on
        String[] tbls = { "None", "Members", "Votes", "Rollcalls", "Parties"};
        JComboBox tblDropdown = new JComboBox(tbls);
        tblDropdown.setSelectedIndex(0);
        tblDropdown.setBounds(700,275,200,50);
        tblDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectedTbl = (String)tblDropdown.getSelectedItem();
        	}
        });

        //Area to type search criteria
        JTextField fillInBlank = new JTextField(20);
        fillInBlank.setBounds(400,325,465,50);
        fillInBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		fillInInput = fillInBlank.getText();
        		System.out.println(fillInInput);
        	}
        });
        
        //Start Date Selector
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); 

        Date earliestDate = null, latestDate = null;
        try {
             earliestDate = formatter.parse("1789-05-16");
             latestDate = formatter.parse("2017-08-03");
        } catch(Exception e) {
        	System.out.println("Failed to parse");
        }
        
        startDate = formatter.format(earliestDate);
        endDate = formatter.format(latestDate);
        SpinnerDateModel modelStart = new SpinnerDateModel(earliestDate, earliestDate, latestDate, Calendar.DAY_OF_MONTH);
        JSpinner dRangeStart = new JSpinner(modelStart);
        dRangeStart.setEditor(new JSpinner.DateEditor(dRangeStart, "yyyy/mm/dd"));           
        dRangeStart.setBounds(500,450,200,50);
        dRangeStart.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                startDate = formatter.format(dRangeStart.getModel().getValue());
            }
        });
        
        //End Date Selector
        SpinnerDateModel modelEnd = new SpinnerDateModel(latestDate, earliestDate, latestDate, Calendar.DAY_OF_MONTH);
        JSpinner dRangeEnd = new JSpinner(modelEnd);
        dRangeEnd.setEditor(new JSpinner.DateEditor(dRangeEnd, "yyyy/mm/dd"));           
        dRangeEnd.setBounds(700,450,200,50);
        dRangeEnd.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                endDate = formatter.format(dRangeStart.getModel().getValue());
            }
        });
        
        
        //Chamber Selector
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

        //Congress Selector
        FieldList congsFieldList = new FieldList();
        congsFieldList.addField("chamber",  "\"Senate\"");
        dataEngine.queryTable(congsFieldList, "HSall_parties", null);
        ResultSet rs = dataEngine.getResultSet();
        int count = 0;
        String[] congList = new String[118];//length should be number of congresses +1 (for "None")
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
        } catch(Exception exc) {
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

        //Button to execute query
        JButton enterDataOne=new JButton("Search");//creating instance of JButton  
        enterDataOne.setBounds(10,560,150,100);//x axis, y axis, width, height 
        enterDataOne.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        contentPane.add(enterDataOne);
        //Create query from currently selected attributes
        enterDataOne.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(selectedSsc != "None" && outChamb!="None" && outCong!="None"){
        			System.out.println("Entered data.");
        			String[] tokens = selectedSsc.split(" ", -1);
        			System.out.println(tokens[0]);//gives method
        			String method = tokens[0];
        			System.out.println(tokens[2]);//gives field
        			String field1 = tokens[2].substring(0);
        			fillInInput = fillInInput.replace("\"", "");
        			
        			//Create the list of fields that the query will use
        			FieldList fieldList = new FieldList();
        			if(field1.equalsIgnoreCase("chamber") || field1.equalsIgnoreCase("state_abbrev") || field1.equalsIgnoreCase("bioname") || 
        					field1.equalsIgnoreCase("bioguide_id") || field1.equalsIgnoreCase("party_name") || field1.equalsIgnoreCase("date") ||
        					field1.equalsIgnoreCase("bill_number") || field1.equalsIgnoreCase("vote_result") || field1.equalsIgnoreCase("vote_desc") ||
        					field1.equalsIgnoreCase("vote_question") || field1.equalsIgnoreCase("dtl_desc")) {//if the field is a string field (any table)
        				fillInInput = "\"" + fillInInput + "\"";
        			}
        			if(field1 != "None")
        				fieldList.addField(field1, fillInInput);
        			if(outChamb != "None")
        				fieldList.addField("chamber", "\"" + outChamb + "\"");
        			if(outCong != "None")
        				fieldList.addField("congress", outCong);
        			//MUST ADD ROLLCALL TABLE
        			fieldList.addField("startDate", startDate);
        			fieldList.addField("endDate", endDate);
        			
        			String tbl = null;
        			if(selectedTbl != "None" && !method.equalsIgnoreCase(selectedTbl)) {
        				if(selectedTbl == "Members")
        					tbl = "HSall_members";
        				if(selectedTbl == "Parties")
        					tbl = "HSall_parties";
        				if(selectedTbl == "Rollcall")
        					tbl = "HSall_rollcalls";
        				if(selectedTbl == "Votes")
        					tbl = "HSall_votes";
        			}
        			
        			//Select which method to use and obtain results
        			if(method.equalsIgnoreCase("Members")) {
        				dataEngine.queryTable(fieldList, "HSall_members", tbl);
        			} else if(method.equalsIgnoreCase("Parties")) {
        				dataEngine.queryTable(fieldList, "HSall_parties", tbl);
        			} else if(method.equalsIgnoreCase("Rollcalls")) {
        				dataEngine.queryTable(fieldList, "HSall_rollcalls", tbl);
        			} else if(method.equalsIgnoreCase("Votes")) {
        				dataEngine.queryTable(fieldList, "HSall_votes", tbl);
        			} 
        			ResultSet rs = dataEngine.getResultSet();
        			
        			//Display the results
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
    					endList.setText("<html>Invalid search value for the selected variable. Please try again.</html>");
    				}
        		} else {
        			endList.setText("<html>Please fill in all necessary fields.</html>");
        		}
        	}
        });

        //Display everything on the GUI
        contentPane.add(ssc);
        contentPane.add(fillLabel);
        contentPane.add(dRange);
        contentPane.add(chamb);
        contentPane.add(cong);
        contentPane.add(dRangeStart);
        contentPane.add(dRangeEnd);
        contentPane.add(fillInBlank);
        contentPane.add(endList);
        contentPane.add(sscDropdown);
        contentPane.add(tblDropdown);
        contentPane.add(chamberDropdown);
        contentPane.add(congDropdown);


    }
}
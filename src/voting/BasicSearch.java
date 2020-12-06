/*
 * This class displays the Basic Search section and allows for user input in the GUI.
 * 
 */

package voting;

import javax.swing.*;  
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.JScrollPane;
import java.awt.Component;


public class BasicSearch extends JFrame {
	private JPanel contentPane;
    public static String epmvrInput = "None";
    public static String selectedSsc = "None";
    public static String outIcp = "None";
    public static String outCast = "None";
    public static String[] columns = { "Select Search Criteria First" };
    
    //create query data engine object to handle SQL queries
    QueryDataEngine dataEngine = new QueryDataEngine();

    public BasicSearch() {
    	//Set up the basics of the GUI
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0, 960, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //Back Button
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

        
        //Title
        JLabel title = new JLabel("Congressional Voting Database", JLabel.CENTER);
        title.setBounds(40,40,880,160);
        title.setFont(new Font("Sans-serif", Font.PLAIN, 48));
        title.setOpaque(true);
        title.setBackground(new Color(255, 255, 255));
        contentPane.add(title);

        //Switch to select Basic Search
        JButton bSearch=new JButton("Basic Search");//creating instance of JButton  
        bSearch.setBounds(175,200,290,60);//x axis, y axis, width, height 
        bSearch.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        Font btnFont = bSearch.getFont();
        Map attributes = btnFont.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        btnFont = btnFont.deriveFont(attributes);
        bSearch.setFont(btnFont);
        bSearch.setBorderPainted(false);
        contentPane.add(bSearch);
        
        //Switch to select Advanced Search
        JButton aSearch=new JButton("Advanced Search");//creating instance of JButton  
        aSearch.setBounds(470,200,310,60);//x axis, y axis, width, height 
        aSearch.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        aSearch.setBorderPainted(false);
        contentPane.add(aSearch);
        aSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
        		AdvancedSearch advancedSearch = new AdvancedSearch();
        		advancedSearch.setVisible(true);
        		f1.dispose();
        	}
        });
		
        //Label for button to select query     
        JLabel ssc = new JLabel("Select Filter Criteria", JLabel.CENTER);
        ssc.setBounds(150,280,290,50);
        ssc.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        ssc.setOpaque(true);
        
        //Label for the currently selected value
        JLabel epmvr = new JLabel("<html><center>Type value to match to selected variable. <br>Don't forget to press enter once you have input the value!</center></html>", JLabel.CENTER);
        epmvr.setBounds(150,330,340,55);
        epmvr.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        epmvr.setOpaque(true);

        //Display area for results
        JLabel endList = new JLabel("<html>List of parties / members / votes / rollcalls. <br/> Click on a given item to display the basic search attributes.</html>", JLabel.CENTER);
        endList.setBounds(175,400,585,275);
        endList.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        endList.setOpaque(true);
        endList.setBackground(new Color(255, 255, 255));
        endList.setBorder(blackline);
        
        //Choices for variables to search by
        String[] sscs = { "None", "Members - congress", "Members - chamber", "Members - icpsr",
        		"Members - state_icpsr", "Members - district_code", "Members - state_abbrev", "Members - party_code", 
        		"Members - occupancy", "Members - last_means", "Members - bioname", "Members - bioguide_id",
        		"Members - born", "Members - died", "Members - number_of_votes", "Members - number_of_errors",
        		"Parties - congress", "Parties - chamber", "Parties - party_code", "Parties - party_name", "Parties - n_members",
        		"Rollcalls - congress", "Rollcalls - chamber", "Rollcalls - rollnumber", "Rollcalls - date",
        		"Rollcalls - session", "Rollcalls - clerk_rollnumber", "Rollcalls - bill_number",
        		"Rollcalls - vote_result", "Rollcalls - vote_desc", "Rollcalls - vote_question", "Rollcalls - dtl_desc",
        		"Votes - congress", "Votes - chamber", "Votes - rollnumber", "Votes - icpsr", "Votes - cast_code"
        		};
        
        JComboBox sscDropdown = new JComboBox(sscs);
        sscDropdown.setSelectedIndex(0);
        sscDropdown.setBounds(490,285,270,50);
        sscDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectedSsc = (String)sscDropdown.getSelectedItem();        		
        	}
        });
        
        //Text Entry for searching
        JTextField epmvrBlank = new JTextField(20);
        epmvrBlank.setBounds(490,335,270,50);
        epmvrBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		epmvrInput = epmvrBlank.getText();
        	}
        });
        
        //Search Button
        JButton enterDataOne=new JButton("Search");//creating instance of JButton  
        enterDataOne.setBounds(10,560,150,100);//x axis, y axis, width, height 
        enterDataOne.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        contentPane.add(enterDataOne);
        
        
        //Execute SQL query when the search button is pressed
        enterDataOne.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		if(epmvrInput != "None"){
        			//split selectedSsc up into left and right - field = right, method = left
        			String[] tokens = selectedSsc.split(" ", -1);
        			System.out.println(tokens[0]);//gives method
        			String method = tokens[0];
        			System.out.println(tokens[2]);//gives field
        			String field = tokens[2].substring(0);
        			epmvrInput = epmvrInput.replace("\"", "");
        			
        			//Initialize the fields being searched
        			FieldList fieldList = new FieldList();
        			fieldList.addField(field, epmvrInput);

        			if(method.equalsIgnoreCase("Members")) {
        				dataEngine.queryTable(fieldList, "HSall_members", null);
        			} else if(method.equalsIgnoreCase("Parties")) {
        				dataEngine.queryTable(fieldList, "HSall_parties", null);
        			} else if(method.equalsIgnoreCase("Rollcalls")) {
        				dataEngine.queryTable(fieldList, "HSall_rollcalls", null);
        			} else if(method.equalsIgnoreCase("Votes")) {
        				dataEngine.queryTable(fieldList, "HSall_votes", null);
        			}
        			
        			ResultSet rs = dataEngine.getResultSet();
        			//display the table on the GUI
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
        		        pane.setBounds(175,400,585,275);
        		        contentPane.add(pane, BorderLayout.CENTER);
        		        contentPane.revalidate();
        		        contentPane.repaint();
    				} catch(Exception ex) {
    					//handle the error that occurs if users do not enter a valid value for the variable they are searching
    					endList.setText("<html>Invalid search value for the selected variable. Please try again.</html>");
    					} 
    				} 
        		else {
    				endList.setText("<html>Please fill in all necessary fields.</html>");
    			}
        	}
        	});

        //Display everything
        contentPane.add(ssc);
        contentPane.add(epmvr);
        contentPane.add(epmvrBlank);
        contentPane.add(endList);
        contentPane.add(sscDropdown);

    }
}
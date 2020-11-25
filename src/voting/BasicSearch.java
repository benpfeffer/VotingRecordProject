import javax.swing.*;  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;
import javax.swing.JScrollPane;
import java.awt.Component;


public class BasicSearch extends JFrame {
	private JPanel contentPane;
	private JPanel contentPaneTest;
	private JPanel contentPaneTesting;
    private JTextField txtTypeYourQuestion;
    private JTextField txtQuestionWeight;
    private JTextField txtEnter;
    private JTextField txtEnter_1;
    private JTextField txtValue;
    private JTextField txtValue_1;
    //private final Action action = new SwingAction();
    public static String epmvrInput = "None";
    public static String selectedSsc = "None";
    public static String selectedInclude = "None";
    public static String outIcp = "None";
    public static String outCast = "None";
    public static String[] columns = { "Select Search Criteria First" };
    
    //create query data engine object
    QueryDataEngine dataEngine = new QueryDataEngine();

    
    
    public BasicSearch() {
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
        Font btnFont = bSearch.getFont();
        Map attributes = btnFont.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        btnFont = btnFont.deriveFont(attributes);
        bSearch.setFont(btnFont);
        bSearch.setBorderPainted(false);
        contentPane.add(bSearch);
        
        JButton aSearch=new JButton("Advanced Search");//creating instance of JButton  
        aSearch.setBounds(470,200,310,80);//x axis, y axis, width, height 
        aSearch.setFont(new Font("Sans-serif", Font.PLAIN, 32));
        aSearch.setBorderPainted(false);
        contentPane.add(aSearch);
        aSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame f1 = (JFrame) SwingUtilities.windowForComponent(contentPane);
        		AdvancedSearch advancedSearch = new AdvancedSearch();
        		advancedSearch.setVisible(true);
        		f1.dispose();
        		System.out.println("Advanced search");
        	}
        });
		
        JLabel ssc = new JLabel("Select Search Criteria", JLabel.CENTER);
        ssc.setBounds(175,258,290,50);
        ssc.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        ssc.setOpaque(true);

        JLabel includeLabel = new JLabel("Include", JLabel.CENTER);
        includeLabel.setBounds(175,350,290,50);
        includeLabel.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        includeLabel.setOpaque(true);
        
        JLabel epmvr = new JLabel("Enter Party / Member / Vote / Rollcall:", JLabel.CENTER);
        epmvr.setBounds(150,305,340,50);
        epmvr.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        epmvr.setOpaque(true);

        JLabel endList = new JLabel("<html>List of parties / members / votes / rollcalls. <br/> Click on a given item to display the basic search attributes.</html>", JLabel.CENTER);
        endList.setBounds(175,400,585,275);
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
        sscDropdown.setBounds(490,260,270,50);
        sscDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectedSsc = (String)sscDropdown.getSelectedItem();
        		System.out.println(selectedSsc);
        		
        	}
        });
        
        String[] includes = {"None", "Members", "Parties", "Rollcalls", "Votes"};
        JComboBox includeDropdown = new JComboBox(includes);
        includeDropdown.setSelectedIndex(0);
        includeDropdown.setBounds(490,350,270,50);
        includeDropdown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectedInclude = (String)includeDropdown.getSelectedItem();
        		System.out.println(selectedInclude);
        		
        	}
        });
        


        JTextField epmvrBlank = new JTextField(20);
        epmvrBlank.setBounds(490,305,270,50);
        epmvrBlank.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		epmvrInput = epmvrBlank.getText();
        		System.out.println(epmvrInput);
        	}
        });

        JButton enterDataOne=new JButton("Search");//creating instance of JButton  
        enterDataOne.setBounds(10,560,150,100);//x axis, y axis, width, height 
        enterDataOne.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        contentPane.add(enterDataOne);
        JFrame currFrame = (JFrame) SwingUtilities.windowForComponent(contentPane);
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
        			if(field.equalsIgnoreCase("chamber") || field.equalsIgnoreCase("state_abbrev") || field.equalsIgnoreCase("bioname") || 
        					field.equalsIgnoreCase("bioguide_id") || field.equalsIgnoreCase("party_name") || field.equalsIgnoreCase("date") ||
        					field.equalsIgnoreCase("bill_number") || field.equalsIgnoreCase("vote_result") || field.equalsIgnoreCase("vote_desc") ||
        					field.equalsIgnoreCase("vote_question") || field.equalsIgnoreCase("dtl_desc")) {//if the field is a string field (any table)
        				epmvrInput = "\"" + epmvrInput + "\"";
        			}
        			FieldList fieldList = new FieldList();
        			fieldList.addField(field, epmvrInput);
        			if(method.equalsIgnoreCase("Members")) {
        				//send to member query
        				if(selectedInclude=="None" || selectedInclude=="Members") {
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
        				}else if(selectedInclude=="Parties") {
        					//send to memberXparty query
        					System.out.println("send to memberXparty query" + selectedInclude);
        					//String[] joinby = {"party_code"};
        					dataEngine.queryMemberXParty(fieldList, "members", "parties");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
        					
        				}else if(selectedInclude=="Rollcalls") {
        					//send to memberXrollcall query
        					System.out.println("send to memberXrollcall query" + selectedInclude);
        					//String[] joinby = {"congress", "chamber"};
        					dataEngine.queryMemberXRollcall(fieldList, "members", "rollcalls");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
        				}else if(selectedInclude=="Votes") {
        					//send to memberXvote query
        					System.out.println("send to memberXvote query" + selectedInclude);
        					//String[] joinby = {"icpsr"};
        					dataEngine.queryMemberXVote(fieldList, "members", "votes");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
        				}
        				
        			}else if(method.equalsIgnoreCase("Parties")) {
        				if(selectedInclude=="None" || selectedInclude=="Parties") {
	        				//send to party query
	        				System.out.println("send to party query");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
        				}else if(selectedInclude=="Members") {
        					//send to memberXparty query
        					System.out.println("send to memberXparty query" + selectedInclude);
        					//String[] joinby = {"party_code"};
        					dataEngine.queryMemberXParty(fieldList, "parties", "members");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
	        			}else if(selectedInclude=="Rollcalls") {
	        				//partiesXrollcalls
	        				dataEngine.queryPartyXRollcall(fieldList, "parties", "rollcalls");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
	        			}else if(selectedInclude=="Votes") {
	        				//partiesXvotes
	        				dataEngine.queryPartyXVote(fieldList, "parties", "votes");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
	        			}
        			}else if(method.equalsIgnoreCase("Rollcalls")) {
        				if(selectedInclude=="None" || selectedInclude=="Rollcalls") {
	        				//send to rollcall query
	        				System.out.println("send to rollcall query");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
	        			}else if(selectedInclude=="Members") {
	        				//rcXm
	        				dataEngine.queryMemberXRollcall(fieldList, "rollcalls", "members");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
	        			}else if(selectedInclude=="Parties") {
	        				//rcXp
	        				dataEngine.queryPartyXRollcall(fieldList, "rollcalls", "parties");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
	        			}else if(selectedInclude=="Votes") {
	        				//rcXv
	        				dataEngine.queryRollcallXVote(fieldList, "rollcalls", "votes");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
	        			}
        			}else if(method.equalsIgnoreCase("Votes")) {
        				if(selectedInclude=="None"||selectedInclude=="Votes") {
	        				//send to vote query
	        				System.out.println("send to vote query");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
        				}else if(selectedInclude=="Members") {
	        				//vXm
        					dataEngine.queryMemberXVote(fieldList, "votes", "members");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
	        			}else if(selectedInclude=="Parties") {
	        				//vXp
	        				dataEngine.queryPartyXVote(fieldList, "votes", "parties");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
	        			}else if(selectedInclude=="Rollcalls") {
	        				//vXrc
	        				dataEngine.queryRollcallXVote(fieldList, "rollcalls", "votes");
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
	            		        pane.setBounds(175,400,585,275);
	            		        contentPane.add(pane, BorderLayout.CENTER);
	            		        contentPane.revalidate();
	            		        contentPane.repaint();
	        				}catch(Exception ex) {
	        					ex.printStackTrace();
	        				}
	        			}
        			}
        			System.out.println("Entered data.");
        		}else{
        			System.out.println("Select search criteria.");
        		}
        	}
        });


        contentPane.add(ssc);
        contentPane.add(epmvr);
        contentPane.add(epmvrBlank);
        contentPane.add(endList);
        contentPane.add(sscDropdown);
        contentPane.add(includeDropdown);
        contentPane.add(includeLabel);

    }
}
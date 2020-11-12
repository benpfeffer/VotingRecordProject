    import java.util.*;
    import java.awt.BorderLayout;
    import java.awt.EventQueue;

    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.border.EmptyBorder;
    import javax.swing.BoxLayout;
    import javax.swing.JButton;
    import javax.swing.JLabel;
    import java.awt.Color;
    import java.awt.Font;
    import java.awt.font.TextAttribute;
    import javax.swing.JTextField;
    import javax.swing.JComboBox;
    import javax.swing.AbstractAction;
    import java.awt.event.ActionEvent;
    import javax.swing.Action;
    import java.awt.event.ActionListener;
    import javax.swing.BorderFactory;
    import javax.swing.border.Border;

public class eighth_add extends JFrame {
        private JPanel contentPane;
        private JTextField txtTypeYourQuestion;
        private JTextField txtQuestionWeight;
        private JTextField txtEnter;
        private JTextField txtEnter_1;
        private JTextField txtValue;
        private JTextField txtValue_1;
        //private final Action action = new SwingAction();
        public static String dRangeInput = "None";
        public static String outChamb = "None";
        public static String outCong = "None";
        public static String outIcp = "None";
        public static String outCast = "None";

       public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        second_add frame = new second_add();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


      /**
         * Create the frame.
         */
        public eighth_add() {
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
                  first first = new first();
                  first.setVisible(true);
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


            JButton bSearch=new JButton("Basic Search");//creating instance of JButton  
		      bSearch.setBounds(175,200,290,80);//x axis, y axis, width, height 
            bSearch.setFont(new Font("Sans-serif", Font.PLAIN, 32));
            bSearch.setBorderPainted(false);
            contentPane.add(bSearch);
            bSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  seventh_add seventh = new seventh_add();
                  seventh.setVisible(true);
                  contentPane.setVisible(false);
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
               
               JLabel dRange = new JLabel("Date Range", JLabel.CENTER);
               dRange.setBounds(175,325,200,50);
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
               
               JLabel other = new JLabel("Other appropriate queries (ICPSR, Name, etc.)", JLabel.CENTER);
               other.setBounds(175,450,690,50);
               other.setFont(new Font("Sans-serif", Font.PLAIN, 18));
               other.setOpaque(true);
               other.setBackground(new Color(255, 255, 255));
               other.setBorder(blackline);
               
               JLabel endList = new JLabel("<html>List of parties / members / votes / rollcalls. <br/> Click on a given item to display the basic search attributes.</html>", JLabel.CENTER);
               endList.setBounds(175,525,690,150);
               endList.setFont(new Font("Sans-serif", Font.PLAIN, 18));
               endList.setOpaque(true);
               endList.setBackground(new Color(255, 255, 255));
               endList.setBorder(blackline);
               
               
               String[] sscs = { "None", "Ssc1", "Ssc2", "Ssc3", "Ssc4", "Ssc5" };
               JComboBox sscDropdown = new JComboBox(sscs);
               sscDropdown.setSelectedIndex(0);
               sscDropdown.setBounds(400,275,290,50);
               String selectedSsc = (String)sscDropdown.getSelectedItem();
               sscDropdown.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                  String selectedSsc = (String)sscDropdown.getSelectedItem();
                  System.out.println(selectedSsc);
                  }
                 });
                 
               JTextField dRangeBlank = new JTextField(20);
               dRangeBlank.setBounds(400,325,465,50);
               dRangeBlank.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                  dRangeInput = dRangeBlank.getText();
                  System.out.println(dRangeInput);
                  }
                 });
                 
               String[] chambers = { "None", "Chamber1", "Chamber2", "Chamber3", "Chamber4", "Chamber5" };
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
                 
               String[] congs = { "None", "1", "2", "3", "4", "5" };
               JComboBox congDropdown = new JComboBox(congs);
               congDropdown.setSelectedIndex(0);
               congDropdown.setBounds(400,375,165,50);
               String selectedCong = (String)congDropdown.getSelectedItem();
               congDropdown.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                  String selectedCong = (String)congDropdown.getSelectedItem();
                  System.out.println(selectedCong);
                  }
                 });
               
               
               
               JButton enterDataOne=new JButton("Search");//creating instance of JButton  
   		      enterDataOne.setBounds(10,560,150,100);//x axis, y axis, width, height 
               enterDataOne.setFont(new Font("Sans-serif", Font.PLAIN, 18));
               contentPane.add(enterDataOne);
               enterDataOne.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                  if(dRangeInput!="None" && outChamb!="None" && outCong!="None"){
                     System.out.println("Entered data.");
                  }else{
                     System.out.println("Fill in all fields.");
                  }
                  }
                 });
                 
               
               contentPane.add(ssc);
               contentPane.add(dRange);
               contentPane.add(chamb);
               contentPane.add(cong);
               contentPane.add(dRangeBlank);
               contentPane.add(other);
               contentPane.add(endList);
               contentPane.add(sscDropdown);
               contentPane.add(chamberDropdown);
               contentPane.add(congDropdown);
             
               
               }
               }

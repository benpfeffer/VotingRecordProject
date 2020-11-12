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

public class seventh_add extends JFrame {
        private JPanel contentPane;
        private JTextField txtTypeYourQuestion;
        private JTextField txtQuestionWeight;
        private JTextField txtEnter;
        private JTextField txtEnter_1;
        private JTextField txtValue;
        private JTextField txtValue_1;
        //private final Action action = new SwingAction();
        public static String epmvrInput = "None";
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
        public seventh_add() {
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
                  eighth_add eighth = new eighth_add();
                  eighth.setVisible(true);
                  contentPane.setVisible(false);
                  System.out.println("Advanced search");
            }
              });

            

            
            
               JLabel ssc = new JLabel("Select Search Criteria", JLabel.CENTER);
               ssc.setBounds(175,275,290,50);
               ssc.setFont(new Font("Sans-serif", Font.PLAIN, 18));
         		ssc.setOpaque(true);
               
               JLabel epmvr = new JLabel("Enter Party / Member / Vote / Rollcall:", JLabel.CENTER);
               epmvr.setBounds(150,325,340,50);
               epmvr.setFont(new Font("Sans-serif", Font.PLAIN, 18));
         		epmvr.setOpaque(true);
               
               JLabel endList = new JLabel("<html>List of parties / members / votes / rollcalls. <br/> Click on a given item to display the basic search attributes.</html>", JLabel.CENTER);
               endList.setBounds(175,400,585,275);
               endList.setFont(new Font("Sans-serif", Font.PLAIN, 18));
               endList.setOpaque(true);
               endList.setBackground(new Color(255, 255, 255));
               endList.setBorder(blackline);
               
               
               String[] sscs = { "None", "Ssc1", "Ssc2", "Ssc3", "Ssc4", "Ssc5" };
               JComboBox sscDropdown = new JComboBox(sscs);
               sscDropdown.setSelectedIndex(0);
               sscDropdown.setBounds(490,275,270,50);
               String selectedSsc = (String)sscDropdown.getSelectedItem();
               sscDropdown.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                  String selectedSsc = (String)sscDropdown.getSelectedItem();
                  System.out.println(selectedSsc);
                  }
                 });
                 
               JTextField epmvrBlank = new JTextField(20);
               epmvrBlank.setBounds(490,325,270,50);
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
               enterDataOne.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                  if(epmvrInput!="None"){
                     System.out.println("Entered data.");
                  }else{
                     System.out.println("Fill in all fields.");
                  }
                  }
                 });
                 
               
               contentPane.add(ssc);
               contentPane.add(epmvr);
               contentPane.add(epmvrBlank);
               contentPane.add(endList);
               contentPane.add(sscDropdown);
             
               
               }
               }

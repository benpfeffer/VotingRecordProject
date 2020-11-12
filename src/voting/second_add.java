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
    import javax.swing.JTextField;
    import javax.swing.JComboBox;
    import javax.swing.AbstractAction;
    import java.awt.event.ActionEvent;
    import javax.swing.Action;
    import java.awt.event.ActionListener;
    import javax.swing.BorderFactory;
    import javax.swing.border.Border;
    


    public class second_add extends JFrame {

        private JPanel contentPane;
        private JTextField txtTypeYourQuestion;
        private JTextField txtQuestionWeight;
        private JTextField txtEnter;
        private JTextField txtEnter_1;
        private JTextField txtValue;
        private JTextField txtValue_1;
        private final Action action = new SwingAction();

        /**
         * Launch the application.
         */
        public static String outCong = "None";
        public static String outChamb = "None";
        public static String outRollNum = "None";
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
        public second_add() {
            Border blackline = BorderFactory.createLineBorder(Color.black);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(0, 0, 960, 720);
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
                  third_add third = new third_add();
                  third.setVisible(true);
                  contentPane.setVisible(false);
                  /*
                  fourth, fifth, sixth set visible to false
                  */
                             }});
            
            JButton addRollcall=new JButton("Add New Rollcall");//creating instance of JButton  
		       addRollcall.setBounds(40,340,290,100);//x axis, y axis, width, height 
            addRollcall.setFont(new Font("Sans-serif", Font.PLAIN, 32));
            contentPane.add(addRollcall);
            addRollcall.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  fourth_add fourth = new fourth_add();
                  fourth.setVisible(true);
                  contentPane.setVisible(false);
               }
              });
              
            JButton addMember=new JButton("Add New Member");//creating instance of JButton  
		       addMember.setBounds(40,460,290,100);//x axis, y axis, width, height 
            addMember.setFont(new Font("Sans-serif", Font.PLAIN, 32));
            contentPane.add(addMember);
            addMember.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  fifth_add fifth = new fifth_add();
                  fifth.setVisible(true);
                  contentPane.setVisible(false);
               }
              });
              
            JButton addParty=new JButton("Add New Party");//creating instance of JButton  
		       addParty.setBounds(40,580,290,100);//x axis, y axis, width, height 
            addParty.setFont(new Font("Sans-serif", Font.PLAIN, 32));
            contentPane.add(addParty);
            addParty.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  sixth_add sixth = new sixth_add();
                  sixth.setVisible(true);
                  contentPane.setVisible(false);
               }
              });

            
            
            /*
            JLabel t1 = new JLabel("Option entered", JLabel.CENTER);
            t1.setBounds(350,220,570,460);
      		t1.setFont(new Font("Sans-serif", Font.PLAIN, 24));
      		t1.setOpaque(true);
            t1.setBackground(new Color(255, 255, 255));
            contentPane.add(t1);*/

            
            

        }
        private class SwingAction extends AbstractAction {
            public SwingAction() {
                putValue(NAME, "");
                putValue(SHORT_DESCRIPTION, "Some short description");
            }
            public void actionPerformed(ActionEvent e) {
            }
        }
    }
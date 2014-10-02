package finalproject;

import java.awt.Point;

/**
 *
 * Maxwell Morin
 */
public class Help extends javax.swing.JFrame {

    private Interface anInterface;
    
    public Help(Interface anInterface) {
        this.anInterface = anInterface;
        initComponents();
        this.setLocation(new Point(350,150));
        
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        helpInformation = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SCAPEGOAT TREE");

        helpInformation.setBackground(new java.awt.Color(0, 0, 0));
        helpInformation.setColumns(20);
        helpInformation.setEditable(false);
        helpInformation.setFont(new java.awt.Font("Times New Roman", 0, 13));
        helpInformation.setForeground(new java.awt.Color(255, 255, 255));
        helpInformation.setRows(5);
        helpInformation.setText("\t      \t\t        SCAPEGOAT TREE 1.0\n\n1.TO ADD A NODE ENTER A NUMBER INTEGER IN THE FIELD IN FRONT OF THE BUTTON \n  \"ADD NODE\" , THEN PRESS THE BUTTON OR THE KEY ENTER \n ENTERED CORRECTLY,IN THE INFO BOX WILL SHOW: \"ADDED THE \n  NODe ...\"; IF THE NODE ALREADY HAS BEEN ENTERED IN THE SAME BOX WILL DISPLAY:\n  \"ERROR. THE NODE HAS NOT BEEN ADDED... SINCE IT ALREADY EXISTS\".\n\n2.TO FIND A NODE ENTER A NUMBER INTEGER IN THE FIELD IN FRONT OF THE BUTTON\n  \"FIND NODE\" ,THEN PRESS THE BUTTON OR THE KEY ENTER IN THE NODE\n  IN THE TREE, IN THE INFO BOX WILL DISPLAY: \"THE NODE... EXISTS\" OTHER \n  SO, IF IT WAS NOT FOUND DISPLAY: \"THE NODE ... DOES NOT EXIST\".\n\n3.TO REMOVE A NODE ENTER A NUMBER INTEGER IN THE FIELD IN FRONT OF THE BUTTON \n  \"DELETE NODE\" , THEN PRESS THE BUTTON OR THE KEY ENTER \n REMOVED FROM THE TREE, IN THE INFO BOX DISPLAYS: \"HAS BEEN REMOVED \n  THE NODE ...\" IN OTHER WORDS, IF IT WAS NOT REMOVED IT WILL SHOW: \"ERROR NODE NOT FOUND \n  EXIST.\"\n\n4.SCAPEGOAT TREES 1.0 HAS THREE TOUR OPTIONS:\n\t4.1. ORDER OPTION: THIS OPTION ALLOWS YOU TO VIEW ALL THE \n\t     NODES IN A LINE THEN TRAVEL THROUGH THE TREE IN ORDER.\n\n\t4.2. PRE-ORDER OPTION: THIS OPTION ALLOWS YOU TO VIEW ALL THE \n\t     NODES IN A LINE THEN TRAVEL THROUGH THE TREE IN PRE-ORDER.\n\n\t4.3. POST-ORDER OPTION: THIS OPTION ALLOWS YOU TO VIEW ALL THE  \n\t    NODES IN A LINE THEN TRAVEL THROUGH THE TREE IN POST-ORDER.\n  \n");
        jScrollPane1.setViewportView(helpInformation);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private javax.swing.JTextArea helpInformation;
    private javax.swing.JScrollPane jScrollPane1;

}

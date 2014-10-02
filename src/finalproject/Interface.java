package finalproject;

import java.awt.*;
import javax.swing.*;
/**
 * Maxwell Morin
 */
@SuppressWarnings("serial")
public class Interface extends javax.swing.JFrame {

    private boolean root;
    private ScapeGoatTree tree;
    private Help help;

    public Interface() {
        initComponents();
        this.setLocation(new Point(0,0));
        help = new Help(this);
        help.setVisible(false);
        tree = new ScapeGoatTree(this);
        root = false;
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Info = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        addText = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        searchText = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        deleteText = new javax.swing.JTextField();
        Order = new javax.swing.JButton();
        PreOrder = new javax.swing.JButton();
        PostOrder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Final = new javax.swing.JTextPane();
        Cont = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        painting = new finalproject.Painting();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCAPEGOAT TREE 1.0      PRESS F11 TO VIEW THE HELP ");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Info.setColumns(20);
        Info.setEditable(false);
        Info.setRows(5);
        Info.setBorder(javax.swing.BorderFactory.createTitledBorder("INFORMATION "));
        jScrollPane2.setViewportView(Info);

        addButton.setText("ADD NODE");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        addButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddButtonKeyPressed(evt);
            }
        });

        addText.setFont(new java.awt.Font("Times New Roman", 1, 14));
        addText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addText.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddTextKeyPressed(evt);
            }
        });

        searchButton.setText("FIND NODE");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        searchText.setFont(new java.awt.Font("Times New Roman", 1, 14));
        searchText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchTextKeyPressed(evt);
            }
        });

        deleteButton.setText("REMOVE NODE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        deleteText.setFont(new java.awt.Font("Times New Roman", 1, 14));
        deleteText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deleteText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DeleteTextKeyPressed(evt);
            }
        });

        Order.setText("IN ORDER");
        Order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderActionPerformed(evt);
            }
        });

        PreOrder.setText("PRE-ORDER");
        PreOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreOrderActionPerformed(evt);
            }
        });

        PostOrder.setText("POST-ORDER");
        PostOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostOrderActionPerformed(evt);
            }
        });

        Final.setBackground(new java.awt.Color(223, 222, 222));
        Final.setEditable(false);
        Final.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jScrollPane1.setViewportView(Final);

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addText, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(addButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchText, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteText, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(deleteButton))
                .addGap(67, 67, 67)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PostOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PreOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(addText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(deleteText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelPrincipalLayout.createSequentialGroup()
                            .addComponent(Order, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PreOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PostOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        Cont.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane3.setViewportView(painting);

        javax.swing.GroupLayout ContLayout = new javax.swing.GroupLayout(Cont);
        Cont.setLayout(ContLayout);
        ContLayout.setHorizontalGroup(
            ContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1343, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        ContLayout.setVerticalGroup(
            ContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1347, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Cont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == 122){
            help.setVisible(true);
        }
    }

    private void OrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenActionPerformed
        Info.setText("");
        Final.setText("");
        tree.Print(0);
}

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        try{
            Info.setText("");
            if(deleteText.getText().trim().equals("") || !isNumber(deleteText.getText().trim())){
                JOptionPane.showMessageDialog(null,"ENTER A NUMBER IN THE SEARCH FIELD.");
                return;
            }
            tree.delete(Double.parseDouble(deleteText.getText().trim()));
            deleteText.setText("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ENTER A NUMBER  IN THE DELETE FIELD.");
        }
}

    private void AddTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAgregarKeyPressed
        try{
            if(evt.getKeyCode() == 10){
                Info.setText("");
                if(root){
                    AddNode();
                }else{
                    AddRoot();
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ENTER A NUMBER IN THE ADD FIELD.");
        }
        if(evt.getKeyCode() == 122){
            help.setVisible(true);
        }
}

    private void SearchTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyPressed

        try{
            if(evt.getKeyCode() == 10){
                Info.setText("");
                if(searchText.getText().trim().equals("") || !isNumber(searchText.getText().trim())){
                    JOptionPane.showMessageDialog(null,"ENTER A NUMBER IN THE SEARCH FIELD.");
                    return;
                }
                if(tree.search(Double.parseDouble(searchText.getText().trim()))){
                    Info.setText("THE NODE: "+ searchText.getText().trim()+" IF THERE IS .");
                    painting.paintTree(tree.getRoot(), true, Double.parseDouble(searchText.getText().trim()));
                }else{
                    Info.setText("ERROR. THE NODE: "+ searchText.getText().trim()+" DOES NOT EXIST.");
                }
                searchText.setText("");
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"ENTER A NUMBER IN THE SEARCH FIELD.");
        }
        if(evt.getKeyCode() == 122){
            help.setVisible(true);
        }
}

    private void PostOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosOrdenActionPerformed
        Info.setText("");
        Final.setText("");
        tree.Print(2);
}

    private void DeleteTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEliminarKeyPressed
        try{
            if(evt.getKeyCode() == 10){
                Info.setText("");
                if(deleteText.getText().trim().equals("") || !isNumber(deleteText.getText().trim())){
                    JOptionPane.showMessageDialog(null,"ENTER A NUMBER IN THE SEARCH FIELD.");
                    return;
                }
                tree.delete(Double.parseDouble(deleteText.getText().trim()));
                deleteText.setText("");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ENTER A NUMBER IN THE DELETE FIELD.");
        }
        if(evt.getKeyCode() == 122){
            help.setVisible(true);
        }
}

    private void PreOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreOrdenActionPerformed
        Info.setText("");
        Final.setText("");
        tree.Print(1);
}

    private void AddButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAgregarKeyPressed
        if(evt.getKeyCode() == 122){
            help.setVisible(true);
        }
}

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        Info.setText("");
        try{
            if(root){
                AddNode();
            }else{
                AddRoot();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ENTER A NUMBER IN THE ADD FIELD.");
        }
}

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        Info.setText("");
        try{
            if(searchText.getText().trim().equals("") || !isNumber(searchText.getText().trim())){
                JOptionPane.showMessageDialog(null,"ENTER A NUMBER INTEGER IN THE SEARCH FIELD.");
                return;
            }
            if(tree.search(Double.parseDouble(searchText.getText().trim()))){
                Info.setText("THE NODE: "+ searchText.getText().trim()+" DOES EXIST.");
                painting.paintTree(tree.getRoot(), true, Double.parseDouble(searchText.getText().trim()));
            }else{
                Info.setText("ERROR. THE NODE: "+ searchText.getText().trim()+" DOES NOT EXIST.");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ENTER A NUMBER INTEGER IN THE SEARCH FIELD.");
        }
        searchText.setText("");
}



    private javax.swing.JButton addButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel Cont;
    private javax.swing.JTextPane Final;
    private javax.swing.JTextArea Info;
    private javax.swing.JButton Order;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton PostOrder;
    private javax.swing.JButton PreOrder;
    private javax.swing.JTextField addText;
    private javax.swing.JTextField searchText;
    private javax.swing.JTextField deleteText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private finalproject.Painting painting;


    public void AddNode()
    {
        if(addText.getText().trim().equals("") || !isNumber(addText.getText().trim())){
            JOptionPane.showMessageDialog(null,"ENTER A NUMBER IN THE ADD FIELD.");
            return;
        }
        tree.addNode(Double.parseDouble(addText.getText()));
        addText.setText("");
    }

    public void AddRoot()
    {
        if(addText.getText().trim().equals("") || !isNumber(addText.getText())){
            JOptionPane.showMessageDialog(null,"ENTER A NUMBER IN THE ADD FIELD.");
            return;
        }
        tree.addRoot(Double.parseDouble(addText.getText()));
        addText.setText("");
        root = true;
    }

    public boolean isNumber(String num)
    {
        int punto = 0;
        for(int i = 0; i < num.length();i++)
        {
            if(num.charAt(i) != '0'&& num.charAt(i) != '1' && num.charAt(i) != '2' && num.charAt(i) != '3' && num.charAt(i) != '4' && num.charAt(i) != '5' &&
               num.charAt(i) != '6'&& num.charAt(i) != '7' && num.charAt(i) != '8' && num.charAt(i) != '9' && num.charAt(i) != '-'){
                if(num.charAt(i) == '.'){
                    punto++;
                }else{
                    return false;
                }
                if(punto > 1){
                    return false;
                }
            }
        }
        return true;
    }

    public void print(String x)
    {
        Final.setText(Final.getText() + x + " ");
    }

    public void error(String x)
    {
        Info.setText(x);
        clean();
    }

    public void clean()
    {
        addText.setText("");
        searchText.setText("");
        deleteText.setText("");
    }

    public void paintingTree(Node root)
    {
       painting.paintTree(root, false, 0);
    }
}


import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Артем
 */
public class SelectJFrame extends javax.swing.JFrame {

    /**
     * Creates new form SelJFrame
     */
    public int ij;
    public int ij2;    
    private Statement Statement;
    PreparedStatement pst=null;
    Connection con2 = null;
    
    
    
    /**
     *
     */

    /**
     *
     */
    public String  ij1;
    public String  fio;
    //public int kl=new NewJFrame().ui;
    
    
    public SelectJFrame() {       
        super("Options of user: "+new User3().fio);
        initComponents(); 
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Identification-Badge-icon.png")));
//        jLabel2.setText(String.valueOf(new User3().kjh));
        //String mh=String.valueOf(ij);
        //jLabel2.setText(mh);        
////        ij=new NewJFrame().klj;
        ij=new User3().kjh;
        
        //jLabel4.setText(String.valueOf(ij2));
        //show_user();
        show_user();
        
        buttonGroup1();
        sw();
        

        
        System.out.println(ij+"n");

        //int mh2=Integer.valueOf(mh);
//        show_user1();
        //show_user1();
//        
//        String mh1=String.valueOf(ij2);
//        jLabel2.setText(mh1+" 1");
        sw();
        show_user2();
        show_userStag();
//        userList1();
//jTable3.setVisible(false);
    }

    
    
    
            public void sw(){
        showTableData();
        String mh1=String.valueOf(ij2);
        //jLabel4.setText(mh1);
        
        String mh=String.valueOf(ij);
//        jLabel2.setText(mh);
        //int mh2=Integer.valueOf(mh);
        //NewJFrame mnj=new NewJFrame();
        //ij=mnj.ijn;
        show_user1();
        
        show_userStag();
    }
    
     
//            public void sw2(){
//                        try{
//            jTable3.setVisible(false);
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//            }
            
    
            
        public ArrayList<Languages> userList1(){
        ArrayList<Languages> usersList=new ArrayList<>();
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           Connection con = DriverManager.getConnection(url);
           String query1="SELECT * FROM languages";
           Statement=con.createStatement();
           ResultSet rs= Statement.executeQuery(query1);
           Languages user;
           while(rs.next()){
               user=new Languages(rs.getInt("id"), rs.getString("lang"));
               usersList.add(user);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return usersList;
    }
    
                        public ArrayList<Languages2> userList2(){
        ArrayList<Languages2> usersList=new ArrayList<>();
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;");
           String query1="select * from fiolang, languages WHERE idlang=id and idfio=?";
           pst = con.prepareStatement(query1);
           pst.setInt(1, ij);
            //Statement=con.createStatement();
            ResultSet rs = pst.executeQuery();
            
           //ResultSet rs= Statement.executeQuery();
           Languages2 user;
           while(rs.next()){
               user=new Languages2(rs.getInt("idfio"), rs.getInt("idlang"), rs.getString("lang"));
               usersList.add(user);
           }

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return usersList;
    }    
                        
                        
              public ArrayList<Languages3> userList3(){
        ArrayList<Languages3> usersList=new ArrayList<>();
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           Connection con = DriverManager.getConnection(url);
           String query1="SELECT * FROM fiodep WHERE idfio=?";
           pst = con.prepareStatement(query1);
           pst.setInt(1, ij);
            //Statement=con.createStatement();
            ResultSet rs = pst.executeQuery();
            
           //ResultSet rs= Statement.executeQuery();
           Languages3 user;
           while(rs.next()){
               user=new Languages3(rs.getInt("idfio"), rs.getInt("iddep"));
               usersList.add(user);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return usersList;
    }                  
                        
                  public ArrayList<Stag> userListStag(){
        ArrayList<Stag> usersList=new ArrayList<>();
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           Connection con = DriverManager.getConnection(url);
           String query1="select * from fio WHERE fio_id=?";
           pst = con.prepareStatement(query1);
           pst.setInt(1, ij);
            //Statement=con.createStatement();
            ResultSet rs = pst.executeQuery();
            
           //ResultSet rs= Statement.executeQuery();
           Stag user;
           while(rs.next()){
               user=new Stag(rs.getInt("fio_id"), rs.getInt("stag_id"));
               usersList.add(user);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return usersList;
    }                    
                        
                        
               
            public void showTableData1(){
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        
        while(model2.getRowCount()>0){
            for(int i=0; i<model2.getRowCount();i++){
                model2.removeRow(i);
            }                 
        }
            }
                
        public void show_user(){
        ArrayList<Languages> list;
        list = userList1();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        Object[] row=new Object[2];
        for (int i=0;i<list.size();i++){
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getLanguage();
            model.addRow(row);
        }
        
    }
            
        public void show_user1(){
        ArrayList<Languages2> list;
        list = userList2();
        DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
        Object[] row=new Object[3];
        for (int i=0;i<list.size();i++){
            row[0]=list.get(i).getID1();
            row[1]=list.get(i).getLanguage1();
            row[2]=list.get(i).getLanguage2();
            model.addRow(row);
        }
        
    }
    
        public void show_user2(){
        ArrayList<Languages3> list;
        list = userList3();
        //DefaultTableModel model=(DefaultTableModel)jTable3.getModel();
        Object[] row=new Object[2];
        for (int i=0;i<list.size();i++){
            row[0]=list.get(i).getID1();
            row[1]=list.get(i).getID2();

            
            
            if(list.get(i).iddep==1){
            jCheckBox1.setSelected(true);
        }
        if(list.get(i).iddep==2){
            jCheckBox2.setSelected(true);
        }
        if(list.get(i).iddep==3){
            jCheckBox3.setSelected(true);
        }
        if(list.get(i).iddep==4){
            jCheckBox4.setSelected(true);
        }
        if(list.get(i).iddep==5){
            jCheckBox6.setSelected(true);
        }
            
            
            
            
        //    model.addRow(row);
        }
        
    } 
      
                public void show_userStag(){
        ArrayList<Stag> list;
        list = userListStag();
        //DefaultTableModel model=(DefaultTableModel)jTable3.getModel();
        Object[] row=new Object[2];
        for (int i=0;i<list.size();i++){
            row[0]=list.get(i).getID1();
            row[1]=list.get(i).getID2();

            
            
            if(list.get(i).stag_id==1){
            jRadioButton1.setSelected(true);
        }
            else if(list.get(i).stag_id==2){
            jRadioButton2.setSelected(true);
        }
            else if(list.get(i).stag_id==3){
            jRadioButton3.setSelected(true);
        }
            else {
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
        }
            
            
            
        //    model.addRow(row);
        }
        
    } 
        
            public void show_userAll(){
        ArrayList<Languages> list;
        list = userList1();
        //DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
        Object[] row=new Object[3];
        for (int i=0;i<list.size();i++){
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getLanguage();
//            row[2]=list.get(i).getLanguage2();
            
            try{
            String url1 = "insert into fiolang (idfio,idlang) values (?,?)";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.setInt(2, list.get(i).id);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 2");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        //    model.addRow(row);
        }
        
    }    
        
        public void showTableData(){
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        
        while(model2.getRowCount()>0){
            for(int i=0; i<model2.getRowCount();i++){
                model2.removeRow(i);
            }
        }
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Language"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "idlanguage", "Selected language"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(0);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable2.getColumnModel().getColumn(1).setMinWidth(0);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("ИТ");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("ПИ");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("ИБ");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setText("ВМ");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox6.setText("И");

        jRadioButton1.setText("1 месяц");

        jRadioButton2.setText("2 месяца");

        jRadioButton3.setText("3 месяца и более");

        jButton3.setText(">");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText(">>");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("<<");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jCheckBox3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox6))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox6)))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //sw();
        //show_user1();
                           try{
            String url1 = "DELETE FROM fiodep WHERE idfio=?";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully all");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        } 

        
        if (jCheckBox1.isSelected()) {
            try{
            String url1 = "insert into fiodep (idfio,iddep) values (?,'1')";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 1");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        } else{{
            try{
            String url1 = "DELETE FROM fiodep WHERE idfio=? and iddep='1'";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 1 1");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }
            
        }
        if(jCheckBox2.isSelected()){
                        try{
            String url1 = "insert into fiodep (idfio,iddep) values (?,'2')";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 2");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }              
        }else{
            try{
            String url1 = "DELETE FROM fiodep WHERE idfio=? and iddep='2'";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 2 2");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }
        if(jCheckBox3.isSelected()){
                        try{
            String url1 = "insert into fiodep (idfio,iddep) values (?,'3')";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 3");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }
        else{
            try{
            String url1 = "DELETE FROM fiodep WHERE idfio=? and iddep='3'";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 3 3");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }}
        if(jCheckBox4.isSelected()){
                        try{
            String url1 = "insert into fiodep (idfio,iddep) values (?,'4')";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 4");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }else{
            try{
            String url1 = "DELETE FROM fiodep WHERE idfio=? and iddep='4'";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 4 4");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }}
        if(jCheckBox6.isSelected()){
                        try{
            String url1 = "insert into fiodep (idfio,iddep) values (?,'5')";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 5");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }else{
            try{
            String url1 = "DELETE FROM fiodep WHERE idfio=? and iddep='5'";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 5 5");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }
        
        
        
        
        
        /////////////////////////
                           try{
            String url1 = "update fio set stag_id=null where fio_id=?";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully all 2");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        } 

        
        if (jRadioButton1.isSelected()) {
            try{
            String url1 = "update fio set stag_id=1 where fio_id=?";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 1 1 1");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        } else if (jRadioButton2.isSelected()){{
            try{
            String url1 = "update fio set stag_id=2 where fio_id=?";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 1 1 2");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }
            
        }
        else if(jRadioButton3.isSelected()){
                        try{
            String url1 = "update fio set stag_id=3 where fio_id=?";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 1 1 3");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }              
        }else{
            try{
            String url1 = "update fio set stag_id=null where fio_id=?";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 1 2 3");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jCheckBox4ActionPerformed

    
    
    
    
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try{
            String url1 = "delete from fiolang where idfio=?";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           //pst.setInt(2, Integer.parseInt(jLabel2.getText()));
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 1");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        

        
        
        
        
            showTableData1(); 
            show_userAll();
            show_user1();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        if (jTable1.isColumnSelected(1)){
            System.out.print("123");
            try{
            String url1 = "delete from fiolang where idfio=? and idlang=?";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.setInt(2, ij2);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 1");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
            
            try{
            String url1 = "insert into fiolang (idfio,idlang) values (?,?)";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.setInt(2, ij2);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 2");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        
        showTableData1();    
        show_user1();    
            
        }else{
            System.out.print("12");
            JOptionPane.showMessageDialog(null, "Не выделено");
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        ij2=Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        //jLabel2.setText(model.getValueAt(selectedRowIndex, 0).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
                DefaultTableModel model1=(DefaultTableModel) jTable2.getModel();
        int selectedRowIndex1 = jTable2.getSelectedRow();
        
//        jLabel1.setText(model1.getValueAt(selectedRowIndex1, 1).toString());
        ij2=Integer.parseInt(model1.getValueAt(selectedRowIndex1, 1).toString());
        
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jTable2.isColumnSelected(2)){
            JOptionPane.showMessageDialog(null, "Выделено 123");
            
            try{
            String url1 = "delete from fiolang where idfio=? and idlang=?";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           pst.setInt(2, ij2);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 1");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
            
            showTableData1();
            show_user1();
        }else{
            JOptionPane.showMessageDialog(null, "Не выделено 1");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try{
            String url1 = "delete from fiolang where idfio=?";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url1);
           pst.setInt(1, ij);
           //pst.setInt(2, Integer.parseInt(jLabel2.getText()));
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully 1");
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
            showTableData1();
            show_user1();
    
    }//GEN-LAST:event_jButton6ActionPerformed

    
    
    
    
    
    
    
    
    
    
    private void buttonGroup1(){
        ButtonGroup bg1=new ButtonGroup();
        bg1.add(jRadioButton1);
        bg1.add(jRadioButton2);
        bg1.add(jRadioButton3);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

//    static class idfio {
//
//        int idfio;
//        
//        public idfio() {
//            this.idfio=idfio;
//            //jLabel2.setText(idfio);
//        }
//        public idfio1() {
//            return idfio;
//            //jLabel2.setText(idfio);
//        } 
//        
//    }
}

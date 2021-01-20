
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;



public class MainJFrame extends javax.swing.JFrame {

    
    private Statement Statement;
    

    Connection con2 = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        super("Access");
        initComponents();
        show_user();
        show_user1();
        show_user2();
        FillListbox();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Identification-Badge-icon.png")));
        
        try{
    jToggleButton1.setVisible(false);
}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
}
        
    }

    
        public ArrayList<User1> userList(){
        ArrayList<User1> usersList=new ArrayList<>();
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           Connection con = DriverManager.getConnection(url);
           String query1="select ss_id,fio1,vhod,vihod from fio,ee1 where FIOid=fio_id";
           Statement=con.createStatement();
           ResultSet rs= Statement.executeQuery(query1);
           User1 user;
           while(rs.next()){
               user=new User1(rs.getInt("ss_id"), rs.getString("fio1"), rs.getString("vhod"), rs.getString("vihod"));
               usersList.add(user);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return usersList;
    }
        
        
            public ArrayList<User> userList1(){
        ArrayList<User> usersList=new ArrayList<>();
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           Connection con = DriverManager.getConnection(url);
           String query1="SELECT * FROM fio";
           Statement=con.createStatement();
           ResultSet rs= Statement.executeQuery(query1);
           User user;
           while(rs.next()){
               user=new User(rs.getInt("fio_id"), rs.getString("fio1"));
               usersList.add(user);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return usersList;
    }

            
                        public ArrayList<User2> userList2(){
        ArrayList<User2> usersList=new ArrayList<>();
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
           //String url = "jdbc:derby://localhost:1533/ssar1";
           Connection con = DriverManager.getConnection(url);
           String query1="SELECT * FROM report";
           Statement=con.createStatement();
           ResultSet rs= Statement.executeQuery(query1);
           User2 user;
           while(rs.next()){
               user=new User2(rs.getString("fio1"), rs.getInt("amount"));
               usersList.add(user);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return usersList;
    }
        
        
        
private void FillListbox(){
    DefaultListModel m = new DefaultListModel();
    DefaultComboBoxModel n = new DefaultComboBoxModel();
    
   
    try{String sql="select * from fio";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
    
    Connection con = DriverManager.getConnection(url);
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    while(rs.next()){
        String name=rs.getString("fio1");rs.getString("fio_id");
        m.addElement(name);
        n.addElement(name);
        jList1.setModel((ListModel<String>) m);
        jComboBox1.setModel((ComboBoxModel<String>) n);
    }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }finally{
        try{
            rs.close();
        }catch(Exception e){
            
        }
    }
    
}  
    
        

        public void show_user(){
        ArrayList<User1> list=userList();
        DefaultTableModel model=(DefaultTableModel)jTable_2.getModel();
        Object[] row=new Object[4];
        for (int i=0;i<list.size();i++){
            row[0]=list.get(i).getSSid();
            row[1]=list.get(i).getFIO();
            row[2]=list.get(i).getVHOD();
            row[3]=list.get(i).getVIHOD();
            model.addRow(row);
        }
        
    }
        
               public void show_user1(){
        ArrayList<User> list=userList1();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        Object[] row=new Object[4];
        for (int i=0;i<list.size();i++){
            row[0]=list.get(i).getFIOid();
            row[1]=list.get(i).getFIO();
            model.addRow(row);
        }
        
    } 
               
                   public void show_user2(){
        ArrayList<User2> list=userList2();
        DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
        Object[] row=new Object[4];
        for (int i=0;i<list.size();i++){
            row[0]=list.get(i).getFIO();
            row[1]=list.get(i).getAMOUNT();
            model.addRow(row);
        }
        
    }    
        

        
        
                 public void showTableData(){
        DefaultTableModel model2 = (DefaultTableModel) jTable_2.getModel();
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "FIO", "Vhod", "Vihod"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_2);

        jButton1.setText("Now");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jToggleButton1.setText("On/Off");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Users");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "FIO"
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
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "fio", "amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jButton3.setText("Other");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        long time = System.currentTimeMillis();
java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String date2 = sdf.format(time);
jLabel1.setText(date2);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if(jToggleButton1.isSelected()){
            
        try{
            String url2 = "insert into ee1 (FIOid, vhod) values (?,?)";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
                //String url = "jdbc:derby://localhost:1533/ssar1";
                Connection con2 = DriverManager.getConnection(url);
                PreparedStatement pst = con2.prepareStatement(url2);
//           pst.executeUpdate();

            String mn = jLabel2.getText();
           
                   long time = System.currentTimeMillis();
java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String date2 = sdf.format(time);
           
con2 = DriverManager.getConnection(url);
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url2);
           pst.setString(1, mn);
           pst.setString(2, date2);           
           //pst.setString(2, date2);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully");           
           
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        showTableData();    
        show_user();   
        
        
                        try{
    jButton2.setVisible(false);
}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
}
            
        }else{
            
        try{
            String url2 = "UPDATE ee1 SET vihod=? WHERE ss_id = (SELECT max(ss_id) FROM ee1)";
            
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=SSAR1;user=admin;password=admin;";
                //String url = "jdbc:derby://localhost:1533/ssar1";
                Connection con2 = DriverManager.getConnection(url);
                PreparedStatement pst = con2.prepareStatement(url2);
//           pst.executeUpdate();

           
           
                   long time = System.currentTimeMillis();
java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String date2 = sdf.format(time);
           
con2 = DriverManager.getConnection(url);
           con2 = DriverManager.getConnection(url);
           pst = con2.prepareStatement(url2);
           pst.setString(1, date2);           
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "inserted successfully");           
           
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        showTableData();    
        show_user();    
        
                        try{
    jButton2.setVisible(true);
}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
}
        
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        
    if (evt.getClickCount() == 2 ){

        
        String sel =null;

    int[] selectedIx = this.jList1.getSelectedIndices();
    //int selectedIx1 = this.jComboBox1.getSelectedIndex();
Object[] row=new Object[4];
//int idx = jTable1.getSelectedRow();
//String idn = jList1.getSelectedValue();

ArrayList<User> list=userList1();
    for (int i = 0; i < selectedIx.length; i++) {
        sel = jList1.getModel().getElementAt(selectedIx[i]);
    //int gh=jTable1.getSelectedRow();
        //jLabel4.setText(sel);
        
        ArrayList<User> list1=userList1();
//            row[0]=list.get(i).getFIOid();
//            row[1]=list.get(i).getFIO();
            //////jLabel4.setText(String.valueOf(list.get(i).fio_id));
            //jLabel4.setText(row);
    //}            
//            model.addRow(row);
//        }
                 //if(list.get(j).fio1==jLabel2.getText()){        
             for (int j=0;j<list.size();j++){
                 //if(list.get(j).fio1==jLabel2.getText()){
            row[0]=list1.get(j).getFIOid();
            row[1]=list1.get(j).getFIO();
            int gh=list1.get(j).fio_id;
            //model.addRow(row);
            if(list.get(j).fio1.equals(jList1.getSelectedValue())){
            //System.out.print(gh);//selectedIx.length
            //System.out.print(j+" ");//list.size()
            //System.out.print(gh+" ");
//            System.out.print(list.get(j).fio1+" ");setText(String.valueOf(list.get(j).fio_id
//System.out.print(jList1.getSelectedValue()+"  ");
jLabel2.setText(String.valueOf(gh));
jLabel3.setText(sel);
//System.out.print(jList1.getSelectedIndex());
//System.out.print(jTable1.getSelectedRow());
//System.out.print(gh);
            }
            
            
        try{
    jToggleButton1.setVisible(true);
}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
}    
            
            
            
            
            
//            if(list.get(j).fio1.equals(jComboBox1.getSelectedItem())){
//            //System.out.print(gh);//selectedIx.length
//            //System.out.print(j+" ");//list.size()
//            //System.out.print(gh+" ");
////            System.out.print(list.get(j).fio1+" ");setText(String.valueOf(list.get(j).fio_id
////System.out.print(jList1.getSelectedValue()+"  ");
//jLabel4.setText(String.valueOf(gh));
//jLabel5.setText(sel);
////System.out.print(jList1.getSelectedIndex());
////System.out.print(jTable1.getSelectedRow());
////System.out.print(gh);
//            }
////            jLabel4.setText(String.valueOf(list.get(i).fio_id));
////list.get(j).fio1==
//            
//             }
        
    }
        
        
        
        
        
        
    }    
    }    
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
////////////////            if (jTable1.getName().equalsIgnoreCase(jButton1.getActionCommand()))) {
////////////////                jButton2.setEnabled(false);
////////////////                // Изменение надписи
////////////////                // putValue(NAME, "Disabled button");
////////////////                jButton2.setText("Disabled button");
////////////////            }

        new NewJFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        
        jLabel2.setText(model.getValueAt(selectedRowIndex, 0).toString());
        jLabel3.setText(model.getValueAt(selectedRowIndex, 1).toString());
        
        
                        try{
    jToggleButton1.setVisible(true);
}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
}
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            new NewJFrameValue2().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:  
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
               // TODO add your handling code here:  
        //String gh1;
        int gh1=jComboBox1.getSelectedIndex();
        jLabel5.setText(String.valueOf(gh1));

        String sel =null;

    int selectedIx = this.jComboBox1.getSelectedIndex();
    //int selectedIx1 = this.jComboBox1.getSelectedIndex();
Object[] row=new Object[4];
//int idx = jTable1.getSelectedRow();
//String idn = jList1.getSelectedValue();

ArrayList<User> list=userList1();
    for (int i = 0; i < gh1; i++) {
        sel = jComboBox1.getModel().getElementAt(selectedIx);
    //int gh=jTable1.getSelectedRow();
        //jLabel4.setText(sel);
        
        ArrayList<User> list1=userList1();
//            row[0]=list.get(i).getFIOid();
//            row[1]=list.get(i).getFIO();
            //////jLabel4.setText(String.valueOf(list.get(i).fio_id));
            //jLabel4.setText(row);
    //}            
//            model.addRow(row);
//        }
                 //if(list.get(j).fio1==jLabel2.getText()){        
             for (int j=0;j<list.size();j++){
                 //if(list.get(j).fio1==jLabel2.getText()){
            row[0]=list1.get(j).getFIOid();
            row[1]=list1.get(j).getFIO();
            int gh=list1.get(j).fio_id;
            
            
            
            //model.addRow(row);
            //if(j==gh1){
                if(j==gh1){
            //System.out.print(gh);//selectedIx.length
            //System.out.print(j+" ");//list.size()
            //System.out.print(gh+" ");
//            System.out.print(list.get(j).fio1+" ");setText(String.valueOf(list.get(j).fio_id
//System.out.print(jList1.getSelectedValue()+"  ");
jLabel2.setText(String.valueOf(gh));
jLabel3.setText(sel);
//System.out.print(jList1.getSelectedIndex());
//System.out.print(jTable1.getSelectedRow());
//System.out.print(gh);
            }
            
            
        try{
    jToggleButton1.setVisible(true);
}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
}    
            
            
            
            
            
    }
        
        
        
        
        
        
    }    
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable_2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}

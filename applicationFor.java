import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;

import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class applicationFor extends javax.swing.JFrame {

        public applicationFor() {
        initComponents();
        Connec();
        LoadProductNo();
        Fetch();
    }   
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connec(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/Gania_Sarmiento_dtbs","root","");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
   
    public void LoadProductNo(){
    
            try {
                pst = con.prepareStatement("SELECT id FROM application_tbl");
                rs = pst.executeQuery();
                txtid.removeAllItems();
                while(rs.next()){
                txtid.addItem(rs.getString(1));
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
      private void Fetch(){
            try {
                int q;
                pst = con.prepareStatement("SELECT * FROM application_tbl");
                rs = pst.executeQuery();
                ResultSetMetaData rss = rs.getMetaData();
                q = rss.getColumnCount();
                
                DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
                df.setRowCount(0);
                while(rs.next()){
                   Vector v2 = new Vector();
                   for(int a=1; a<=q; a++){
                   v2.add(rs.getString("id"));
                   v2.add(rs.getString("Aname"));
                   v2.add(rs.getString("Papplied"));
                   v2.add(rs.getString("Astatus"));                   
                   v2.add(rs.getString("Address"));
                   
                   }
                   
                   df.addRow(v2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
            }
      
      } 
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAid = new javax.swing.JLabel();
        txtAname = new javax.swing.JTextField();
        txtPapplied = new javax.swing.JTextField();
        txtAstatus = new javax.swing.JTextField();
        txtid = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel1.setText("Applicant Name:");

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel2.setText("Position Applied:");

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel3.setText("Applicant Status:");

        txtAid.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        txtAid.setText("Application ID:");

        txtPapplied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPappliedActionPerformed(evt);
            }
        });

        txtAstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAstatusActionPerformed(evt);
            }
        });

        txtid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel6.setText("Address:");

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Job Application");

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Application ID", "Applicant Name", "Position Applied", "Application Status", "Address"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnAdd.setBackground(new java.awt.Color(51, 153, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(51, 153, 255));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(51, 153, 255));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExport.setBackground(new java.awt.Color(51, 153, 255));
        btnExport.setText("Export CSV");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnPDF.setBackground(new java.awt.Color(51, 153, 255));
        btnPDF.setText("Export PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAdd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnUpdate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnDelete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnExport)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPapplied)
                                    .addComponent(txtAstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(txtAname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtAid)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnSearch)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAid)
                    .addComponent(txtAname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPapplied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnSearch)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(btnExport)
                            .addComponent(btnPDF))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        String id = txtid.getSelectedItem().toString();
            try {
                pst=con.prepareStatement("DELETE FROM application_tbl WHERE id=?");
                pst.setString(1, id);
                
                int k = pst.executeUpdate();
                if(k==1){
                 JOptionPane.showMessageDialog(this,"Record Has Been Successfully Deleted!");
                
                  txtAname.setText("");
                  txtPapplied.setText("");
                  txtAstatus.setText("");                
                  txtAstatus.setText("");                 
                  txtAddress.setText("");
                  txtAname.requestFocus();
                 Fetch();
                 LoadProductNo();                 
                 
                }else{
                
                    JOptionPane.showMessageDialog(this,"Record Failed To Delete!!");
                
                
                }
                        
                
            } catch (SQLException ex) {
                Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }                                         

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
            try {
                // TODO add your handling code here:
                
                String id = txtid.getSelectedItem().toString();
                pst = con.prepareStatement("SELECT * FROM application_tbl WHERE id=?");
                pst.setString(1, id);
                rs=pst.executeQuery();
                
                if(rs.next()==true){
                    txtAname.setText(rs.getString(2));
                    txtPapplied.setText(rs.getString(3));
                    txtAstatus.setText(rs.getString(4));                   
                      txtAddress.setText(rs.getString(5));
                
                }else{
                    JOptionPane.showMessageDialog(this,"No Record Found!");
                
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }                                         

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
            try {
                // TODO add your handling code here:
                String aname = txtAname.getText();
                String papplied = txtPapplied.getText();
                String astatus = txtAstatus.getText();
                String address = txtAddress.getText();
                String id = txtid.getSelectedItem().toString();
                
                pst = con.prepareStatement("UPDATE application_tbl SET Aname=?,Papplied=?,Astatus=?, Address=? WHERE id=?");
           
                pst.setString(1, aname);
                pst.setString(2, papplied);
                pst.setString(3, astatus);
                pst.setString(4, address);
                pst.setString(5, id);
                
                int k=pst.executeUpdate();
                if(k==1){
                JOptionPane.showMessageDialog(this,"Record has been succesfully updated!!");
                  txtAname.setText("");
                  txtPapplied.setText("");
                  txtAstatus.setText("");
                  txtAddress.setText("");
                  txtAname.requestFocus();
                  Fetch();
                  LoadProductNo();
                
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }                                         

    private void txtPappliedActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        
    }                                           

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
            
        if(txtAname.getText().isEmpty()){
         JOptionPane.showMessageDialog(this,"Applicant name is required!");   
            
        
        }else if(txtPapplied.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"Position applied is required!");
        
        }else if(txtAstatus.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"Applicant status  is required!");
           
        }else if(txtAddress.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"Applicant address is required!");
        
        }else{
        
        
        
        
        try {
                // TODO add your handling code here:
                
                String aname = txtAname.getText();
                String papplied = txtPapplied.getText();
                String astatus = txtAstatus.getText();
                String address = txtAddress.getText();
                
               pst = con.prepareStatement("INSERT INTO application_tbl(Aname,Papplied,Astatus,Address)VALUES(?,?,?,?)");
               pst.setString(1,aname);
                pst.setString(2,papplied);
                 pst.setString(3,astatus);
                 pst.setString(4,address);
                 
                 
                 int k = pst.executeUpdate();
                 
                 if (k==1){
                    JOptionPane.showMessageDialog(this,"Record Added!! successfully!");
                    txtAname.setText("");
                    txtPapplied.setText("");
                    txtAstatus.setText("");
                    txtAddress.setText("");
                    Fetch();
                    LoadProductNo();
                    
                            
                 }else{
                 JOptionPane.showMessageDialog(this,"Record failed to saved!");
                 }
                 
            } catch (SQLException ex) {
                Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }                                      

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        String filename = "C:\\Users\\Joshua Gania\\Desktop\\Java Excel File.csv";
            try {
                FileWriter fw = new FileWriter(filename);
                pst = con.prepareStatement("SELECT * FROM application_tbl");
                rs = pst.executeQuery();
                
                while(rs.next()){
                   fw.append(rs.getString(1));
                   fw.append(',');
                   fw.append(rs.getString(2));
                   fw.append(',');
                   fw.append(rs.getString(3));
                   fw.append(',');
                   fw.append(rs.getString(4));
                   fw.append(',');
                   fw.append(rs.getString(5));
                   fw.append('\n');
                
                }
                JOptionPane.showMessageDialog(this,"CSV File is exported successfully!!");
                fw.flush();
                fw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }                                         

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {                                       
            try {
                // TODO add your handling code here:
                
                pst = con.prepareStatement("SELECT * FROM application_tbl");
                rs=pst.executeQuery();
                
                Document PDFreport = new Document();
                try {
                    PdfWriter.getInstance(PDFreport, new FileOutputStream("C:\\Users\\Joshua Gania\\Desktop\\Java PDF File.pdf"));
                } catch (DocumentException ex) {
                    Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                PDFreport.open();
                
                PdfPTable PDFTable = new PdfPTable(5);
                PdfPCell table_cell;
                
                while(rs.next()){
                
                    String id = rs.getString("id");
                    table_cell = new PdfPCell(new Phrase(id));
                    PDFTable.addCell(table_cell);
                    
                    String aname = rs.getString("Aname");
                    table_cell = new PdfPCell(new Phrase(aname));
                    PDFTable.addCell(table_cell);
                    
                    String papplied = rs.getString("Papplied");
                    table_cell = new PdfPCell(new Phrase(papplied));
                    PDFTable.addCell(table_cell);
                    
                    String astatus= rs.getString("Astatus");
                    table_cell = new PdfPCell(new Phrase(astatus));
                    PDFTable.addCell(table_cell);
                    
                    String address= rs.getString("Address");
                    table_cell = new PdfPCell(new Phrase(address));
                    PDFTable.addCell(table_cell);
                    
                                   
                
                }
                
                JOptionPane.showMessageDialog(this,"PDF File is exported successfully!!");                
                try {
                    PDFreport.add(PDFTable);
                } catch (DocumentException ex) {
                    Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
                }
                PDFreport.close();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(applicationFor.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }                                      

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void txtAstatusActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(applicationFor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(applicationFor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(applicationFor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(applicationFor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new applicationFor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JLabel txtAid;
    private javax.swing.JTextField txtAname;
    private javax.swing.JTextField txtAstatus;
    private javax.swing.JTextField txtPapplied;
    private javax.swing.JComboBox<String> txtid;
    // End of variables declaration                   
}

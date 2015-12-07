/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebooksharing1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lingshanjiang
 */
public class SuperUserCheckBook extends javax.swing.JFrame {

    /**
     * Creates new form SuperUserCheckBook
     */
    
    private static String table;
    private static int rowID;
    private static String bookname;
    
    public SuperUserCheckBook(String table,int rowID,String bookname) {
        
        this.table=table;
        this.rowID=rowID;
        this.bookname=bookname;

        
        initComponents();
        
        String sql=null;
        
        if(table=="pendingbook"){
            sql="SELECT bookfile,bookname From pendingbook WHERE pbid=?";
        }
        if(table=="complaints"){
            sql="SELECT bookfile,bookname FROM bookinfo WHERE bookID=?";
        }
        
        try {
            DbConnector dbc = new DbConnector();
            Connection conn = dbc.Connects();
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, rowID);
            ResultSet rs = pst.executeQuery();
           
           
            String str = "";
            while (rs.next()) {
                
                Check_bookname.setText(bookname);
 
                Blob blob = rs.getBlob("BOOKFILE");
                long blobLength = blob.length();
                
                int pos = 1;   // position is 1-based
                int len = 10;
                byte[] bytes = blob.getBytes(pos, len);
                
                InputStream is = blob.getBinaryStream();
                int b = is.read();
                System.out.println(b);
                
                int content;
                while ((content = is.read()) != -1) {
                    // convert to char and display it
                    str += (char) content;
                    //System.out.println(str);
                    
                }
            }
            
            BOOKCONTENT.append(str);
            BOOKCONTENT.setLineWrap(true);
        } catch (SQLException ex) {
            Logger.getLogger(BookOpened.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BookOpened.class.getName()).log(Level.SEVERE, null, ex);
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

        Check_bookname = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BOOKCONTENT = new javax.swing.JTextArea();
        Check_bookname1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Check_bookname.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        Check_bookname.setText("Bookname:");

        BOOKCONTENT.setEditable(false);
        BOOKCONTENT.setColumns(20);
        BOOKCONTENT.setLineWrap(true);
        BOOKCONTENT.setRows(5);
        jScrollPane2.setViewportView(BOOKCONTENT);

        Check_bookname1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        Check_bookname1.setText("Bookname:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Check_bookname1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Check_bookname, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Check_bookname1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Check_bookname, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SuperUserCheckBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuperUserCheckBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuperUserCheckBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuperUserCheckBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuperUserCheckBook(table,rowID,bookname).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea BOOKCONTENT;
    private javax.swing.JLabel Check_bookname;
    private javax.swing.JLabel Check_bookname1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

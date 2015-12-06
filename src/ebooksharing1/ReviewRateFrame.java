/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebooksharing1;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author indrajit
 */
public class ReviewRateFrame extends javax.swing.JFrame {

    /**
     * Creates new form ReviewRateFrame
     */
    private static int bookid;
    private static String username;
    private String bName = "";

    public ReviewRateFrame(int bookid, String username) {
        super("Rate and Review");
        this.bookid = bookid;
        this.username = username;
        initComponents();
        display_bookImage();
        ReviewRateLabel.setText("Review and Rate this Book ");
        // + Integer.toString(bookid)
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ReviewRateLabel = new javax.swing.JLabel();
        RatingLabel = new javax.swing.JLabel();
        ReviewLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reviewTextArea = new javax.swing.JTextArea();
        RateTextField = new javax.swing.JTextField();
        CoverLabel = new javax.swing.JLabel();
        SubmitRatingReviewButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        BookNameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));

        ReviewRateLabel.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        ReviewRateLabel.setText("BookId");

        RatingLabel.setText("Your Rating: ");

        ReviewLabel.setText("Your Review:");

        reviewTextArea.setColumns(20);
        reviewTextArea.setRows(5);
        jScrollPane1.setViewportView(reviewTextArea);

        SubmitRatingReviewButton.setText("Submit");
        SubmitRatingReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitRatingReviewButtonActionPerformed(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        BookNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        BookNameLabel.setText("BookName");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ReviewRateLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(BookNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(CoverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RatingLabel)
                                    .addComponent(ReviewLabel)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(ExitButton)
                                .addGap(1, 1, 1)))))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SubmitRatingReviewButton)
                    .addComponent(RateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(404, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ReviewRateLabel)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RatingLabel))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReviewLabel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(CoverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubmitRatingReviewButton)
                            .addComponent(ExitButton)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(BookNameLabel)))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitRatingReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitRatingReviewButtonActionPerformed
        // TODO add your handling code here:
        submit();
    }//GEN-LAST:event_SubmitRatingReviewButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // TODO add your handling code here:
        cancel();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void submit() {
        String Str_rate = RateTextField.getText();
        String review = reviewTextArea.getText();
        DbConnector dbc = new DbConnector();
        Connection conn = dbc.Connects();
        int rating = 0;
        int rating_count = 0;
        int new_rating = 0;
        int new_rating_count = 0;

        try {

            if (!Str_rate.isEmpty() && !review.isEmpty()) // && !uploader_name.isEmpty()
            {
                int rate = Integer.parseInt(Str_rate);

                String BookInfosql = "SELECT Rating, Rating_counts from BOOKINFO where Bookid = ?";
                PreparedStatement BookInfostmt = conn.prepareStatement(BookInfosql);
                BookInfostmt.setInt(1, bookid);
                ResultSet rs = BookInfostmt.executeQuery();
                while (rs.next()) {
                    rating = rs.getInt("rating");
                    rating_count = rs.getInt("rating_counts");
                }
                new_rating_count = rating_count + 1;
                new_rating = ((rating * rating_count) + rate) / new_rating_count;
                update_rating_rating_count(new_rating_count, new_rating);
                String sql = "INSERT INTO REVIEW_RATING (BookID, Username, review_text, rating) "
                        + "VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, bookid);
                stmt.setString(2, username);
                stmt.setString(3, review);
                stmt.setInt(4, rate);
                stmt.execute();
                conn.commit();
                conn.close();
                JOptionPane.showMessageDialog(null, "Rating and Review submission succcessful.");
                RateTextField.setText("");
                reviewTextArea.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "All fields required.", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    public ImageIcon getImage() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Blob image = null;
        
        byte[] imgData = null;
        DbConnector dbc = new DbConnector();
        Connection conn = dbc.Connects();
        String sql = "SELECT bookname, cover FROM bookinfo  where bookid = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, bookid);
            rs = pst.executeQuery();
            while (rs.next()) {
                image = rs.getBlob("Cover");
                imgData = image.getBytes(1, (int) image.length());
                bName = rs.getString("BookName");
            }

        } catch (Exception e) {
            //Logger.getLogger(ReviewRateFrame.class.getName()).log(Level.SEVERE, null, ex);
            e.printStackTrace();
        }
        return new ImageIcon(new ImageIcon(imgData).getImage().getScaledInstance(200, 250, java.awt.Image.SCALE_SMOOTH));
    }

    private void display_bookImage() {
        CoverLabel.setIcon(getImage());
        BookNameLabel.setText(bName);
    }

    private void update_rating_rating_count(int new_rating_count, int new_rating) {
        DbConnector dbc = new DbConnector();
        Connection conn = dbc.Connects();

        String BookInfosqlinsert = "UPDATE BOOKINFO SET rating = ?, rating_counts = ? WHERE BOOKID =?";
        PreparedStatement BookInfosqlinsertstmt;
        try {
            BookInfosqlinsertstmt = conn.prepareStatement(BookInfosqlinsert);
            BookInfosqlinsertstmt.setInt(1, new_rating);
            BookInfosqlinsertstmt.setInt(2, new_rating_count);
            BookInfosqlinsertstmt.setInt(3, bookid);
            BookInfosqlinsertstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewRateFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            java.util.logging.Logger.getLogger(ReviewRateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReviewRateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReviewRateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReviewRateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReviewRateFrame(bookid, username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookNameLabel;
    private javax.swing.JLabel CoverLabel;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField RateTextField;
    private javax.swing.JLabel RatingLabel;
    private javax.swing.JLabel ReviewLabel;
    private javax.swing.JLabel ReviewRateLabel;
    private javax.swing.JButton SubmitRatingReviewButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea reviewTextArea;
    // End of variables declaration//GEN-END:variables

    public void cancel() {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
    }
}

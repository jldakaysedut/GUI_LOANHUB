/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import config.Session;
import loanhub.*;
import config.dbConnector;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class applicationDetails extends javax.swing.JFrame {

  
    public applicationDetails() {
        initComponents();
    }


 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        approveButton = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        aamount = new javax.swing.JTextField();
        aterm = new javax.swing.JTextField();
        aincome = new javax.swing.JTextField();
        adate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        aid = new javax.swing.JTextField();
        pid = new javax.swing.JTextField();
        afname = new javax.swing.JTextField();
        acontact = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        alname = new javax.swing.JTextField();
        astatus = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 51, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel1.setText("APPLICATION DETAILS");
        jLabel1.setToolTipText("");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 324, 40));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Approved");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, 40));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Deny");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 100, 40));

        id.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        id.setText("Uid");
        jPanel2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        approveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dark red (2).jpg"))); // NOI18N
        approveButton.setText("jLabel10");
        jPanel2.add(approveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -90, 760, 180));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 750, 70));

        jPanel4.setBackground(new java.awt.Color(102, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aamount.setEnabled(false);
        jPanel4.add(aamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 226, -1));

        aterm.setEnabled(false);
        jPanel4.add(aterm, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 226, -1));

        aincome.setEnabled(false);
        jPanel4.add(aincome, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 226, -1));

        adate.setEnabled(false);
        adate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adateActionPerformed(evt);
            }
        });
        jPanel4.add(adate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 226, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Amount");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Term");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Income");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Date");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Status");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, -1));

        aid.setEnabled(false);
        jPanel4.add(aid, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 120, 210, -1));

        pid.setEnabled(false);
        jPanel4.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 170, 210, -1));

        afname.setEnabled(false);
        afname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afnameActionPerformed(evt);
            }
        });
        jPanel4.add(afname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 200, -1));

        acontact.setEnabled(false);
        jPanel4.add(acontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 200, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Application ID");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Plan ID");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("First Name");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Contact");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Last Name");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("Back");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 100, 40));

        alname.setEnabled(false);
        jPanel4.add(alname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 200, -1));

        astatus.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        astatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Approved", "Denied" }));
        astatus.setEnabled(false);
        jPanel4.add(astatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 230, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/red-and-orange-background.jpg"))); // NOI18N
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 750, 320));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adateActionPerformed

    private void afnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afnameActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

   loanApplication la = new loanApplication();
        la.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


    if (aid.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please select an application first!");
} else {
    dbConnector dbc = new dbConnector();

    dbc.updateData("UPDATE tbl_apply SET status = 'Approved' WHERE a_id = '" + aid.getText() + "'");

    JOptionPane.showMessageDialog(null, "Application Approved Successfully!");

    // ✅ Log action
    try {
        Session sess = Session.getInstance();
        String logQuery = "INSERT INTO tbl_logs (u_id, action, date) VALUES ('" 
                + sess.getUid() + "', 'Approved Application ID: " + aid.getText() + "', NOW())";
        dbc.insertData(logQuery);
    } catch (Exception ex) {
        System.out.println("Log Insert Error: " + ex);
    }

    // Redirect to loanApplication and close this form
    loanApplication la = new loanApplication();
    la.setVisible(true);
    this.dispose();
}



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


  if (aid.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please select an application first!");
} else {
    dbConnector dbc = new dbConnector();

    try {
        ResultSet rs = dbc.getData("SELECT status FROM tbl_apply WHERE a_id = '" + aid.getText() + "'");
        
        if (rs.next()) {
            String currentStatus = rs.getString("status");

            if ("Approved".equalsIgnoreCase(currentStatus)) {
                JOptionPane.showMessageDialog(null, "This application has already been approved and cannot be denied.");
            } else {
                dbc.updateData("UPDATE tbl_apply SET status = 'Denied' WHERE a_id = '" + aid.getText() + "'");
                JOptionPane.showMessageDialog(null, "Application Denied Successfully!");

                // ✅ Log action
                try {
                    Session sess = Session.getInstance();
                    String logQuery = "INSERT INTO tbl_logs (u_id, action, date) VALUES ('" 
                            + sess.getUid() + "', 'Denied Application ID: " + aid.getText() + "', NOW())";
                    dbc.insertData(logQuery);
                } catch (Exception ex) {
                    System.out.println("Log Insert Error: " + ex);
                }

                // Redirect to main application list
                loanApplication la = new loanApplication();
                la.setVisible(true);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Application not found.");
        }

    } catch (SQLException ex) {
        System.out.println("Error: " + ex);
    }
}


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
         Session sess = Session.getInstance();  
     id.setText("USER ID: "+sess.getUid());        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(applicationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(applicationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(applicationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(applicationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new applicationDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField aamount;
    public javax.swing.JTextField acontact;
    public javax.swing.JTextField adate;
    public javax.swing.JTextField afname;
    public javax.swing.JTextField aid;
    public javax.swing.JTextField aincome;
    public javax.swing.JTextField alname;
    private javax.swing.JLabel approveButton;
    public javax.swing.JComboBox<String> astatus;
    public javax.swing.JTextField aterm;
    private javax.swing.JLabel id;
    public javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JTextField pid;
    // End of variables declaration//GEN-END:variables
}

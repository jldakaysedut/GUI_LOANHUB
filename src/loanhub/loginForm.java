/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanhub;

import admin.admindashboard;
import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import user.userDashboard;

/**
 *
 * @author jldak
 */
public class loginForm extends javax.swing.JFrame {

    /**
     * Creates new form loginForm
     */
    public loginForm() {
        initComponents();
    }

    static String status;
    static String type;
    
    
   
    public static boolean loginAcc(String username, String password){
        dbConnector connector = new dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_user  WHERE u_username = '" + username + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()){
              
            
                String hashedPass = resultSet.getString("u_password");
                String rehashedPass = passwordHasher.hashPassword(password);  
                
                
         
            if(hashedPass.equals(rehashedPass)){
                
            status = resultSet.getString("u_status");   
            type = resultSet.getString("u_type"); 
            Session sess = Session.getInstance();
            sess.setUid(resultSet.getInt("u_id"));
            sess.setFname(resultSet.getString("u_fname"));
            sess.setLname(resultSet.getString("u_lname"));
            sess.setEmail(resultSet.getString("u_email"));
            sess.setContact(resultSet.getString("u_contact"));
            sess.setUsername(resultSet.getString("u_username"));
            sess.setType(resultSet.getString("u_type"));
            sess.setStatus(resultSet.getString("u_status"));          
            return true; 
            
             }else{ 
                
            return false;
            }
              
           }else{ 
                
            return false;
            }
            
        }catch (SQLException | NoSuchAlgorithmException ex){
            return false;
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 51, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 38)); // NOI18N
        jLabel1.setText("Welcome to LoanHub");
        jLabel1.setToolTipText("");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 380, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dark red (2).jpg"))); // NOI18N
        jLabel12.setText("jLabel10");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -90, 750, 180));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 90));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo_loanhub2 (2).png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 126));

        jLabel11.setBackground(new java.awt.Color(255, 153, 0));
        jLabel11.setFont(new java.awt.Font("Viner Hand ITC", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("By: Dakay");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black backround (1).png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, -10, 340, 410));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 400));

        jPanel5.setBackground(new java.awt.Color(102, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Password");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 82, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Username");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 82, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel5.setText("Login Form");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 167, -1));

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel5.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 240, 34));

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel5.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 240, 35));

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 100, 40));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 100, 40));

        jLabel4.setBackground(new java.awt.Color(51, 204, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("New? Click Here to Register");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 240, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Forgot Password? Click Here");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 250, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/red-and-orange-background.jpg"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 450, 390));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
  
        
        
      
 
    }//GEN-LAST:event_userActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        
           
if(loginAcc(user.getText(),pass.getText())){
    if(!status.equals("Active")){
    JOptionPane.showMessageDialog(null,"In-Active Account, Contact the admin");   
}else{      
      
     
      if(type.equals("Admin")){    
     JOptionPane.showMessageDialog(null,"Login Success"); 
     admindashboard ads = new admindashboard();
     ads.setVisible(true);
     this.dispose();    
     
      }else if(type.equals("User")){
      JOptionPane.showMessageDialog(null,"Login Success"); 
     userDashboard usd = new userDashboard();
     usd.setVisible(true);
     this.dispose();    
      }else{
     JOptionPane.showMessageDialog(null,"No Account type found, Contact Admin");
       
    }
      
    }
 }else{
     JOptionPane.showMessageDialog(null,"Invalid Account");
}  
  
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

regForm rgf = new regForm();
rgf.setVisible(true);
this.dispose();
    



       
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}

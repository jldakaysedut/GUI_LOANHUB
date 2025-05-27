/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import loanhub.regForm;
import static loanhub.regForm.contact;
import static loanhub.regForm.email;
import static loanhub.regForm.usname;

/**
 *
 * @author jldak
 */
public class createuserForm extends javax.swing.JFrame {

    /**
     * Creates new form createuserForm
     */
    public createuserForm() {
        initComponents();
    }
    
    
    
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
    
public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }



public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }


public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}




    public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
    
    
    
    
    public boolean dublicateCheck(){
    
    dbConnector dbc = new dbConnector();
    
    try{
        
        
        String contactNumber = cn.getText();
    if (!contactNumber.matches("^09\\d{9}$")) {
        JOptionPane.showMessageDialog(null, "Invalid contact number! Must be 11 digits and start with '09'.");
        cn.setText("");
        return true;
    }
     
        
        
    String query = "SELECT * FROM tbl_user WHERE (u_username = '" + un.getText() + "' OR u_email = '" + em.getText() + "' OR u_contact = '" + cn.getText() + "') AND u_id = '"+uid.getText()+"' ";
    ResultSet resultSet = dbc.getData(query);
          
            if(resultSet.next()){
                
                email = resultSet.getString("u_email");             
                if(email.equals(em.getText())){
                   JOptionPane.showMessageDialog(null, "Email is already used!"); 
                   em.setText("");
                }
                
                usname = resultSet.getString("u_username");               
                if(usname.equals(un.getText())){
                   JOptionPane.showMessageDialog(null, "Username is already used!"); 
                    un.setText("");
                } 
                
                
                contact = resultSet.getString("u_contact");
                if(contact.equals(cn.getText())){
                    JOptionPane.showMessageDialog(null, "Contact is already used!"); 
                    cn.setText(""); 
                }
                
                
                return true;
            }else{
                return false;
            }
            
    }catch(SQLException ex){
        System.out.println(""+ex);
        return false;
        
    }
}

    
    
    
    
    public boolean updateCheck(){
    
    dbConnector dbc = new dbConnector();
    
    try{
        
        
        String contactNumber = cn.getText();
    if (!contactNumber.matches("^09\\d{9}$")) {
        JOptionPane.showMessageDialog(null, "Invalid contact number! Must be 11 digits and start with '09'.");
        cn.setText("");
        return true;
    }
     
        
        
    String query = "SELECT * FROM tbl_user WHERE (u_username = '" + un.getText() + "' OR u_email = '" 
            + em.getText() + "' OR u_contact = '" + cn.getText() + "') AND u_id!='"+uid.getText()+"'   ";
    ResultSet resultSet = dbc.getData(query);
          
            if(resultSet.next()){
                
                email = resultSet.getString("u_email");             
                if(email.equals(em.getText())){
                   JOptionPane.showMessageDialog(null, "Email is already used!"); 
                   em.setText("");
                }
                
                usname = resultSet.getString("u_username");               
                if(usname.equals(un.getText())){
                   JOptionPane.showMessageDialog(null, "Username is already used!"); 
                    un.setText("");
                } 
                
                
                contact = resultSet.getString("u_contact");
                if(contact.equals(cn.getText())){
                    JOptionPane.showMessageDialog(null, "Contact is already used!"); 
                    cn.setText(""); 
                }
                
               
                
                
                return true;
            }else{
                return false;
            }
            
    }catch(SQLException ex){
        System.out.println(""+ex);
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
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        update = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        ps = new javax.swing.JTextField();
        ut = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cn = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        us = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 51, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel1.setText("CREATE USER FORM");
        jLabel1.setToolTipText("");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 16, 324, 52));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dark red (2).jpg"))); // NOI18N
        jLabel16.setText("jLabel10");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -90, 760, 180));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 750, 70));

        jPanel4.setBackground(new java.awt.Color(102, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        add.setForeground(new java.awt.Color(255, 153, 0));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel3.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 109, -1));

        delete.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 153, 51));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel3.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 109, -1));

        clear.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 204, 51));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel3.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 109, -1));

        update.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        update.setForeground(new java.awt.Color(255, 153, 0));
        update.setText("Update");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 109, -1));

        cancel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 204, 51));
        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel3.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 109, -1));

        refresh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 204, 51));
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel3.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 109, -1));

        jPanel5.setLayout(null);

        image.setBackground(new java.awt.Color(255, 153, 0));
        image.setForeground(new java.awt.Color(255, 153, 0));
        jPanel5.add(image);
        image.setBounds(20, 0, 210, 160);

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 160));

        jPanel6.setBackground(new java.awt.Color(153, 0, 0));
        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 300, 10));

        select.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        select.setForeground(new java.awt.Color(255, 153, 0));
        select.setText("Select");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel3.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 110, -1));

        remove.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 153, 0));
        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel3.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 190, 110, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black backround (1).png"))); // NOI18N
        jLabel12.setText("jLabel8");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 300, 510));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 300, 410));

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel1.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 58, 244, -1));
        jPanel1.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 102, 244, -1));
        jPanel1.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 144, 244, -1));
        jPanel1.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 228, 244, -1));

        ps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psActionPerformed(evt);
            }
        });
        jPanel1.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 270, 244, -1));

        ut.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });
        jPanel1.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 312, 244, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("First Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Last name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 104, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 146, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Username");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Password");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 272, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("User status");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 356, -1, -1));

        cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnActionPerformed(evt);
            }
        });
        jPanel1.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 186, 244, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Contact Number");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 188, -1, -1));

        us.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        jPanel1.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 355, 244, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Account type");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 313, -1, -1));

        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel1.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 16, 244, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("User ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 18, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/red-and-orange-background.jpg"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 410));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 440, 410));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void psActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psActionPerformed

    
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

   if(fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty() || cn.getText().isEmpty() || 
   un.getText().isEmpty() || ps.getText().isEmpty() || image.getIcon() == null) {
    
    JOptionPane.showMessageDialog(null, "All fields are required including Image!");
    
} else if(!em.getText().toLowerCase().endsWith("@gmail.com")) {
    
    JOptionPane.showMessageDialog(null, "Email must be a valid Gmail address (must end with @gmail.com)!");
    
} else if(!cn.getText().matches("^09\\d{9}$")) {
    
    JOptionPane.showMessageDialog(null, "Contact number must start with '09' and be exactly 11 digits!");
    
} else if(ps.getText().length() < 8) {
    
    JOptionPane.showMessageDialog(null, "Password should be minimum of 8 characters!");
    ps.setText("");
    
} else if(dublicateCheck()) {
    
    System.out.println("Duplicate Exist");
    
} else {
    try {
        String pass = passwordHasher.hashPassword(ps.getText());
        dbConnector dbc = new dbConnector();

        String insertQuery = "INSERT INTO tbl_user(u_fname, u_lname, u_email, u_contact, u_username, u_password, u_type, u_status, u_image) " +
                             "VALUES('" + fn.getText() + "', '" + ln.getText() + "', '" + em.getText() + "', '" + cn.getText() + "', '" +
                             un.getText() + "', '" + pass + "', '" + ut.getSelectedItem() + "', '" + us.getSelectedItem() + "', '" + destination + "')";

        int generatedId = dbc.insertDataAndReturnID(insertQuery); // ✅ Get new user ID

        if (generatedId != -1) {

            // ✅ Insert log using current session user
            try {
                Session sess = Session.getInstance();
                String logQuery = "INSERT INTO tbl_logs (u_id, action, date) VALUES ('" + 
                                   sess.getUid() + "', 'Added new user: ID " + generatedId + "', NOW())";
                dbc.insertData(logQuery);
            } catch (Exception ex) {
                System.out.println("Log Insert Error: " + ex);
            }

            try {
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "Registration Success!");
                usersForm uf = new usersForm();
                uf.setVisible(true);
                this.dispose();
            } catch(IOException ex) {
                System.out.println("Insert Image Error: " + ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Connection error!");
        }

    } catch(NoSuchAlgorithmException ex) {
        System.out.println("Password Hash Error: " + ex);
    }
}
  
   
    }//GEN-LAST:event_addActionPerformed

    private void cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnActionPerformed

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed

createuserForm cuf = new createuserForm();
cuf.setVisible(true);
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
if(fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty() || cn.getText().isEmpty() ||
   un.getText().isEmpty() || ps.getText().isEmpty()) {

    JOptionPane.showMessageDialog(null, "All fields are required!");

} else if(!em.getText().toLowerCase().endsWith("@gmail.com")) {

    JOptionPane.showMessageDialog(null, "Email must be a valid Gmail address (must end with @gmail.com)!");

} else if(!cn.getText().matches("^09\\d{9}$")) {

    JOptionPane.showMessageDialog(null, "Contact number must start with '09' and be exactly 11 digits!");

} else if(ps.getText().length() < 8) {

    JOptionPane.showMessageDialog(null, "Password should be minimum of 8 characters!");
    ps.setText("");

} else if(updateCheck()) {

    System.out.println("Duplicate Exist");

} else if (image.getIcon() == null) {  // Check if image is selected
    JOptionPane.showMessageDialog(null, "Please upload an image!");

} else {

    dbConnector dbc = new dbConnector();

    dbc.updateData("UPDATE tbl_user SET " +
                   "u_fname = '" + fn.getText() + "', " +
                   "u_lname = '" + ln.getText() + "', " +
                   "u_email = '" + em.getText() + "', " +
                   "u_contact = '" + cn.getText() + "', " +
                   "u_username = '" + un.getText() + "', " +
                   "u_password = '" + ps.getText() + "', " +
                   "u_type = '" + ut.getSelectedItem() + "', " +
                   "u_status = '" + us.getSelectedItem() + "', " +
                   "u_image = '" + destination + "' " +
                   "WHERE u_id = '" + uid.getText() + "'");

    // ✅ Log the update action
    try {
        Session sess = Session.getInstance();
        String logQuery = "INSERT INTO tbl_logs (u_id, action, date) VALUES ('" +
                           sess.getUid() + "', 'Updated user: ID " + uid.getText() + "', NOW())";
        dbc.insertData(logQuery);
    } catch (Exception ex) {
        System.out.println("Log Insert Error: " + ex);
    }

    // ✅ Handle image
    if(destination.isEmpty()) {
        File existingFile = new File(oldpath);
        if(existingFile.exists()) {
            existingFile.delete();
        }
    } else {
        if(!oldpath.equals(path)) {
            imageUpdater(oldpath, path);
        }
    }

    usersForm uf = new usersForm();
    uf.setVisible(true);
    this.dispose();
}


        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed


usersForm urf = new usersForm();
urf.setVisible(true);
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed




        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked






        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed



JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/userimages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            select.setEnabled(false);
                            remove.setEnabled(true);
                            
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }


        // TODO add your handling code here:
    }//GEN-LAST:event_selectActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed



 remove.setEnabled(false);
 select.setEnabled(true);
 image.setIcon(null);
 destination = "";
 path = "";
 
                            



    }//GEN-LAST:event_removeActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

int confirm = JOptionPane.showConfirmDialog(null, 
    "Are you sure you want to delete User ID " + uid.getText() + "?", 
    "Confirm Delete", 
    JOptionPane.YES_NO_OPTION);

if (confirm == JOptionPane.YES_OPTION) {
    dbConnector dbc = new dbConnector();

    try {
        // 🗑 Delete user from database
        String deleteQuery = "DELETE FROM tbl_user WHERE u_id = '" + uid.getText() + "'";
        dbc.updateData(deleteQuery);

        // 📝 Log the delete action
        try {
            Session sess = Session.getInstance();
            String logQuery = "INSERT INTO tbl_logs (u_id, action, date) VALUES ('" +
                              sess.getUid() + "', 'Deleted user: ID " + uid.getText() + "', NOW())";
            dbc.insertData(logQuery);
        } catch (Exception ex) {
            System.out.println("Log Insert Error: " + ex);
        }

        // 🖼️ Delete image file if exists
        if (!destination.isEmpty()) {
            File imgFile = new File(destination);
            if (imgFile.exists()) {
                imgFile.delete();
            }
        }

        // ✅ Confirmation message
        JOptionPane.showMessageDialog(null, "User deleted successfully.");

        // 🧹 Clear fields
        uid.setText("");
        fn.setText("");
        ln.setText("");
        em.setText("");
        cn.setText("");
        un.setText("");
        ps.setText("");
        ut.setSelectedIndex(0);
        us.setSelectedIndex(0);
        image.setIcon(null);
        destination = "";
        oldpath = "";
        path = "";

        // 🔄 Return to users form
        usersForm uf = new usersForm();
        uf.setVisible(true);
        this.dispose();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error deleting user: " + ex.getMessage());
    }
}







        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(createuserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createuserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createuserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createuserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createuserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JButton clear;
    public javax.swing.JTextField cn;
    private javax.swing.JButton delete;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField ps;
    private javax.swing.JButton refresh;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField uid;
    public javax.swing.JTextField un;
    public javax.swing.JButton update;
    public javax.swing.JComboBox<String> us;
    public javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}

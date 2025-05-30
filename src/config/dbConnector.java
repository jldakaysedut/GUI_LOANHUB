/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 *
 */
public class dbConnector {
    
    private Connection connect;
   public dbConnector(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/loanhub", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
        } 
    
   
   
   //Function to retrieve data
        public ResultSet getData(String sql) throws SQLException{
            Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }
        
        
        
        //Function to save data
        public boolean insertData(String sql){
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                pst.close();
               return true;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
               return false;
            }
        
        
        
        
        
    
}
        
        
        
         public void updateData(String sql){
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                    int rowsUpdated = pst.executeUpdate();
                        if(rowsUpdated > 0){
                            JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
                        }else{
                            System.out.println("Data Update Failed!");
                        }
                        pst.close();
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
            }
        
        }
        
        
  // Function to insert data and return generated ID (like p_id)
public int insertDataAndReturnID(String sql) {
    try {
        PreparedStatement pst = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            int generatedId = rs.getInt(1); // This is your auto-incremented ID
            pst.close();
            return generatedId;
        }
        pst.close();
    } catch (SQLException ex) {
        System.out.println("Insert with ID Error: " + ex.getMessage());
    }
    return -1; // return -1 if failed
}
      
     public boolean updateDataapply(String sql, Object... params) {
    try (PreparedStatement pst = connect.prepareStatement(sql)) {
        for (int i = 0; i < params.length; i++) {
            pst.setObject(i + 1, params[i]);
        }
        int rows = pst.executeUpdate();
        return rows > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
  


}

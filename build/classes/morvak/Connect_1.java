/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morvak;

/**
 *
 * @author Thulani Mpofu a.k.a Lani 
 * 
 */


import java.sql.Connection;     //Allows the connection to database
import java.sql.DriverManager;   //Loads the driver to connect to the database
import java.sql.PreparedStatement; //
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Connect_1 {
    
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
 public static Connection ConnectDB() {
        String host = "jdbc:mysql://localhost:3306/"; //Databse host 
        String dbName = "morvak_database";   //Database Name
        String username = "root";   //Database username
        String password = "";  //Database Password
        String url = host + dbName + "?user=" + username + "&password=" + password;  //Databse URL
        try {
            // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(url); // Setting up the connection to the database 
            Statement stat = conn.createStatement();
            JOptionPane.showMessageDialog(null, "Connected  "); 
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);   //Identifying any errors 
            return null;
        }
     

    }   
 
 
    
    
    
}

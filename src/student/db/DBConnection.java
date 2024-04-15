/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class DBConnection {
    
     private static Connection conn = null;
     private static String url = "jdbc:mysql://localhost:3306/student2";
     private static String pwd ="";
     private static String user ="root";
    
    
    
    public static Connection dbConnection() throws SQLException{
        if (conn == null){
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection(url, user, pwd);  
        } catch (ClassNotFoundException e) {
            System.out.println("error occure");
        }
        
    } 
        return conn;
    }   
    
    
    
    
}

package Db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
/**
 *
 * @author duvindu
 */
public class Connection_Class {
    
   Connection  conn;
   
    public static  Connection conDb() {
        //static method for db connection
        
          System.out.println("Loading the driver");
     try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL ="jdbc:sqlserver://localhost:1433;databaseName=Libary;user=project;password=4321"; //connection string
        
        System.out.println("Connecting");  
        Connection conn = DriverManager.getConnection(connectionURL);
        
            return conn;
    
     }

     catch(ClassNotFoundException | SQLException e){
         JOptionPane.showMessageDialog(null, e);
         return null;
     
     }
  
    }
    
    
}

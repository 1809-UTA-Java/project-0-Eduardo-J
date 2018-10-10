package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	//Declare Connection and Statement objects
    //Connection myConnection = null;
    //Statement myStatement = null;
	public static Connection getConnection() throws SQLException, IOException{
	
		//Properties prop = new Properties();
		//InputStream in = new FileInputStream("connection.properties");
		//prop.load(in);
		
        //Register the driver
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        return DriverManager.getConnection(
        		"jdbc:oracle:thin:@192.168.45.3:1521:xe",
        		"system",
        		"revature"
        		
        		);
        
        /*
        //Configure Connection
        myConnection = DriverManager.getConnection(
            "jdbc:oracle:thin:@192.168.45.3:1521:xe", 
            "system", 
            "revature");
        try {

            //Create Statement
            myStatement = myConnection.createStatement();
            myStatement.execute("INSERT INTO CUSTOMERS (id, name, username, pass) VALUES (5, 'job', 'job', 'job')");

            //Create a ResultSet object for storing data from a SELECT
            ResultSet customers = myStatement.executeQuery("SELECT * FROM CUSTOMERS");

            while(customers.next()) {
                System.out.println(customers.getInt("id"));
                System.out.println(customers.getString("name"));
                System.out.println(customers.getString("username"));
                System.out.println(customers.getString("pass"));
                System.out.println();
            }

            myStatement.close();
            myConnection.close();
        } catch (SQLException ex) {
            ex.getMessage();
        } 
        */
        
        
        
        
	}
    
}

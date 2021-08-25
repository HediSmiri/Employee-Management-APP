package com.mycompany.parc;

import java.sql.* ;

public class DatabaseCon {
    
    public void connex(java.awt.Choice Service,String query,String item) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        // Step 1: Loading or registering Oracle JDBC driver class
        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
        // Step 2: Opening database connection

            // Step 2.A: Create and get connection using DriverManager class
            String url = "C:\\Users\\Smiri\\Documents\\CPG.accdb";
            String full = "jdbc:ucanaccess://"+url ;
            //jdbc:ucanaccess://C:\\Users\\Smiri\\Documents\\CPG.mdb
            connection = DriverManager.getConnection(full); 
            // Step 2.B: Creating JDBC Statement 
            
            statement = connection.createStatement();
            
            // Step 2.C: Executing SQL & retrieve data into ResultSet
            resultSet = statement.executeQuery(query);

            // processing returned data and printing into console
            int test = 0 ;
            while(resultSet.next()) {
                Service.addItem(resultSet.getString(item));
                }
                
            }
}

package com.mycompany.parc;

import java.sql.* ;

public class DatabaseCon {
    
    public int connex(String matricule , String password){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String mat = null , pass = null;
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
        try {

            // Step 2.A: Create and get connection using DriverManager class
            String url = "C:\\Users\\Smiri\\Documents\\CPG.accdb";
            String full = "jdbc:ucanaccess://"+url ;
            //jdbc:ucanaccess://C:\\Users\\Smiri\\Documents\\CPG.mdb
            connection = DriverManager.getConnection(full); 

            // Step 2.B: Creating JDBC Statement 
            statement = connection.createStatement();
            String query = "SELECT * FROM User;" ;
            // Step 2.C: Executing SQL & retrieve data into ResultSet
            resultSet = statement.executeQuery(query);

            // processing returned data and printing into console
            int test = 0 ;
            while(resultSet.next()) {
                mat = resultSet.getString(1);
                pass = resultSet.getString(6);
                if ((mat.equals(matricule)) && (pass.equals(password))){
                    return 1 ;
                }
                
            }
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
        finally {

            // Step 3: Closing database connection
            try {
                if(null != connection) {

                    // cleanup resources, once after processing
                    resultSet.close();
                    statement.close();

                    // and then finally close connection
                    connection.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        return 0;
    }
}
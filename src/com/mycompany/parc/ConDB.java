/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parc;

import java.sql.* ;

public class ConDB {
    
       public static Connection ConnectDB(){
           
        String url1 = "C:\\Users\\Smiri\\Documents\\CPG.accdb";

        String url = "jdbc:ucanaccess://"+url1 ;
        
        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
        
        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url);
            return connection;
      //connection.close();
        } catch (SQLException e) {
            System.out.print(e);
            return null;
        }        
    }
        
    public int insert(String query){
        Connection conn ;
        conn = ConnectDB();
        PreparedStatement preparedStmt ;
        try{
            conn.prepareStatement(query).execute();
            return 0 ;
        }catch(SQLException e){
            System.out.print(e);
        }
           return 1;
        
    }
    
    public ResultSet Result(String query){
        Connection conn ;
        conn = ConnectDB();
        try{
            Statement statement = null;
        ResultSet res = null;
        statement = conn.createStatement();
        // Step 2.C: Executing SQL & retrieve data into ResultSet
        res = statement.executeQuery(query);
        conn.close();
        // processing returned data and printing into console
        return res ;
        }catch(SQLException e){
            System.out.print(e);
        }
           return null;
    }
    
    public int Delete(String query){
        Connection conn ;
        conn = ConnectDB();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Record deleted successfully");
            return 0 ;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 1 ;
    }
    
    
}

    
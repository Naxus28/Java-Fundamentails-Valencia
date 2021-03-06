//STEP 1. Import required packages
import java.sql.*;

public class JDBCExample {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   
	// JDBC driver name and database URL--query string 'autoReconnect=true' will
	// attempt to auto reconnect to DB if connection is dead or stale;
	// 'useSSL=false' disables ssl
	// see query string options here:
	// https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-reference-configuration-properties.html
   static final String DB_URL = "jdbc:mysql://localhost?autoReconnect=true&useSSL=false";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "UFPhD2012";
   
   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
   
	   try{
	      //STEP 2: Register JDBC driver
		  //Class.forName loads a class, including running its static initializers
	      Class.forName("com.mysql.jdbc.Driver");
	
	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
	      //STEP 4: Execute a query
	      System.out.println("Creating database...");
	      stmt = conn.createStatement();
	      
	      String sql = "CREATE DATABASE STUDENTS";
	      stmt.executeUpdate(sql);
	      System.out.println("Database created successfully...");
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	    	  	// nothing we can do
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
   
	   System.out.println("Goodbye!");
	   
   }//end main
}//end JDBCExample
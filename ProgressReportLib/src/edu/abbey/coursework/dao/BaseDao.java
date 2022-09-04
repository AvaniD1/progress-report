package edu.abbey.coursework.dao;

import edu.abbey.coursework.model.Student;
import edu.abbey.coursework.model.StudentRelativeScore;
import edu.abbey.coursework.model.Subject;
import edu.abbey.coursework.model.YearGroup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*

Highlight the use of inheritance
Base class implements - DB connection open , close and logging of SQL errors 
as they are common for all DAO classes

Protected Class constructors 


*/
public class BaseDao {
    
    private static String DB_NAME = "progress_report";
    private int PORT = 3306;
    private static String DB_CONNECTION_STRING = 
            "jdbc:mysql://localhost:3306/%s?serverTimezone=UTC";
    
    private static String userName = "dbTestReader";
    
    // This should be moved to an external property file and only specified at runtime
    private static String password = "dbTestReader!23"; 
    
    
    protected Connection dbConnection = null;
    
    protected BaseDao() throws SQLException {
        createDBConnection();
    }
    
    private void createDBConnection() throws SQLException {
        try {
            String dbConnectionString = String.format(DB_CONNECTION_STRING,DB_NAME);
            dbConnection = DriverManager.getConnection(dbConnectionString,userName, password);

        } catch (SQLException ex) {
            logSQLError(ex);
            throw ex;
        }
    }


        
    public void closeConnection() {
        if(dbConnection != null){
            try{
                dbConnection.close();
            }
            catch(SQLException ex){
                logSQLError(ex);
            }
        }
    }
    
    protected void logSQLError(SQLException ex){
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
}

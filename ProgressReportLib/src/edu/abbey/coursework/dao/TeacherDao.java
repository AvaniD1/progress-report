/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Avani Dwivedi
 */
public class TeacherDao extends BaseDao {
    
    public TeacherDao() throws SQLException {
        super();
    }
   
    public String getTeacherPassword(String teacherName)
            throws SQLException {
        try{
            PreparedStatement  statement = dbConnection.prepareStatement(
                    "SELECT password FROM teachers where username = ?");
            statement.setString(1,teacherName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getString("password");
        }
        catch(SQLException ex){
            logSQLError(ex);
            throw ex;
        }    
    }    
    
}

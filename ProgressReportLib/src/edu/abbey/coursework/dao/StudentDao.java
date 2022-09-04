/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework.dao;

import edu.abbey.coursework.model.Student;
import edu.abbey.coursework.model.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Avani Dwivedi
 */
public class StudentDao extends BaseDao {
    
    public StudentDao() throws SQLException {
        super();
    }
    
    public String getStudentPassword(String studentName) throws SQLException {
        try{
            PreparedStatement  statement = dbConnection.prepareStatement(
                    "SELECT password FROM students where username = ?");
            statement.setString(1,studentName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getString("password");
        }
        catch(SQLException ex){
            logSQLError(ex);
            throw ex;
        }
    }

    
    public List<Student> getStudentsByYearGroup(String yearGroupId) throws SQLException{
         try{
            String query = "SELECT username AS student_id, first_name, last_name FROM students\n" +
                            "WHERE current_year_group_id = ?";
            
            PreparedStatement statement = dbConnection.prepareStatement(query);
            statement.setString(1,yearGroupId);
            ResultSet resultSet = statement.executeQuery();
            List<Student> students = new ArrayList<>();
            
            while(resultSet.next()){
                Student student = new Student();
                student.setStudentId(resultSet.getString("student_id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                students.add(student);
            }
            
            return students;
        }
        catch(SQLException ex){
            logSQLError(ex);
            throw ex;
        }       
    }
    
    public List<Subject> getStudentSubjectsByYearGroup(String studentId, 
            String yearGroupId) throws SQLException{
        
         try{
            String query = "SELECT s.subject_id, s.display_name, s.description "
                    + "FROM student_subjects ss\n" +
                    "INNER JOIN subjects s\n" +
                    "ON s.subject_id = ss.subject_id\n" +
                    "WHERE ss.year_group_id = ? AND ss.student_id = ?";
            
            PreparedStatement statement = dbConnection.prepareStatement(query);
            statement.setString(1,yearGroupId);
            statement.setString(2,studentId);
            ResultSet resultSet = statement.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            
            while(resultSet.next()){
                Subject subject = new Subject();
                subject.setSubjectId(resultSet.getString("subject_id"));
                subject.setDisplayName(resultSet.getString("display_name"));
                subject.setDescription(resultSet.getString("description"));
                subjects.add(subject);
            }
            
            return subjects;
        }
        catch(SQLException ex){
            logSQLError(ex);
            throw ex;
        }       
    }
    
    
}

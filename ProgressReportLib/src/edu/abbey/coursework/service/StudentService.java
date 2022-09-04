/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework.service;

import edu.abbey.coursework.dao.StudentDao;
import edu.abbey.coursework.model.Student;
import edu.abbey.coursework.model.Subject;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Avani Dwivedi
 */
public class StudentService {
    
    public List<Student> getStudentsByYearGroup(String yearGroupId) throws SQLException {
        StudentDao dao = new StudentDao();
        try{
            return dao.getStudentsByYearGroup(yearGroupId);
        }
        finally{
            if(dao != null)
                dao.closeConnection();
        }
    }
    
    public List<Subject> getStudentSubjectsByYearGroup(String studentId, String yearGroupId) 
                throws SQLException {
        StudentDao dao = new StudentDao();
        try{
            return dao.getStudentSubjectsByYearGroup(studentId, yearGroupId);
        }
        finally{
            if(dao != null)
                dao.closeConnection();
        }
    }
}

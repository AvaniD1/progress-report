/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import edu.abbey.coursework.dao.ExamDao;
import edu.abbey.coursework.dao.StudentDao;
import edu.abbey.coursework.dao.TeacherDao;
import edu.abbey.coursework.dao.YearGroupDao;
import edu.abbey.coursework.model.Student;
import edu.abbey.coursework.model.ExamOverallScore;
import edu.abbey.coursework.model.YearGroup;
import edu.abbey.coursework.model.Subject;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Avani Dwivedi
 * 
 * ************* IMPORTANT **************************
 * Make sure to add the MySQL JDBC Driver as a library to your Project
 * Download the jar for MySQL Latest driver from
 * https://downloads.mysql.com/archives/c-j/
 * Select 'Platform Independent (Architecture Independent), ZIP Archive' option 
 * to download ZIP containing jar file e.g. zip should contain a folder 
 * mysql-connector-java-8.0.21 or like that depending on latest version number. 
 * Copy this folder to some location e.g. 
 * C:\Program Files\MySQL\mysql-connector-java-8.0.21
 * Then from NetBeans select Libraries for your project from RHS project explorer
 * Then Right Click 'Libraries' and select 'Add JAR/Folder' option
 * Then Select jar file from the folder that you got from the zip e.g. 
 * C:\Program Files\MySQL\mysql-connector-java-8.0.21\mysql-connector-java-8.0.21.jar
 * in my case. Now you have configured JDBC driver for use in your project
 */
public class DaoTest {
    

    @Test
    public void testGetStudentPassword() throws SQLException {
        
        StudentDao dao = new StudentDao();
        String password = dao.getStudentPassword("student001");
        assertNotNull(password); 
        dao.closeConnection();
    }
    
    @Test
    public void testGetTeacherPassword() throws SQLException {
        
        TeacherDao dao = new TeacherDao();
        String password = dao.getTeacherPassword("teacher001");
        assertNotNull(password);
        dao.closeConnection();
    }
    
    @Test
    public void testGetYearGroups() throws SQLException {
        YearGroupDao dao = new YearGroupDao();
        List<YearGroup> yearGroups = dao.getAllYearGroups();
        assertNotNull(yearGroups);
        assertTrue(yearGroups.size() > 0);
        for(YearGroup yearGroup : yearGroups){
            assertNotNull(yearGroup);
            System.out.println(yearGroup);    
        }
        dao.closeConnection();
        
    }
    
    @Test 
    public void testGetStudentsByYearGroup() throws SQLException{
        StudentDao dao = new StudentDao();
        List<Student> students = dao.getStudentsByYearGroup("LVI");
        assertNotNull(students);
        assertTrue(students.size() > 0);
        for(Student student : students){
            assertNotNull(student);
            System.out.println(student);
        }
        dao.closeConnection();
    }
    
    @Test 
    public void testGetStudentSubjectsByYearGroup() throws SQLException{
        StudentDao dao = new StudentDao();
        List<Subject> subjects = dao.getStudentSubjectsByYearGroup("student003", "LVI");
        assertNotNull(subjects);
        assertTrue(subjects.size() > 0);
        for(Subject subject : subjects){
            assertNotNull(subject);
            System.out.println(subject);
        }
        dao.closeConnection();
    }
    
    
    @Test
    public void testGetStudentExamScoresBySubjectAndYearGroup() throws SQLException{
        ExamDao dao = new ExamDao();
        List<ExamOverallScore> examOverallScores = 
                dao.getExamOverallScoresBySubjectAndYearGroup("PHY", "LVI");
        assertNotNull(examOverallScores);
        assertTrue(examOverallScores.size() > 0);
        for(ExamOverallScore examOverallScore  : examOverallScores){
            assertNotNull(examOverallScore);
            System.out.println(examOverallScore);
        }
        dao.closeConnection();        
    }
}

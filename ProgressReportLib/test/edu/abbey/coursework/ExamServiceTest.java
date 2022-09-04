/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import edu.abbey.coursework.model.StudentPercentageScore;
import edu.abbey.coursework.model.StudentRelativeScore;
import edu.abbey.coursework.service.ExamService;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Avani Dwivedi
 */
public class ExamServiceTest {
    
    private ExamService examService = new ExamService();    

    @Test
    public void testGetStudentExamScoresBySubjectAndYearGroup() throws SQLException {
        List<StudentRelativeScore> studentRelativeScores = 
            examService.getStudentExamScoresBySubjectAndYearGroup("student003", "PHY", "LVI");
        assertNotNull(studentRelativeScores);
        assertTrue(studentRelativeScores.size() > 0);
        for(StudentRelativeScore studentRelativeScore  : studentRelativeScores){
            assertNotNull(studentRelativeScore);
            System.out.println(studentRelativeScore);
        }
    }
    
    @Test
    public void testGetStudentPercentageExamScoresBySubjectAndYearGroup() throws SQLException {
        List<StudentPercentageScore> studentPercentageScores = 
            examService.getStudentPercentageExamScoresBySubjectAndYearGroup("student003", "PHY", "LVI");
        assertNotNull(studentPercentageScores);
        assertTrue(studentPercentageScores.size() > 0);
        for(StudentPercentageScore studentRelativeScore  : studentPercentageScores){
            assertNotNull(studentRelativeScore);
            System.out.println(studentRelativeScore);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework.service;

import edu.abbey.coursework.dao.ExamDao;
import edu.abbey.coursework.model.ExamOverallScore;
import edu.abbey.coursework.model.StudentRawScore;
import edu.abbey.coursework.model.StudentRelativeScore;
import edu.abbey.coursework.model.StudentPercentageScore;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Avani Dwivedi
 */
public class ExamService {
    
    public List<StudentRelativeScore> getStudentExamScoresBySubjectAndYearGroup(
            String studentId, String subjectId, String yearGroupId)
            throws SQLException {
        ExamDao dao = new ExamDao();
        PercentileService percentileService = new PercentileService();
        try{
            List<StudentRelativeScore> studentRelativeScores = new ArrayList<>();
            
            List<ExamOverallScore> examOverallScores = 
                    dao.getExamOverallScoresBySubjectAndYearGroup(subjectId, yearGroupId);
            
            // Calculate percentile for each exam for this student
            for(ExamOverallScore examOverallScore : examOverallScores){
                
                StudentRelativeScore studentRelativeScore = new StudentRelativeScore();
                studentRelativeScore.setStudentId(studentId);
                studentRelativeScore.setExamId(examOverallScore.getExamId());
                studentRelativeScore.setExamDate(examOverallScore.getExamDate());
                studentRelativeScore.setExamDescription(examOverallScore.getExamDescription());
                studentRelativeScore.setAverageScore(examOverallScore.getAverageScore());
                studentRelativeScore.setMaximumScore(examOverallScore.getMaximumScore());
                studentRelativeScore.setTotalScore(examOverallScore.getTotalScore());
                        
                StudentRawScore studentRawScore = 
                        dao.getStudentRawScoresByStudentIdAndExamId(studentId, examOverallScore.getExamId());
                studentRelativeScore.setScore(studentRawScore.getScore());
                
                List<Integer> allScores = 
                        dao.getAllScoresByExamId(examOverallScore.getExamId());
                double percentile = percentileService.getPercentile(studentRawScore.getScore(), allScores);
                studentRelativeScore.setPercentile(percentile);   
                
                studentRelativeScores.add(studentRelativeScore);
            }
            
            return studentRelativeScores;
        }
        finally{
            if(dao != null)
                dao.closeConnection();
        }        
    }
    
    public List<StudentPercentageScore> getStudentPercentageExamScoresBySubjectAndYearGroup(
            String studentId, String subjectId, String yearGroupId)
            throws SQLException {
        
        ExamDao dao = new ExamDao();
        
        try{
            List<StudentPercentageScore> studentPercentageScores = new ArrayList<>();
            
            List<ExamOverallScore> examOverallScores = 
                    dao.getExamOverallScoresBySubjectAndYearGroup(subjectId, yearGroupId);
            
            // Calculate percentile for each exam for this student
            for(ExamOverallScore examOverallScore : examOverallScores){
                
                StudentRawScore studentRawScore = 
                        dao.getStudentRawScoresByStudentIdAndExamId(studentId, examOverallScore.getExamId());
                
                StudentPercentageScore studentPercentageScore = new StudentPercentageScore();
                studentPercentageScore.setExamId(examOverallScore.getExamId());
                studentPercentageScore.setExamDescription(examOverallScore.getExamDescription());
                studentPercentageScore.setStudentId(studentId);
                studentPercentageScore.setPercentageScore(
                        calculatePercentage(studentRawScore.getScore(), examOverallScore.getTotalScore()));
                studentPercentageScore.setPercentageAvgScore(
                        calculatePercentage(examOverallScore.getAverageScore(), examOverallScore.getTotalScore()));
                studentPercentageScore.setPercentageMaxScore(
                        calculatePercentage(examOverallScore.getMaximumScore(),examOverallScore.getTotalScore()));
 
                
                studentPercentageScores.add(studentPercentageScore);
            }
            
            return studentPercentageScores;
        }
        finally{
            if(dao != null)
                dao.closeConnection();
        }        
    }
    
    private int calculatePercentage(int score, int totalScore){
        return (score *100/totalScore);
    }
}

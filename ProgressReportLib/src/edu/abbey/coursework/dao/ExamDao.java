/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework.dao;

import edu.abbey.coursework.model.StudentRawScore;
import edu.abbey.coursework.model.ExamOverallScore;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Avani Dwivedi
 */
public class ExamDao extends BaseDao {
    
    public ExamDao() throws SQLException {
        super();
    }
    

    public List<ExamOverallScore> getExamOverallScoresBySubjectAndYearGroup(
            String subjectId, String yearGroupId)
            throws SQLException {
        try{
            String query = "SELECT e.exam_id, e.exam_date , e.description, e.total_score,\n" +
                "FLOOR(AVG(ses.student_score)) AS average_score, MAX(ses.student_score) maximum_score\n" +
                "FROM student_exam_scores ses\n" +
                "INNER JOIN exams e\n" +
                "ON e.exam_id = ses.exam_id\n" +
                "WHERE e.subject_id = ? AND e.year_group_id = ? \n" +
                "GROUP BY e.exam_id, e.exam_date , e.description, e.total_score\n" +
                "ORDER BY e.exam_date ASC;";
            
            PreparedStatement statement = dbConnection.prepareStatement(query);
            
            statement.setString(1,subjectId);
            statement.setString(2,yearGroupId);
            
            ResultSet resultSet = statement.executeQuery();
            List<ExamOverallScore> examOverallScores = new ArrayList<>();
            
            while(resultSet.next()){
                ExamOverallScore examOverallScore = new ExamOverallScore();
                examOverallScore.setExamId(resultSet.getInt("exam_id"));
                examOverallScore.setExamDate(resultSet.getString("exam_date"));
                examOverallScore.setExamDescription(resultSet.getString("description"));
                examOverallScore.setTotalScore(resultSet.getInt("total_score"));
                examOverallScore.setAverageScore(resultSet.getInt("average_score"));
                examOverallScore.setMaximumScore(resultSet.getInt("maximum_score"));
                examOverallScores.add(examOverallScore);
            }
            
            return examOverallScores;
        }
        catch(SQLException ex){
            logSQLError(ex);
            throw ex;
        }        
    }
    
        public StudentRawScore getStudentRawScoresByStudentIdAndExamId(
                String studentId, int examId)
        throws SQLException {
        try{
            String query = "SELECT student_id, student_score FROM student_exam_scores\n" +
            "WHERE exam_id = ? and student_id = ?; ";
            
            PreparedStatement statement = dbConnection.prepareStatement(query);
            statement.setInt(1,examId);
            statement.setString(2,studentId);
            ResultSet resultSet = statement.executeQuery();
            
            resultSet.next();
            StudentRawScore studentScore = new StudentRawScore();
            studentScore.setExamId(examId);
            studentScore.setStudentId(resultSet.getString("student_id"));
            studentScore.setScore(resultSet.getInt("student_score"));
            
            return studentScore;
        }
        catch(SQLException ex){
            logSQLError(ex);
            throw ex;
        }          
    }

    public List<StudentRawScore> getStudentRawScoresByExamId(int examId)
        throws SQLException {
        try{
            String query = "SELECT student_id, student_score FROM student_exam_scores\n" +
                    "WHERE exam_id = ? ORDER BY student_score ASC";
            
            PreparedStatement statement = dbConnection.prepareStatement(query);
            statement.setInt(1,examId);
            ResultSet resultSet = statement.executeQuery();
            List<StudentRawScore> studentScores = new ArrayList<>();
            
            while(resultSet.next()){
                StudentRawScore studentScore = new StudentRawScore();
                studentScore.setExamId(examId);
                studentScore.setStudentId(resultSet.getString("student_id"));
                studentScore.setScore(resultSet.getInt("student_score"));
                studentScores.add(studentScore);
            }
            
            return studentScores;
        }
        catch(SQLException ex){
            logSQLError(ex);
            throw ex;
        }          
    }
    
    public List<Integer> getAllScoresByExamId(int examId)
        throws SQLException {
        try{
            String query = "SELECT student_score FROM student_exam_scores\n" +
                    "WHERE exam_id = ? ORDER BY student_score ASC";
            
            PreparedStatement statement = dbConnection.prepareStatement(query);
            statement.setInt(1,examId);
            ResultSet resultSet = statement.executeQuery();
            List<Integer> allScores = new ArrayList<>();
            
            while(resultSet.next()){
                allScores.add(resultSet.getInt("student_score"));
            }
            
            return allScores;
        }
        catch(SQLException ex){
            logSQLError(ex);
            throw ex;
        }          
    }
}

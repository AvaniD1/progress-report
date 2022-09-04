/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import edu.abbey.coursework.model.StudentPercentageScore;
import edu.abbey.coursework.service.ExamService;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Avani Dwivedi
 */
public class ProgressGraphGenerator {
    
    private ExamService examService = new ExamService();   
    
    public void generateGraphs(Stage primaryStage, 
                                String yearGroupId,
                                String studentId, 
                                String subjectId){
        try{
            
            Stage stage = new Stage();
            stage.setTitle("Progress Report Chart");
            final NumberAxis yAxis = new NumberAxis();
            final CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Exams");
            yAxis.setLabel("% Score");
            yAxis.setForceZeroInRange(false);
            final LineChart<String,Number> lineChart = 
                    new LineChart<String,Number>(xAxis,yAxis);

            String studentName = studentId;
            String year = yearGroupId;
            String subject = subjectId;
            lineChart.setTitle(String.format("Student: %s\nYear: %s\t\tSubject: %s",studentName,year,subject));

            XYChart.Series yourScore = new XYChart.Series();
            yourScore.setName("Your % Score");

            XYChart.Series avgScore = new XYChart.Series();
            avgScore.setName("Class Average % Score");
        
            XYChart.Series maxScore = new XYChart.Series();
            maxScore.setName("Class Maximum % Score");
        
            List<StudentPercentageScore> studentPercentageScores = 
                examService.getStudentPercentageExamScoresBySubjectAndYearGroup(studentId, subjectId, yearGroupId);
            
            for(StudentPercentageScore studentPercentageScore : studentPercentageScores){
                yourScore.getData().add(new XYChart.Data(
                    studentPercentageScore.getExamDescription(),
                    studentPercentageScore.getPercentageScore()));
                
                avgScore.getData().add(new XYChart.Data(
                    studentPercentageScore.getExamDescription(),
                    studentPercentageScore.getPercentageAvgScore()));

                maxScore.getData().add(new XYChart.Data(
                    studentPercentageScore.getExamDescription(),
                    studentPercentageScore.getPercentageMaxScore()));                
            }
            
            Scene scene  = new Scene(lineChart);       
            lineChart.getData().addAll(yourScore, avgScore, maxScore);

            stage.setScene(scene);
            stage.sizeToScene();
            stage.initOwner(primaryStage);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR,
                           ex.getMessage());
            alert.showAndWait();
            
        }
        
    }
    
}

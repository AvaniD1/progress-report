/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import edu.abbey.coursework.model.StudentRelativeScore;
import edu.abbey.coursework.service.ExamService;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Avani Dwivedi
 */
public class RelativeScoresTableGenerator {
    
    private ExamService examService = new ExamService();   
    private TableView<StudentRelativeScore> relativeScoresTable = new TableView<StudentRelativeScore>();
    
    public void generateTable(Stage primaryStage, 
                                String yearGroupId,
                                String studentId, 
                                String subjectId){
        
        try{
            Scene scene = new Scene(new Group());
            Stage stage = new Stage();
            stage.setTitle("Absolute Report");
            stage.sizeToScene();

            String StudentName = studentId;
            String YearGroup = yearGroupId;
            String Subject= subjectId;

            final Label label = new Label(String.format("Student Name: %s\nYear Group:%s\t\tSubject:%s", StudentName, YearGroup, Subject));
            label.setFont(new Font("Arial", 20));

            relativeScoresTable.setEditable(true);

            TableColumn examCol = new TableColumn("Exam");
            examCol.setMinWidth(100);
            examCol.setCellValueFactory(new PropertyValueFactory<StudentRelativeScore, String>("examDescription"));

            TableColumn examdateCol = new TableColumn("Exam Date");
            examdateCol.setMinWidth(100);
            examdateCol.setCellValueFactory(new PropertyValueFactory<StudentRelativeScore, String>("examDate"));

            TableColumn totalCol = new TableColumn("Total");
            totalCol.setMinWidth(200);
            totalCol.setCellValueFactory(new PropertyValueFactory<StudentRelativeScore, Integer>("totalScore"));

            TableColumn maxCol = new TableColumn("Max score");
            maxCol.setMinWidth(200);
            maxCol.setCellValueFactory(new PropertyValueFactory<StudentRelativeScore, String>("maximumScore"));

            TableColumn avgCol = new TableColumn("Average score");
            avgCol.setMinWidth(200);
            avgCol.setCellValueFactory(new PropertyValueFactory<StudentRelativeScore, String>("averageScore"));

            TableColumn yourCol = new TableColumn("Student Score");
            yourCol.setMinWidth(200);
            yourCol.setCellValueFactory(new PropertyValueFactory<StudentRelativeScore, String>("score"));

            TableColumn percentileCol = new TableColumn("Percentile");
            percentileCol.setMinWidth(200);
            percentileCol.setCellValueFactory(new PropertyValueFactory<StudentRelativeScore, String>("percentile"));

            List<StudentRelativeScore> studentRelativeScores = 
                    examService.getStudentExamScoresBySubjectAndYearGroup(studentId, subjectId, yearGroupId);
            ObservableList<StudentRelativeScore> data =
            FXCollections.observableArrayList(studentRelativeScores);
            
            relativeScoresTable.setItems(data);
            relativeScoresTable.getColumns().addAll(examCol, examdateCol, totalCol, maxCol, avgCol, yourCol, percentileCol);

            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(label, relativeScoresTable);

            ((Group) scene.getRoot()).getChildren().addAll(vbox);

            stage.setScene(scene);
            stage.initOwner(primaryStage);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();  
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR,ex.getMessage());
            alert.showAndWait();
        }
        
    }
    
}

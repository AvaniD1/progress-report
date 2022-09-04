/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import edu.abbey.coursework.model.Student;
import edu.abbey.coursework.model.YearGroup;
import edu.abbey.coursework.service.YearGroupService;
import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
/**
 *
 * @author Avani Dwivedi
 */
public class ReportSelector {
    
              
    public void start(Stage primaryStage, SelectedData selectedData) {
        
        try{
            Stage stage = new Stage();
            
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(50, 50, 50, 50));

            Label yearGroupLabel = new Label("Year Group Id:");
            grid.add(yearGroupLabel, 0, 0);
            
            Label selectedYearGroup = new Label(selectedData.getYearGroupId());
            grid.add(selectedYearGroup, 1, 0);
            
            Label studentLabel = new Label("Student Id:");
            grid.add(studentLabel, 0, 1);
            
            Label selectedStudent = new Label(selectedData.getStudentId());
            grid.add(selectedStudent, 1, 1);
            
            Label subjectLabel = new Label("Subject Id:");
            grid.add(subjectLabel, 0, 2);
            
            Label selectedSubject = new Label(selectedData.getSubjectId());
            grid.add(selectedSubject, 1, 2);

            Button showGraphBtn = new Button("Show Percentage Graphs");
            HBox hbBtnGraphs = new HBox(10);
            hbBtnGraphs.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtnGraphs.getChildren().add(showGraphBtn);
            grid.add(hbBtnGraphs, 1, 5);

            Button showTableBtn = new Button("Show Absolute scores Table");
            HBox hbBtnTable = new HBox(10);
            hbBtnTable.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtnTable.getChildren().add(showTableBtn);
            grid.add(hbBtnTable, 0, 5);

            showGraphBtn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {

                    ProgressGraphGenerator generator = 
                            new ProgressGraphGenerator();
                    generator.generateGraphs(primaryStage, 
                            selectedData.getYearGroupId(), 
                            selectedData.getStudentId(), 
                            selectedData.getSubjectId());

                }
            });

            showTableBtn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    RelativeScoresTableGenerator generator = 
                            new RelativeScoresTableGenerator();
                    generator.generateTable(primaryStage, 
                            selectedData.getYearGroupId(), 
                            selectedData.getStudentId(), 
                            selectedData.getSubjectId());
                }
            });

            Scene scene = new Scene(grid);

            stage.setScene(scene);
            stage.sizeToScene();
            stage.initOwner(primaryStage);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait(); 
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.showAndWait();
       }
    }
    
}

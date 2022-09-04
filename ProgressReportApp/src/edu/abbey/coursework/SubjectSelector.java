/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import edu.abbey.coursework.model.Student;
import edu.abbey.coursework.model.Subject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Avani Dwivedi
 */
public class SubjectSelector {
    
    private StudentDataPopulater studentDataPopulater = new StudentDataPopulater();
    
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
            
            Text scenetitle = new Text("Select Subject");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
            grid.add(scenetitle, 0, 2, 4, 1);

            Label studentIdLabel = new Label("Subject Id:");
            grid.add(studentIdLabel, 0, 3);

            ComboBox<Subject> subjectCtl = new ComboBox();
            subjectCtl.setEditable(false);
            studentDataPopulater.populateSubjects(subjectCtl, selectedData);
            grid.add(subjectCtl, 1, 3);

            Button cancelBtn = new Button("Cancel");
            HBox hbBtnCancel = new HBox(10);
            hbBtnCancel.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtnCancel.getChildren().add(cancelBtn);
            grid.add(hbBtnCancel, 0, 5);

            Button nextBtn = new Button("Next");
            HBox hbBtnNext = new HBox(10);
            hbBtnNext.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtnNext.getChildren().add(nextBtn);
            grid.add(hbBtnNext, 1, 5);

            cancelBtn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    stage.close();
                }
            });

            nextBtn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    ReportSelector reportSelector = new ReportSelector();
                    reportSelector.start(primaryStage, selectedData);
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

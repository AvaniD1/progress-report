/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import edu.abbey.coursework.model.Student;
import edu.abbey.coursework.model.YearGroup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Avani Dwivedi
 */
public class YearGroupSelector {
    private YearGroupDataPopulater yearGroupDataPopulater = new YearGroupDataPopulater();
    
    public void start(Stage primaryStage) {
        
        try{
            SelectedData selectedData = new SelectedData();

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(50, 50, 50, 50));

            Text scenetitle = new Text("Select Year Group");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
            grid.add(scenetitle, 0, 0, 4, 1);

            Label yearGroupLabel = new Label("Year Group Id:");
            grid.add(yearGroupLabel, 0, 1);

            ComboBox<YearGroup> yearGroupCtl = new ComboBox();
            yearGroupCtl.setEditable(false);
            yearGroupDataPopulater.populate(yearGroupCtl, selectedData);
            grid.add(yearGroupCtl,1,1);

            
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
                    primaryStage.close();
                }
            });

            nextBtn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                   StudentSelector studentSelector = new StudentSelector();
                   studentSelector.start(primaryStage, selectedData);
                }
            });

            Scene scene = new Scene(grid);

            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.showAndWait();
       }
    }    
}

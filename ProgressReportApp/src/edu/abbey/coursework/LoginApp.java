/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import edu.abbey.coursework.model.AccountType;
import edu.abbey.coursework.model.Credentials;
import edu.abbey.coursework.service.Login;
import edu.abbey.coursework.service.LoginFactory;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Avani Dwivedi
 * Use following for testing
 * username: teacher001
 * year group: lower six
 * student: test3
 * subject: physics
 */
public class LoginApp extends Application {
    
     public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Progress Report Application");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Student Progress Report Application");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(scenetitle, 0, 0, 6, 1);

        Label accountType = new Label("AccountType:");
        grid.add(accountType, 0, 1);

        final ToggleGroup accountTypeGroup = new ToggleGroup();
        RadioButton rbAccountTypeStudent = new RadioButton("STUDENT");
        rbAccountTypeStudent.setSelected(false);
        rbAccountTypeStudent.setToggleGroup(accountTypeGroup);
        grid.add(rbAccountTypeStudent, 1, 1);
        
        RadioButton rbAccountTypeTeacher = new RadioButton("TEACHER");
        rbAccountTypeTeacher.setSelected(true);
        rbAccountTypeTeacher.setToggleGroup(accountTypeGroup);
        grid.add(rbAccountTypeTeacher, 1, 2);
        
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 3);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 3);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 4);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 4);

        Button btnLogin = new Button("Login");
        HBox hbLoginBtn = new HBox(10);
        hbLoginBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbLoginBtn.getChildren().add(btnLogin);
        grid.add(hbLoginBtn, 1, 6);

        Button btnCancel = new Button("Cancel");
        HBox hbCancelBtn = new HBox(10);
        hbCancelBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbCancelBtn.getChildren().add(btnCancel);
        grid.add(hbCancelBtn, 0, 6);
        
        //final Text actiontarget = new Text();
        //grid.add(actiontarget, 1, 6);

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                
                LoginController loginController = new LoginController();
                loginController.login(primaryStage, 
                        userTextField.getText(), 
                        pwBox.getText());
            }
        });
        
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                primaryStage.close();
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}

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
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Avani Dwivedi
 */
public class LoginController {
    
    public void login(Stage primaryStage, String userName, String password){
        try{
            LoginFactory loginFactory = new LoginFactory();
            Login login = loginFactory.create(AccountType.TEACHER);
            Credentials credentials = new Credentials();
            credentials.setUsername(userName);
            credentials.setPassword(password);
            login.login(credentials); 
            
            primaryStage.hide();
            
            // Start the main flow after successful login
            YearGroupSelector yearGroupSelector = new YearGroupSelector();
            yearGroupSelector.start(primaryStage);
                    
       }
       catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR,
                           ex.getMessage());
            alert.showAndWait();
       }       
    }
    
}

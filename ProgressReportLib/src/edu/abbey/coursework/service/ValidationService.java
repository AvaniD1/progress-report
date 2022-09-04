/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework.service;

import java.util.regex.Pattern;

/**
 *
 * @author Avani Dwivedi
 */
public class ValidationService {
    
    private static String EMAIL_REGEX_PATTERN = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    
    private Pattern emailValidationPattern;
    
    public ValidationService(){
        emailValidationPattern = Pattern.compile(EMAIL_REGEX_PATTERN);
    }
    
    
    public boolean isEmailAddressValid(String emailAddress){
        if(emailValidationPattern.matcher(emailAddress).matches()){
            return true;
        }
        
        return false;
    }

    public boolean validatePassword(String password){
        return true;
        
    }
}


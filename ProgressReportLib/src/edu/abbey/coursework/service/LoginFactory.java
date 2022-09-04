package edu.abbey.coursework.service;

import edu.abbey.coursework.model.AccountType;

public class LoginFactory {
    public Login create(AccountType accountType){
        if(accountType.equals(AccountType.STUDENT)){
            return new StudentLogin();
        }
        else {
            return new TeacherLogin();
        }
    }
}

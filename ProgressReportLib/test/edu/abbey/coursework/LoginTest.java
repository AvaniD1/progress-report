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
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.security.sasl.AuthenticationException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Avani Dwivedi
 */
public class LoginTest {
    
    private static LoginFactory loginFactory = null;
    
    @BeforeClass
    public static void setUp() {
        loginFactory = new LoginFactory();
    }
    
    @Test
    public void testSuccessfulStudentLogin() 
            throws NoSuchAlgorithmException, AuthenticationException, SQLException {
        Login login = loginFactory.create(AccountType.STUDENT);
        Credentials credentials = new Credentials();
        credentials.setUsername("student001");
        credentials.setPassword("testreport123"); // right password
        login.login(credentials);
    }
    
    @Test
    public void testFailedStudentLogin() 
            throws NoSuchAlgorithmException, AuthenticationException, SQLException {
        Login login = loginFactory.create(AccountType.STUDENT);
        Credentials credentials = new Credentials();
        credentials.setUsername("student001");
        credentials.setPassword("testreport1234"); // wrong password 
        try{
            login.login(credentials);
        }
        catch(AuthenticationException ex){
            assertNotNull(ex);
        }        
    }

    @Test
    public void testSuccessfulTeacherLogin() 
            throws NoSuchAlgorithmException, AuthenticationException, SQLException {
        Login login = loginFactory.create(AccountType.TEACHER);
        Credentials credentials = new Credentials();
        credentials.setUsername("teacher001");
        credentials.setPassword("testreport321"); // right password
        login.login(credentials);
    }
    
    @Test
    public void testFailedTeacherLogin() 
            throws NoSuchAlgorithmException, AuthenticationException, SQLException {
        Login login = loginFactory.create(AccountType.TEACHER);
        Credentials credentials = new Credentials();
        credentials.setUsername("teacher001");
        credentials.setPassword("testreport3210"); // wrong password 
        try{
            login.login(credentials);
        }
        catch(AuthenticationException ex){
            assertNotNull(ex);
        }        
    }

}

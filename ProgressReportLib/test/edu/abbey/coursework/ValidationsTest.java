/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import edu.abbey.coursework.service.ValidationService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Avani Dwivedi
 */
public class ValidationsTest {
    
    private ValidationService validationService = new ValidationService();
    

   @Test
   public void testEmailValidation(){
       // Test Valid Email addresses
       assertTrue(validationService.isEmailAddressValid("test.user@domain.com"));
       assertTrue(validationService.isEmailAddressValid("test.user@domain.co.uk"));
       assertTrue(validationService.isEmailAddressValid("test_!#$%&'user@domain.co.uk"));
       assertTrue(validationService.isEmailAddressValid("test.user@dk"));
   
       // Test invalid email addresses
       assertFalse(validationService.isEmailAddressValid("somewhere.com"));
       assertFalse(validationService.isEmailAddressValid("someone"));
       assertFalse(validationService.isEmailAddressValid("@somewhere.com"));
       assertFalse(validationService.isEmailAddressValid("useratyahoo.com"));
       assertFalse(validationService.isEmailAddressValid("somewhere.com"));
       assertFalse(validationService.isEmailAddressValid("someone"));
       assertFalse(validationService.isEmailAddressValid("test£user@domain.co.uk"));
   }
}

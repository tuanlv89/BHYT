/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoanganhtuan
 */
public class LoginViewTest {
    
    public LoginViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInputGreaterThanLimitCaseTrue() {
        String input = "abcaaaaaaaaaaaabcaaaaaaaaaaaabcaaaaaaaaaaa";
        
        view.LoginView instance = new view.LoginView();
        boolean expResult = true;
        boolean result = instance.isInputGreaterThanLimit(input);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInputGreaterThanLimitCaseFalse() {
        String input = "abcd";
        
        view.LoginView instance = new view.LoginView();
        boolean expResult = false;
        boolean result = instance.isInputGreaterThanLimit(input);
        
        assertEquals(expResult, result);
    }
}

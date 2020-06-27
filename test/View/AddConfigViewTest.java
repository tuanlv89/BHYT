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
public class AddConfigViewTest {
    view.AddConfigView instance;
    
    public AddConfigViewTest() {
        instance = new view.AddConfigView();
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
    public void testIsTeenagerAge() {
        int age = 10;
        
        boolean expResult = true;
        boolean result = instance.isTeenagerAge(age);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsNoteTeenAge() {
        int age = 20;
        
        boolean expResult = false;
        boolean result = instance.isTeenagerAge(age);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidPercentCaseTrue() {
        double percent = 40.0;
        
        boolean expResult = true;
        boolean result = instance.isValidPercentage(percent);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidPercentCaseFalse() {
        double percent = 101.0;
        
        boolean expResult = false;
        boolean result = instance.isValidPercentage(percent);
        assertEquals(expResult, result);
    }
}

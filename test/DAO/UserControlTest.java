/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.User;
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
public class UserControlTest {
    
    public UserControlTest() {
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
    public void testCheckUserCaseTrue() throws ParseException {
        System.out.println("check User");
        String username = "tuanlv";
        String password = "1412";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = dateFormat.parse("19981214");
        
        UserControl instance = new UserControl();
        User result = instance.checkUser(username, password);
        User expResult = new User("BN01", "Lê Văn Tuấn", 22, "Sinh viên", "Hà Đông, Hà Nội", "Hà Đông, Hà Nội", date, "Kinh", false, false, "Bạch Mai, Hà Nội", "BH2020", "tuanlv", "1412", 1, 1);
        
        assertEquals(result.getId(), expResult.getId());
        assertEquals(result.getName(), expResult.getName());
        assertEquals(result.getAge(), expResult.getAge());
        assertEquals(result.getJob(), expResult.getJob());
        assertEquals(result.getAddress(), expResult.getAddress());
        assertEquals(result.getHometown(), expResult.getHometown());
        assertEquals(result.getNation(), expResult.getNation());
        assertEquals(result.getBhytID(), expResult.getBhytID());
        assertEquals(result.getBhytRegisterPlace(), expResult.getBhytRegisterPlace());
        assertEquals(result.getTuyenDK(), expResult.getTuyenDK());
        assertEquals(result.getRole(), expResult.getRole());
        assertEquals(result.getDob(), expResult.getDob());
    }
    
    @Test
    public void testCheckUserCaseFalse() {
        System.out.println("check User");
        String username = "LeVT";
        String password = "khongcopass";
        
        UserControl instance = new UserControl();
        User result = instance.checkUser(username, password);
        User expResult = new User();
        assertEquals(result.getId(), expResult.getId());
        assertEquals(result.getName(), expResult.getName());
        assertEquals(result.getAge(), expResult.getAge());
        assertEquals(result.getJob(), expResult.getJob());
        assertEquals(result.getAddress(), expResult.getAddress());
        assertEquals(result.getHometown(), expResult.getHometown());
        assertEquals(result.getNation(), expResult.getNation());
        assertEquals(result.getBhytID(), expResult.getBhytID());
        assertEquals(result.getBhytRegisterPlace(), expResult.getBhytRegisterPlace());
        assertEquals(result.getTuyenDK(), expResult.getTuyenDK());
        assertEquals(result.getRole(), expResult.getRole());
        assertEquals(result.getDob(), expResult.getDob());
    }
}

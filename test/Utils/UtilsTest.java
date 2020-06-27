/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import DAO.ConfigControl;
import model.Config;
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
public class UtilsTest {
    
    Config currentConfig;
    
    public UtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ConfigControl configControl = new ConfigControl();
        currentConfig = configControl.getCurrentConfig();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetChiPhiDungTuyen1() {
        int tuoi = 2;
        int tuyen = 3;
        boolean hoNgheo = true;
        boolean thanNhanLS = true;
        String danToc = "Kinh";
        
        double expResult = currentConfig.getQuyenLoiDungTuyen1();
        double result = Utils.ChiPhiDungTuyen(tuoi, tuyen, hoNgheo, thanNhanLS, danToc);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetChiPhiDungTuyen2() {
        int tuoi = 2;
        int tuyen = 4;
        boolean hoNgheo = true;
        boolean thanNhanLS = true;
        String danToc = "Kinh";
        
        double expResult = currentConfig.getQuyenLoiDungTuyen1();
        double result = Utils.ChiPhiDungTuyen(tuoi, tuyen, hoNgheo, thanNhanLS, danToc);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetChiPhiDungTuyen3() {
        int tuoi = 20;
        int tuyen = 4;
        boolean hoNgheo = true;
        boolean thanNhanLS = true;
        String danToc = "Kinh";
        
        double expResult = currentConfig.getQuyenLoiDungTuyen1();
        double result = Utils.ChiPhiDungTuyen(tuoi, tuyen, hoNgheo, thanNhanLS, danToc);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetChiPhiDungTuyen4() {
        int tuoi = 20;
        int tuyen = 3;
        boolean hoNgheo = false;
        String danToc = "Kinh";
        boolean thanNhanLS = true;
        
        double expResult = currentConfig.getQuyenLoiDungTuyen2();
        double result = Utils.ChiPhiDungTuyen(tuoi, tuyen, hoNgheo, thanNhanLS, danToc);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetChiPhiDungTuyen5() {
        int tuoi = 20;
        int tuyen = 3;
        boolean hoNgheo = false;
        String danToc = "Tay";
        boolean thanNhanLS = false;
        
        double expResult = currentConfig.getQuyenLoiDungTuyen2();
        double result = Utils.ChiPhiDungTuyen(tuoi, tuyen, hoNgheo, thanNhanLS, danToc);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetChiPhiDungTuyen6() {
        int tuoi = 20;
        int tuyen = 3;
        boolean hoNgheo = false;
        String danToc = "Tay";
        boolean thanNhanLS = true;
        
        double expResult = currentConfig.getQuyenLoiDungTuyen2();
        double result = Utils.ChiPhiDungTuyen(tuoi, tuyen, hoNgheo, thanNhanLS, danToc);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetChiPhiDungTuyen7() {
        int tuoi = 20;
        int tuyen = 3;
        boolean hoNgheo = true;
        String danToc = "Kinh";
        boolean thanNhanLS = false;
        
        double expResult = currentConfig.getQuyenLoiDungTuyen2();
        double result = Utils.ChiPhiDungTuyen(tuoi, tuyen, hoNgheo, thanNhanLS, danToc);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetChiPhiDungTuyen8() {
        int tuoi = 20;
        int tuyen = 3;
        boolean hoNgheo = true;
        String danToc = "Kinh";
        boolean thanNhanLS = true;
        
        double expResult = currentConfig.getQuyenLoiDungTuyen2();
        double result = Utils.ChiPhiDungTuyen(tuoi, tuyen, hoNgheo, thanNhanLS, danToc);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetChiPhiDungTuyen9() {
        int tuoi = 20;
        int tuyen = 3;
        boolean hoNgheo = true;
        String danToc = "Tay";
        boolean thanNhanLS = false;
        
        double expResult = currentConfig.getQuyenLoiDungTuyen2();
        double result = Utils.ChiPhiDungTuyen(tuoi, tuyen, hoNgheo, thanNhanLS, danToc);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetChiPhiDungTuyen10() {
        int tuoi = 20;
        int tuyen = 3;
        boolean hoNgheo = true;
        String danToc = "Tay";
        boolean thanNhanLS = true;
        
        double expResult = currentConfig.getQuyenLoiDungTuyen2();
        double result = Utils.ChiPhiDungTuyen(tuoi, tuyen, hoNgheo, thanNhanLS, danToc);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetChiPhiDungTuyen11() {
        int tuoi = 20;
        int tuyen = 3;
        boolean hoNgheo = false;
        String danToc = "Kinh";
        boolean thanNhanLS = false;
        
        double expResult = currentConfig.getQuyenLoiDungTuyen3();
        double result = Utils.ChiPhiDungTuyen(tuoi, tuyen, hoNgheo, thanNhanLS, danToc);
        assertEquals(expResult, result, 0.0);
    }
}

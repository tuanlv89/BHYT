/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ConfigControl;
import Utils.Utils;
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
public class HospitalSearchViewTest {
    
    Config currentConfig;
    view.HospitalSearchView instance;
    
    public HospitalSearchViewTest() {
        ConfigControl configControl = new ConfigControl();
        currentConfig = configControl.getCurrentConfig();
        instance = new view.HospitalSearchView();
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
    public void testCorrectRoute() { // Dung tuyen
        int tuoi = 5;
        String danToc = "Kinh";
        boolean thanNhanLietSi = true;
        boolean hoNgheo = false;
        int tuyenDK = Utils.TUYEN_TINH;
        int tuyenBV = Utils.TUYEN_TINH;
        
        double expResult = Utils.ChiPhiDungTuyen(tuoi, tuyenDK, hoNgheo, thanNhanLietSi, danToc);
        double result = instance.getVienPhiMienGiam(tuoi, danToc, thanNhanLietSi, hoNgheo, tuyenDK, tuyenBV);
        
        assertEquals(expResult, result, result);
    }
    
    @Test
    public void testTraiTuyenTrungUong() { // trai tuyen trung uong
        int tuoi = 5;
        String danToc = "Kinh";
        boolean thanNhanLietSi = true;
        boolean hoNgheo = false;
        int tuyenDK = Utils.TUYEN_TINH;
        int tuyenBV = Utils.TUYEN_TRUNG_UONG;
        
        double expResult = currentConfig.getTraiTuyenTuyenTrungUong();
        double result = instance.getVienPhiMienGiam(tuoi, danToc, thanNhanLietSi, hoNgheo, tuyenDK, tuyenBV);
        
        assertEquals(expResult, result, result);
    }
    
    @Test
    public void testTraiTuyenTuyenTinh() { // trai tuyen tuyen tinh
        int tuoi = 5;
        String danToc = "Kinh";
        boolean thanNhanLietSi = true;
        boolean hoNgheo = false;
        int tuyenDK = Utils.TUYEN_HUYEN;
        int tuyenBV = Utils.TUYEN_TINH;
        
        double expResult = currentConfig.getTraiTuyenTuyenTinh();
        double result = instance.getVienPhiMienGiam(tuoi, danToc, thanNhanLietSi, hoNgheo, tuyenDK, tuyenBV);
        
        assertEquals(expResult, result, result);
    }
    
    @Test
    public void testTraiTuyenTuyenHuyen() { // trai tuyen tuyen huyen
        int tuoi = 5;
        String danToc = "Kinh";
        boolean thanNhanLietSi = true;
        boolean hoNgheo = false;
        int tuyenDK = Utils.TUYEN_TINH;
        int tuyenBV = Utils.TUYEN_HUYEN;
        
        double expResult = currentConfig.getTraiTuyenTuyenHuyen();
        double result = instance.getVienPhiMienGiam(tuoi, danToc, thanNhanLietSi, hoNgheo, tuyenDK, tuyenBV);
        
        assertEquals(expResult, result, result);
    }
    
    @Test
    public void testTraiTuyenTuyenHuyenCaseFalse() { // trai tuyen tuyen huyen
        int tuoi = 5;
        String danToc = "Kinh";
        boolean thanNhanLietSi = true;
        boolean hoNgheo = false;
        int tuyenDK = Utils.TUYEN_TINH;
        int tuyenBV = 5;
        
        double expResult = 0.0;
        double result = instance.getVienPhiMienGiam(tuoi, danToc, thanNhanLietSi, hoNgheo, tuyenDK, tuyenBV);
        
        assertEquals(expResult, result, result);
    }
}

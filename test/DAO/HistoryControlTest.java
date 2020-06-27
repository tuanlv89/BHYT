/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.MedicalHistory;
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
public class HistoryControlTest {
    
    public HistoryControlTest() {
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
    public void testGetAllHistoryById() throws ParseException {
        HistoryControl instance = new HistoryControl();
        String userId = "BN01";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        ArrayList<MedicalHistory> expResult = new ArrayList();
        Date date1 = dateFormat.parse("20190206163020");
        MedicalHistory mh1 = new MedicalHistory("HTR01", "Lê Văn Tuấn", "Trần Minh An", "Bệnh viện Bạch Mai", "Bạch Mai, Hà Nội", date1, "Viêm dạ dày", true, 1000000, 200000);

        Date date2 = dateFormat.parse("20200325102015");
        MedicalHistory mh2 = new MedicalHistory("HTR02", "Lê Văn Tuấn", "Nguyễn Trung Hiếu", "Bệnh viện Việt Đức", "Việt Đức, Hà Nội", date2, "Đau răng", true, 1500000, 750000);
        expResult.add(mh1);
        expResult.add(mh2);

        ArrayList<MedicalHistory> result = new ArrayList();
        result = instance.getAllHistoryById(userId);

        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getId(), result.get(i).getId());
            assertEquals(expResult.get(i).getPatientName(), result.get(i).getPatientName());
            assertEquals(expResult.get(i).getDoctorName(), result.get(i).getDoctorName());
            assertEquals(expResult.get(i).getHospitalName(), result.get(i).getHospitalName());
            assertEquals(expResult.get(i).getHospitalAddress(), result.get(i).getHospitalAddress());
            assertEquals(expResult.get(i).getDiseaseName(), result.get(i).getDiseaseName());
            assertEquals(expResult.get(i).getIsDungTuyen(), result.get(i).getIsDungTuyen());
            assertEquals(expResult.get(i).getTotalMoney(), result.get(i).getTotalMoney(), 0.0);
            assertEquals(expResult.get(i).getPayMoney(), result.get(i).getPayMoney(), 0.0);
        }
    }
    
    @Test
    public void testGetAllHistoryByIdCaseEmpty() {
        String userId = "20";
        HistoryControl instance = new HistoryControl();
        DBConection conection = new DBConection();
        Connection conn = conection.getConnection();
        String sql = "Select * FROM history WHERE idUser = '" + userId + "';";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                ArrayList<MedicalHistory> expResult = new ArrayList<>();
                ArrayList<MedicalHistory> result = instance.getAllHistoryById(userId);
                assertEquals(expResult, result);
            }
            conn.close();
            
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
    }
    
    @Test
    public void testGetAllHistory() throws ParseException {
        HistoryControl instance = new HistoryControl();
        String userId = "BN01";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        ArrayList<MedicalHistory> expResult = new ArrayList();
        Date date1 = dateFormat.parse("20190206163020");
        MedicalHistory mh1 = new MedicalHistory("HTR01", "Lê Văn Tuấn", "Trần Minh An", "Bệnh viện Bạch Mai", "Bạch Mai, Hà Nội", date1, "Viêm dạ dày", true, 1000000, 200000);

        Date date2 = dateFormat.parse("20200325102015");
        MedicalHistory mh2 = new MedicalHistory("HTR02", "Lê Văn Tuấn", "Nguyễn Trung Hiếu", "Bệnh viện Việt Đức", "Việt Đức, Hà Nội", date2, "Đau răng", true, 1500000, 750000);
        
        Date date3 = dateFormat.parse("20200625101015");
        MedicalHistory mh3 = new MedicalHistory("HTR03", "Nguyễn Minh An", "Nguyễn Trung Hiếu", "Bệnh viện Việt Đức", "Việt Đức, Hà Nội", date3, "Đau bụng", true, 150000, 0);
        
        expResult.add(mh1);
        expResult.add(mh2);
        expResult.add(mh3);

        ArrayList<MedicalHistory> result = new ArrayList();
        result = instance.getAllHistory();

        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getId(), result.get(i).getId());
            assertEquals(expResult.get(i).getPatientName(), result.get(i).getPatientName());
            assertEquals(expResult.get(i).getDoctorName(), result.get(i).getDoctorName());
            assertEquals(expResult.get(i).getHospitalName(), result.get(i).getHospitalName());
            assertEquals(expResult.get(i).getHospitalAddress(), result.get(i).getHospitalAddress());
            assertEquals(expResult.get(i).getDiseaseName(), result.get(i).getDiseaseName());
            assertEquals(expResult.get(i).getIsDungTuyen(), result.get(i).getIsDungTuyen());
            assertEquals(expResult.get(i).getTotalMoney(), result.get(i).getTotalMoney(), 0.0);
            assertEquals(expResult.get(i).getPayMoney(), result.get(i).getPayMoney(), 0.0);
        }
    }
    
    @Test
    public void testGetAllHistoryCaseEmpty() {
        HistoryControl instance = new HistoryControl();
        DBConection conection = new DBConection();
        Connection conn = conection.getConnection();
        
        String sql = "Select * FROM history;";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                ArrayList<MedicalHistory> expResult = new ArrayList<>();
                ArrayList<MedicalHistory> result = instance.getAllHistory();
                assertEquals(expResult, result);
            }
            conn.close();
            
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
    }
}

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
import java.util.ArrayList;
import model.Hospital;
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
public class HospitalControlTest {
    
    public HospitalControlTest() {
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
    public void testGetAllHospital() throws ParseException {
        HospitalControl instance = new HospitalControl();
       
        ArrayList<Hospital> expResult = new ArrayList();
        Hospital bv1 = new Hospital("BV01", "Bệnh viện Bạch Mai","Bạch Mai, Hà Nội", 1, "084088888");
        Hospital bv2 = new Hospital("BV02", "Bệnh viện Việt Đức", "Việt Đức, Hà Nội", 1, "069066541");
        Hospital bv3 = new Hospital("BV03", "Bệnh viện quân y 103", "Hà Đông, Hà Nội", 2, "097944151");
        Hospital bv4 = new Hospital("BV04", "Bệnh viện mắt Quốc tế", "Cầu Giấy, Hà Nội", 1, "015614614");
        
        expResult.add(bv1);
        expResult.add(bv2);
        expResult.add(bv3);
        expResult.add(bv4);

        ArrayList<Hospital> result = new ArrayList();
        result = instance.getAllHospital();

        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getId(), result.get(i).getId());
            assertEquals(expResult.get(i).getTen(), result.get(i).getTen());
            assertEquals(expResult.get(i).getDiaChi(), result.get(i).getDiaChi());
            assertEquals(expResult.get(i).getHotline(), result.get(i).getHotline());
            assertEquals(expResult.get(i).getTuyen(), result.get(i).getTuyen());     
        }
    }
    
    @Test
    public void testGetAllHospitalCaseEmpty() {
        HospitalControl instance = new HospitalControl();
        DBConection conection = new DBConection();
        Connection conn = conection.getConnection();
        String sql = "Select * FROM benhvien";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                ArrayList<Hospital> expResult = new ArrayList<>();
                ArrayList<Hospital> result = instance.getAllHospital();
                assertEquals(expResult, result);
            }
            conn.close();
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
    }
    
    @Test
    public void testGetHospitalByName() throws ParseException{
        String name="Bệnh viện Bạch Mai";
        HospitalControl instance = new HospitalControl();

        Hospital expResult = new Hospital("BV01", "Bệnh viện Bạch Mai","Bạch Mai, Hà Nội", 1, "084088888");

        ArrayList<Hospital> result = new ArrayList();
        result= instance.getHospitalByName(name);

        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.getId(), result.get(i).getId());
            assertEquals(expResult.getTen(), result.get(i).getTen());
            assertEquals(expResult.getDiaChi(), result.get(i).getDiaChi());
            assertEquals(expResult.getHotline(), result.get(i).getHotline());
            assertEquals(expResult.getTuyen(), result.get(i).getTuyen());    
        }
    }
    
    @Test
    public void testGetHospitalByNameCaseEmpty() {
        HospitalControl instance = new HospitalControl();
        String name = "Vinmec";
        
        ArrayList<Hospital> expResult = new ArrayList<>();
        ArrayList<Hospital>  result = instance.getHospitalByName(name);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetHospitalByAddress() throws ParseException{
        String diaChi = "Hà Nội";
        HospitalControl instance = new HospitalControl();

        ArrayList<Hospital> expResult = new ArrayList();
        Hospital bv1 = new Hospital("BV01", "Bệnh viện Bạch Mai","Bạch Mai, Hà Nội", 1, "084088888");
        Hospital bv2 = new Hospital("BV02", "Bệnh viện Việt Đức", "Việt Đức, Hà Nội", 1, "069066541");
        Hospital bv3 = new Hospital("BV03", "Bệnh viện quân y 103", "Hà Đông, Hà Nội", 2, "097944151");
        Hospital bv4 = new Hospital("BV04", "Bệnh viện mắt Quốc tế", "Cầu Giấy, Hà Nội", 1, "015614614");
        
        expResult.add(bv1);
        expResult.add(bv2);
        expResult.add(bv3);
        expResult.add(bv4);

        ArrayList<Hospital> result = new ArrayList();
        result = instance.getHospitalByAddress(diaChi);

        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getId(), result.get(i).getId());
            assertEquals(expResult.get(i).getTen(), result.get(i).getTen());
            assertEquals(expResult.get(i).getDiaChi(), result.get(i).getDiaChi());
            assertEquals(expResult.get(i).getHotline(), result.get(i).getHotline());
            assertEquals(expResult.get(i).getTuyen(), result.get(i).getTuyen()); 
        }
    }
    
    @Test
    public void  testGetHospitalByAddrCaseEmpty() {
        HospitalControl instance = new HospitalControl();
        String diaChi = "Hải Phòng";
        
        ArrayList<Hospital> expResult = new ArrayList();
        ArrayList<Hospital> result = instance.getHospitalByAddress(diaChi);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetHospitalByTuyen() throws ParseException{
        int tuyen = 1;
        HospitalControl instance = new HospitalControl();

        ArrayList<Hospital> expResult = new ArrayList();
        Hospital bv1 = new Hospital("BV01", "Bệnh viện Bạch Mai","Bạch Mai, Hà Nội", 1, "084088888");
        Hospital bv2 = new Hospital("BV02", "Bệnh viện Việt Đức", "Việt Đức, Hà Nội", 1, "069066541");
        Hospital bv4 = new Hospital("BV04", "Bệnh viện mắt Quốc tế", "Cầu Giấy, Hà Nội", 1, "015614614");
        
        expResult.add(bv1);
        expResult.add(bv2);
        expResult.add(bv4);

        ArrayList<Hospital> result = new ArrayList();
        result= instance.getHospitalByTuyen(tuyen);

        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getId(), result.get(i).getId());
            assertEquals(expResult.get(i).getTen(), result.get(i).getTen());
            assertEquals(expResult.get(i).getDiaChi(), result.get(i).getDiaChi());
            assertEquals(expResult.get(i).getHotline(), result.get(i).getHotline());
            assertEquals(expResult.get(i).getTuyen(), result.get(i).getTuyen()); 
        }
    }
    
    @Test
    public void testGetHospitalByTuyenCaseEmpty() {
        HospitalControl instance = new HospitalControl();
        int tuyen = 4;
        
        ArrayList<Hospital> expResult = new ArrayList();
        ArrayList<Hospital> result = instance.getHospitalByTuyen(tuyen);
        assertEquals(expResult, result);
    }
}

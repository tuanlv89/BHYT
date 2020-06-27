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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ConfigControlTest {
    
    public ConfigControlTest() {
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
    public void testGetAllConfigs() throws ParseException{
        ConfigControl instance = new ConfigControl();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        
        Date date1 = dateFormat.parse("20200607214500");
        Date date2 = dateFormat.parse("20200203153000");
        Date date3 = dateFormat.parse("20191214102200");

        ArrayList<Config> expResult = new ArrayList();
        
        Config cf1 = new Config(11, 100, 90.5, 85.5, 70, 60, 50, date1);
        Config cf2 = new Config(10, 90.5, 85, 80.5, 60, 55, 40, date2);
        Config cf3 = new Config(6, 100, 90, 80.5, 65.5, 50, 45, date3);
        
        
        expResult.add(cf1);
        expResult.add(cf2);
        expResult.add(cf3);
        
        ArrayList<Config> result = new ArrayList();
        result = instance.getAllConfigs();

        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getAge(), result.get(i).getAge());
            assertEquals(expResult.get(i).getQuyenLoiDungTuyen1(), result.get(i).getQuyenLoiDungTuyen1(), 0);
            assertEquals(expResult.get(i).getQuyenLoiDungTuyen2(), result.get(i).getQuyenLoiDungTuyen2(), 0);
            assertEquals(expResult.get(i).getQuyenLoiDungTuyen3(), result.get(i).getQuyenLoiDungTuyen3(), 0);
            assertEquals(expResult.get(i).getTraiTuyenTuyenTinh(), result.get(i).getTraiTuyenTuyenTinh(), 0);
            assertEquals(expResult.get(i).getTraiTuyenTuyenHuyen(), result.get(i).getTraiTuyenTuyenHuyen(), 0);
            assertEquals(expResult.get(i).getTraiTuyenTuyenTrungUong(), result.get(i).getTraiTuyenTuyenTrungUong(), 0);
        }
    }
    
    @Test
    public void testGetAllConfigsCaseEmpty() {
        DBConection conection = new DBConection();
        Connection conn = conection.getConnection();
        String sql = "select * from bhyt.cauhinh order by ngayApDung desc";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                ConfigControl instance = new ConfigControl();
                ArrayList<Config> expResult = new ArrayList<>();
        
                ArrayList<Config> result = new ArrayList();
                result = instance.getAllConfigs();
                assertEquals(expResult, result);
            }
            conn.close();
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
    }
    
    @Test
    public void testGetCurrentConfig() throws ParseException{
        ConfigControl instance = new ConfigControl();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = dateFormat.parse("20200607214500");
        
        Config expResult = new Config(11, 100, 90.5, 85.5, 70, 60, 50, date);
   
        Config result= instance.getCurrentConfig();
        assertEquals(expResult.getAge(), result.getAge());
        assertEquals(expResult.getQuyenLoiDungTuyen1(), result.getQuyenLoiDungTuyen1(), 0);
        assertEquals(expResult.getQuyenLoiDungTuyen2(), result.getQuyenLoiDungTuyen2(), 0);
        assertEquals(expResult.getQuyenLoiDungTuyen3(), result.getQuyenLoiDungTuyen3(), 0);
        assertEquals(expResult.getTraiTuyenTuyenTinh(), result.getTraiTuyenTuyenTinh(), 0);
        assertEquals(expResult.getTraiTuyenTuyenHuyen(), result.getTraiTuyenTuyenHuyen(), 0);
        assertEquals(expResult.getTraiTuyenTuyenTrungUong(), result.getTraiTuyenTuyenTrungUong(), 0);
    }

    @Test
    public void testGetCurrentConfigCaseEmpty() {
        DBConection conection = new DBConection();
        Connection conn = conection.getConnection();
        
        String sql = "select * from bhyt.cauhinh order by ngayApDung desc";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                ConfigControl instance = new ConfigControl();
                Config expResult = null;
        
                Config result = instance.getCurrentConfig();
                assertEquals(expResult, result);
            }
            conn.close();
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
    }
    
    @Test 
    public void testInsertNewConfig() throws SQLException {
        DBConection conection = new DBConection();
        Connection conn = conection.getConnection();
        conn.setAutoCommit(false);
        
        ConfigControl instance = new ConfigControl();
        
        Timestamp ngayApDung = new Timestamp(System.currentTimeMillis());
        Config newConfig = new Config(10, 20, 30, 40, 50, 50, 60, ngayApDung);
        Config config = new Config();
        
        instance.insertNewConfig(conn, newConfig);
        String sql = "SELECT * FROM bhyt.cauhinh WHERE tuoi = " + newConfig.getAge() + " AND quyenLoiDungTuyen1 = " + newConfig.getQuyenLoiDungTuyen1()
                + " AND quyenLoiDungTuyen2 = " + newConfig.getQuyenLoiDungTuyen2() + " AND quyenLoiDungTuyen3 = " + newConfig.getQuyenLoiDungTuyen3()
                + " AND ttTuyenHuyen = " + newConfig.getTraiTuyenTuyenHuyen() + " AND ttTuyenTinh = " + newConfig.getTraiTuyenTuyenTinh() + " AND ttTuyenTrungUong = " + newConfig.getTraiTuyenTuyenTrungUong();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                config.setAge(rs.getInt("tuoi"));
                config.setQuyenLoiDungTuyen1(rs.getDouble("quyenLoiDungTuyen1"));
                config.setQuyenLoiDungTuyen2(rs.getDouble("quyenLoiDungTuyen2"));
                config.setQuyenLoiDungTuyen3(rs.getDouble("quyenLoiDungTuyen3"));
                config.setTraiTuyenTuyenHuyen(rs.getDouble("ttTuyenHuyen"));
                config.setTraiTuyenTuyenTinh(rs.getDouble("ttTuyenTinh"));
                config.setTraiTuyenTuyenTrungUong(rs.getDouble("ttTuyenTrungUong"));
            }

            assertEquals(newConfig.getAge(), config.getAge());
            assertEquals(newConfig.getQuyenLoiDungTuyen1(), config.getQuyenLoiDungTuyen1(), 0.0);
            assertEquals(newConfig.getQuyenLoiDungTuyen2(), config.getQuyenLoiDungTuyen2(), 0.0);
            assertEquals(newConfig.getQuyenLoiDungTuyen3(), config.getQuyenLoiDungTuyen3(), 0.0);
            assertEquals(newConfig.getTraiTuyenTuyenHuyen(), config.getTraiTuyenTuyenHuyen(), 0.0);
            assertEquals(newConfig.getTraiTuyenTuyenTinh(), config.getTraiTuyenTuyenTinh(), 0.0);
            assertEquals(newConfig.getTraiTuyenTuyenTrungUong(), config.getTraiTuyenTuyenTrungUong(), 0.0);
            
        } catch (SQLException e) {
           e.printStackTrace(); ;
        } finally {
            conn.rollback();
            conn.setAutoCommit(true);
            conn.close();
        }
    }
}

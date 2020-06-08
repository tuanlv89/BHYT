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
import java.util.ArrayList;
import model.Config;

/**
 *
 * @author Tuanlv98
 */
public class ConfigControl {
    DBConection conection = new DBConection();

    public ArrayList<Config> getAllConfigs() {
        Connection conn = conection.getConnection();
        String sql = "select * from bhyt.cauhinh order by ngayApDung desc";
        ArrayList<Config> listConfigs = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Config config = new Config();
                config.setId(rs.getInt("idCH"));
                config.setAge(rs.getInt("tuoi"));
                config.setQuyenLoiDungTuyen1(rs.getDouble("quyenLoiDungTuyen1"));
                config.setQuyenLoiDungTuyen2(rs.getDouble("quyenLoiDungTuyen2"));
                config.setQuyenLoiDungTuyen3(rs.getDouble("quyenLoiDungTuyen3"));
                config.setTraiTuyenTuyenHuyen(rs.getDouble("ttTuyenHuyen"));
                config.setTraiTuyenTuyenTinh(rs.getDouble("ttTuyenTinh"));
                config.setTraiTuyenTuyenTrungUong(rs.getDouble("ttTuyenTrungUong"));
                config.setNgayApDung(rs.getTimestamp("ngayApDung"));
               listConfigs.add(config);
            }
            conn.close();
            System.out.println(sql);
            return listConfigs;
            
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
        return null;
    }
    
    public Config getCurrentConfig() {
        Connection conn = conection.getConnection();
        String sql = "select * from bhyt.cauhinh order by ngayApDung desc";
        ArrayList<Config> listConfigs = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Config config = new Config();
                config.setId(rs.getInt("idCH"));
                config.setAge(rs.getInt("tuoi"));
                config.setQuyenLoiDungTuyen1(rs.getDouble("quyenLoiDungTuyen1"));
                config.setQuyenLoiDungTuyen2(rs.getDouble("quyenLoiDungTuyen2"));
                config.setQuyenLoiDungTuyen3(rs.getDouble("quyenLoiDungTuyen3"));
                config.setTraiTuyenTuyenHuyen(rs.getDouble("ttTuyenHuyen"));
                config.setTraiTuyenTuyenTinh(rs.getDouble("ttTuyenTinh"));
                config.setTraiTuyenTuyenTrungUong(rs.getDouble("ttTuyenTrungUong"));
                config.setNgayApDung(rs.getDate("ngayApDung"));
               listConfigs.add(config);
            }
            conn.close();
            System.out.println(sql);
            return listConfigs.get(0);
            
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
        return null;
    }
    
    public boolean insert(Config config) {
        String sql = "INSERT INTO bhyt.cauhinh (idCH, tuoi, quyenLoiDungTuyen1, quyenLoiDungTuyen2, quyenLoiDungTuyen3, ttTuyenHuyen, ttTuyenTinh, ttTuyenTrungUong, ngayApDung)" +
                " VALUES (null, "+ config.getAge()+ ","+ config.getQuyenLoiDungTuyen1() + ","+ config.getQuyenLoiDungTuyen2() + ","+ config.getQuyenLoiDungTuyen3() +
        ","+ config.getTraiTuyenTuyenHuyen()+ ","+ config.getTraiTuyenTuyenTinh()+ ","+ config.getTraiTuyenTuyenTrungUong()+ ","+ "\""+config.getNgayApDung() + "\""+ ")";
        Connection conn = conection.getConnection();
        try {
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(sql);
            if(rs > 0) {
                conn.close();
                System.out.println(sql);
                return true;   
            }
            return false;
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
        return false;
    }
}

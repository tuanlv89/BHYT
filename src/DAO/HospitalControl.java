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
import model.Hospital;
import model.MedicalHistory;

/**
 *
 * @author Tuanlv98
 */
public class HospitalControl {
    DBConection conection = new DBConection();
    
    public ArrayList<Hospital> getAllHospital() {
        Connection conn = conection.getConnection();
        String sql = "Select * FROM benhvien";
        ArrayList<Hospital> listHospitals = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Hospital hospital = new Hospital();
                hospital.setId(rs.getString("idBV"));
                hospital.setTen(rs.getString("ten"));
                hospital.setDiaChi(rs.getString("diachi"));
                hospital.setTuyen(rs.getInt("tuyen"));
                hospital.setHotline(rs.getString("hotline"));
                
                listHospitals.add(hospital);
            }
            conn.close();
            System.out.println(sql);
            return listHospitals;
            
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
        return null;
    }
    
    public ArrayList<Hospital> getHospitalByName(String name) {
        String sql = "SELECT * FROM bhyt.benhvien WHERE ten LIKE N'%"+ name +"%'";
        Connection conn = conection.getConnection();
        ArrayList<Hospital> listHospitals = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Hospital hospital = new Hospital();
                hospital.setId(rs.getString("idBV"));
                hospital.setTen(rs.getString("ten"));
                hospital.setDiaChi(rs.getString("diachi"));
                hospital.setTuyen(rs.getInt("tuyen"));
                hospital.setHotline(rs.getString("hotline"));
                
                listHospitals.add(hospital);
            }
            conn.close();
            System.out.println(sql);
            return listHospitals;
            
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
        return null;
    }
    
    public ArrayList<Hospital> getHospitalByAddress(String address) {
        String sql = "SELECT * FROM bhyt.benhvien WHERE diachi LIKE N'%"+ address +"%'";
        Connection conn = conection.getConnection();
        ArrayList<Hospital> listHospitals = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Hospital hospital = new Hospital();
                hospital.setId(rs.getString("idBV"));
                hospital.setTen(rs.getString("ten"));
                hospital.setDiaChi(rs.getString("diachi"));
                hospital.setTuyen(rs.getInt("tuyen"));
                hospital.setHotline(rs.getString("hotline"));
                
                listHospitals.add(hospital);
            }
            conn.close();
            System.out.println(sql);
            return listHospitals;
            
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
        return null;
    }
    
    public ArrayList<Hospital> getHospitalByTuyen(int tuyen) {
        String sql = "SELECT * FROM bhyt.benhvien WHERE tuyen = " + tuyen;
        Connection conn = conection.getConnection();
        ArrayList<Hospital> listHospitals = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Hospital hospital = new Hospital();
                hospital.setId(rs.getString("idBV"));
                hospital.setTen(rs.getString("ten"));
                hospital.setDiaChi(rs.getString("diachi"));
                hospital.setTuyen(rs.getInt("tuyen"));
                hospital.setHotline(rs.getString("hotline"));
                
                listHospitals.add(hospital);
            }
            conn.close();
            System.out.println(sql);
            return listHospitals;
            
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
        return null;
    }
    
    public ArrayList<Hospital> getHospitalByMienGiam(double min, double max, ArrayList<Hospital> list) {
        //String sql = "SELECT * FROM bhyt.benhvien WHERE column_name BETWEEN" + min + " AND " + max+ ";";
        ArrayList<Hospital> listHospitals = new ArrayList<>();
        for(Hospital hospital: list) {
            if(hospital.getMienGiam() >= min && hospital.getMienGiam()<= max) {
                listHospitals.add(hospital);
            }
        }
        return listHospitals;
    }
}

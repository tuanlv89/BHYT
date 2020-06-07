package DAO;


import DAO.DBConection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.MedicalHistory;
import model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tuanlv98
 */
public class HistoryControl {
    DBConection conection = new DBConection();
    
    public ArrayList<MedicalHistory> getAllHistory(String id) {
        Connection conn = conection.getConnection();
        String sql = "Select * FROM history WHERE idUser = '" + id + "';";
        ArrayList<MedicalHistory> listHistory = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MedicalHistory history = new MedicalHistory();
                history.setId(rs.getString("idHistory"));
                history.setPatientName(rs.getString("hoTenBN"));
                history.setDoctorName(rs.getString("hoTenBS"));
                history.setHospitalName(rs.getString("ten"));
                history.setHospitalAddress(rs.getString("diachi"));
                history.setDate(rs.getDate("ngayKham"));
                history.setDiseaseName(rs.getString("chuanDoan"));
                history.setIsDungTuyen(rs.getBoolean("dungTuyen"));
                history.setTotalMoney(rs.getDouble("tongTienKham"));
                history.setPayMoney(rs.getDouble("tienPhaiTra"));
                
                listHistory.add(history);
            }
            conn.close();
            System.out.println(sql);
            return listHistory;
            
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
        return null;
    }
}

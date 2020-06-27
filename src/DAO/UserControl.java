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
import model.User;

/**
 *
 * @author Tuanlv98
 */
public class UserControl {
    DBConection conection = new DBConection();
    
    public User checkUser(String username, String password){
        Connection conn = conection.getConnection();
        String sql = "Select * FROM user WHERE username = '" + username + "' AND password = '" + password + "';";
        User user = new User();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setJob(rs.getString("job"));
                user.setAddress(rs.getString("address"));
                user.setHometown(rs.getString("hometown"));
                user.setDob(rs.getDate("dob"));
                user.setNation(rs.getString("nation"));
                user.setIsRelativeMartyrs(rs.getBoolean("isRelativeMartyrs"));
                user.setIsPoorFamily(rs.getBoolean("isPoorFamily"));
                user.setBhytID(rs.getString("bhytID"));
                user.setBhytRegisterPlace(rs.getString("bhytRegisterPlace"));
                user.setTuyenDK(rs.getInt("tuyenDK"));
                user.setRole(rs.getInt("role"));
            }
            conn.close();
            System.out.println(sql);
            return user;
            
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
        return null;
    }
    
    public User getUser(String id) {
        Connection conn = conection.getConnection();
        String sql = "Select * FROM user WHERE id = '" + id + "';";
        User user = new User();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setJob(rs.getString("job"));
                user.setAddress(rs.getString("address"));
                user.setHometown(rs.getString("hometown"));
                user.setDob(rs.getDate("dob"));
                user.setNation(rs.getString("nation"));
                user.setIsRelativeMartyrs(rs.getBoolean("isRelativeMartyrs"));
                user.setIsPoorFamily(rs.getBoolean("isPoorFamily"));
                user.setBhytID(rs.getString("bhytID"));
                user.setBhytRegisterPlace(rs.getString("bhytRegisterPlace"));
                user.setTuyenDK(rs.getInt("tuyenDK"));
                user.setRole(rs.getInt("role"));
            }
            System.out.println(sql);
            conn.close();
            return user;
        } catch (SQLException e) {
           e.printStackTrace(); ;
        }
        return null;
    }
}

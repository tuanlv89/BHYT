/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuanlv98
 */
public class DBConection {
    public Connection getConnection() {
        Connection conn = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bhyt?autoReconnect=true&useSSL=false", "root", "12345");
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi ne");
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            
            System.out.println("Loi ne :(");
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }
}

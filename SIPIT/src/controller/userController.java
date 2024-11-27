/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aidil
 */
public class userController {
    private Connection conn;
    
    public userController(Connection conn) {
        this.conn = conn;
    }
    
    // Metode untuk autentikasi pengguna
    public boolean authenticate(String username, String password) {
        try {
            String query = "SELECT * FROM pengguna WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Return true jika ada data yang cocok
        } catch (Exception e) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, e);
            return false; // Return false jika terjadi error
        }
    }
    
    public boolean register(String nama, String username, String password) {
        try {
            String sql = "INSERT INTO pengguna (nama, username, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setString(2, username);
            stmt.setString(3, password);

            int rowInserted = stmt.executeUpdate();
            stmt.close();
            return rowInserted > 0; // Return true jika insert berhasil
        } catch (Exception e) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, e);
            return false; // Return false jika terjadi error
        }
    }
}

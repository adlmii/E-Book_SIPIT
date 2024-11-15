/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aidil
 */
public class bookmarkController {
    private Connection conn;

    public bookmarkController(Connection conn) {
        this.conn = conn;
    }

    public boolean addBookmark(String username, String judulBuku, String author) {
        String sql = "INSERT INTO bookmark (username, judulBuku, author) VALUES (?, ?, ?)";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, username);
            st.setString(2, judulBuku);
            st.setString(3, author);
            return st.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.getLogger(bookmarkController.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}

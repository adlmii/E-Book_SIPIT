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
    
    public boolean updateBookmark(String id, String halaman) {
        String sql = "UPDATE bookmark SET halaman=? WHERE id=?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, halaman);
            st.setString(2, id);

            int rowUpdated = st.executeUpdate();
            return rowUpdated > 0;
        } catch (Exception e) {
            Logger.getLogger(bookmarkController.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    public boolean deleteBookmark(String id) {
        String sql = "DELETE FROM bookmark WHERE id=?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, id);

            int rowDeleted = st.executeUpdate();
            return rowDeleted > 0;
        } catch (Exception e) {
            Logger.getLogger(bookmarkController.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }


    // Testing
    public boolean addBookmarkTest(String username, String judulBuku, String author) {
        String sql = "INSERT INTO bookmarkTest (username, judulBuku, author) VALUES (?, ?, ?)";
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

    public boolean updateBookmarkTest(String id, String halaman) {
        String sql = "UPDATE bookmarkTest SET halaman=? WHERE id=?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, halaman);
            st.setString(2, id);

            int rowUpdated = st.executeUpdate();
            return rowUpdated > 0;
        } catch (Exception e) {
            Logger.getLogger(bookmarkController.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean deleteBookmarkTest(String id) {
        String sql = "DELETE FROM bookmarkTest WHERE id=?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, id);

            int rowDeleted = st.executeUpdate();
            return rowDeleted > 0;
        } catch (Exception e) {
            Logger.getLogger(bookmarkController.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}

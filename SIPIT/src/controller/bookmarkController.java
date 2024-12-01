/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        // Cek apakah judul buku sudah ada untuk username tersebut
        if (isDuplicate(username, judulBuku)) {
            return false; // Gagal menambahkan karena duplikasi
        }

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
        // Cek apakah halaman sudah sama dengan yang ada di database
        String checkQuery = "SELECT halaman FROM bookmark WHERE id=?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, id);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    String existingHalaman = rs.getString("halaman");
                    // Jika halaman sama, tidak perlu melakukan update
                    if (existingHalaman.equals(halaman)) {
                        System.out.println("Tidak ada perubahan pada halaman.");
                        return false; // Tidak ada perubahan
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

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

    private boolean isDuplicate(String username, String judulBuku) {
        String query = "SELECT COUNT(*) AS count FROM bookmark WHERE username = ? AND judulBuku = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, judulBuku);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("count") > 0; // Jika ada data, maka duplikat
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Anggap tidak ada duplikat jika ada kesalahan
    }


    // Testing
    public boolean addBookmarkTest(String username, String judulBuku, String author) {
        // Cek apakah judul buku sudah ada untuk username tersebut
        if (isDuplicateTest(username, judulBuku)) {
            return false; // Gagal menambahkan karena duplikasi
        }
        
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

        // Cek apakah halaman sudah sama dengan yang ada di database
        String checkQuery = "SELECT halaman FROM bookmarkTest WHERE id=?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, id);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    String existingHalaman = rs.getString("halaman");
                    // Jika halaman sama, tidak perlu melakukan update
                    if (existingHalaman.equals(halaman)) {
                        System.out.println("Tidak ada perubahan pada halaman.");
                        return false; // Tidak ada perubahan
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

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

    private boolean isDuplicateTest(String username, String judulBuku) {
        String query = "SELECT COUNT(*) AS count FROM bookmarkTest WHERE username = ? AND judulBuku = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, judulBuku);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("count") > 0; // Jika ada data, maka duplikat
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Anggap tidak ada duplikat jika ada kesalahan
    }
}

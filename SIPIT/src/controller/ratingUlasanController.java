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
public class ratingUlasanController {
    private Connection conn;
    
    public ratingUlasanController(Connection conn) {
        this.conn = conn;
    }
    
    public boolean addRatingUlasan(String username, String judulBuku, String rating, String ulasan) {
        if (isDuplicate(username, judulBuku)) {
            return false; // Jika ada duplikasi, kembalikan false
        }

        // Jika tidak ada duplikasi, lanjutkan menambahkan ulasan
        String insertQuery = "INSERT INTO ratingUlasan (username, judulBuku, rating, ulasan) VALUES (?, ?, ?, ?)";
        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
            insertStmt.setString(1, username);
            insertStmt.setString(2, judulBuku);
            insertStmt.setString(3, rating);
            insertStmt.setString(4, ulasan);

            int rowsInserted = insertStmt.executeUpdate();
            return rowsInserted > 0; // Mengembalikan true jika data berhasil ditambahkan
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Gagal menambahkan data
        }
    }
    
    public boolean updateRatingUlasan(String id, String judulBuku, String rating, String ulasan) {
        // Pertama, cek apakah data yang ingin diperbarui sudah ada atau tidak berubah
        String checkQuery = "SELECT judulBuku, rating, ulasan FROM ratingUlasan WHERE id=?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, id);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    // Cek apakah data yang baru sama dengan data yang ada
                    String existingJudulBuku = rs.getString("judulBuku");
                    String existingRating = rs.getString("rating");
                    String existingUlasan = rs.getString("ulasan");

                    // Jika data yang ingin diperbarui sama dengan data yang ada, maka tidak perlu update
                    if (existingJudulBuku.equals(judulBuku) && existingRating.equals(rating) && existingUlasan.equals(ulasan)) {
                        return false; // Tidak ada perubahan, return false
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(ratingUlasanController.class.getName()).log(Level.SEVERE, null, e);
            return false; // Jika terjadi kesalahan saat pengecekan
        }

        // Jika ada perubahan, lakukan update
        String sql = "UPDATE ratingUlasan SET judulBuku=?, rating=?, ulasan=? WHERE id=?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, judulBuku);
            st.setString(2, rating);
            st.setString(3, ulasan);
            st.setString(4, id);

            int rowUpdated = st.executeUpdate();
            return rowUpdated > 0; // Return true if the update was successful
        } catch (SQLException e) {
            Logger.getLogger(ratingUlasanController.class.getName()).log(Level.SEVERE, null, e);
            return false; // Return false if an exception occurred
        }
    }
    
    public boolean deleteRatingUlasan(String id) {
        String sql = "DELETE FROM ratingulasan WHERE id=?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, id);

            int rowDeleted = st.executeUpdate();
            return rowDeleted > 0; // Return true if the deletion was successful
        } catch (Exception e) {
            Logger.getLogger(ratingUlasanController.class.getName()).log(Level.SEVERE, null, e);
            return false; // Return false if an exception occurred
        }
    }

    public boolean isDuplicate(String username, String judulBuku) {
        // Mengecek apakah sudah ada ulasan untuk judul buku yang sama oleh pengguna yang sama
        String checkQuery = "SELECT COUNT(*) FROM ratingUlasan WHERE username=? AND judulBuku=?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, username);
            checkStmt.setString(2, judulBuku);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    // Jika ada duplikasi, kembalikan true
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Jika terjadi kesalahan SQL
        }
        return false; // Tidak ada duplikasi
    }

    // Testing

    public boolean addRatingUlasanTest(String username, String judulBuku, String rating, String ulasan) {
        if (isDuplicateTest(username, judulBuku)) {
            return false; // Jika ada duplikasi, kembalikan false
        }

        // Jika tidak ada duplikasi, lanjutkan menambahkan ulasan
        String insertQuery = "INSERT INTO ratingUlasanTest (username, judulBuku, rating, ulasan) VALUES (?, ?, ?, ?)";
        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
            insertStmt.setString(1, username);
            insertStmt.setString(2, judulBuku);
            insertStmt.setString(3, rating);
            insertStmt.setString(4, ulasan);

            int rowsInserted = insertStmt.executeUpdate();
            return rowsInserted > 0; // Mengembalikan true jika data berhasil ditambahkan
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Gagal menambahkan data
        }
    }
    
    public boolean updateRatingUlasanTest(String id, String judulBuku, String rating, String ulasan) {
        // Pertama, cek apakah data yang ingin diperbarui sudah ada atau tidak berubah
        String checkQuery = "SELECT judulBuku, rating, ulasan FROM ratingUlasanTest WHERE id=?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, id);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    // Cek apakah data yang baru sama dengan data yang ada
                    String existingJudulBuku = rs.getString("judulBuku");
                    String existingRating = rs.getString("rating");
                    String existingUlasan = rs.getString("ulasan");

                    // Jika data yang ingin diperbarui sama dengan data yang ada, maka tidak perlu update
                    if (existingJudulBuku.equals(judulBuku) && existingRating.equals(rating) && existingUlasan.equals(ulasan)) {
                        return false; // Tidak ada perubahan, return false
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(ratingUlasanController.class.getName()).log(Level.SEVERE, null, e);
            return false; // Jika terjadi kesalahan saat pengecekan
        }

        // Jika ada perubahan, lakukan update
        String sql = "UPDATE ratingUlasanTest SET judulBuku=?, rating=?, ulasan=? WHERE id=?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, judulBuku);
            st.setString(2, rating);
            st.setString(3, ulasan);
            st.setString(4, id);

            int rowUpdated = st.executeUpdate();
            return rowUpdated > 0; // Return true if the update was successful
        } catch (SQLException e) {
            Logger.getLogger(ratingUlasanController.class.getName()).log(Level.SEVERE, null, e);
            return false; // Return false if an exception occurred
        }
    }
    
    public boolean deleteRatingUlasanTest(String id) {
        String sql = "DELETE FROM ratingUlasanTest WHERE id=?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, id);

            int rowDeleted = st.executeUpdate();
            return rowDeleted > 0; // Return true if the deletion was successful
        } catch (Exception e) {
            Logger.getLogger(ratingUlasanController.class.getName()).log(Level.SEVERE, null, e);
            return false; // Return false if an exception occurred
        }
    }

    public boolean isDuplicateTest(String username, String judulBuku) {
        // Mengecek apakah sudah ada ulasan untuk judul buku yang sama oleh pengguna yang sama
        String checkQuery = "SELECT COUNT(*) FROM ratingUlasanTest WHERE username=? AND judulBuku=?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, username);
            checkStmt.setString(2, judulBuku);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    // Jika ada duplikasi, kembalikan true
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Jika terjadi kesalahan SQL
        }
        return false; // Tidak ada duplikasi
    }
}

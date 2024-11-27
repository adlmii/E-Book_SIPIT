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
public class ratingUlasanController {
    private Connection conn;
    
    public ratingUlasanController(Connection conn) {
        this.conn = conn;
    }
    
    public boolean addRatingUlasan(String username, String judulBuku, String rating, String ulasan) {
        String sql = "INSERT INTO ratingUlasan (username, judulBuku, rating, ulasan) VALUES (?, ?, ?, ?)";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, username);
            st.setString(2, judulBuku);
            st.setString(3, rating);
            st.setString(4, ulasan);

            int rowInserted = st.executeUpdate();
            return rowInserted > 0; // Return true if the insertion was successful
        } catch (Exception e) {
            Logger.getLogger(ratingUlasanController.class.getName()).log(Level.SEVERE, null, e);
            return false; // Return false if an exception occurred
        }
    }
    
    public boolean updateRatingUlasan(String id, String judulBuku, String rating, String ulasan) {
        String sql = "UPDATE ratingUlasan SET judulBuku=?, rating=?, ulasan=? WHERE id=?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, judulBuku);
            st.setString(2, rating);
            st.setString(3, ulasan);
            st.setString(4, id);

            int rowUpdated = st.executeUpdate();
            return rowUpdated > 0; // Return true if the update was successful
        } catch (Exception e) {
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

    // Testing

    public boolean addRatingUlasanTest(String username, String judulBuku, String rating, String ulasan) {
        String sql = "INSERT INTO ratingUlasanTest (username, judulBuku, rating, ulasan) VALUES (?, ?, ?, ?)";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, username);
            st.setString(2, judulBuku);
            st.setString(3, rating);
            st.setString(4, ulasan);

            int rowInserted = st.executeUpdate();
            return rowInserted > 0; // Return true if the insertion was successful
        } catch (Exception e) {
            Logger.getLogger(ratingUlasanController.class.getName()).log(Level.SEVERE, null, e);
            return false; // Return false if an exception occurred
        }
    }
    
    public boolean updateRatingUlasanTest(String id, String judulBuku, String rating, String ulasan) {
        String sql = "UPDATE ratingUlasanTest SET judulBuku=?, rating=?, ulasan=? WHERE id=?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, judulBuku);
            st.setString(2, rating);
            st.setString(3, ulasan);
            st.setString(4, id);

            int rowUpdated = st.executeUpdate();
            return rowUpdated > 0; // Return true if the update was successful
        } catch (Exception e) {
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
}

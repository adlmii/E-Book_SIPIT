package test;

import org.junit.*;

import controller.ratingUlasanController;

import java.sql.*;

import static org.junit.Assert.*;

public class ratingUlasanControllerTest {

    private static Connection conn;
    private ratingUlasanController controller;

    @BeforeClass
    public static void setUpDatabase() throws Exception {
        // Membuat koneksi ke database
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sipit", "root", "");

        // Membuat tabel ratingUlasanTest
        try (Statement stmt = conn.createStatement()) {
            String createTable = "CREATE TABLE IF NOT EXISTS ratingUlasanTest (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(50), " +
                    "judulBuku VARCHAR(255), " +
                    "rating VARCHAR(5), " +
                    "ulasan TEXT" +
                    ")";
            stmt.executeUpdate(createTable);
        }
    }

    @AfterClass
    public static void tearDownDatabase() throws Exception {
        // Menghapus tabel ratingUlasanTest
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS ratingUlasanTest");
        }

        // Menutup koneksi
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    @Before
    public void setUp() {
        // Menginisialisasi controller dengan koneksi database
        controller = new ratingUlasanController(conn);
    }

    @Test
    public void testAddRatingUlasan() throws Exception {
        // Menguji penambahan rating dan ulasan
        boolean isAdded = controller.addRatingUlasanTest("testUser", "Test Book", "5", "Excellent book!");
        assertTrue("Rating and ulasan should be added successfully", isAdded);

        // Memeriksa apakah data berhasil masuk ke tabel
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ratingUlasanTest WHERE username='testUser'")) {
            assertTrue("Rating and ulasan should exist in the database", rs.next());
        }
    }

    @Test
    public void testUpdateRatingUlasan() throws Exception {
        // Menambahkan data awal
        controller.addRatingUlasanTest("testUser", "Test Book", "5", "Excellent book!");

        // Mendapatkan ID dari data yang baru ditambahkan
        String id = null;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id FROM ratingUlasanTest WHERE username='testUser'")) {
            if (rs.next()) {
                id = rs.getString("id");
            }
        }
        assertNotNull("ID should not be null", id);

        // Menguji pembaruan data
        boolean isUpdated = controller.updateRatingUlasanTest(id, "Updated Book", "4", "Good book.");
        assertTrue("Rating and ulasan should be updated successfully", isUpdated);

        // Memeriksa apakah data diperbarui
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT judulBuku, rating, ulasan FROM ratingUlasanTest WHERE id=" + id)) {
            assertTrue("Updated rating and ulasan should exist", rs.next());
            assertEquals("Updated Book", rs.getString("judulBuku"));
            assertEquals("4", rs.getString("rating"));
            assertEquals("Good book.", rs.getString("ulasan"));
        }
    }

    @Test
    public void testDeleteRatingUlasan() throws Exception {
        // Menambahkan data awal
        controller.addRatingUlasanTest("testUser", "Test Book", "5", "Excellent book!");

        // Mendapatkan ID dari data yang baru ditambahkan
        String id = null;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id FROM ratingUlasanTest WHERE username='testUser'")) {
            if (rs.next()) {
                id = rs.getString("id");
            }
        }
        assertNotNull("ID should not be null", id);

        // Menguji penghapusan data
        boolean isDeleted = controller.deleteRatingUlasanTest(id);
        assertTrue("Rating and ulasan should be deleted successfully", isDeleted);

        // Memeriksa apakah data telah dihapus
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ratingUlasanTest WHERE id=" + id)) {
            assertFalse("Rating and ulasan should no longer exist", rs.next());
        }
    }
}

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
    public void testAddRatingUlasan2() throws Exception {
        // Menambahkan data awal ke tabel untuk pengujian (judul buku yang sama dengan rating dan ulasan)
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("INSERT INTO ratingUlasanTest (username, judulBuku, rating, ulasan) " +
                               "VALUES ('testUser', 'Test Book', '4', 'Buku yang sangat bagus!')");
        }
    
        // Menguji penambahan data dengan judul buku yang sama
        String judulBuku = "Test Book";
        String ulasan = "Ulasan baru untuk buku yang sama";
        String rating = "5"; // Rating yang valid
    
        // Simulasi klik pada tombol 'Tambah' untuk menambahkan ulasan dengan judul yang sama
        boolean isAdded = controller.addRatingUlasanTest("testUser", judulBuku, rating, ulasan);
    
        // Verifikasi bahwa data tidak ditambahkan karena duplikasi judul buku
        assertFalse("Data dengan judul buku yang sama tidak boleh ditambahkan", isAdded);
    
        // Memeriksa apakah hanya ada satu entri untuk judul buku yang sama
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM ratingUlasanTest WHERE username='testUser' AND judulBuku='Test Book'")) {
            if (rs.next()) {
                int count = rs.getInt("count");
                assertEquals("Hanya satu ulasan yang boleh ada untuk judul buku yang sama per pengguna", 1, count);
            }
        }
    }

    @Test
    public void testInvalidRatingUlasan() {
        String id = "1";
        String judulBuku = "Test Book";
        String ulasan = "Great book!";
        String rating = "6"; // Rating lebih dari 5

        // Simulasi klik tombol 'Perbarui'
        boolean isUpdated = controller.updateRatingUlasanTest(id, judulBuku, rating, ulasan);

        // Validasi
        assertFalse("Rating lebih dari 5 tidak boleh diterima", isUpdated);
    }

    @Test
    public void testInvalidRatingUlasan2() {
        String id = "1";
        String judulBuku = "Test Book";
        String ulasan = "Poor book!";
        String rating = "0"; // Rating kurang dari 1

        // Simulasi klik tombol 'Perbarui'
        boolean isUpdated = controller.updateRatingUlasanTest(id, judulBuku, rating, ulasan);

        // Validasi
        assertFalse("Rating kurang dari 1 tidak boleh diterima", isUpdated);
    }

    @Test
    public void testInvalidRatingUlasan3() {
        String id = "1";
        String judulBuku = "Test Book";
        String ulasan = "Invalid rating!";
        String rating = "abc"; // Rating berupa huruf

        // Simulasi klik tombol 'Perbarui'
        boolean isUpdated = controller.updateRatingUlasanTest(id, judulBuku, rating, ulasan);

        // Validasi
        assertFalse("Rating harus berupa angka, tidak boleh huruf", isUpdated);
    }

    @Test
    public void testRatingUlasanKosong() {
        String id = "1";
        String judulBuku = "Test Book";
        String ulasan = ""; // Ulasan kosong
        String rating = ""; // Rating kosong

        // Simulasi klik tombol 'Perbarui'
        boolean isUpdated = controller.updateRatingUlasanTest(id, judulBuku, rating, ulasan);

        // Validasi
        assertFalse("Tidak boleh memperbarui jika rating dan ulasan kosong", isUpdated);
    }

    
    @Test
    public void testAddRatingUlasan3() throws Exception {
        // Menguji penambahan rating dan ulasan
        boolean isAdded = controller.addRatingUlasanTest("testUser", "Test Book", "6", "Excellent book!");
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
    public void testUpdateRatingUlasanNoChanges() throws Exception {
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

        // Menguji pembaruan data dengan data yang sama (tidak ada perubahan)
        boolean isUpdated = controller.updateRatingUlasanTest(id, "Test Book", "5", "Excellent book!");
        assertFalse("Data should not be updated when there is no change", isUpdated);

        // Memeriksa apakah data tetap tidak berubah
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT judulBuku, rating, ulasan FROM ratingUlasanTest WHERE id=" + id)) {
            assertTrue("The rating and ulasan should remain the same", rs.next());
            assertEquals("Test Book", rs.getString("judulBuku"));
            assertEquals("5", rs.getString("rating"));
            assertEquals("Excellent book!", rs.getString("ulasan"));
        }
    }

    @Test
    public void testUpdateRatingUlasanKosong() throws Exception {

        boolean isAdded = controller.addRatingUlasanTest("testUser", "Buku Awal", "5", "Buku yang sangat bagus!");
        assertTrue("Data awal harus berhasil ditambahkan", isAdded);

        String id = null;
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM ratingUlasanTest WHERE username='testUser' AND judulBuku='Buku Awal'")) {
            if (rs.next()) {
                id = rs.getString("id");
            }
        }
        assertNotNull("ID tidak boleh null", id);

        boolean isUpdated = controller.updateRatingUlasanTest(id, "Buku Awal", "", "");
        assertFalse("Data tidak boleh diperbarui jika rating dan ulasan kosong", isUpdated);

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT judulBuku, rating, ulasan FROM ratingUlasanTest WHERE id=" + id)) {
            assertTrue("Data harus tetap ada di database", rs.next());
            assertEquals("Buku Awal", rs.getString("judulBuku"));
            assertEquals("5", rs.getString("rating"));
            assertEquals("Buku yang sangat bagus!", rs.getString("ulasan"));
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

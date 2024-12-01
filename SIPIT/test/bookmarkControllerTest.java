package test;

import org.junit.*;

import controller.bookmarkController;

import java.sql.*;

import static org.junit.Assert.*;

public class bookmarkControllerTest {

    private static Connection conn;
    private bookmarkController controller;

    @BeforeClass
    public static void setUpDatabase() throws Exception {
        // Membuat koneksi ke database
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sipit", "root", "");

        // Membuat tabel bookmarkTest
        try (Statement stmt = conn.createStatement()) {
            String createTable = "CREATE TABLE IF NOT EXISTS bookmarkTest (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(50), " +
                    "judulBuku VARCHAR(255), " +
                    "author VARCHAR(255), " +
                    "halaman VARCHAR(10)" +
                    ")";
            stmt.executeUpdate(createTable);
        }
    }

    @AfterClass
    public static void tearDownDatabase() throws Exception {
        // Menghapus tabel bookmarkTest
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS bookmarkTest");
        }

        // Menutup koneksi
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    @Before
    public void setUp() {
        // Menginisialisasi controller dengan koneksi database
        controller = new bookmarkController(conn);
    }

    @Test
    public void testAddBookmark() throws Exception {
        // Menguji penambahan bookmark
        boolean isAdded = controller.addBookmarkTest("testUser", "Test Book", "Test Author");
        assertTrue("Bookmark should be added successfully", isAdded);

        // Memeriksa apakah data berhasil masuk ke tabel
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM bookmarkTest WHERE username='testUser'")) {
            assertTrue("Bookmark should exist in the database", rs.next());
        }
    }

    @Test
    public void testAddBookmark2() throws Exception {
        // Menambahkan data awal ke tabel (untuk simulasi duplikasi berdasarkan judul buku)
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("INSERT INTO bookmarkTest (username, judulBuku, author) " +
                               "VALUES ('testUser', 'Test Book', 'Author A')");
        }
    
        // Menguji penambahan bookmark dengan judul buku yang sama untuk pengguna yang sama (harus gagal)
        boolean isDitambahkan = controller.addBookmarkTest("testUser", "Test Book", "Author B");
        assertFalse("Bookmark tidak boleh ditambahkan karena judul buku sama untuk pengguna yang sama", isDitambahkan);
    
        // Memeriksa apakah hanya ada satu data dengan judul buku yang sama untuk pengguna tersebut
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM bookmarkTest WHERE username='testUser' AND judulBuku='Test Book'")) {
            if (rs.next()) {
                int jumlah = rs.getInt("count");
                assertEquals("Hanya boleh ada satu data dengan judul buku yang sama di database untuk pengguna yang sama", 1, jumlah);
            }
        }
    }
    

    @Test
    public void testUpdateBookmark() throws Exception {
        // Menambahkan data awal
        controller.addBookmarkTest("testUser", "Test Book", "Test Author");

        // Mendapatkan ID dari data yang baru ditambahkan
        String id = null;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id FROM bookmarkTest WHERE username='testUser'")) {
            if (rs.next()) {
                id = rs.getString("id");
            }
        }
        assertNotNull("ID tidak boleh null null", id);

        // Menguji pembaruan halaman
        boolean isUpdated = controller.updateBookmarkTest(id, "100");
        assertTrue("Bookmark berhasil diupdate", isUpdated);

        // Memeriksa apakah data diperbarui
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT halaman FROM bookmarkTest WHERE id=" + id)) {
            assertTrue("Updated bookmark should exist", rs.next());
            assertEquals("Halaman should be updated to 100", "100", rs.getString("halaman"));
        }
    }

    @Test
    public void testUpdateBookmarkInvalidInput() throws Exception {
        // Menambahkan data awal
        controller.addBookmarkTest("testUser", "Test Book", "Test Author");

        // Mendapatkan ID dari data yang baru ditambahkan
        String id = null;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id FROM bookmarkTest WHERE username='testUser'")) {
            if (rs.next()) {
                id = rs.getString("id");
            }
        }
        assertNotNull("ID tidak boleh null null", id);

        // Menguji pembaruan halaman
        boolean isUpdated = controller.updateBookmarkTest(id, "xyz");
        assertTrue("Bookmark berhasil diupdate", isUpdated);

        // Memeriksa apakah data diperbarui
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT halaman FROM bookmarkTest WHERE id=" + id)) {
            assertTrue("Updated bookmark should exist", rs.next());
            assertEquals("Halaman should be updated to 100", "100", rs.getString("halaman"));
        }
    }

    @Test
    public void testUpdateBookmarkNoChange() throws Exception {
        // Menambahkan data awal ke tabel untuk pengujian
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("INSERT INTO bookmarkTest (id, username, judulBuku, author, halaman) " +
                            "VALUES ('1', 'testUser', 'Test Book', 'Author A', '1')");
        }

        // Mencoba untuk memperbarui halaman dengan nilai yang sama (tidak ada perubahan)
        boolean isUpdated = controller.updateBookmarkTest("1", "1");

        // Verifikasi bahwa update gagal karena tidak ada perubahan
        assertFalse("Tidak ada perubahan, jadi bookmark tidak boleh diperbarui", isUpdated);

        // Memeriksa apakah data halaman di database tetap sama
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT halaman FROM bookmarkTest WHERE id='1'")) {
            if (rs.next()) {
                String halaman = rs.getString("halaman");
                assertEquals("Halaman harus tetap '1' karena tidak ada perubahan", "1", halaman);
            }
        }
    }


    @Test
    public void testDeleteBookmark() throws Exception {
        // Menambahkan data awal
        controller.addBookmarkTest("testUser", "Test Book", "Test Author");

        // Mendapatkan ID dari data yang baru ditambahkan
        String id = null;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id FROM bookmarkTest WHERE username='testUser'")) {
            if (rs.next()) {
                id = rs.getString("id");
            }
        }
        assertNotNull("ID should not be null", id);

        // Menguji penghapusan bookmark
        boolean isDeleted = controller.deleteBookmarkTest(id);
        assertTrue("Bookmark should be deleted successfully", isDeleted);

        // Memeriksa apakah data telah dihapus
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM bookmarkTest WHERE id=" + id)) {
            assertFalse("Bookmark should no longer exist", rs.next());
        }
    }
}

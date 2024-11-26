package Rekomendasi.model;

public class buku {
    private String id_buku;
    private String judul_buku;
    private String nama_pengarang;
    private String genre_buku;
    private String sinopsis;
    private String ulasan;
    private int rating;
    private String jumlahHalaman;
    
    public buku(String id_buku, String judul_buku, String nama_pengarang, String genre_buku, String sinopsis,
            String ulasan, int rating, String jumlahHalaman) {
        this.id_buku = id_buku;
        this.judul_buku = judul_buku;
        this.nama_pengarang = nama_pengarang;
        this.genre_buku = genre_buku;
        this.sinopsis = sinopsis;
        this.ulasan = ulasan;
        this.rating = rating;
        this.jumlahHalaman = jumlahHalaman;
    }

    public buku(String judul_buku, int rating) {
        this.judul_buku = judul_buku;
        this.rating = rating;
    }

    public buku(String judul_buku, String ulasan) {
        this.judul_buku = judul_buku;
        this.ulasan = ulasan;
    }

    
    public buku(String ulasan) {
        this.ulasan = ulasan;
    }

    public buku(int rating) {
        this.rating = rating;
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public String getJudul_Buku() {
        return judul_buku;
    }

    public void setJudul_buku(String judul_buku) {
        this.judul_buku = judul_buku;
    }

    public String getNama_pengarang() {
        return nama_pengarang;
    }

    public void setNama_pengarang(String nama_pengarang) {
        this.nama_pengarang = nama_pengarang;
    }

    public String getGenre_buku() {
        return genre_buku;
    }

    public void setGenre_buku(String genre_buku) {
        this.genre_buku = genre_buku;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getUlasan() {
        return ulasan;
    }

    public void setUlasan(String ulasan) {
        this.ulasan = ulasan;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getJumlahHalaman() {
        return jumlahHalaman;
    }

    public void setJumlahHalaman(String jumlahHalaman) {
        this.jumlahHalaman = jumlahHalaman;
    }
}
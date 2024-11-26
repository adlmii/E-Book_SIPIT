package model;

public class Pengguna {
    String id_pengguna;
    String nama_pengguna;
    String tgl_lahir_pengguna;
    String jenis_kelamin_pengguna;
    String nmr_telp_pengguna;
    String alamat_pengguna;
    String email_pengguna;
    String foto_profil_pengguna;
    
    public Pengguna(String id_pengguna, String nama_pengguna, String tgl_lahir_pengguna, String jenis_kelamin_pengguna, 
            String nmr_telp_pengguna, String alamat_pengguna, String email_pengguna, String foto_profil_pengguna) {
        this.id_pengguna = id_pengguna;
        this.nama_pengguna = nama_pengguna;
        this.tgl_lahir_pengguna = tgl_lahir_pengguna;
        this.jenis_kelamin_pengguna = jenis_kelamin_pengguna;
        this.nmr_telp_pengguna = nmr_telp_pengguna;
        this.alamat_pengguna = alamat_pengguna;
        this.email_pengguna = email_pengguna;
        this.foto_profil_pengguna = foto_profil_pengguna;
    }

    public Pengguna(String nama_pengguna){
        this.nama_pengguna = nama_pengguna;
    }

    public String getId_pengguna() {
        return id_pengguna;
    }
    public void setId_pengguna(String id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public String getNama_pengguna() {
        return nama_pengguna;
    }
    public void setNama_pengguna(String nama_pengguna) {
        this.nama_pengguna = nama_pengguna;
    }

    public String getTgl_lahir_pengguna() {
        return tgl_lahir_pengguna;
    }

    public void setTgl_lahir_pengguna(String tgl_tahir_pengguna) {
        this.tgl_lahir_pengguna = tgl_lahir_pengguna;
    }

    public String getJenis_kelamin_pengguna() {
        return jenis_kelamin_pengguna;
    }
    public void setJenis_kelamin_pengguna(String jenis_kelamin_pengguna) {
        this.jenis_kelamin_pengguna = jenis_kelamin_pengguna;
    }

    public String getNmr_telp_pengguna() {
        return nmr_telp_pengguna;
    }
    public void setNmr_telp_pengguna(String nmr_telp_pengguna) {
        this.nmr_telp_pengguna = nmr_telp_pengguna;
    }

    public String getAlamat_pengguna() {
        return alamat_pengguna;
    }
    public void setAlamat_pengguna(String alamat_pengguna) {
        this.alamat_pengguna = alamat_pengguna;
    }

    public String getEmail_pengguna() {
        return email_pengguna;
    }

    public void setEmail_pengguna(String email_engguna) {
        this.email_pengguna = email_pengguna;
    }

    public String getFoto_profil_pengguna() {
        return foto_profil_pengguna;
    }

    public void setFotoProfilPengguna(String foto_profil_pengguna) {
        this.foto_profil_pengguna = foto_profil_pengguna;
    }
    
}
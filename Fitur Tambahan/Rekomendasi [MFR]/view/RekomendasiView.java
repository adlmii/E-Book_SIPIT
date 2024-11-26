package Rekomendasi.view;

import Rekomendasi.model.buku;
import java.util.List;

public class RekomendasiView {
    public RekomendasiView() {
    }

    // Method to display the list of recommended books
    public void tampilkanRekomendasi(List<buku> books, String genre) {
        if (books.isEmpty()) {
            System.out.println("Tidak ada buku yang tersedia untuk genre " + genre);
        } else {
            System.out.println("Berikut adalah rekomendasi buku untuk genre " + genre + ":");
            for (buku book : books) {
                System.out.println("- Judul: " + book.getJudul_Buku() + 
                                   " | Pengarang: " + book.getNama_pengarang() + 
                                   " | Sinopsis: " + book.getSinopsis());
            }
        }
    }

    // Method to display a success message
    public void cetakPesanBerhasil(String pesan) {
        System.out.println(pesan);
    }
}
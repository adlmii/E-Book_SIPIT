package Rekomendasi;

import Rekomendasi.controller.rekomendasiController;
import Rekomendasi.model.buku;
import Rekomendasi.view.RekomendasiView;

import java.util.Scanner;
import java.util.List;

public class main {
    public static void main(String[] args) {
        rekomendasiController controller = new rekomendasiController();
        RekomendasiView view = new RekomendasiView();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di sistem rekomendasi buku!");
        System.out.print("Masukkan genre buku yang ingin direkomendasikan (contoh: fantasi, sains-fiksi, biografi): ");
        String genre = scanner.nextLine();

        // Mendapatkan rekomendasi buku berdasarkan genre
        List<buku> recommendedBooks = controller.recommendBooksByGenre(genre);

        // Menampilkan hasil rekomendasi menggunakan view
        view.tampilkanRekomendasi(recommendedBooks, genre);

        scanner.close();
    }
}
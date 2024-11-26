import controller.PencarianController;
import model.Buku;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PencarianController pencarianController = new PencarianController();

        // Menambahkan beberapa buku ke daftar
        pencarianController.tambahBuku(new Buku("1", "The Lord of the Rings", "J.R.R. Tolkien", "Fantasi", 
                       "Petualangan epik di Middle-earth.", "Karya klasik fantasi.", 5, 
                       "1200", "hobbit, cincin, middle-earth"));
        pencarianController.tambahBuku(new Buku("2", "Sejarah Indonesia", "Bambang Purwanto", "Sejarah",
                       "Riwayat bangsa Indonesia dari masa lampau hingga kini.", "Buku wajib bagi pelajar sejarah.", 4,
                       "500", "Indonesia, sejarah, nusantara"));
        pencarianController.tambahBuku(new Buku("3", "Petualangan Si Kancil", "Pak Kasur", "Dongeng Anak",
                       "Kisah seekor kancil yang cerdas.", "Buku bacaan anak-anak yang menyenangkan.", 3,
                       "100", "kancil, hutan, binatang"));

        boolean running = true;

        while (running) {
            System.out.println("\n");
            System.out.println("=== Menu Pencarian Buku ===");
            System.out.println("1. Cari Buku");
            System.out.println("2. Keluar");
            System.out.println("\n");
            System.out.print("Pilih opsi: ");
            String pilihan = sc.nextLine();

            switch (pilihan) {
                case "1":
                    System.out.print("Masukkan Judul Buku: ");
                    String judulBuku = sc.nextLine();

                    Buku hasilPencarian = pencarianController.cariBuku(judulBuku);

                    if (hasilPencarian != null) {
                        System.out.println(hasilPencarian.tampilkanBuku());
                    } else {
                        System.out.println("Maaf, Buku yang Anda cari tidak ditemukan.");
                    }
                    break;

                case "2":
                    running = false;
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("\n");
                    System.out.println("Pilihan tidak valid.");
            }
        }
        sc.close();
    }
}
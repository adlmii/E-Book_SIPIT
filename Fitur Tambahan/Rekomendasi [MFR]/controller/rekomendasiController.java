package Rekomendasi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import Rekomendasi.model.buku;


public class rekomendasiController {
    private List<buku> books;

    public rekomendasiController() {
        books = new ArrayList<>();
        // Menambahkan beberapa contoh buku ke dalam daftar
        books.add(new buku("1", "Harry Potter", "J.K. Rowling", "fantasi", "Cerita tentang penyihir muda", "Sangat menarik", 5, "400"));
        books.add(new buku("2", "The Lord of the Rings", "J.R.R. Tolkien", "fantasi", "Petualangan di Middle-earth", "Epik", 5, "1200"));
        books.add(new buku("3", "Dune", "Frank Herbert", "sains-fiksi", "Perjuangan keluarga di planet gurun", "Brilian", 4, "800"));
        books.add(new buku("4", "Neuromancer", "William Gibson", "sains-fiksi", "Cyberpunk klasik", "Inovatif", 4, "300"));
        books.add(new buku("5", "Steve Jobs Biography", "Walter Isaacson", "biografi", "Kehidupan Steve Jobs", "Inspiratif", 5, "600"));
        books.add(new buku("6", "Elon Musk Biography", "Ashlee Vance", "biografi", "Kehidupan Elon Musk", "Motivasi tinggi", 5, "400"));
    }

    // Metode untuk merekomendasikan buku berdasarkan genre
    public List<buku> recommendBooksByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre_buku().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }
}
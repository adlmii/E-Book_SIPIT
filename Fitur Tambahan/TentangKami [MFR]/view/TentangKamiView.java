package TentangKami.view;

import TentangKami.model.TentangKami;
import java.util.*;

public class TentangKamiView {
    public TentangKamiView() {
    }

    // Method to print details of a list of TentangKami objects
    public void cetakTentangKami(List<TentangKami> tentangKamis) {
        System.out.println("=== Tentang Kami Information ===");

        for (int i = 0; i < tentangKamis.size(); ++i) {
            TentangKami tk = tentangKamis.get(i);
            System.out.println((i + 1) + ". ID: " + tk.getId_tentang_kami() +
                               ", Email Developer: " + tk.getEmail_developer() +
                               ", Terms & Conditions: " + tk.getTerms_condition() +
                               ", Disclaimer: " + tk.getDisclaimer() +
                               ", Privacy Policy: " + tk.getPrivacy_policy());
        }
    }

    // Method to print a success message
    public void cetakPesanBerhasil(String pesan) {
        System.out.println(pesan);
    }
}
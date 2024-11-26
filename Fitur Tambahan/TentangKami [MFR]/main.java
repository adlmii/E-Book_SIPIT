package TentangKami;

import TentangKami.model.TentangKami;
import TentangKami.view.TentangKamiView;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // Create some sample TentangKami objects
        TentangKami tentangKami1 = new TentangKami(0, "developer@example.com", "Terms 1", "Disclaimer 1", "Privacy Policy 1");
        TentangKami tentangKami2 = new TentangKami(0, "support@example.com", "Terms 2", "Disclaimer 2", "Privacy Policy 2");

        // Add them to a list
        List<TentangKami> tentangKamis = new ArrayList<>();
        tentangKamis.add(tentangKami1);
        tentangKamis.add(tentangKami2);

        // Create an instance of TentangKamiView and display the information
        TentangKamiView view = new TentangKamiView();
        view.cetakTentangKami(tentangKamis);

        // Print a success message
        view.cetakPesanBerhasil("Data displayed successfully!");
    }
}
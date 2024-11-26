package View;

import View.bookmark;
import controller.bookmarkController;
import Config.koneksi;
import Model.Session;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aidil
 */
public class pencarianBuku extends javax.swing.JFrame {

    private Connection conn;
    
    public pencarianBuku() {
        initComponents();
        conn = koneksi.getConnection();
        getData();
        nonAktifbtn();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Kembali ke frame Login
                bookmark bookmark = new bookmark();
                bookmark.setVisible(true);
                dispose(); // Tutup frame Menu
            }
        });
    }
    
    private void getData() {
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "Select * From buku";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                int id          = rs.getInt("id");
                String judulBuku= rs.getString("judulBuku");
                String author   = rs.getString("author");
                
                Object[] rowData = {id,judulBuku,author};
                model.addRow(rowData);
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            Logger.getLogger(pencarianBuku.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        panel_button = new javax.swing.JPanel();
        btn_tambah = new javax.swing.JButton();
        t_pencarian = new javax.swing.JTextField();
        lbl_buku = new javax.swing.JLabel();
        img_pencarian = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SIPIT - BOOKMARK");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/logo-sipit4.png")).getImage());
        setSize(new java.awt.Dimension(854, 529));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_data.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tbl_data.setForeground(new java.awt.Color(153, 153, 153));
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Judul Buku", "Author"
            }
        ));
        tbl_data.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_data.setRowHeight(30);
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 420, 270));

        btn_tambah.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_buttonLayout = new javax.swing.GroupLayout(panel_button);
        panel_button.setLayout(panel_buttonLayout);
        panel_buttonLayout.setHorizontalGroup(
            panel_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_buttonLayout.createSequentialGroup()
                .addContainerGap(336, Short.MAX_VALUE)
                .addComponent(btn_tambah)
                .addContainerGap())
        );
        panel_buttonLayout.setVerticalGroup(
            panel_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_buttonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        panel.add(panel_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 420, 60));

        t_pencarian.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        t_pencarian.setText("Pencarian");
        t_pencarian.setFocusable(false);
        t_pencarian.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_pencarianFocusGained(evt);
            }
        });
        t_pencarian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_pencarianMouseClicked(evt);
            }
        });
        panel.add(t_pencarian, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 380, 40));

        lbl_buku.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbl_buku.setText("BUKU");
        panel.add(lbl_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 50, -1));

        img_pencarian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-line.png"))); // NOI18N
        panel.add(img_pencarian, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 30, -1));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        int selectedRow = tbl_data.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Pilih Baris yang ingin diubah");
            return;
        }
        
        String judulBuku = tbl_data.getValueAt(selectedRow, 1).toString();
        String author = tbl_data.getValueAt(selectedRow, 2).toString();
        
        bookmarkController controller = new bookmarkController(conn);
        boolean isSuccess = controller.addBookmark(Session.username, judulBuku, author);

    if (isSuccess) {
        JOptionPane.showMessageDialog(this, "Data Berhasil diperbarui");
        getData();
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Gagal menambah bookmark");
    }

    bookmark bookmarkFrame = new bookmark();
    bookmarkFrame.setVisible(true);
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        btn_tambah.setEnabled(true);
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void t_pencarianFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_pencarianFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t_pencarianFocusGained

    private void t_pencarianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_pencarianMouseClicked
        t_pencarian.setText("");
    }//GEN-LAST:event_t_pencarianMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pencarianBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pencarianBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pencarianBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pencarianBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pencarianBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel img_pencarian;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_buku;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel_button;
    private javax.swing.JTextField t_pencarian;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables


    private void nonAktifbtn() {
        btn_tambah.setEnabled(false);
    }

    private void aktifbtn() {
        btn_tambah.setEnabled(true);
    }
    
}

package Sipit;

import Config.koneksi;
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
public class ratingUlasan extends javax.swing.JFrame {

    private Connection conn;
    
    public ratingUlasan() {
        initComponents();
        conn = koneksi.getConnection();
        getData();
        nonAktifbtn();
        aktifbtn();
    }
    
    private void getData() {
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM ratingulasan WHERE username = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, Session.username);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                String username = rs.getString("username");
                String judulBuku= rs.getString("judulBuku");
                int rating      = rs.getInt("rating");
                String ulasan   = rs.getString("ulasan");
                
                Object[] rowData = {username,judulBuku,rating,ulasan};
                model.addRow(rowData);
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            Logger.getLogger(ratingUlasan.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nav = new javax.swing.JPanel();
        nav_ratingulasan = new javax.swing.JLabel();
        nav_home = new javax.swing.JLabel();
        nav_bookmark = new javax.swing.JLabel();
        nav_logout = new javax.swing.JLabel();
        lbl_judulBuku = new javax.swing.JLabel();
        t_judulBuku = new javax.swing.JTextField();
        lbl_rating = new javax.swing.JLabel();
        t_rating = new javax.swing.JTextField();
        lbl_ulasan = new javax.swing.JLabel();
        t_ulasan = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_perbarui = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIPIT - RATING ULASAN");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/logo-sipit4.png")).getImage());
        setSize(new java.awt.Dimension(854, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nav.setBackground(new java.awt.Color(0, 0, 255));

        nav_ratingulasan.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        nav_ratingulasan.setForeground(new java.awt.Color(255, 255, 255));
        nav_ratingulasan.setText("Rating Ulasan");
        nav_ratingulasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_ratingulasanMouseClicked(evt);
            }
        });

        nav_home.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        nav_home.setForeground(new java.awt.Color(255, 255, 255));
        nav_home.setText("Home");
        nav_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_homeMouseClicked(evt);
            }
        });

        nav_bookmark.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        nav_bookmark.setForeground(new java.awt.Color(255, 255, 255));
        nav_bookmark.setText("Bookmark");
        nav_bookmark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_bookmarkMouseClicked(evt);
            }
        });

        nav_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        nav_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_logoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout navLayout = new javax.swing.GroupLayout(nav);
        nav.setLayout(navLayout);
        navLayout.setHorizontalGroup(
            navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(nav_home)
                .addGap(18, 18, 18)
                .addComponent(nav_bookmark)
                .addGap(18, 18, 18)
                .addComponent(nav_ratingulasan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 504, Short.MAX_VALUE)
                .addComponent(nav_logout)
                .addGap(29, 29, 29))
        );
        navLayout.setVerticalGroup(
            navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nav_logout)
                    .addGroup(navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nav_ratingulasan)
                        .addComponent(nav_home)
                        .addComponent(nav_bookmark)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 60));

        lbl_judulBuku.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbl_judulBuku.setText("Judul Buku");
        getContentPane().add(lbl_judulBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 340, -1));

        t_judulBuku.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        t_judulBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_judulBukuActionPerformed(evt);
            }
        });
        getContentPane().add(t_judulBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 350, 34));

        lbl_rating.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbl_rating.setText("Rating");
        getContentPane().add(lbl_rating, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 340, -1));

        t_rating.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        getContentPane().add(t_rating, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 350, 34));

        lbl_ulasan.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbl_ulasan.setText("Ulasan");
        getContentPane().add(lbl_ulasan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 340, -1));

        t_ulasan.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        t_ulasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_ulasanActionPerformed(evt);
            }
        });
        getContentPane().add(t_ulasan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 350, 35));

        btn_tambah.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 32));

        btn_perbarui.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btn_perbarui.setText("PERBARUI");
        btn_perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbaruiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_perbarui, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, 32));

        btn_batal.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        getContentPane().add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, 32));

        btn_hapus.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 80, 32));

        tbl_data.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tbl_data.setForeground(new java.awt.Color(153, 153, 153));
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Judul Buku", "Rating", "Ulasan"
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
        if (tbl_data.getColumnModel().getColumnCount() > 0) {
            tbl_data.getColumnModel().getColumn(0).setHeaderValue("ID");
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 438, 349));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 820, 80));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_judulBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_judulBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_judulBukuActionPerformed

    private void t_ulasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_ulasanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_ulasanActionPerformed

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
        int selectedRow = tbl_data.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Pilih Baris yang ingin diubah");
            return;
        }
        
        String id = tbl_data.getValueAt(selectedRow, 0).toString();
        String judulBuku = t_judulBuku.getText();
        String ulasan = t_ulasan.getText();
        String rating = t_rating.getText();
        
        if(judulBuku.isEmpty() || rating.isEmpty() || ulasan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua Kolom Harus diisi !", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            String sql = "UPDATE ratingUlasan SET judulBuku=?, rating=?, ulasan=? WHERE id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, judulBuku);
            st.setString(2, rating);
            st.setString(3, ulasan);
            st.setString(4, id);
            
            int rowUpdated = st.executeUpdate();
            if(rowUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil diperbarui");
                resetForm();
                getData();
            }
            
            st.close();
        } catch (Exception e) {
            Logger.getLogger(ratingUlasan.class.getName()).log(Level.SEVERE,null,e);
        }
    }//GEN-LAST:event_btn_perbaruiActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String judulBuku = t_judulBuku.getText();
        String ulasan = t_ulasan.getText();
        String rating = t_rating.getText();
        
        if(judulBuku.isEmpty() || ulasan.isEmpty() || rating.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua Kolom Harus diisi !", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            String sql = "INSERT INTO ratingUlasan (username, judulBuku, rating, ulasan) VALUES (?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, Session.username);
            st.setString(2, judulBuku);
            st.setString(3, rating);
            st.setString(4, ulasan);
            
            int rowInserted = st.executeUpdate();
            if(rowInserted > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil ditambahkan");
                resetForm();
                getData();
            }
            
            st.close();
        } catch (Exception e) {
            Logger.getLogger(ratingUlasan.class.getName()).log(Level.SEVERE,null,e);
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        resetForm();
        aktifbtn();
        nonAktifbtn();
        
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
       int selectedRow = tbl_data.getSelectedRow();
       if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Pilih Baris yang ingin diubah");
            return;
        }
       
       int confirm = JOptionPane.showConfirmDialog(this, "Hapus data?", "Konfirmasi",JOptionPane.YES_NO_OPTION);
       if(confirm == JOptionPane.YES_OPTION){
           String id = tbl_data.getValueAt(selectedRow, 0).toString();
           
           try {
               String sql = "DELETE FROM ratingulasan WHERE id=?";
               PreparedStatement st = conn.prepareStatement(sql);
               st.setString(1, id);
               
               int rowDelete = st.executeUpdate();
               if(rowDelete > 0){
                   JOptionPane.showMessageDialog(this, "Data Berhasil dihapus");
               } 
               st.close();
               
           } catch (Exception e) {
               Logger.getLogger(ratingUlasan.class.getName()).log(Level.SEVERE,null,e);
           }
       }
       
       resetForm();
       getData();
       nonAktifbtn();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        int selectedRow = tbl_data.getSelectedRow();
        if(selectedRow != -1){
            String judulBuku = tbl_data.getValueAt(selectedRow, 1).toString();
            String rating = tbl_data.getValueAt(selectedRow, 2).toString();
            String ulasan = tbl_data.getValueAt(selectedRow, 3).toString();
        
            t_judulBuku.setText(judulBuku);
            t_ulasan.setText(ulasan);
            t_rating.setText(rating);
        }
        
        btn_tambah.setEnabled(false);
        btn_perbarui.setEnabled(true);
        btn_hapus.setEnabled(true);
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void nav_ratingulasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_ratingulasanMouseClicked
        
    }//GEN-LAST:event_nav_ratingulasanMouseClicked

    private void nav_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_homeMouseClicked
        Menu  menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav_homeMouseClicked

    private void nav_bookmarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_bookmarkMouseClicked
        bookmark  bookmark = new bookmark();
        bookmark.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav_bookmarkMouseClicked

    private void nav_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_logoutMouseClicked
        login login = new login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(ratingUlasan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ratingUlasan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ratingUlasan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ratingUlasan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ratingUlasan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_judulBuku;
    private javax.swing.JLabel lbl_rating;
    private javax.swing.JLabel lbl_ulasan;
    private javax.swing.JPanel nav;
    private javax.swing.JLabel nav_bookmark;
    private javax.swing.JLabel nav_home;
    private javax.swing.JLabel nav_logout;
    private javax.swing.JLabel nav_ratingulasan;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField t_judulBuku;
    private javax.swing.JTextField t_rating;
    private javax.swing.JTextField t_ulasan;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        t_judulBuku.setText("");
        t_ulasan.setText("");
        t_rating.setText("");
    }

    private void nonAktifbtn() {
        btn_perbarui.setEnabled(false);
        btn_hapus.setEnabled(false);
    }

    private void aktifbtn() {
        btn_tambah.setEnabled(true);
        btn_batal.setEnabled(true);
    }
}

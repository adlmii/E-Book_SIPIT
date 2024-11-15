package Sipit;

import Config.koneksi;
import Sipit.Menu;
import Sipit.Session;
import Sipit.login;
import Sipit.ratingUlasan;
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
public class bookmark extends javax.swing.JFrame {

    private Connection conn;
    
    public bookmark() {
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
            String sql = "Select * From bookmark where username = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, Session.username);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                int id          = rs.getInt("id");
                String judulBuku= rs.getString("judulBuku");
                String author   = rs.getString("author");
                String halaman   = rs.getString("halaman");
                
                Object[] rowData = {id,judulBuku,author,halaman};
                model.addRow(rowData);
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            Logger.getLogger(bookmark.class.getName()).log(Level.SEVERE,null,e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        panel_button = new javax.swing.JPanel();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_perbarui = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIPIT - BOOKMARK");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/logo-sipit4.png")).getImage());
        setSize(new java.awt.Dimension(854, 529));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nav.setBackground(new java.awt.Color(0, 0, 255));

        nav_ratingulasan.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
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

        nav_bookmark.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 510, Short.MAX_VALUE)
                .addComponent(nav_logout)
                .addGap(24, 24, 24))
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
                "ID", "Judul Buku", "Author", "Halaman"
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 809, 370));

        btn_batal.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_tambah.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_perbarui.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btn_perbarui.setText("PERBARUI");
        btn_perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbaruiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_buttonLayout = new javax.swing.GroupLayout(panel_button);
        panel_button.setLayout(panel_buttonLayout);
        panel_buttonLayout.setHorizontalGroup(
            panel_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_buttonLayout.createSequentialGroup()
                .addContainerGap(443, Short.MAX_VALUE)
                .addComponent(btn_tambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_buttonLayout.setVerticalGroup(
            panel_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_buttonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        getContentPane().add(panel_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 810, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        pencarianBuku  pencarian = new pencarianBuku();
        pencarian.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
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
               String sql = "DELETE FROM bookmark WHERE id=?";
               PreparedStatement st = conn.prepareStatement(sql);
               st.setString(1, id);
               
               int rowDelete = st.executeUpdate();
               if(rowDelete > 0){
                   JOptionPane.showMessageDialog(this, "Data Berhasil dihapus");
               } 
               st.close();
               
           } catch (Exception e) {
               Logger.getLogger(bookmark.class.getName()).log(Level.SEVERE,null,e);
           }
       }
       
       getData();
       nonAktifbtn();
       aktifbtn();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked

        
        btn_tambah.setEnabled(false);
        btn_hapus.setEnabled(true);
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void nav_ratingulasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_ratingulasanMouseClicked
        ratingUlasan  ratingUlasan = new ratingUlasan();
        ratingUlasan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav_ratingulasanMouseClicked

    private void nav_bookmarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_bookmarkMouseClicked

    }//GEN-LAST:event_nav_bookmarkMouseClicked

    private void nav_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_homeMouseClicked
        Menu  menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav_homeMouseClicked

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
    int selectedRow = tbl_data.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih Baris yang ingin diubah");
        return;
    }

    // Safely retrieve the values from the table with null checks
        String halaman = tbl_data.getValueAt(selectedRow, 3).toString();
        String id = tbl_data.getValueAt(selectedRow, 0).toString();

    try {
        String sql = "UPDATE bookmark SET halaman=? WHERE id=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, halaman);
        st.setString(2, id);

        int rowUpdated = st.executeUpdate();
        if (rowUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Data Berhasil diperbarui");
            getData(); // Refresh the table data
        } else {
            JOptionPane.showMessageDialog(this, "Data Gagal diperbarui");
        }

        st.close();
    } catch (Exception e) {
        Logger.getLogger(ratingUlasan.class.getName()).log(Level.SEVERE, null, e);
    }
    }//GEN-LAST:event_btn_perbaruiActionPerformed

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
            java.util.logging.Logger.getLogger(bookmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookmark().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel nav;
    private javax.swing.JLabel nav_bookmark;
    private javax.swing.JLabel nav_home;
    private javax.swing.JLabel nav_logout;
    private javax.swing.JLabel nav_ratingulasan;
    private javax.swing.JPanel panel_button;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables


    private void nonAktifbtn() {
        btn_hapus.setEnabled(false);
    }

    private void aktifbtn() {
        btn_tambah.setEnabled(true);
        btn_batal.setEnabled(true);
    }    

}

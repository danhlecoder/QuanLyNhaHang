/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import entity.*;
import dao.*;
import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author KLphu
 */
public class KhuyenMaiGUI extends javax.swing.JFrame {

    /**
     * Creates new form KhachHangGUI
     */
    public KhuyenMaiGUI() {
        dskm = new KhuyenMai_DAO();
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        docdulieu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField("Tìm kiếm");
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jPopupMenu1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPopupMenu1.setForeground(new java.awt.Color(178, 28, 77));
        jPopupMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPopupMenu1.setPreferredSize(new java.awt.Dimension(170, 250));

        jMenuItem1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\khachhang.png"));
        jMenuItem1.setText("Khách hàng");
        jMenuItem1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\hoadon.png"));
        jMenuItem2.setText("Hóa đơn");
        jMenuItem2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\bannho.png"));
        jMenuItem3.setText("Bàn");
        jMenuItem3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\thucdon.png"));
        jMenuItem4.setText("Món ăn");
        jMenuItem4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\makhuyenmai.png"));
        jMenuItem5.setText("Mã khuyến mãi");
        jMenuItem5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\doanhthu.png"));
        jMenuItem6.setText("Kết ca");
        jMenuItem6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\dangxuat.png"));
        jMenuItem7.setText("Đăng xuất");
        jMenuItem7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(178, 28, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(jTableModel1 = new javax.swing.table.DefaultTableModel(
            new String [] {
                "STT", "Mã khuyến mãi", "Hạn sử dụng", "Giá trị", "Điều kiện sử dụng"
            }
            , 0));
    jScrollPane1.setViewportView(jTable1);

    jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 1430, -1));

    jLabel5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\tim.png"));
    jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, -1, -1));

    jTextField4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
    jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 200, 380, 40));

    jButton7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jButton7.setText("Tìm");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton7ActionPerformed(evt);
        }
    });
    jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 199, 70, 40));

    jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 78, 1490, 730));

    jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jButton1.setForeground(new java.awt.Color(178, 28, 77));
    jButton1.setText("Khuyến Mãi");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 32, 200, 45));

    jButton2.setBackground(new java.awt.Color(178, 28, 77));
    jButton2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\menu.png"));
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 10, -1, -1));

    jButton6.setBackground(new java.awt.Color(178, 28, 77));
    jButton6.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\trangchu.png"));
    jButton6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton6ActionPerformed(evt);
        }
    });
    jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 13, -1, -1));

    jLabel6.setBackground(new java.awt.Color(178, 28, 77));
    jLabel6.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\user.png"));
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 20, -1, -1));

    jLabel7.setBackground(new java.awt.Color(178, 28, 77));
    jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    TaiKhoan_DAO tk = new TaiKhoan_DAO();
    String a = tk.getname();
    jLabel7.setText(a);
    jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 30, -1, -1));

    getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    jPanel1.getAccessibleContext().setAccessibleParent(jPanel1);

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jPopupMenu1.show(this, jButton2.getX()-88, jButton2.getY()+98);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();

        // Mở cửa sổ mới
        KhachHangGUI khachhanggui = new KhachHangGUI();
        khachhanggui.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();

        // Mở cửa sổ mới
        HoaDonTaoGUI hoadontaogui = new HoaDonTaoGUI();
        hoadontaogui.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.dispose();

        // Mở cửa sổ mới
        BanGUI bangui = new BanGUI();
        bangui.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        this.dispose();

        // Mở cửa sổ mới
        MonAnGUI monangui = new MonAnGUI();
        monangui.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.dispose();

        // Mở cửa sổ mới
        KhuyenMaiGUI khuyenmaigui = new KhuyenMaiGUI();
        khuyenmaigui.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        this.dispose();

        // Mở cửa sổ mới
        KetCaGUI ketcagui = new KetCaGUI();
        ketcagui.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        TaiKhoan_DAO tk = new TaiKhoan_DAO();
        tk.fillZero();
        // Mở cửa sổ mới
        DangNhapGUI dangnhapgui = new DangNhapGUI();
        dangnhapgui.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Ban_DAO banDAO=new Ban_DAO();
        List<Ban> listAllBan=banDAO.getall();
        // Mở cửa sổ mới
        TrangChuGUI trangchugui = new TrangChuGUI(listAllBan, "");
        trangchugui.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        for (int i = jTableModel1.getRowCount() - 1; i >= 0; i--) {
            jTableModel1.removeRow(i);
        }
        String sdt = jTextField4.getText();
        if (sdt.isEmpty()) docdulieu();
        KhuyenMai_DAO ds = new KhuyenMai_DAO();
        List<KhuyenMai> list = ds.fin(sdt);
        count = 0;
        for (KhuyenMai s : list)
        {
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat dfm = new DecimalFormat("#,###đ");
            count++;
            String [] r = {"" + count, s.getMaKhuyenMai(), fm.format(s.getHanSuDung()),"" + s.getGiaTri(), dfm.format(s.getDieuKien())};
            jTableModel1.addRow(r);
        }
        jTable1.setModel(jTableModel1);
    }//GEN-LAST:event_jButton7ActionPerformed
    private void docdulieu(){
        KhuyenMai_DAO ds = new KhuyenMai_DAO();
        List<KhuyenMai> list = ds.getall();
        count = 0;
        for (KhuyenMai s : list)
        {
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat dfm = new DecimalFormat("#,###đ");
            count++;
            String [] r = {"" + count, s.getMaKhuyenMai(), fm.format(s.getHanSuDung()),"" + s.getGiaTri(), dfm.format(s.getDieuKien())};
            jTableModel1.addRow(r);
        }
        jTable1.setModel(jTableModel1);
    }
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhuyenMaiGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.table.DefaultTableModel jTableModel1;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
    private KhuyenMai_DAO dskm;
    private int count = 0;
}
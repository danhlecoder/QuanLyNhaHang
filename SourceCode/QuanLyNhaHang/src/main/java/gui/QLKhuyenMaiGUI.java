/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import entity.*;
import dao.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 *
 * @author KLphu
 */
public class QLKhuyenMaiGUI extends javax.swing.JFrame {

    /**
     * Creates new form KhachHangGUI
     */
    public QLKhuyenMaiGUI() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField("");
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jPopupMenu1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPopupMenu1.setForeground(new java.awt.Color(178, 28, 77));
        jPopupMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPopupMenu1.setPreferredSize(new java.awt.Dimension(190, 250));

        jMenuItem1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\doanhthu.png"));
        jMenuItem1.setText("QL Thống kê");
        jMenuItem1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\makhuyenmai.png"));
        jMenuItem2.setText("QL Khuyến mãi");
        jMenuItem2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\khachhang.png"));
        jMenuItem3.setText("QL Nhân viên");
        jMenuItem3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\qltaikhoan.png"));
        jMenuItem4.setText("QL Tài khoản");
        jMenuItem4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\dangxuat.png"));
        jMenuItem5.setText("Đăng xuất");
        jMenuItem5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

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
                "STT", "Ngày tạo", "Mã khuyến mãi", "Hạn sử dụng", "Giá trị khuyến mãi", "Điều kiện sử dụng"
            }
            , 0));
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable1MouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jTable1);

    jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 1430, -1));

    jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel1.setText("Hạn sử dụng: ");
    jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

    jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel2.setText("Mã Khuyến mãi:");
    jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

    jTextField1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 140, 320, 40));

    jTextField2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 320, 40));

    jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel4.setText("Điều kiện sử dụng: ");
    jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, -1, -1));

    jButton3.setBackground(new java.awt.Color(178, 28, 77));
    jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jButton3.setForeground(new java.awt.Color(255, 255, 255));
    jButton3.setText("Thêm");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });
    jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 140, 40));

    jLabel5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\tim.png"));
    jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, -1, -1));

    jTextField4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
    jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 380, 40));

    jButton4.setBackground(new java.awt.Color(178, 28, 77));
    jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jButton4.setForeground(new java.awt.Color(255, 255, 255));
    jButton4.setText("Cập nhật");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });
    jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 140, 40));

    jButton5.setBackground(new java.awt.Color(178, 28, 77));
    jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jButton5.setForeground(new java.awt.Color(255, 255, 255));
    jButton5.setText("Xóa");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton5ActionPerformed(evt);
        }
    });
    jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 140, 40));

    jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel8.setText("Giá trị khuyến mãi: ");
    jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, -1, -1));

    jTextField5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jPanel3.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 50, 320, 40));
    jPanel3.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 320, 40));

    jButton7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jButton7.setText("Tìm");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton7ActionPerformed(evt);
        }
    });
    jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 210, 70, 40));

    jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 78, 1490, 730));

    jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jButton1.setForeground(new java.awt.Color(178, 28, 77));
    jButton1.setText("QL Khuyến mãi");
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
    jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel7.setText("Quản Lý");
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
    private void xoaRong(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField5.setText("");
        jDateChooser1.setDate(null);
        jTextField2.requestFocus();
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int r = jTable1.getSelectedRow();
        if (r >= 0){
            String maKH = (String) jTable1.getValueAt(r, 2);
            if (dskm.del(maKH))
            {
                jTableModel1.removeRow(r);
                xoaRong();
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        KhuyenMai s = new KhuyenMai(jTextField2.getText(), Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField5.getText()) , new Date(), jDateChooser1.getDate());
        if (dskm.cre(s)){
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat dfm = new DecimalFormat("#,###đ");
            Object [] r = {count, s.getMaKhuyenMai(), fm.format(s.getHanSuDung()),s.getGiaTri(), dfm.format(s.getDieuKien())};
            jTableModel1.addRow(r);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    
        // Mở cửa sổ mới
        QLTrangChu qltrangchu = new QLTrangChu();
        qltrangchu.setVisible(true);
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int r = jTable1.getSelectedRow();
        jTextField2.setText(jTableModel1.getValueAt(r, 2).toString());
        jTextField5.setText(jTableModel1.getValueAt(r, 4).toString());
        jTextField1.setText(jTableModel1.getValueAt(r, 5).toString());
        KhuyenMai_DAO ds = new KhuyenMai_DAO();
        List<KhuyenMai> list = ds.fin(jTableModel1.getValueAt(r, 2).toString());
        for (KhuyenMai s: list){
        jDateChooser1.setDate(s.getHanSuDung());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int r = jTable1.getSelectedRow();
        if (r >= 0){
            KhuyenMai s = new KhuyenMai(jTextField2.getText(), Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField5.getText()) , new Date(), jDateChooser1.getDate());
            if (dskm.upd(s)){
                SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
                DecimalFormat dfm = new DecimalFormat("#,###đ");
                jTable1.setValueAt(jTextField2.getText(), r, 2);
                jTable1.setValueAt(jTextField5.getText(), r, 4);
                jTable1.setValueAt(dfm.format(jTextField1.getText()), r, 6);
                jTable1.setValueAt(fm.format(jDateChooser1.getDate()), r, 3);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();

        // Mở cửa sổ mới
        QLTKDoanhThuGUI qltkdoanhthugui = new QLTKDoanhThuGUI();
        qltkdoanhthugui.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();

        // Mở cửa sổ mới
        QLKhuyenMaiGUI qlkhuyenmaigui = new QLKhuyenMaiGUI();
        qlkhuyenmaigui.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.dispose();

        // Mở cửa sổ mới
        QLNhanVienGUI qlnhanviengui = new QLNhanVienGUI();
        qlnhanviengui.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        this.dispose();

        // Mở cửa sổ mới
        QLTaiKhoanGUI qltaikhoangui = new QLTaiKhoanGUI();
        qltaikhoangui.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        this.dispose();

        // Mở cửa sổ mới
        DangNhapGUI dangnhapgui = new DangNhapGUI();
        dangnhapgui.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    private void docdulieu(){
        KhuyenMai_DAO ds = new KhuyenMai_DAO();
        List<KhuyenMai> list = ds.getall();
        count = 0;
        for (KhuyenMai s : list)
        {
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat dfm = new DecimalFormat("#,###đ");
            Date now = new Date();
            String ngay = fm.format(now);
            count++;
            String [] r = {"" + count, fm.format(s.getNgayTao()) , s.getMaKhuyenMai(), fm.format(s.getHanSuDung()),"" + s.getGiaTri(), dfm.format(s.getDieuKien())};
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
            java.util.logging.Logger.getLogger(QLKhuyenMaiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLKhuyenMaiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLKhuyenMaiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLKhuyenMaiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLKhuyenMaiGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.table.DefaultTableModel jTableModel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
    private KhuyenMai_DAO dskm;
    private int count = 0;
}

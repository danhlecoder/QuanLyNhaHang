/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.PhanCong_DAO;
import entity.*;
import entity.*;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author KLphu
 */
public class QLTrangChu extends javax.swing.JFrame {
    private int count = 0;
    /**
     * Creates new form KhachHangGUI
     */
    public QLTrangChu() {
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(178, 28, 77)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText(",");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 10, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Hôm nay");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 50, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("tháng");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 40, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Thứ ba");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("2024");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 40, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("28");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 20, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText(",");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 220, 10, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("05");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 20, -1));

        jCalendar1.setBackground(new java.awt.Color(255, 255, 255));
        jCalendar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel4.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 230));

        jTable2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable2.setModel(jTableModel2 = new javax.swing.table.DefaultTableModel(
            new String [] {
                "STT", "Mã nhân viên", "Tên nhân viên", "Chức vụ"
            }
            , 0));
    jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable2MouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(jTable2);

    jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 420, 280));

    jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
    jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 330, 30));

    jButton1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\tim.png"));
    jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
    jButton1.setPreferredSize(new java.awt.Dimension(50, 50));
    jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 30, 30));

    jButton4.setBackground(new java.awt.Color(0, 168, 17));
    jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jButton4.setForeground(new java.awt.Color(255, 255, 255));
    jButton4.setText("Chọn");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });
    jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 30));

    jTextField2.setEditable(false);
    jTextField2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jTextField2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField2ActionPerformed(evt);
        }
    });
    jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 302, 130, -1));

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"1", "2", "3" }));
    jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 130, 30));

    jTextField3.setEditable(false);
    jTextField3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jTextField3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField3ActionPerformed(evt);
        }
    });
    jPanel4.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 260, -1));

    jButton5.setText("Chọn Ngày");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton5ActionPerformed(evt);
        }
    });
    jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, 30));

    jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 730));

    jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jTable1.setModel(jTableModel1 = new javax.swing.table.DefaultTableModel(
        new String [] {
            "", "Mã Nhân Viên", "Ca Làm Việc", "Ngày Làm Việc", "Chấm Công"
        }
        , 0));
jScrollPane1.setViewportView(jTable1);

jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 1010, -1));

jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 78, 1490, 730));

jButton2.setBackground(new java.awt.Color(178, 28, 77));
jButton2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\menu.png"));
jButton2.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
    }
    });
    jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 10, -1, -1));

    jLabel6.setBackground(new java.awt.Color(178, 28, 77));
    jLabel6.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\user.png"));
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 20, -1, -1));

    jLabel7.setBackground(new java.awt.Color(178, 28, 77));
    jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel7.setText(" Quản Lý");
    jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 30, -1, -1));

    jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jButton3.setForeground(new java.awt.Color(178, 28, 77));
    jButton3.setText("Lịch phân công");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });
    jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 200, 45));

    getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    jPanel1.getAccessibleContext().setAccessibleParent(jPanel1);

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jPopupMenu1.show(this, jButton2.getX()-88, jButton2.getY()+98);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();

        // Mở cửa sổ mới
        QLTKDoanhThuGUI qltkdoanhthugui = new QLTKDoanhThuGUI();
        qltkdoanhthugui.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        this.dispose();

        // Mở cửa sổ mới
        DangNhapGUI dangnhapgui = new DangNhapGUI();
        dangnhapgui.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        PhanCong_DAO pcd = new PhanCong_DAO();
        Date ngay = jCalendar1.getDate();
        int ca = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        int r = jTable2.getSelectedRow();
        String manv = "";
        if (r >= 0) {
            manv = jTableModel2.getValueAt(r, 1).toString();
        }
        else 
            JOptionPane.showMessageDialog(this, "Chọn nhân viên");
        PhanCong pc = new PhanCong(manv, ca, ngay, 0);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(ngay);
        if (pcd.cre(pc)) {
            Object[] rr = {count+1, manv, ca, date, 0}; 
            jTableModel1.addRow(rr);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Date selDay = jCalendar1.getDate();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(selDay);
        jTextField3.setText(date);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int r = jTable2.getSelectedRow();
        jTextField2.setText(jTableModel2.getValueAt(r, 1).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void docdulieu(){
        docbangnv();
        docbangphancong();
    }
    
    private void docbangnv(){
        PhanCong_DAO pc = new PhanCong_DAO();
        List<NhanVien> list = pc.getallnv();
        count = 0;
        for (NhanVien e : list){
            count++;
            String [] r = {count+"", e.getMaNV(), e.getHotenNV(), e.getChucVu()};
            jTableModel2.addRow(r);
        }
        jTable2.setModel(jTableModel2);
    }
    
    private void docbangphancong(){
        PhanCong_DAO pc = new PhanCong_DAO();
        List<PhanCong> list = pc.getallpc();
        int count = 0;
        for (PhanCong e : list){
            count++;
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
            String day =fm.format(e.getngay());
            String [] r = {count+"", e.getmaNV(), e.getca()+"", day, e.getchamCong()+""};
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
            java.util.logging.Logger.getLogger(QLTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new QLTrangChu().setVisible(true);
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
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.table.DefaultTableModel jTableModel1;
    private javax.swing.JTable jTable2;
    private javax.swing.table.DefaultTableModel jTableModel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}

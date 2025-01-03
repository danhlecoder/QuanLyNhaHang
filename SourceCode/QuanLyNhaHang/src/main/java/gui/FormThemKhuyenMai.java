/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.Ban_DAO;
import dao.KhachHang_DAO;
import dao.KhuyenMai_DAO;
import entity.Ban;
import entity.KhachHang;
import entity.KhuyenMai;
import java.awt.Window;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author KLphu
 */
public class FormThemKhuyenMai extends javax.swing.JFrame {
    private String mahd;
    private int tongtienhd;
    /**
     * Creates new form NewJFrame
     */
    public FormThemKhuyenMai(String maHD, int tienhd) {
        dskh = new KhachHang_DAO();
        initComponents();
        docdulieu();
        this.mahd = maHD;
        this.tongtienhd = tienhd;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1295, 683));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1295, 683));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 168, 17));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Chọn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 170, 40));

        jTextField1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 530, 36));

        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(jTableModel1 = new javax.swing.table.DefaultTableModel(
            new String [] {
                "STT", "Mã khuyến mãi", "Hạn sử dụng", "Giá trị", "Điều kiện sử dụng"
            }
            , 0));
    jScrollPane1.setViewportView(jTable1);

    jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 1210, 400));

    jLabel1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\tim.png"));
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, -1, -1));

    getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                window.dispose();
            }
        }
        
        int r = jTable1.getSelectedRow();
        String t = "";
        if (r >= 0) {
            int dk = Integer.parseInt(jTableModel1.getValueAt(r, 3).toString());
            if (tongtienhd < dk) {
                JOptionPane.showMessageDialog(this, "Không thỏa điền kiện");
            }
            else {
                t = jTableModel1.getValueAt(r, 1).toString();
                ThanhToanGUI thanhtoangui = new ThanhToanGUI(mahd, t);
                thanhtoangui.setVisible(true);
            }
        }
        else 
            JOptionPane.showMessageDialog(this, "Chọn Mã khuyến mãi!!!");
        // Mở cửa sổ mới
    }//GEN-LAST:event_jButton1ActionPerformed

    private void docdulieu(){
        KhuyenMai_DAO ds = new KhuyenMai_DAO();
        List<KhuyenMai> list = ds.getall();
        //DecimalFormat dfm = new DecimalFormat("#,###đ");
        jTextField1.setText(tongtienhd+"");
        count = 0;
        for (KhuyenMai s : list)
        {
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
            count++;
            String [] r = {"" + count, s.getMaKhuyenMai(), fm.format(s.getHanSuDung()),"" + s.getGiaTri(), s.getDieuKien()+""};
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
            java.util.logging.Logger.getLogger(FormThemKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThemKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThemKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThemKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormThemKhuyenMai("", 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.table.DefaultTableModel jTableModel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    private KhachHang_DAO dskh;
    private int count = 0;
}

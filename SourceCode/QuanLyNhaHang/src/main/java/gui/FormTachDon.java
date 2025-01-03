/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.*;
import entity.*;
import entity.MonAn;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author KLphu
 */
public class FormTachDon extends javax.swing.JFrame {
    private FormCDHD_DAO f = new FormCDHD_DAO();
    private javax.swing.JTextField[] jTF = new javax.swing.JTextField[100];
    private javax.swing.JLabel[] jL = new javax.swing.JLabel[100];
    private List<MonAn> ma;
    private String maHD;
    private int count = 0, z = 0;
    /**
     * Creates new form FormTachDon
     */
    public FormTachDon(String maHD) {
        initComponents();
        this.maHD = maHD;
        docdulieu(maHD);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(178, 28, 77));
        Ban_DAO b = new Ban_DAO();
        String ten = b.getten();
        jLabel2.setText(ten);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, -1));

        jComboBox3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(178, 28, 77));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jComboBox3.setBorder(null);
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 95, 230, 30));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 780, 350));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(178, 28, 77));
        jLabel3.setText("Tách đến");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 70, -1));

        jButton1.setBackground(new java.awt.Color(0, 168, 17));
        jButton1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thực hiện");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 560, 160, 30));

        jPanel3.setBackground(new java.awt.Color(239, 239, 239));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(178, 28, 77));
        jLabel4.setText("STT");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 12, 40, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(178, 28, 77));
        jLabel5.setText("Tên thực đơn");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 12, 110, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(178, 28, 77));
        jLabel6.setText("SL trên đơn gốc");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 12, 130, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(178, 28, 77));
        jLabel1.setText("SL tách");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 12, 70, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 780, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean dk = false;
        for (int i = 1; i <= count; i++){
            int t1 = Integer.parseInt(jTF[i].getText());
            int t2 = Integer.parseInt(jL[i].getText());
            if (t1 > t2){
                JOptionPane.showMessageDialog(this, "Số lượng cần tách không quá số lượng ở HD gốc");
                break;
            }
            else{
                dk = true;
            }
        }
        if (dk){
            TrangChu_DAO tc = new TrangChu_DAO();
            TaiKhoan_DAO tk = new TaiKhoan_DAO();
            FormCDHD_DAO ds = new FormCDHD_DAO();
            Ban_DAO b = new Ban_DAO();
            b.upd("Bận", jComboBox3.getSelectedItem().toString());
            String manv = tk.getma();
            String mahd = tc.phatsinh(manv);
            Date now = new Date();
            String makh = ds.getkh(maHD);
            int c = 0;
            for (MonAn a: ma){
                c++;
                int t1 = Integer.parseInt(jTF[c].getText());
                int t2 = Integer.parseInt(jL[c].getText());
                tc.updcthd(t2-t1, maHD, a.getMaMonAn());
                a.setsl(t1);
            }
            HoaDon hd = new HoaDon(mahd, now, new KhachHang(makh), new NhanVien(manv), null, 10, null, new Ban(jComboBox3.getSelectedItem().toString()), ma);
            if (tc.crehd(hd)) {
                for(MonAn e:ma){
                    if(e.getsl()!=0)
                        tc.crecthd(e, mahd);
                }
                JOptionPane.showMessageDialog(this, "Tách thành công");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void docdulieu(String mahd){
        FormCDHD_DAO ds = new FormCDHD_DAO();
        List<MonAn> list = ds.getall(mahd);
        ma = list;
        count = 0;
        List<Ban> dsb = ds.getallban();
        for (Ban bb: dsb){
            jComboBox3.addItem(bb.getMaBan());
        }
        for (MonAn s : list)
        {
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat dfm = new DecimalFormat("#,###đ");
            
            count++;
            jTF[count] = new javax.swing.JTextField();
            javax.swing.JPanel jP = paint1mon(count, s.getTenMonAn(), s.getsl());
            jTF[count].setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
            jTF[count].setForeground(new java.awt.Color(178, 28, 77));
            jTF[count].setHorizontalAlignment(javax.swing.JTextField.CENTER);
            jTF[count].setText("0");
            jTF[count].setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(178, 28, 77)));
            jP.add(jTF[count], new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 60, 20));
            jPanel2.add(jP, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6+z, 770, 40));
            z+=40;
        }
    }
    
    private javax.swing.JPanel paint1mon(int c, String ten, int sl){
        javax.swing.JPanel jP1 = new javax.swing.JPanel();
        javax.swing.JLabel jL1 = new javax.swing.JLabel();
        javax.swing.JLabel jL2 = new javax.swing.JLabel();
        jL[c] = new javax.swing.JLabel();
        
        jP1.setBackground(new java.awt.Color(255, 255, 255));
        jP1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jL1.setForeground(new java.awt.Color(178, 28, 77));
        jL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL1.setText(c+"");
        jP1.add(jL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 16, 37, -1));

        jL2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jL2.setForeground(new java.awt.Color(178, 28, 77));
        jL2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jL2.setText(ten);
        jP1.add(jL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 16, 245, -1));

        jL[c].setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jL[c].setForeground(new java.awt.Color(178, 28, 77));
        jL[c].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL[c].setText(sl+"");
        jP1.add(jL[c], new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 16, 37, -1));
        return jP1;
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
            java.util.logging.Logger.getLogger(FormTachDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTachDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTachDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTachDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTachDon().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;
import dao.HoaDonXuat_DAO;
import entity.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
/**
 *
 * @author KLphu
 */
public class HoaDonXuatGUI extends javax.swing.JPanel {

    /**
     * Creates new form HoaDonXuatGUI
     */
    public HoaDonXuatGUI() {
        dshdx = new HoaDonXuat_DAO();
        initComponents();
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

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\tim.png"));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 140, -1, -1));

        jTextField1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 140, 340, 36));

        jTable1.setModel(jTableModel1 = new javax.swing.table.DefaultTableModel(
            new String [] {
                "STT", "Mã hóa đơn", "Ngày xuất hóa đơn", "Tên khách hàng", "Tên nhân viên", "Mã bàn", "Tổng tiền"
            }
            , 0));
    jScrollPane1.setViewportView(jTable1);

    jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 1350, -1));

    jButton7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jButton7.setText("Tìm");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton7ActionPerformed(evt);
        }
    });
    jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 140, 70, 40));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1490, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        for (int i = jTableModel1.getRowCount() - 1; i >= 0; i--) {
            jTableModel1.removeRow(i);
        }
        String sdt = jTextField1.getText();
        if (sdt.isEmpty()) docdulieu();
        HoaDonXuat_DAO ds = new HoaDonXuat_DAO();
        List<HoaDon> list = ds.fin(sdt);
        count = 0;
        for (HoaDon s : list)
        {
            if (s.getNgayXuat() == null) continue;
            if (s.getMaMonAn() == null) continue;
            count++;
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat dfm = new DecimalFormat("#,###đ");
            int ttien = tongtien(s); 
            String tt;
            if (ttien == 0) tt = "";
            else tt = ""+dfm.format(ttien);

            String [] r = {"" + count, s.getMaHoaDon(),fm.format(s.getNgayXuat()), s.getMaKH().getMaKH(), s.getMaNV().getMaNV(), s.getMaBan().getMaBan(), ""+ tt};
            jTableModel1.addRow(r);
        }  
        jTable1.setModel(jTableModel1);
    }//GEN-LAST:event_jButton7ActionPerformed
    private void docdulieu(){
        HoaDonXuat_DAO ds = new HoaDonXuat_DAO();
        List<HoaDon> list = ds.getall();
        count = 0;
        for (HoaDon s : list)
        {
            if (s.getNgayXuat() == null) continue;
            if (s.getMaMonAn() == null) continue;
            count++;
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat dfm = new DecimalFormat("#,###đ");
            int ttien = tongtien(s); 
            String tt;
            if (ttien == 0) tt = "";
            else tt = ""+dfm.format(ttien);
            
            String [] r = {"" + count, s.getMaHoaDon(),fm.format(s.getNgayXuat()), s.getMaKH().getMaKH(), s.getMaNV().getMaNV(), s.getMaBan().getMaBan(), ""+ tt};
            jTableModel1.addRow(r);
        }  
        jTable1.setModel(jTableModel1);
    }
    
    public int tongtien(HoaDon s){
        int t = 0;
        for (MonAn ma : s.getMaMonAn())
        {
            int km = ma.getGiaTien()*ma.getKhuyenMai();
            //System.out.println(km);
            int c = ma.getGiaTien() - km/100;
            //System.out.println(c);
            t += c;
        }
        //System.out.println("tongtien MonAn: "+t);
        for (KhuyenMai km : s.getMaKhuyenMai())
        {
            int c = t*km.getGiaTri();
            c /= 100;
            //System.out.println("km: "+c);
            t -= c;
        }
        int thue = t*s.getThueVAT();
        thue /= 100;
        t += thue;
        return t;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.table.DefaultTableModel jTableModel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    private HoaDonXuat_DAO dshdx;
    private int count = 0;
}

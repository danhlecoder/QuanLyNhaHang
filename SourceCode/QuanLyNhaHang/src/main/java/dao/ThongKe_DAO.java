/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConnectMSSQL;
import entity.Ban;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.MonAn;
import entity.NhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ThongKe_DAO {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public ThongKe_DAO() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        
        public int getTongHD(String t1, String t2){ 
            try {
                
                int max = 0;
                Statement s = conn.createStatement();
                String query = "SELECT COUNT(DISTINCT MaHD) FROM HoaDon where NgayXuat between '"+t1+"' and '"+t2+"'";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    max = rs.getInt(1);
                }
                return max;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        
        public List<HoaDon> getall(String t1, String t2){
            List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT hd.MaHD, hd.NgayXuat, kh.TenKH, nv.HoTenNV, hd.MaBan, hd.NgayLap, hd.ThueVAT " +
                                                      "FROM HoaDon hd " +
                                                      "join NhanVien nv on nv.MaNV = hd.MaNV " +
                                                      "join KhachHang kh on kh.MaKH = hd.MaKH " +
                                                      "left join CHI_TIET_HOADON ct on ct.MaHD = hd.MaHD " +
                                                      "where hd.NgayXuat between '"+t1+"' and '"+t2+"'");
			while (rs.next()) {
				String mahd = rs.getString("MaHD");
                                Date ngx = rs.getDate("NgayXuat");
                                Date ngt = rs.getDate("NgayLap");
                                int t = rs.getInt("ThueVAT");
                                String TenKH = rs.getString("TenKH");
                                String HoTenNV = rs.getString("HoTenNV");
                                String MaBan = rs.getString("MaBan");
                                Statement s1 = conn.createStatement();
                                ResultSet rs1 = s1.executeQuery("select k.MaKhuyenMai, k.GiaTri " +
                                                                "from CHITIET_KHUYENMAI_HOADON ct " +
                                                                "join KhuyenMai k on k.MaKhuyenMai = ct.MaKhuyenMai " +
                                                                "where MaHD = '"+mahd+"'");
                                List<KhuyenMai> lkm = new ArrayList<KhuyenMai>();
                                while (rs1.next()) {
                                    String mkm = rs1.getString("MaKhuyenMai");
                                    int gt = rs1.getInt("GiaTri");
                                    KhuyenMai km = new KhuyenMai(mkm, gt);
                                    lkm.add(km);
                                }
                                Statement s2 = conn.createStatement();
                                ResultSet rs2 = s2.executeQuery("select m.MaMonAn, m.GiaTien, ct.SoLuongMonAn as sl, m.GiaTri as km " +
                                                                "from CHI_TIET_HOADON ct " +
                                                                "join MonAn m on m.MaMonAn = ct.MaMonAn " +
                                                                "where MaHD = '"+mahd+"'");
                                List<MonAn> lma = new ArrayList<MonAn>();
                                while (rs2.next()) {
                                    String mma = rs2.getString("MaMonAn");
                                    int gt = rs2.getInt("GiaTien");
                                    int sl = rs2.getInt("sl");
                                    int km = rs2.getInt("km");
                                    for (int i = 0; i < sl; i++){
                                        MonAn ma = new MonAn(mma, gt, km);
                                        lma.add(ma);
                                    }
                                }
                                KhachHang kh = new KhachHang(TenKH);
                                NhanVien nv = new NhanVien(HoTenNV);
                                Ban b = new Ban(MaBan);
				HoaDon tk = new HoaDon(mahd, ngt, kh, nv, lkm, t, ngx, b, lma);
				list.add(tk);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
        
}

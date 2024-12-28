/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import config.ConnectMSSQL;
import entity.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Dell
 */
public class HoaDonTao_DAO {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public HoaDonTao_DAO() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        
        public List<HoaDon> getall() {
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT hd.MaHD, hd.NgayXuat, kh.TenKH, nv.HoTenNV, hd.MaBan, hd.NgayLap, hd.ThueVAT " +
                                                      "FROM HoaDon hd " +
                                                      "join NhanVien nv on nv.MaNV = hd.MaNV " +
                                                      "join KhachHang kh on kh.MaKH = hd.MaKH " +
                                                      "left join CHI_TIET_HOADON ct on ct.MaHD = hd.MaHD " +
                                                      "where hd.NgayXuat IS NULL");
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
        public static boolean startsWithDateRegex(String str) {
            return str.matches("^(>|<|=|between)");
        }
        public List<HoaDon> fin(String tam) {
		List<HoaDon> list = new ArrayList<HoaDon>();
		try{
                    Statement s = conn.createStatement();
                    ResultSet rs = null;
                    
                        s = conn.createStatement();
			rs = s.executeQuery("SELECT hd.MaHD, hd.NgayXuat, kh.TenKH, nv.HoTenNV, hd.MaBan, hd.NgayLap, hd.ThueVAT " +
                                                      "FROM HoaDon hd " +
                                                      "join NhanVien nv on nv.MaNV = hd.MaNV " +
                                                      "join KhachHang kh on kh.MaKH = hd.MaKH " +
                                                      "left join CHI_TIET_HOADON ct on ct.MaHD = hd.MaHD " + 
                                                      "where lower(kh.TenKH) like lower(N'%" + tam +"%')");
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
                        s = conn.createStatement();
			rs = s.executeQuery("SELECT hd.MaHD, hd.NgayXuat, kh.TenKH, nv.HoTenNV, hd.MaBan, hd.NgayLap, hd.ThueVAT " +
                                                      "FROM HoaDon hd " +
                                                      "join NhanVien nv on nv.MaNV = hd.MaNV " +
                                                      "join KhachHang kh on kh.MaKH = hd.MaKH " +
                                                      "left join CHI_TIET_HOADON ct on ct.MaHD = hd.MaHD " + 
                                                      "where lower(nv.HoTenNV) like lower(N'%" + tam +"%')");
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
                        s = conn.createStatement();
			rs = s.executeQuery("SELECT hd.MaHD, hd.NgayXuat, kh.TenKH, nv.HoTenNV, hd.MaBan, hd.NgayLap, hd.ThueVAT " +
                                                      "FROM HoaDon hd " +
                                                      "join NhanVien nv on nv.MaNV = hd.MaNV " +
                                                      "join KhachHang kh on kh.MaKH = hd.MaKH " +
                                                      "left join CHI_TIET_HOADON ct on ct.MaHD = hd.MaHD " + 
                                                      "where lower(ct.MaBan) like lower(N'%" + tam +"%')");
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
                        s = conn.createStatement();
			rs = s.executeQuery("SELECT hd.MaHD, hd.NgayXuat, kh.TenKH, nv.HoTenNV, hd.MaBan, hd.NgayLap, hd.ThueVAT " +
                                                      "FROM HoaDon hd " +
                                                      "join NhanVien nv on nv.MaNV = hd.MaNV " +
                                                      "join KhachHang kh on kh.MaKH = hd.MaKH " +
                                                      "left join CHI_TIET_HOADON ct on ct.MaHD = hd.MaHD " + 
                                                      "where lower(hd.MaHD) like lower(N'%" + tam +"%')");
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

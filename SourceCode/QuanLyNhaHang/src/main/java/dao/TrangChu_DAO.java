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
/**
 *
 * @author Dell
 */
public class TrangChu_DAO {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public TrangChu_DAO() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        
        public List<HoaDon> getall(String maban) {
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT hd.MaHD, hd.NgayXuat, kh.MaKH, hd.MaBan, hd.NgayLap, hd.ThueVAT " +
                                                      "FROM HoaDon hd " +
                                                      "join KhachHang kh on kh.MaKH = hd.MaKH " +
                                                      "where hd.NgayXuat IS NULL and hd.Maban = '" + maban + "'");
			while (rs.next()) {
				String mahd = rs.getString("MaHD");
                                Date ngx = rs.getDate("NgayXuat");
                                Date ngt = rs.getDate("NgayLap");
                                int t = rs.getInt("ThueVAT");
                                String TenKH = rs.getString("MaKH");
                                String HoTenNV = "";
                                String MaBan = rs.getString("MaBan");
                                Statement s1 = conn.createStatement();
                                List<KhuyenMai> lkm = new ArrayList<KhuyenMai>();
                                Statement s2 = conn.createStatement();
                                ResultSet rs2 = s2.executeQuery("select m.TenMonAn, m.GiaTien, ct.SoLuongMonAn as sl, m.GiaTri as km " +
                                                                "from CHI_TIET_HOADON ct " +
                                                                "join MonAn m on m.MaMonAn = ct.MaMonAn " +
                                                                "where MaHD = '"+mahd+"'");
                                List<MonAn> lma = new ArrayList<MonAn>();
                                while (rs2.next()) {
                                    String mma = rs2.getString("TenMonAn");
                                    int gt = rs2.getInt("GiaTien");
                                    int sl = rs2.getInt("sl");
                                    int km = rs2.getInt("km");
                                    MonAn ma = new MonAn(mma, gt, km, sl);
                                    lma.add(ma);
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
        public String phatsinh(String mavn) {
		try {
                        int max = 0;
			Statement s = conn.createStatement();
			String query = "SELECT COUNT(*)FROM HoaDon";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
                            max = rs.getInt(1)+1;
                        }
                        String t;
                        if (max > 0 && max < 10)
                            t = "0000"+max;
                        else if (max < 100)
                            t = "000"+max;
                        else if (max < 1000)
                            t = "00"+max;
                        else if (max < 10000)
                            t = "0"+max;
                        else t = "" + max;
                    String ma = mavn.substring(2, 5);
                    Date d = new Date();
                    int day = 0;
                    String dd = "";
                    day = d.getDate();
                    if (day < 10)
                        dd = "0"+day;
                    else dd = day + "";
                    int month;
                    String mm = "";
                    month = d.getMonth()+1;
                    if (month < 10)
                        mm = "0"+month;
                    else mm = month + "";
                    return "HD" + t + "" + ma +""+dd+mm;
		} catch (Exception e) {
			e.printStackTrace();
		}
                return "";
	}
        
        public boolean crehd(HoaDon hd) {
            int n = 0;
            String query = "insert into HoaDon values(?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, hd.getMaHoaDon());
                Date nlul = hd.getNgayLap();
                long timeInMillis = nlul.getTime();
                java.sql.Date sqlDate = new java.sql.Date(timeInMillis);
                s.setDate(2, sqlDate);
                s.setString(3, hd.getMaKH().getMaKH());
                s.setString(4, hd.getMaNV().getMaNV());
                s.setString(5, null);
                s.setInt(6, 10);
                s.setDate(7, null);
                s.setString(8, hd.getMaBan().getMaBan());
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public String phatsinhct() {
		try {
                        int max = 0;
			Statement s = conn.createStatement();
			String query = "SELECT COUNT(*)FROM CHI_TIET_HOADON";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
                            max = rs.getInt(1)+1;
                        }
                        String t;
                        if (max > 0 && max < 10)
                            t = "00"+max;
                        else if (max < 100)
                            t = "0"+max;
                        else t = "" + max;
                        return "CTHD" + t;
		} catch (Exception e) {
			e.printStackTrace();
		}
                return "";
	}
        
        public boolean crecthd(MonAn ma, String mahd) {
            int n = 0;
            String query = "insert into CHI_TIET_HOADON values(?, ?, ?, ?)";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, phatsinhct());
                s.setString(2, mahd);
                s.setString(3, ma.getMaMonAn());
                s.setInt(4, ma.getsl());
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public boolean updcthd(int sl, String tt, String ma) {
            int n = 0;
            String query = "update CHI_TIET_HOADON set SoLuongMonAn = ? Where MaHD = ? and MaMonAn = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setInt(1, sl);
                s.setString(2, tt);
                s.setString(3, ma);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
}

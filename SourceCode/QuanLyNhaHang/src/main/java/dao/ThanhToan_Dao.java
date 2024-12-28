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
import entity.Phieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ThanhToan_Dao {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public ThanhToan_Dao() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        
        public List<MonAn> getall(String maHD) {
		List<MonAn> list = new ArrayList<MonAn>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select cthd.MaMonAn, ma.TenMonAn, cthd.SoLuongMonAn, ma.Size, ma.GiaTri, ma.GiaTien " +
                                                      "from CHI_TIET_HOADON cthd " +
                                                      "join MonAn ma on cthd.MaMonAn = ma.MaMonAn " + 
                                                      "where cthd.MaHD = '"+ maHD +"'");
			while (rs.next()) {
                                String ma = rs.getString("MaMonAn");
				String Ten = rs.getString("TenMonAn");
                                int sl = rs.getInt("SoLuongMonAn");
                                String Size = rs.getString("Size");
                                int km = rs.getInt("GiaTri");
                                int gia = rs.getInt("GiaTien");
                                MonAn m = new MonAn(ma, Ten, Size, gia, km, sl);
                                list.add(m);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
        public String gettenkh(String mahd) {
            try {
                Statement s = conn.createStatement();
                String query = "select kh.TenKH from HoaDon hd "
                        + "join KhachHang kh on kh.MaKH = hd.MaKH "
                        + "where MaHD = '"+mahd+"'";
                ResultSet rs = s.executeQuery(query);
                String ht = "";
                while (rs.next()){
                    ht = rs.getString("TenKH");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "error";
        }
        
        public String gettennv(String mahd) {
            try {
                Statement s = conn.createStatement();
                String query = "select kh.HoTenNV from HoaDon hd "
                        + "join NhanVien kh on kh.MaNV = hd.MaNV "
                        + "where MaHD = '"+mahd+"'";
                ResultSet rs = s.executeQuery(query);
                String ht = "";
                while (rs.next()){
                    ht = rs.getString("HoTenNV");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "error";
        }
        
        public boolean crephieu(Phieu p) {
            int n = 0;
            String query = "insert into PHIEU values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, p.getMaPhieu());
                Date nlul = p.getNgay();
                long timeInMillis = nlul.getTime();
                java.sql.Date sqlDate = new java.sql.Date(timeInMillis);
                s.setDate(2, sqlDate);
                s.setInt(3, p.getTo1());
                s.setInt(4, p.getTo2());
                s.setInt(5, p.getTo5());
                s.setInt(6, p.getTo10());
                s.setInt(7, p.getTo20());
                s.setInt(8, p.getTo50());
                s.setInt(9, p.getTo100());
                s.setInt(10, p.getTo200());
                s.setInt(11, p.getTo500());
                s.setInt(12, p.getTienChuyenKhoan());
                s.setString(13, p.getMaHD());
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        public boolean upd(Date d, String ma) {
            int n = 0;
            String query = "update HoaDon set NgayXuat = ? Where MaHD = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                long timeInMillis = d.getTime();
                java.sql.Date sqlDate = new java.sql.Date(timeInMillis);
                s.setDate(1, sqlDate);
                s.setString(2, ma);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        public int getkm(String makm) {
            try {
                Statement s = conn.createStatement();
                String query = "select GiaTri from KhuyenMai where MaKhuyenMai = '" + makm +"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    ht = rs.getInt("GiaTri");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
}

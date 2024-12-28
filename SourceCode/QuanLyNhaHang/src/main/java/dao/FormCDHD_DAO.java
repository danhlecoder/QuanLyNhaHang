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
public class FormCDHD_DAO {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public FormCDHD_DAO() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        
        public List<MonAn> getall(String maHD) {
		List<MonAn> lma = new ArrayList<MonAn>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select cthd.MaMonAn, ma.TenMonAn, cthd.SoLuongMonAn " +
                                                      "from CHI_TIET_HOADON cthd " +
                                                      "join MonAn ma on cthd.MaMonAn = ma.MaMonAn " + 
                                                      "where cthd.MaHD = '"+ maHD +"'");
			while (rs.next()) {
				String ma = rs.getString("MaMonAn");
				String Ten = rs.getString("TenMonAn");
                                int SoLuongMonAn = rs.getInt("SoLuongMonAn");
                                MonAn man = new MonAn(ma, Ten, SoLuongMonAn);
                                lma.add(man);
			}
			return lma;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
        public List<Ban> getallban() {
		List<Ban> lb = new ArrayList<Ban>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select MaBan from Ban " +
                                                      "where TrangThai = N'Trống'");
			while (rs.next()) {
				String ma = rs.getString("MaBan");
                                Ban man = new Ban(ma);
                                lb.add(man);
			}
			return lb;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
        public String getkh(String mahd) {
            String kh = "";
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select MaKH from HoaDon " +
                                                      "where MaHD = '"+mahd+"'");
			while (rs.next()) {
                                String makh = rs.getString("MaKH");
                                kh = makh;
			}
			return kh;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
        }
        public boolean upd(String mahd, String maBan) {
            int n = 0;
            String query = "update HoaDon set MaBan = ? Where MaHD = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, maBan);
                s.setString(2, mahd);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
}

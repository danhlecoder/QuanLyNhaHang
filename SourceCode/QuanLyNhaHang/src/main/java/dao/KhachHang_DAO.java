/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.ConnectMSSQL;
import entity.KhachHang;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class KhachHang_DAO {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public KhachHang_DAO() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        
        public List<KhachHang> getall() {
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from khachhang");
			while (rs.next()) {
				String makh = rs.getString("MaKH");
				String tenkh = rs.getString("TenKH");
                                String sdt = rs.getString("SDT");
				boolean gt = rs.getBoolean("GioiTinh");
				KhachHang tk = new KhachHang(makh, tenkh, sdt , gt);
				list.add(tk);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
        
        public String phatsinh() {
		try {
                        int max = 0;
			Statement s = conn.createStatement();
			String query = "SELECT COUNT(*)FROM KhachHang";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
                            max = rs.getInt(1);
                        }
                        String t;
                        if (max > 0 && max < 10)
                            t = "00"+max;
                        else if (max < 100)
                            t = "0"+max+1;
                        else t = "" + max+1;
                        return "KH" + t;
		} catch (Exception e) {
			e.printStackTrace();
		}
                return "";
	}
        
        public boolean cre(KhachHang k) {
            int n = 0;
            String query = "insert into KhachHang values(?, ?, ?, ?)";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, k.getMaKH());
                s.setString(2, k.getTenKH());
                s.setString(3, k.getSDT());
                int gt = 0;
                if (k.getGioiTinh()) gt = 1;
                s.setInt(4, gt);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public boolean del(String maKH) {
            int n = 0;
            String query = "delete from KhachHang where MaKH = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, maKH);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public boolean upd(KhachHang k) {
            int n = 0;
            String query = "update KhachHang set TenKH = ?, SDT = ?, GioiTinh = ? Where MaKH = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, k.getTenKH());
                s.setString(2, k.getSDT());
                s.setBoolean(3, k.getGioiTinh());
                s.setString(4, k.getMaKH());
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public List<KhachHang> fin(String t) {
                if (t.isEmpty()) return null;
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {
			Statement s = conn.createStatement();
                        String query = "select * from khachhang where SDT LIKE '%" + t + "%'";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				String makh = rs.getString("MaKH");
				String tenkh = rs.getString("TenKH");
                                String sdt = rs.getString("SDT");
				boolean gt = rs.getBoolean("GioiTinh");
				KhachHang tk = new KhachHang(makh, tenkh, sdt , gt);
				list.add(tk);
			}
                        query = "select * from khachhang where LOWER(TenKH) LIKE LOWER(N'%" + t + "%')";
			rs = s.executeQuery(query);
			while (rs.next()) {
				String makh = rs.getString("MaKH");
				String tenkh = rs.getString("TenKH");
                                String sdt = rs.getString("SDT");
				boolean gt = rs.getBoolean("GioiTinh");
				KhachHang tk = new KhachHang(makh, tenkh, sdt , gt);
				list.add(tk);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
}

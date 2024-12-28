/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConnectMSSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.*;

/**
 *
 * @author Dell
 */
public class NhanVien_DAO {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public NhanVien_DAO() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        
        public List<NhanVien> getall() {
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from NhanVien");
			while (rs.next()) {
				String manv = rs.getString("maNV");
				String tenNV = rs.getString("hotenNV");
                                String sdt = rs.getString("sDT");
                                String canCuoc = rs.getString("canCuoc");
                                String diachi = rs.getString("diaChi");
                                String email = rs.getString("email");
                                int caLamViec = rs.getInt("caLamViec");
                                String trangThai = rs.getString("trangThai");
                                String chucVu = rs.getString("chucVu");
				boolean gt = rs.getBoolean("gioiTinh");
				NhanVien tk = new NhanVien(manv, tenNV, sdt , canCuoc, diachi, email, caLamViec, trangThai, chucVu, gt);
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
			String query = "SELECT COUNT(*)FROM NhanVien";
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
                        return "NV" + max+1;
		} catch (Exception e) {
			e.printStackTrace();
		}
                return "";
	}
        
        public boolean cre(NhanVien k) {
            int n = 0;
            String query = "insert into NhanVien values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, k.getMaNV());
                s.setString(2, k.getHotenNV());
                s.setString(3, k.getsDT());
                s.setString(4, k.getCanCuoc());
                s.setString(5, k.getDiaChi());
                s.setString(6, k.getEmail());
                s.setInt(7, k.getCaLamViec());
                s.setString(8, k.getTrangThai());
                s.setString(9, k.getChucVu());
                int gt = 0;
                if (k.isGioiTinh()) gt = 1;
                s.setInt(10, gt);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public boolean del(String maNV) {
            int n = 0;
            String query = "delete from NhanVien where MaNV = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, maNV);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public boolean upd(NhanVien k) {
            int n = 0;
            String query = "update NhanVien set hotenNV = ?, sDT = ?, canCuoc = ?, diaChi = ?, email = ?, caLamViec = ?, trangThai = ?, chucVu = ?, gioiTinh = ? Where maNV = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, k.getHotenNV());
                s.setString(2, k.getsDT());
                s.setString(3, k.getCanCuoc());
                s.setString(4, k.getDiaChi());
                s.setString(5, k.getEmail());
                s.setInt(6, k.getCaLamViec());
                s.setString(7, k.getTrangThai());
                s.setString(8, k.getChucVu());
                s.setBoolean(9, k.isGioiTinh());
                s.setString(10, k.getMaNV());
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
}

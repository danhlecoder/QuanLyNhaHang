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
import entity.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class TaiKhoan_DAO {
	Connection conn = null;
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public TaiKhoan_DAO() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}

	public List<TaiKhoan> getall() {
		List<TaiKhoan> list = new ArrayList<TaiKhoan>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select TenDangNhap, MatKhau, TrangThai, hoatDong from taikhoan");
			while (rs.next()) {
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				boolean trangThai = rs.getBoolean("trangThai");
                                boolean hoatDong = rs.getBoolean("hoatDong");
				TaiKhoan tk = new TaiKhoan(tenDangNhap, matKhau, trangThai, hoatDong);
				list.add(tk);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
        
        public String getname() {
            try {
                Statement s = conn.createStatement();
                String query = "select nv.HoTenNV from TaiKhoan tk join NhanVien nv on tk.TenDangNhap = nv.MaNV where tk.HoatDong = 1";
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
        
        public String getma() {
            try {
                Statement s = conn.createStatement();
                String query = "select TenDangNhap from TaiKhoan where HoatDong = 1";
                ResultSet rs = s.executeQuery(query);
                String ht = "";
                while (rs.next()){
                    ht = rs.getString("TenDangNhap");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "error";
        }
        
        public String getnameNV(String maNV) {
            try {
                Statement s = conn.createStatement();
                String query = "select HoTenNV from NhanVien nv where MaNV = '" + maNV +"'";
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
        
        public String getCCCD(String maNV) {
            try {
                Statement s = conn.createStatement();
                String query = "select CanCuoc from NhanVien nv where MaNV = '" + maNV +"'";
                ResultSet rs = s.executeQuery(query);
                String ht = "";
                while (rs.next()){
                    ht = rs.getString("CanCuoc");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "error";
        }

	public boolean xoaTaiKhoan(String tenDangNhap) {
		try {
			Statement s = conn.createStatement();
			String query = "update TaiKhoan set TrangThai = 0 WHERE tenDangNhap = '" + tenDangNhap + "'";
			int rowsAffected = s.executeUpdate(query);
			if (rowsAffected > 0) {
				System.out.println("Xóa tài khoản thành công.");
				return true;
			} else {
				System.out.println("Không tìm thấy tài khoản để xóa.");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
        
        public String phatsinh() {
		try {
                        int max = 0;
			Statement s = conn.createStatement();
			String query = "SELECT COUNT(*)FROM TaiKhoan";
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
                    return "TK" + t;
		} catch (Exception e) {
			e.printStackTrace();
		}
                return "";
	}
        
        public boolean cre(TaiKhoan k) {
            int n = 0;
            String query = "insert into TaiKhoan values(?, ?, ?, ?)";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, k.getTenDangNhap());
                s.setString(2, k.getMatKhau());
                int gt = 0;
                if (k.isTrangThai()) gt = 1;
                s.setInt(3, gt);
                if (k.isHoatDong()) gt = 0;
                s.setInt(4, gt);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public boolean del(String tenDangNhap) {
            int n = 0;
            String query = "delete from TaiKhoan where tenDangNhap = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, tenDangNhap);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public boolean upd(TaiKhoan k) {
            int n = 0;
            String query = "update Taikhoan set matKhau = ?, trangThai = ?, hoatDong= ? Where tenDangNhap = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, k.getMatKhau());
                s.setBoolean(2, k.isTrangThai());
                s.setBoolean(3, k.isHoatDong());
                s.setString(4, k.getTenDangNhap());
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public boolean fillZero() {
            int n = 0;
            String query = "update TaiKhoan set HoatDong = case when HoatDong = 0 then HoatDong else 0 end;";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public boolean capNhapHoatDong(String user) {
            int n = 0;
            String query = "update TaiKhoan set HoatDong = 1 where TenDangNhap = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, user);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
}

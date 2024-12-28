/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConnectMSSQL;
import entity.*;
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
public class PhanCong_DAO {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public PhanCong_DAO() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        
         public List<NhanVien> getallnv() {
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select MaNV, ChucVu, HoTenNV from NhanVien");
			while (rs.next()) {
                            String makh = rs.getString("MaNV");
                            String tenkh = rs.getString("HoTenNV");
                            String tt = rs.getString("ChucVu");
                            NhanVien tk = new NhanVien(makh, tenkh, tt);
                            list.add(tk);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
         
        public List<PhanCong> getallpc() {
		List<PhanCong> list = new ArrayList<PhanCong>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select MaNV, CaLamViec, Ngaylamviec, ChamCong from PHANCONGNHANVIEN");
			while (rs.next()) {
                            String makh = rs.getString("MaNV");
                            int tenkh = rs.getInt("CaLamViec");
                            Date tt = rs.getDate("Ngaylamviec");
                            int cc = rs.getInt("ChamCong");
                            PhanCong tk = new PhanCong(makh, tenkh, tt, cc);
                            list.add(tk);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
        
        public boolean cre(PhanCong k) {
            int n = 0;
            String query = "insert into PHANCONGNHANVIEN values(?, ?, ?, ?)";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, k.getmaNV());
                s.setInt(2, k.getca());
                Date nlul = k.getngay();
                long timeInMillis = nlul.getTime();
                java.sql.Date sqlDate = new java.sql.Date(timeInMillis);
                s.setDate(3, sqlDate);
                s.setInt(4, k.getchamCong());
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
}

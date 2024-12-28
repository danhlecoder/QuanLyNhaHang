/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import config.ConnectMSSQL;
import entity.KhuyenMai;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Dell
 */
public class KhuyenMai_DAO {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public KhuyenMai_DAO() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        
        public List<KhuyenMai> getall() {
		List<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from KhuyenMai");
			while (rs.next()) {
				String makh = rs.getString("MaKhuyenMai");
                                int dk = rs.getInt("DieuKien");
				int gtri = rs.getInt("GiaTri");
                                Date ntao = rs.getDate("NgayTao");
                                Date hsd = rs.getDate("HanSuDung");
				KhuyenMai tk = new KhuyenMai(makh, dk, gtri, ntao, hsd);
				list.add(tk);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
        
        public boolean cre(KhuyenMai k) {
            int n = 0;
            String query = "insert into KhuyenMai values(?, ?, ?, ?, ?)";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, k.getMaKhuyenMai());
                s.setInt(2, k.getDieuKien());
                s.setInt(3, k.getGiaTri());
                Date ngt = k.getNgayTao();
                long timeInMillis = ngt.getTime();
                java.sql.Date sqlDate = new java.sql.Date(timeInMillis);
                s.setDate(4, sqlDate);
                Date hsd = k.getNgayTao();
                long timeInMillishsd = ngt.getTime();
                java.sql.Date sqlDatehsd = new java.sql.Date(timeInMillishsd);
                s.setDate(5, sqlDatehsd);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public boolean del(String maKM) {
            int n = 0;
            String query = "delete from KhuyenMai where MaKhuyenMai = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, maKM);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public boolean upd(KhuyenMai k) {
            int n = 0;
            String query = "update KhuyenMai set DieuKien = ?, GiaTri = ?, NgayTao = ?, HanSuDung = ? Where MaKH = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(5, k.getMaKhuyenMai());
                s.setInt(1, k.getDieuKien());
                s.setInt(2, k.getGiaTri());
                Date ngt = k.getNgayTao();
                long timeInMillis = ngt.getTime();
                java.sql.Date sqlDate = new java.sql.Date(timeInMillis);
                s.setDate(3, sqlDate);
                Date hsd = k.getNgayTao();
                long timeInMillishsd = ngt.getTime();
                java.sql.Date sqlDatehsd = new java.sql.Date(timeInMillishsd);
                s.setDate(4, sqlDatehsd);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public static boolean startsWithComparisonOperatorRegex(String str) {
            return str.matches("^[<>=]{1,2}");
        }
        public List<KhuyenMai> fin(String t) {
                if (t.isEmpty()) return null;
		List<KhuyenMai> list = new ArrayList<KhuyenMai>();
		try {
			Statement s = conn.createStatement();
                        String query = "select * from KhuyenMai where MaKhuyenMai LIKE '%" + t + "%'";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				String makh = rs.getString("MaKhuyenMai");
                                int dk = rs.getInt("DieuKien");
				int gtri = rs.getInt("GiaTri");
                                Date ntao = rs.getDate("NgayTao");
                                Date hsd = rs.getDate("HanSuDung");
				KhuyenMai tk = new KhuyenMai(makh, dk, gtri,ntao, hsd);
				list.add(tk);
			}
                        if (startsWithComparisonOperatorRegex(t)){
                            s = conn.createStatement();
                            query = "select * from KhuyenMai where GiaTri " + t;
                            rs = s.executeQuery(query);
                            while (rs.next()) {
				String makh = rs.getString("MaKhuyenMai");
                                int dk = rs.getInt("DieuKien");
				int gtri = rs.getInt("GiaTri");
                                Date ntao = rs.getDate("NgayTao");
                                Date hsd = rs.getDate("HanSuDung");
				KhuyenMai tk = new KhuyenMai(makh, dk, gtri,ntao, hsd);
				list.add(tk);
			}
                        }
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
        
        public int getvalue(String makm) {
            try {
                Statement s = conn.createStatement();
                String query = "select DieuKien from KhuyenMai where MaKhuyenMai = '" + makm +"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    ht = rs.getInt("DieuKien");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        
        
}

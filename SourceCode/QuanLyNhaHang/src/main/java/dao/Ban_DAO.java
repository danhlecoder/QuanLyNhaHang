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
import entity.Ban;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Dell
 */
public class Ban_DAO {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public Ban_DAO() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        
        public List<Ban> getall() {
		List<Ban> list = new ArrayList<Ban>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select MaBan, TrangThai, Lau, TenBan from Ban");
			while (rs.next()) {
				String makh = rs.getString("MaBan");
				int tenkh = rs.getInt("Lau");
                                String tt = rs.getString("TrangThai");
                                String ten = rs.getString("TenBan");
				Ban tk = new Ban(makh, tt, tenkh, ten);
				list.add(tk);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
        
        public String getma(String ten) {
            try {
                Statement s = conn.createStatement();
                String query = "select MaBan from Ban where TenBan = '"+ten+"'";
                ResultSet rs = s.executeQuery(query);
                String ht = "";
                while (rs.next()){
                    ht = rs.getString("MaBan");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "error";
        }
        
        public String getmathd(String mahd) {
            try {
                Statement s = conn.createStatement();
                String query = "select MaBan from HoaDon where MaHD = '"+mahd+"'";
                ResultSet rs = s.executeQuery(query);
                String ht = "";
                while (rs.next()){
                    ht = rs.getString("MaBan");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "error";
        }
        
        public boolean upd(String tt, String ma) {
            int n = 0;
            String query = "update Ban set TrangThai = ? Where MaBan = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, tt);
                s.setString(2, ma);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public List<Ban> fin(String t) {
                if (t.isEmpty()) return null;
		List<Ban> list = new ArrayList<Ban>();
		try {
			Statement s = conn.createStatement();
                        String query = "select * from Ban where LOWER(MaBan) LIKE LOWER(N'%" + t + "%')";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				String makh = rs.getString("MaBan");
				int tenkh = rs.getInt("Lau");
                                String tt = rs.getString("TrangThai");
				Ban tk = new Ban(makh, tt, tenkh);
				list.add(tk);
			}
                        query = "select * from Ban where LOWER(TrangThai) LIKE LOWER(N'%" + t + "%')";
			rs = s.executeQuery(query);
			while (rs.next()) {
				String makh = rs.getString("MaBan");
				int tenkh = rs.getInt("Lau");
                                String tt = rs.getString("TrangThai");
				Ban tk = new Ban(makh, tt, tenkh);
				list.add(tk);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
        
        public List<Ban> getBanByLau(int lau){
            List<Ban> list=new ArrayList<Ban>();
            String query="select MaBan, TrangThai, Lau, TenBan from Ban where Lau= ?";
            try {
                 PreparedStatement s = conn.prepareStatement(query);
                 s.setInt(1, lau);
                 ResultSet rs = s.executeQuery();
                 while (rs.next()) {
				String makh = rs.getString("MaBan");
				int tenkh = rs.getInt("Lau");
                                String tt = rs.getString("TrangThai");
                                String ten = rs.getString("TenBan");
				Ban tk = new Ban(makh, tt, tenkh, ten);
				list.add(tk);
			}
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }
        
        public boolean fillZero() {
            int n = 0;
            String query = "update Ban set SuDung = case when SuDung = 0 then SuDung else 0 end;";
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
            String query = "update Ban set SuDung = 1 where MaBan = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setString(1, user);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        public String check() {
            try {
                Statement s = conn.createStatement();
                String query = "select MaBan from Ban where SuDung = '1'";
                ResultSet rs = s.executeQuery(query);
                String ht = "";
                while (rs.next()){
                    ht = rs.getString("MaBan");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "error";
        }
        public String getten() {
            try {
                Statement s = conn.createStatement();
                String query = "select TenBan from Ban where SuDung = '1'";
                ResultSet rs = s.executeQuery(query);
                String ht = "r";
                while (rs.next()){
                    ht = rs.getString("TenBan");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "error";
        }
}

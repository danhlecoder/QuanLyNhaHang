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
import entity.MonAn;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dell
 */
public class MonAn_DAO {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public MonAn_DAO() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        public static boolean startsWithComparisonOperatorRegex(String str) {
            return str.matches("^[<>=]{1,2}");
        }
        public List<MonAn> getall() {
		List<MonAn> list = new ArrayList<MonAn>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from MonAn");
			while (rs.next()) {
				String makh = rs.getString("MaMonAn");
				String tenkh = rs.getString("TenMonAn");
                                int gt = rs.getInt("GiaTien");
                                String l = rs.getString("Loai");
                                String sz = rs.getString("Size");
                                int km = rs.getInt("GiaTri");
                                String gc = rs.getString("GhiChu");
                                String tt = rs.getString("TrangThai");
				MonAn tk = new MonAn(makh, tenkh, gt, l, sz, km, tt, gc);
				list.add(tk);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }
        
        public boolean upd(int km, String tt, String ma) {
            int n = 0;
            String query = "update MonAn set GiaTri = ?, TrangThai = ? Where MaMonAn = ?";
            try {
                PreparedStatement s = conn.prepareStatement(query);
                s.setInt(1, km);
                s.setString(2, tt);
                s.setString(3, ma);
                n = s.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n > 0;
        }
        
        public List<MonAn> fin(String t) {
                if (t.isEmpty()) return null;
		List<MonAn> list = new ArrayList<MonAn>();
		try {
			Statement s = conn.createStatement();
                        String query = "select * from MonAn where LOWER(TenMonAN) LIKE LOWER(N'%" + t + "%')";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				String makh = rs.getString("MaMonAn");
				String tenkh = rs.getString("TenMonAn");
                                int gt = rs.getInt("GiaTien");
                                String l = rs.getString("Loai");
                                String sz = rs.getString("Size");
                                int km = rs.getInt("GiaTri");
                                String gc = rs.getString("GhiChu");
                                String tt = rs.getString("TrangThai");
				MonAn tk = new MonAn(makh, tenkh, gt, l, sz, km, tt, gc);
				list.add(tk);
			}
                        query = "select * from MonAn where LOWER(Loai) LIKE LOWER(N'%" + t + "%')";
			rs = s.executeQuery(query);
			while (rs.next()) {
				String makh = rs.getString("MaMonAn");
				String tenkh = rs.getString("TenMonAn");
                                int gt = rs.getInt("GiaTien");
                                String l = rs.getString("Loai");
                                String sz = rs.getString("Size");
                                int km = rs.getInt("GiaTri");
                                String gc = rs.getString("GhiChu");
                                String tt = rs.getString("TrangThai");
				MonAn tk = new MonAn(makh, tenkh, gt, l, sz, km, tt, gc);
				list.add(tk);
			}
                        if (startsWithComparisonOperatorRegex(t)){
                            query = "select * from MonAn where GiaTien " + t;
			rs = s.executeQuery(query);
			while (rs.next()) {
				String makh = rs.getString("MaMonAn");
				String tenkh = rs.getString("TenMonAn");
                                int gt = rs.getInt("GiaTien");
                                String l = rs.getString("Loai");
                                String sz = rs.getString("Size");
                                int km = rs.getInt("GiaTri");
                                String gc = rs.getString("GhiChu");
                                String tt = rs.getString("TrangThai");
				MonAn tk = new MonAn(makh, tenkh, gt, l, sz, km, tt, gc);
				list.add(tk);
			}
                        query = "select * from MonAn where KhuyenMai " + t;
			rs = s.executeQuery(query);
			while (rs.next()) {
				String makh = rs.getString("MaMonAn");
				String tenkh = rs.getString("TenMonAn");
                                int gt = rs.getInt("GiaTien");
                                String l = rs.getString("Loai");
                                String sz = rs.getString("Size");
                                int km = rs.getInt("GiaTri");
                                String gc = rs.getString("GhiChu");
                                String tt = rs.getString("TrangThai");
				MonAn tk = new MonAn(makh, tenkh, gt, l, sz, km, tt, gc);
				list.add(tk);
			}
                        }
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        }

    public MonAn findMonAnTheoID(String maMA){
            MonAn ma=new MonAn();
            String query="select * from MonAn where MaMonAn=?";
        try {
            PreparedStatement s = conn.prepareStatement(query);
            s.setString(1, maMA);
            ResultSet rs=s.executeQuery();
           while(rs.next()){
            String ten=rs.getString("TenMonAn");
            int gt=rs.getInt("GiaTien");
            String loai=rs.getString("Loai");
            
            ma=new MonAn(maMA, ten, loai, gt, 0);
           }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MonAn_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ma;
        } 
        
        public  List<MonAn> getMonAnTheoLoai(String loai){
            List<MonAn> l=new ArrayList<MonAn>();
            String query="select * from MonAn where Loai=?";
            try {
            PreparedStatement s = conn.prepareStatement(query);
            s.setString(1, loai);
            ResultSet rs=s.executeQuery();
           while(rs.next()){
            String id = rs.getString("MaMonAn");
            
            MonAn ma = findMonAnTheoID(id);
            l.add(ma);
                     }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MonAn_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return l;
        }
}

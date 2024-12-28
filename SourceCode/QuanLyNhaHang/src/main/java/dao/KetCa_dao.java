/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConnectMSSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Dell
 */
public class KetCa_dao {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public KetCa_dao() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        
        public int getto1(String ngay) {
            try {
                Statement s = conn.createStatement();
                String query = "select to1 from PHIEU where Ngay = '"+ngay+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    ht += rs.getInt("to1");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        
        public int getto5(String ngay) {
            try {
                Statement s = conn.createStatement();
                String query = "select to5 from PHIEU where Ngay = '"+ngay+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    ht += rs.getInt("to5");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        public int getto2(String ngay) {
            try {
                Statement s = conn.createStatement();
                String query = "select to2 from PHIEU where Ngay = '"+ngay+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    ht += rs.getInt("to2");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        public int getto10(String ngay) {
            try {
                Statement s = conn.createStatement();
                String query = "select to10 from PHIEU where Ngay = '"+ngay+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    ht += rs.getInt("to10");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        
        public int getto20(String ngay) {
            try {
                Statement s = conn.createStatement();
                String query = "select to20 from PHIEU where Ngay = '"+ngay+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    ht += rs.getInt("to20");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        
        public int getto50(String ngay) {
            try {
                Statement s = conn.createStatement();
                String query = "select to50 from PHIEU where Ngay = '"+ngay+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    ht += rs.getInt("to50");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        public int getto100(String ngay) {
            try {
                Statement s = conn.createStatement();
                String query = "select to100 from PHIEU where Ngay = '"+ngay+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    ht += rs.getInt("to100");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        
        public int getto200(String ngay) {
            try {
                Statement s = conn.createStatement();
                String query = "select to200 from PHIEU where Ngay = '"+ngay+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    ht += rs.getInt("to200");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        
        public int getto500(String ngay) {
            try {
                Statement s = conn.createStatement();
                String query = "select to500 from PHIEU where Ngay = '"+ngay+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    ht += rs.getInt("to500");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        
        public String getmaphieu(String ngay, String manv) {
            try {
                Statement s = conn.createStatement();
                String query = "select top 1 MaPhieu "
                        + "from PHIEU p join HoaDon hd on hd.MaHD = p.MaHD "
                        + "where Ngay = '"+ngay+"' and hd.MaNV = '"+manv+"'";
                ResultSet rs = s.executeQuery(query);
                String ht = "";
                while (rs.next()){
                    ht = rs.getString("MaPhieu");
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "P?";
        }
        
        public int tinhtienmat(String ngay, String manv) {
            try {
                Statement s = conn.createStatement();
                String query = "select to1, to2 , to5, to10, to20, to50, to100, to200, to500 "
                        + "from PHIEU p join HoaDon hd on hd.MaHD = p.MaHD "
                        + "where Ngay = '"+ngay+"' and hd.MaNV = '"+manv+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    int to1 = rs.getInt("to1");
                    int to2 = rs.getInt("to2");
                    int to5 = rs.getInt("to5");
                    int to10 = rs.getInt("to10");
                    int to20 = rs.getInt("to20");
                    int to50 = rs.getInt("to50");
                    int to100 = rs.getInt("to100");
                    int to200 = rs.getInt("to200");
                    int to500 = rs.getInt("to500");
                    
                    ht += to1*1000 + to2*2000 + to5*5000 + to10*10000 + to20*20000 + to50*50000 + to100*100000 + to200*200000 + to500*500000;
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        public int tinhchuyenkhoan(String ngay, String manv) {
            try {
                Statement s = conn.createStatement();
                String query = "select TienChuyenKhoan as ck "
                        + "from PHIEU p join HoaDon hd on hd.MaHD = p.MaHD "
                        + "where Ngay = '"+ngay+"' and hd.MaNV = '"+manv+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    int ck = rs.getInt("ck");
                    ht += ck;
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        
        public int tongtienmat(String ngay) {
            try {
                Statement s = conn.createStatement();
                String query = "select to1, to2 , to5, to10, to20, to50, to100, to200, to500 "
                        + "from PHIEU p join HoaDon hd on hd.MaHD = p.MaHD "
                        + "where Ngay = '"+ngay+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    int to1 = rs.getInt("to1");
                    int to2 = rs.getInt("to2");
                    int to5 = rs.getInt("to5");
                    int to10 = rs.getInt("to10");
                    int to20 = rs.getInt("to20");
                    int to50 = rs.getInt("to50");
                    int to100 = rs.getInt("to100");
                    int to200 = rs.getInt("to200");
                    int to500 = rs.getInt("to500");
                    
                    ht += to1*1000 + to2*2000 + to5*5000 + to10*10000 + to20*20000 + to50*50000 + to100*100000 + to200*200000 + to500*500000;
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        public int tongchuyenkhoan(String ngay) {
            try {
                Statement s = conn.createStatement();
                String query = "select TienChuyenKhoan as ck "
                        + "from PHIEU p join HoaDon hd on hd.MaHD = p.MaHD "
                        + "where Ngay = '"+ngay+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    int ck = rs.getInt("ck");
                    ht += ck;
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        
        public int getsohd(String ngay, String manv) {
            try {
                Statement s = conn.createStatement();
                String query = "select p.MaHD "
                        + "from PHIEU p join HoaDon hd on hd.MaHD = p.MaHD "
                        + "where Ngay = '"+ngay+"' and hd.MaNV = '"+manv+"'";
                ResultSet rs = s.executeQuery(query);
                int ht = 0;
                while (rs.next()){
                    String tam = rs.getString("MaHD");
                    ht += 1;
                }
                return ht;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConnectMSSQL;
import entity.MonAn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class DTMonAN_DAO {
    Connection conn = null;
    
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDatBan;"
			+ "encrypt=true;trustServerCertificate=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123456";

	public DTMonAN_DAO() {
		try {
			conn = ConnectMSSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connect Fail");
		}
	}
        public int getall(String mama) {
		//List<MonAn> list = new ArrayList<MonAn>();
                int tongmaa = 0;
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select cthd.MaMonAn, ma.TenMonAn, cthd.SoLuongMonAn, ma.Size, ma.GiaTri, ma.GiaTien " +
                                                      "from CHI_TIET_HOADON cthd " +
                                                      "join MonAn ma on cthd.MaMonAn = ma.MaMonAn " + 
                                                      "where cthd.MaMonAn = '"+ mama +"'");
			while (rs.next()) {
                                String ma = rs.getString("MaMonAn");
				String Ten = rs.getString("TenMonAn");
                                int sl = rs.getInt("SoLuongMonAn");
                                String Size = rs.getString("Size");
                                int km = rs.getInt("GiaTri");
                                int gia = rs.getInt("GiaTien");
                                
                                int tienkm = gia*km;
                                int tienma = (gia-tienkm/100)*sl;
                                tongmaa+=tienma;
                                //MonAn m = new MonAn(ma, Ten, Size, gia, km, sl);
                                //list.add(m);
			}
			return tongmaa;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
        }
}

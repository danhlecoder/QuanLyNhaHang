/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import dao.TaiKhoan_DAO;
import entity.TaiKhoan;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        TaiKhoan_DAO tk_dao = new TaiKhoan_DAO();
        List<TaiKhoan> list = tk_dao.getall();
        list.forEach(tk -> System.out.println(tk));
    }
}

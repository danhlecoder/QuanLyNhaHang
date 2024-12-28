/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class KhachHang {
    private String maKH, tenKH, SDT;
    private boolean gioiTinh;

    public KhachHang(String maKH) {
        this(maKH, "", "", true);
    }

    public KhachHang(String maKH, String tenKH, String sDT, boolean gioiTinh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        SDT = sDT;
        this.gioiTinh = gioiTinh;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String sDT) {
        SDT = sDT;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean diaChi) {
        this.gioiTinh = gioiTinh;
    }

}

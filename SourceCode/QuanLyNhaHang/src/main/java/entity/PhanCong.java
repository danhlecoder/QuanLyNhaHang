/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class PhanCong {
    private String maNV;
    private int ca;
    private Date ngay;
    private int chamCong;

    public PhanCong(String maKH) {
        this.maNV = maKH;
    }

    public PhanCong(String maKH, int ca, Date ngay, int chamCong) {
        this.maNV = maKH;
        this.ca = ca;
        this.ngay = ngay;
        this.chamCong = chamCong;
    }

    public String getmaNV() {
        return maNV;
    }

    public void setmaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getca() {
        return ca;
    }

    public void setca(int ca) {
        this.ca = ca;
    }

    public Date getngay() {
        return ngay;
    }

    public void setngay(Date ngay) {
        this.ngay = ngay;
    }

    public int getchamCong() {
        return chamCong;
    }

    public void setchamCong(int chamCong) {
        this.chamCong = chamCong;
    }

}

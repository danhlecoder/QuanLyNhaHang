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
public class Phieu {
    private String maPhieu;
    private String maHD;
    private Date ngay;
    private int to1;
    private int to2;
    private int to5;
    private int to10;
    private int to20;
    private int to50;
    private int to100;
    private int to200;
    private int to500;
    private int tienChuyenKhoan;
	
	public Phieu(String maPhieu, String maHD, Date ngay, int to1, int to2, int to5, int to10, int to20, int to50,
			int to100, int to200, int to500, int tienChuyenKhoan) {
		super();
		this.maPhieu = maPhieu;
		this.maHD = maHD;
		this.ngay = ngay;
		this.to1 = to1;
		this.to2 = to2;
		this.to5 = to5;
		this.to10 = to10;
		this.to20 = to20;
		this.to50 = to50;
		this.to100 = to100;
		this.to200 = to200;
		this.to500 = to500;
		this.tienChuyenKhoan = tienChuyenKhoan;
	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public int getTo1() {
		return to1;
	}

	public void setTo1(int to1) {
		this.to1 = to1;
	}

	public int getTo2() {
		return to2;
	}

	public void setTo2(int to2) {
		this.to2 = to2;
	}

	public int getTo5() {
		return to5;
	}

	public void setTo5(int to5) {
		this.to5 = to5;
	}

	public int getTo10() {
		return to10;
	}

	public void setTo10(int to10) {
		this.to10 = to10;
	}

	public int getTo20() {
		return to20;
	}

	public void setTo20(int to20) {
		this.to20 = to20;
	}

	public int getTo50() {
		return to50;
	}

	public void setTo50(int to50) {
		this.to50 = to50;
	}

	public int getTo100() {
		return to100;
	}

	public void setTo100(int to100) {
		this.to100 = to100;
	}

	public int getTo200() {
		return to200;
	}

	public void setTo200(int to200) {
		this.to200 = to200;
	}

	public int getTo500() {
		return to500;
	}

	public void setTo500(int to500) {
		this.to500 = to500;
	}

	public int getTienChuyenKhoan() {
		return tienChuyenKhoan;
	}

	public void setTienChuyenKhoan(int tienChuyenKhoan) {
		this.tienChuyenKhoan = tienChuyenKhoan;
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class HoaDon {
    	private String maHoaDon;
	private Date ngayLap;
	private KhachHang maKH;
	private NhanVien maNV;
	private List<KhuyenMai> maKhuyenMai;
	private int thueVAT;
	private Date ngayXuat;
	private Ban maBan;
	private List<MonAn> maMonAn;
	
	public HoaDon(String maHoaDon, Date ngayLap, KhachHang maKH, NhanVien maNV, List<KhuyenMai> maKhuyenMai, int thueVAT,
			Date ngayXuat, Ban maBan, List<MonAn> maMonAn) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.maKH = maKH;
		this.maNV = maNV;
		this.maKhuyenMai = maKhuyenMai;
		this.thueVAT = thueVAT;
		this.ngayXuat = ngayXuat;
		this.maBan = maBan;
		this.maMonAn = maMonAn;
	}
        public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
        
        public HoaDon(String maHoaDon, List<KhuyenMai> maKhuyenMai, List<MonAn> maMonAn) {
		super();
		this.maHoaDon = maHoaDon;
                this.maKhuyenMai = maKhuyenMai;
                this.maMonAn = maMonAn;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public KhachHang getMaKH() {
		return maKH;
	}

	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	public List<KhuyenMai> getMaKhuyenMai() {
		return maKhuyenMai;
	}

	public void setMaKhuyenMai(List<KhuyenMai> maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}

	public int getThueVAT() {
		return thueVAT;
	}

	public void setThueVAT(int thueVAT) {
		this.thueVAT = thueVAT;
	}

	public Date getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public Ban getMaBan() {
		return maBan;
	}

	public void setMaBan(Ban maBan) {
		this.maBan = maBan;
	}

	public List<MonAn> getMaMonAn() {
		return maMonAn;
	}

	public void setMaMonAn(List<MonAn> maMonAn) {
		this.maMonAn = maMonAn;
	}

}

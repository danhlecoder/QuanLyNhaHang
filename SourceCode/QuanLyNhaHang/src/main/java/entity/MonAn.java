/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class MonAn {
	private String maMonAn;
	private String tenMonAn;
	private int giaTien;
	private String loai;
	private String size;
	private String ghiChu;
	private String trangThai;
        private int khuyenMai;
        private int sl;
	
	public MonAn(String maMonAn, String tenMonAn, int giaTien, String loai, String size, int khuyenMai,
			String trangThai, String ghiChu) {
		this.maMonAn = maMonAn;
		this.tenMonAn = tenMonAn;
		this.giaTien = giaTien;
		this.loai = loai;
		this.size = size;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
                this.khuyenMai = khuyenMai;
	}
        public MonAn(String maMonAn, int giaTien, int khuyenMai){
            this.maMonAn = maMonAn;
            this.giaTien = giaTien;
            this.khuyenMai = khuyenMai;
        }
        
        public MonAn(String maMonAn, String tenMonAn, int sl){
            this.maMonAn = maMonAn;
            this.tenMonAn = tenMonAn;
            this.sl = sl;
        }
        public MonAn(String maMonAn, int giaTien, int khuyenMai, int sl){
            this.maMonAn = maMonAn;
            this.giaTien = giaTien;
            this.khuyenMai = khuyenMai;
            this.sl = sl;
        }
        public MonAn(String maMonAn, String tenMonAn, String size, int giaTien, int khuyenMai){
            this.maMonAn = maMonAn;
            this.giaTien = giaTien;
            this.khuyenMai = khuyenMai;
            this.size = size;
            this.tenMonAn = tenMonAn;
        }
        
        public MonAn(String maMonAn, String tenMonAn, String size, int giaTien, int khuyenMai, int sl){
            this.maMonAn = maMonAn;
            this.giaTien = giaTien;
            this.khuyenMai = khuyenMai;
            this.size = size;
            this.tenMonAn = tenMonAn;
            this.sl = sl;
        }
        public MonAn(){
        }
        public int getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(int khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
        public int getsl() {
		return sl;
	}

	public void setsl(int sl) {
		this.sl = sl;
	}
	public String getMaMonAn() {
		return maMonAn;
	}

	public void setMaMonAn(String maMonAn) {
		this.maMonAn = maMonAn;
	}

	public String getTenMonAn() {
		return tenMonAn;
	}

	public void setTenMonAn(String tenMonAn) {
		this.tenMonAn = tenMonAn;
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class Ban {
    private String maBan;
	private String trangThai;
	private int lau;
        private String ten;
	
	public Ban(String maBan, String trangThai, int lau) {
		super();
		this.maBan = maBan;
		this.trangThai = trangThai;
		this.lau = lau;
	}
        public Ban(String maBan, String trangThai, int lau, String ten) {
		super();
		this.maBan = maBan;
		this.trangThai = trangThai;
		this.lau = lau;
                this.ten = ten;
	}
        public Ban(String maBan) {
            this.maBan = maBan;
	}
	public String getMaBan() {
		return maBan;
	}

	public void setMaBan(String ten) {
		this.ten = ten;
	}
        
        public String getten() {
		return ten;
	}

	public void setten(String maBan) {
		this.maBan = maBan;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public int getLau() {
		return lau;
	}

	public void setLau(int lau) {
		this.lau = lau;
	}

}

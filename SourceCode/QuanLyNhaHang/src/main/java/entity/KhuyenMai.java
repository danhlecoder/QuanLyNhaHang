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
public class KhuyenMai {
    private String maKhuyenMai;
	private int dieuKien;
	private int giaTri;
	private Date ngayTao;
	private Date hanSuDung;
	
	public KhuyenMai(String maKhuyenMai, int dieuKien, int giaTri, Date ngayTao, Date hanSuDung) {
		this.maKhuyenMai = maKhuyenMai;
		this.dieuKien = dieuKien;
		this.giaTri = giaTri;
		this.ngayTao = ngayTao;
		this.hanSuDung = hanSuDung;
	}
        public KhuyenMai(){
            
        }
        
        public KhuyenMai(String maKhuyenMai, int giaTri){
            this.maKhuyenMai = maKhuyenMai;
            this.giaTri = giaTri;
        }
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}

	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}

	public int getDieuKien() {
		return dieuKien;
	}

	public void setDieuKien(int dieuKien) {
		this.dieuKien = dieuKien;
	}

	public int getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(int giaTri) {
		this.giaTri = giaTri;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDung(Date hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

}

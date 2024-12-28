/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Dell
 */
public class NhanVien {
    private String maNV;
    private String hotenNV;
    private String sDT;
    private String canCuoc;
    private String diaChi;
    private String email;
    private int caLamViec;
    private String trangThai;
    private String chucVu;
    private boolean gioiTinh;
    
	public NhanVien(String maNV, String hotenNV, String sDT, String canCuoc, String diaChi, String email, int caLamViec,
			String trangThai, String chucVu, boolean gioiTinh) {
		super();
		this.maNV = maNV;
		this.hotenNV = hotenNV;
		this.sDT = sDT;
		this.canCuoc = canCuoc;
		this.diaChi = diaChi;
		this.email = email;
		this.caLamViec = caLamViec;
		this.trangThai = trangThai;
		this.chucVu = chucVu;
		this.gioiTinh = gioiTinh;
	}
        
        public NhanVien(String maNV) {
            this.maNV = maNV;
        }
        
        public NhanVien(String maNV,String HoTenNV, String ChucVu) {
            this.maNV = maNV;
            this.hotenNV = HoTenNV;
            this.chucVu = ChucVu;
        }
	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHotenNV() {
		return hotenNV;
	}

	public void setHotenNV(String hotenNV) {
		this.hotenNV = hotenNV;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getCanCuoc() {
		return canCuoc;
	}

	public void setCanCuoc(String canCuoc) {
		this.canCuoc = canCuoc;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCaLamViec() {
		return caLamViec;
	}

	public void setCaLamViec(int caLamViec) {
		this.caLamViec = caLamViec;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

}

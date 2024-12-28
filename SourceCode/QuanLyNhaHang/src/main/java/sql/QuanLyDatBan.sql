-- TAO DATABASE
CREATE DATABASE QuanLyDatBan
GO
USE QuanLyDatBan

-- TAO TABLE

-- Tạo table Nhân Viên
CREATE TABLE NhanVien (
	MaNV NVARCHAR(20) PRIMARY KEY NOT NULL,
	HoTenNV NVARCHAR(50) NOT NULL,
	SDT NVARCHAR(12) UNIQUE,
	CanCuoc NVARCHAR(20) UNIQUE,
	DiaChi NVARCHAR(30),
	Email NVARCHAR(50) UNIQUE,
	CaLamViec int check (CaLamViec=1 or CaLamViec=2 or CaLamViec=3),
	TrangThai NVARCHAR(20) check (TrangThai = N'Đang Làm' OR TrangThai = N'Đã nghỉ' OR TrangThai = N'Tạm Nghỉ'),
	ChucVu NVARCHAR(10) NOT NULL CHECK (ChucVu LIKE 'NV' OR ChucVu LIKE 'NQL'),
	GioiTinh INT NOT NULL CHECK (GioiTinh = 0 OR GioiTinh=1)
)

-- Tạo table Tài Khoản
CREATE TABLE TaiKhoan(
	TenDangNhap NVARCHAR(20) PRIMARY KEY NOT NULL,
	MatKhau NVARCHAR(10) NOT NULL,
	TrangThai BIT DEFAULT 1,
	HoatDong BIT DEFAULT 0,
	FOREIGN KEY (TenDangNhap) REFERENCES NhanVien(MaNV)
	
)


-- Tạo table Khách Hàng
CREATE TABLE KhachHang(
	MaKH NVARCHAR(20) PRIMARY KEY NOT NULL,
	TenKH NVARCHAR(50) NOT NULL,
	SDT NVARCHAR(12) UNIQUE, 
	GioiTinh INT NOT NULL CHECK (GioiTinh = 0 OR GioiTinh=1)
)

--Tạo table Bàn
CREATE TABLE Ban(
	MaBan NVARCHAR(20) NOT NULL PRIMARY KEY,
	TenBan NVARCHAR(20),
	TrangThai NVARCHAR(20) CHECK (TrangThai = N'Trống' OR TrangThai = N'Bận' OR TrangThai = N'Tạm ngưng') DEFAULT N'Trống',-- 0 EMPTY 1 FULL
	Lau INT NOT NULL,
	SuDung BIT DEFAULT 0
	
	

)

-- Tạo table món ăn
CREATE TABLE MonAn(
	MaMonAn NVARCHAR(20) NOT NULL PRIMARY KEY,
	TenMonAn NVARCHAR(50) NOT NULL,
	GiaTien MONEY,
	Loai NVARCHAR(50) check (Loai = N'Gà' OR Loai = N'Burger' OR Loai = N'Cơm'or Loai = N'Mì Ý' OR Loai = N'THỨC UỐNG & TRÁNG MIỆNG' OR Loai = N'Combo') NOT NULL,
	Size NVARCHAR(20) check (Size = 'M' OR Size = 'L' OR Size = 'XL'), 
	GiaTri INT,
	GhiChu NVARCHAR(50),
	TrangThai NVARCHAR(20) check (TrangThai = N'Tạm Ngưng' OR TrangThai = N'Bình thường')
	
)

-- Tạo table Khuyến Mãi
CREATE TABLE KhuyenMai(
	MaKhuyenMai NVARCHAR(20) NOT NULL PRIMARY KEY,
	DieuKien MONEY, 
	GiaTri INT,
	NgayTao DATETIME NOT NULL,
	HanSuDung DATETIME NOT NULL
	
)


-- Tạo Hóa đơn
CREATE TABLE HoaDon(
	MaHD NVARCHAR(20) NOT NULL  PRIMARY KEY,
	NgayLap DATETIME NOT NULL CHECK (NgayLap <= GETDATE()),
	MaKH NVARCHAR(20) FOREIGN KEY REFERENCES KhachHang(MaKH),
	MaNV NVARCHAR(20) FOREIGN KEY REFERENCES NhanVien(MaNV),
	MaKhuyenMai NVARCHAR(20) FOREIGN KEY REFERENCES KhuyenMai(MaKhuyenMai),
	ThueVAT int NOT NULL,
	NgayXuat DATETIME CHECK (NgayXuat <= GETDATE()),
	MaBan NVARCHAR(20) FOREIGN KEY REFERENCES Ban(MaBan),
	
)

-- Tạo table Chi tiết KM HD
CREATE TABLE CHITIET_KHUYENMAI_HOADON(
	MaHD NVARCHAR(20) NOT NULL ,
	MaKhuyenMai NVARCHAR(20) NOT NULL,
	PRIMARY KEY (MaHD, MaKhuyenMai),
	FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
	FOREIGN KEY (MaKhuyenMai) REFERENCES KhuyenMai(MaKhuyenMai)
)

-- Tạo table Chi Tiết Hóa Đơn
CREATE TABLE CHI_TIET_HOADON (
	MaCTHD NVARCHAR(20) NOT NULL PRIMARY KEY,
	MaHD NVARCHAR(20) NOT NULL FOREIGN KEY REFERENCES HoaDon(MaHD),
	MaMonAn NVARCHAR(20) FOREIGN KEY REFERENCES MonAn(MaMonAn),
	SoLuongMonAn INT NOT NULL,
	--PRIMARY KEY (MaHD,MaBan,MaMonAn)
)

--Tạo table bảng Phiếu
CREATE TABLE PHIEU(
	MaPhieu NVARCHAR(20) NOT NULL, 
	Ngay DATETIME NOT NULL CHECK (Ngay <= GETDATE()),
	To1   INT,
	To2   INT,
	To5   INT,
	To10  INT,
	To20  INT,
	To50  INT,
	To100 INT,
	To200 INT,
	To500 INT,
	TienChuyenKhoan MONEY,
	MaHD NVARCHAR(20) NOT NULL FOREIGN KEY REFERENCES HoaDon(MaHD),
	PRIMARY KEY (MaPhieu,MaHD)


)
-- Tạo table bảng phân công nhân viên
CREATE TABLE PHANCONGNHANVIEN(
	MaNV NVARCHAR(20) NOT NULL,
	CaLamViec int check (CaLamViec=1 or CaLamViec=2 or CaLamViec=3),
	Ngaylamviec DATETIME,
	ChamCong BIT DEFAULT 0, --0 là NO, 1 là yes--
	FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
	PRIMARY KEY (MaNV,Calamviec,Ngaylamviec)
)

Insert into NhanVien 
values 
('NV001', N'admin', '0339341845', '074203007328',N'Bình Dương','admin@gmail.com',1,N'Đang Làm','NQL',0),
('NV002', N'Nguyễn Thị Nga', '0987654324', '037193000257', N'Ninh Bình', 'nga.nguyen@gmail.com', 1, N'Đang Làm', 'NV', 1),
('NV003', N'Trần Văn Nghĩa', '0123466789', '077078006328', N'Vũng Tàu', 'nghiatran@gmail.com', 2, N'Đang Làm', 'NV', 0),
('NV004', N'Lê Thị Lan', '0333123426', '079188056329', N'TP.Hồ Chí Minh', 'lanle@gmail.com', 3, N'Đã nghỉ', 'NV', 1),
('NV005', N'Phan Văn Tài ', '0367323456', '031098563219', N'TP.Hải Phòng', 'taiphan@gmail.com', 1, N'Đang Làm', 'NV', 0),
('NV006', N'Hồ Văn Hùng', '0948888888', '079094321098', N'Hồ Chí Minh', 'hung.ho@gmail.com', 2, N'Đang Làm', 'NV', 0),
('NV007', N'Nguyễn Thị Lan Anh', '0987777777', '001195432107', N'Hà Nội', 'mai.nguyen@gmail.com', 3, N'Đang Làm', 'NV', 1),
('NV008', N'Trần Văn Thoại', '0393333333', '035093298701', N'Hà Nam', 'thoaitran@gmail.com', 1, N'Đang Làm', 'NV', 0),
('NV009', N'Lê Thị Dung', '0366566666', '048198198765', N'Đà Nẵng', 'dung.le@gmail.com', 2, N'Đã nghỉ', 'NV', 1),
('NV010', N'Phan Văn Tài', '0932109866', '001202432107', N'Hà Nội', 'tai.phan@gmail.com', 3, N'Đang Làm', 'NV', 0),
('NV011', N'Đặng Thị Thơm', '0945671834', '038193210952', N'Hồ Chí Minh', 'thom.dang@gmail.com', 1, N'Đang Làm', 'NV', 1),
('NV012', N'Lương Văn Y', '0987654341', '027201210987', N'Bắc Ninh', 'Y.lu@gmail.com', 2, N'Đang Làm', 'NV', 0),
('NV013', N'Hoàng Thị Hương', '0987123456', '030300432107', N'Hải Dương', 'huong.hoang@gmail.com', 3, N'Đã nghỉ', 'NV', 1),
('NV014', N'Nguyễn Văn Đức', '0365432198', '001095432105', N'Hà Nội', 'duc.nguyen@gmail.com', 1, N'Đang Làm', 'NV', 0),
('NV015', N'Trần Thị Kim Hoa', '0967891634', '033303432101', N'Hưng Yên', 'hoa.tran@gmail.com', 2, N'Đang Làm', 'NV', 1),
('NV016', N'Hồ Thị Trúc', '0333789056', '036198210987', N'Nam Định', 'truc.ho@gmail.com', 3, N'Đang Làm', 'NV', 1),
('NV017', N'Hà Văn Toàn', '0367291234', '092192432104', N'Cần Thơ', 'toan.ha@gmail.com', 1, N'Đang Làm', 'NV', 0),
('NV018', N'Nguyễn Thị Mỹ Anh', '0187123456', '091188432102', N'Kiên Giang', 'myanh.nguyen@gmail.com', 2, N'Đã nghỉ', 'NV', 1),
('NV019', N'Trần Thế Lợi', '0267891234', '087200321097', N'Đồng Tháp', 'loi.tran@gmail.com', 3, N'Đang Làm', 'NV', 0),
('NV020', N'Hoàng Thị Vui', '0587654421', '072302298700', N'Tây Ninh', 'vui.hoang@gmail.com', 1, N'Đang Làm', 'NV', 1),
('NV021', N'Lê Thị Hằng', '0387123456', '060199321096', N'Bình Thuận', 'hang.le@gmail.com', 2, N'Đang Làm', 'NV', 1),
('NV022', N'Phan Văn Thế', '0678987654', '070190432110', N'Bình Phước', 'the.phan@gmail.com', 3, N'Đã nghỉ', 'NV', 0),
('NV023', N'Đặng Thị Thơ', '0365891234', '080202210985', N'Long An', 'tho.dang@gmail.com', 1, N'Đang Làm', 'NV', 1),
('NV024', N'Lương Tuấn Tú', '0988654381', '086099198763', N'Vĩnh Long', 'tu.lu@gmail.com', 2, N'Đang Làm', 'NV', 0),
('NV025', N'Hoàng Thị Mẫn', '0307891234', '096190432114', N'Cà Mau', 'man.hoang@gmail.com', 3, N'Đang Làm', 'NV',1),
('NV026', N'Nguyễn Thị Quỳnh', '0957654391', '095203210984', N'Bạc Liêu', 'quynh.nguyen@gmail.com', 1, N'Tạm Nghỉ', 'NV', 1),
('NV027', N'Trần Văn Tám', '0123956789', '083200746592', N'Bến Tre', 'tam.tran@gmail.com', 2, N'Tạm Nghỉ', 'NV', 0),
('NV028', N'Phạm Thế Khải', '0338123456', '082095548610', N'Tiền Giang', 'khai.pham@gmail.com', 3, N'Tạm Nghỉ', 'NV', 0),
('NV029', N'Lê Anh Thư', '0367923456', '056302569322', N'Khánh Hòa', 'tuyet.le@gmail.com', 1, N'Tạm Nghỉ', 'NV', 1),
('NV030', N'Nguyễn Đức Chiến', '0532109876', '058202545698', N'Ninh Thuận', 'chien.nguyen@gmail.com', 2, N'Tạm Nghỉ', 'NV', 0)


Insert into TaiKhoan
VALUES 
('NV001', 'admin', 1,0),
('NV002', '123456', 1,0),
('NV003', 'Ghi789/', 1,0),
('NV004', 'Jkl012)', 0,0),
('NV005', 'Mno345[', 1,0),
('NV006', 'Pqr678*', 1,0),
('NV007', 'Stu901^', 1,0),
('NV008', 'Vwx234$', 1,0),
('NV009', 'Yz@567&', 0,0),
('NV010', 'Abc123!', 1,0),
('NV011', 'Def456~', 1,0),
('NV012', 'Ghi789/', 1,0),
('NV013', 'Jkl012)', 0,0),
('NV014', 'Mno345[', 1,0),
('NV015', 'Pqr678*', 1,0),
('NV016', 'Stu901^', 1,0),
('NV017', 'Vwx234$', 1,0),
('NV018', 'Yz@567&', 0,0),
('NV019', 'Abc123!', 1,0),
('NV020', 'Def456~', 1,0),
('NV021', 'Ghi789/', 1,0),
('NV022', 'Jkl012)', 0,0),
('NV023', 'Mno345[', 1,0),
('NV024', 'Pqr678*', 1,0),
('NV025', 'Stu901^', 1,0),
('NV026', 'Vwx234$', 1,0),
('NV027', 'Yz@567&', 1,0),
('NV028', 'Abc123!', 1,0),
('NV029', 'Def456~', 0,0),
('NV030', 'Ghi789/', 1,0)



Insert into KhachHang 
values 
('KH001', N'Nguyễn Hồng Sơn', '0129645767',0),
('KH002', N'Nguyễn Thị Hương', '0980254325', 1),
('KH003', N'Trần Văn Nam', '0123916789', 0),
('KH004', N'Lê Thị Lan', '0333103456', 1),
('KH005', N'Phạm Văn An', '0347123456', 0),
('KH006', N'Hồ Văn Hùng', '0989788888', 1),
('KH007', N'Nguyễn Thị Mai', '0598777777', 0),
('KH008', N'Trần Văn Bình', '0332633333', 1),
('KH009', N'Lê Thị Hà', '03666666566', 0),
('KH010', N'Phan Văn Tài', '09321078876', 1),
('KH011', N'Đặng Thị Ngọc', '0945698234', 0),
('KH012', N'Lương Văn Dũng', '0987674308', 1),
('KH013', N'Hoàng Thị Hương', '0982423456', 0),
('KH014', N'Nguyễn Văn Khánh', '0360932198', 1),
('KH015', N'Trần Thị Hạnh', '0967898734', 0),
('KH016', N'Phạm Văn Tuấn', '0333786556', 1),
('KH017', N'Hà Văn Quân', '0367891204', 0),
('KH018', N'Nguyễn Thị An', '0987128456', 1),
('KH019', N'Trần Văn Minh', '0367876234', 0),
('KH020', N'Hoàng Văn Thanh', '0987895402', 1),
('KH021', N'Lê Thị Hoa', '0367123453', 0),
('KH022', N'Phan Văn Hùng', '0978984654', 1),
('KH023', N'Đặng Thị Hồng', '0367864234', 0),
('KH024', N'Lương Văn Hải', '0987621361', 1),
('KH025', N'Hoàng Thị Hằng', '0367801234', 0),
('KH026', N'Nguyễn Văn Hòa', '0957684321', 1),
('KH027', N'Trần Thị Huệ', '0123453489', 0),
('KH028', N'Phạm Văn Hùng', '0333120456', 1),
('KH029', N'Lê Thị Hương', '0367128956', 0),
('KH030', N'Nguyễn Văn Minh', '0937609876', 1)

Insert into Ban 
values 
	('A01',N'Bàn 01', N'Trống', 1,0),
    ('A02',N'Bàn 02', N'Trống', 1,0),
    ('A03',N'Bàn 03', N'Trống', 1,0),
    ('A04',N'Bàn 04', N'Trống', 1,0),
    ('A05',N'Bàn 05', N'Trống', 1,0),
    ('A06',N'Bàn 06', N'Trống', 1,0),
    ('A07',N'Bàn 07', N'Trống', 1,0),
    ('A08',N'Bàn 08', N'Trống', 1,0),
    ('A09',N'Bàn 09', N'Trống', 1,0),
    ('A10',N'Bàn 10', N'Trống', 1,0),
	('B11',N'Bàn 11', N'Trống', 2,0),
    ('B12',N'Bàn 12', N'Trống', 2,0),
    ('B13',N'Bàn 13', N'Trống', 2,0),
    ('B14',N'Bàn 14', N'Trống', 2,0),
    ('B15',N'Bàn 15', N'Trống', 2,0),
    ('B16',N'Bàn 16', N'Trống', 2,0),
    ('B17',N'Bàn 17', N'Trống', 2,0),
    ('B18',N'Bàn 18', N'Trống', 2,0),
    ('B19',N'Bàn 19', N'Trống', 2,0),
    ('B20',N'Bàn 20', N'Trống', 2,0),
	('C21',N'Bàn 21', N'Trống', 3,0),
    ('C22',N'Bàn 22', N'Trống', 3,0),
    ('C23',N'Bàn 23', N'Trống', 3,0),
    ('C24',N'Bàn 24', N'Trống', 3,0),
    ('C25',N'Bàn 25', N'Trống', 3,0),
    ('C26',N'Bàn 26', N'Trống', 3,0),
    ('C27',N'Bàn 27', N'Trống', 3,0),
    ('C28',N'Bàn 28', N'Trống', 3,0),
    ('C29',N'Bàn 29', N'Trống', 3,0),
    ('C30',N'Bàn 30', N'Trống', 3,0)


	--Delete MonAn
Insert into MonAn(MaMonAn,TenMonAn,GiaTien,Loai,Size,GiaTri,TrangThai)
values 
('TD0101',N'1 miếng Gà Rán',35000,N'Gà',null,0,N'Bình Thường'),
('TD0102',N'2 miếng Gà Rán',70000,N'Gà',null,0,N'Bình Thường'),
('TD0103',N'3 miếng Gà Rán',104000,N'Gà',null,10,N'Bình Thường'),
('TD0104',N'1 miếng Đùi Gà Quay',75000,N'Gà',null,0,N'Bình Thường'),
('TD0105',N'1 Miếng Phi Lê Gà Quay',39000,N'Gà',null,0,N'Bình Thường'),
('TD0106',N'3 Miếng Phi Lê Gà Quay',97000,N'Gà',null,0,N'Bình Thường'),
('TD0107',N'3 Cánh gà Hot Wings',54000,N'Gà',null,0,N'Bình Thường'),
('TD0108',N'5 Cánh gà Hot Wings',85.000,N'Gà',null,10,N'Bình Thường'),
('TD0109',N'Gà Viên(Vừa)',38000,N'Gà',null,0,N'Bình Thường'),
('TD0110',N'5 Gà viên(Lớn)',64000,N'Gà',null,0,N'Bình Thường'),
('TD0111',N'3 miếng gà Nuggets',27000,N'Gà',null,0,N'Bình Thường'),
('TD0112',N'5 miếng gà Nuggets',40000,N'Gà',null,0,N'Bình Thường'),
('TD0113',N'10 miếng gà Nuggets',75000,N'Gà',null,5,N'Bình Thường'),

('TD0214',N'Burger Zinger',54000,N'Burger',null,0,N'Bình Thường'),
('TD0215',N'Burger Tôm',45000,N'Burger',null,0,N'Bình Thường'),
('TD0216',N'Burger Gà Quay Flava',54000,N'Burger',null,0,N'Bình Thường'),

('TD0317',N'Cơm gà xiên que',45000,N'Cơm',null,5,N'Bình Thường'),
('TD0318',N'Cơm gà Teriyaki',45000,N'Cơm',null,5,N'Bình Thường'),
('TD0319',N'Cơm gà Rán',48000,N'Cơm',null,5,N'Bình Thường'),
('TD0320',N'Cơm Phi-Lê gà Quay',45000,N'Cơm',null,5,N'Bình Thường'),
('TD0321',N'Cơm',12000,N'Cơm',null,0,N'Bình Thường'),

('TD0422',N'Mì Ý Gà Viên',40000,N'Mì Ý',null,0,N'Bình Thường'),
('TD0423',N'Mì Ý Gà Zinger',58000,N'Mì Ý',null,0,N'Bình Thường'),
('TD0424',N'Mì Ý Phi-Lê Gà Quay',61000,N'Mì Ý',null,5,N'Bình Thường'),
('TD0425',N'Mì Ý Gà Rán',61000,N'Mì Ý',null,5,N'Bình Thường'),


('TD0526',N'1 Bánh Trứng',18000,N'THỨC UỐNG & TRÁNG MIỆNG',null,0,N'Bình Thường'),
('TD0527',N'4 Bánh Trứng',58000,N'THỨC UỐNG & TRÁNG MIỆNG',null,5,N'Bình Thường'),
('TD0528',N'2 Viên Khoai Môn Kim Sa',26000,N'THỨC UỐNG & TRÁNG MIỆNG',null,0,N'Bình Thường'),
('TD0529',N'3 Viên Khoai Môn Kim Sa',34000,N'THỨC UỐNG & TRÁNG MIỆNG',null,0,N'Bình Thường'),
('TD0530',N'5 Viên Khoai Môn Kim Sa',54000,N'THỨC UỐNG & TRÁNG MIỆNG',null,5,N'Bình Thường'),
('TD0531',N'2 Thanh Bí Phô Mai',29000,N'THỨC UỐNG & TRÁNG MIỆNG',null,0,N'Bình Thường'),
('TD0532',N'3 Thanh Bí Phô Mai',42000,N'THỨC UỐNG & TRÁNG MIỆNG',null,0,N'Bình Thường'),
('TD0533',N'5 Thanh Bí Phô Mai',65000,N'THỨC UỐNG & TRÁNG MIỆNG',null,5,N'Bình Thường'),
('TD0534',N'Pepsi Lon',19000,N'THỨC UỐNG & TRÁNG MIỆNG',null,0,N'Bình Thường'),
('TD0535',N'7Up Lon',19000,N'THỨC UỐNG & TRÁNG MIỆNG',null,0,N'Bình Thường'),
('TD0536',N'Nước suối Aquafina 500ml',15000,N'THỨC UỐNG & TRÁNG MIỆNG',null,0,N'Bình Thường'),
('TD0537',N'Trà Đào',24000,N'THỨC UỐNG & TRÁNG MIỆNG','M',0,N'Bình Thường'),
('TD0538',N'Trà Đào',50000,N'THỨC UỐNG & TRÁNG MIỆNG','L',0,N'Bình Thường'),
('TD0539',N'Milo Hộp',20000,N'THỨC UỐNG & TRÁNG MIỆNG',null,0,N'Bình Thường'),
('TD0540',N'Trà Chanh Lipton(Vừa)',12000,N'THỨC UỐNG & TRÁNG MIỆNG','M',0,N'Bình Thường'),
('TD0541',N'Trà Chanh Lipton(Lớn)',17000,N'THỨC UỐNG & TRÁNG MIỆNG','L',0,N'Bình Thường'),
('TD0542',N'Pepsi Không Calo Lon',19000,N'THỨC UỐNG & TRÁNG MIỆNG',null,0,N'Bình Thường'),
('TD0543',N'Ô Long Kem Phô Mai',25000,N'THỨC UỐNG & TRÁNG MIỆNG',null,0,N'Bình Thường'),
('TD0544',N'Kem Ly Dâu Sữa',25000,N'THỨC UỐNG & TRÁNG MIỆNG','M',0,N'Bình Thường'),
('TD0545',N'Kem Ly Dâu Sữa',30000,N'THỨC UỐNG & TRÁNG MIỆNG','L',0,N'Bình Thường'),
('TD0546',N'Kem Ly Dâu Sữa',35000,N'THỨC UỐNG & TRÁNG MIỆNG','XL',0,N'Bình Thường'),
('TD0547',N'Ô Long Tuyết Lê Khổng Lồ',35000,N'THỨC UỐNG & TRÁNG MIỆNG','L',0,N'Bình Thường'),
('TD0548',N'Ô Long Tuyết Lê Khổng Lồ',40000,N'THỨC UỐNG & TRÁNG MIỆNG','XL',5,N'Bình Thường'),
('TD0549',N'Trà chanh Mật Ong Giã Tay Khổng Lồ',35000,N'THỨC UỐNG & TRÁNG MIỆNG','L',0,N'Bình Thường'),
('TD0550',N'Trà chanh Mật Ong Giã Tay Khổng Lồ',40000,N'THỨC UỐNG & TRÁNG MIỆNG','XL',5,N'Bình Thường'),
('TD0551',N'Cà phê đen đá',18000,N'THỨC UỐNG & TRÁNG MIỆNG','M',0,N'Bình Thường'),
('TD0552',N'Cà phê Sữa đá',18000,N'THỨC UỐNG & TRÁNG MIỆNG','M',0,N'Bình Thường'),

('TD0653',N'Combo Mì Ý Gà Viên ',47000,N'Combo',null,5,N'Bình Thường'),
('TD0654',N'Combo Mì Ý Gà Rán ',77000,N'Combo',null,5,N'Bình Thường'),
('TD0655',N'Combo Cơm Gà Rán ',71000,N'Combo',null,5,N'Bình Thường'),
('TD0656',N'Combo Cơm Phi Lê Gà Quay  ',71000,N'Combo',null,5,N'Bình Thường'),
('TD0657',N'Combo Cơm Gà Teriyaki ',69000,N'Combo',null,5,N'Bình Thường'),
('TD0658',N'Combo Burger Tôm ',67000,N'Combo',null,5,N'Bình Thường'),
('TD0659',N'Combo Burger Zinger ',77000,N'Combo',null,5,N'Bình Thường')


Insert into KhuyenMai
values 
(N'WELCOME',200000,30,'2024-04-11 08:00:00', '2024-07-30 23:59:59'),
(N'M1T1',200000,20,'2024-04-11 08:00:00', '2024-07-30 23:59:59'),
(N'COMBOFAMILY', 1000000,10,'2024-04-11 08:00:00', '2024-07-30 23:59:59'),
(N'BIRTHDAYTREAT',500.000,30,'2024-04-11 08:00:00', '2024-07-30 23:59:59'),
(N'PARTYDEAL',2000000,30,'2024-04-11 08:00:00', '2024-07-30 23:59:59'),
(N'SV15',200000,15,'2024-04-11 08:00:00', '2024-07-30 23:59:59'),
(N'BIRTH20-KIDS',2000000,20,'2024-04-11 08:00:00', '2024-07-30 23:59:59'),
(N'DIS50OFF',2000000,50,'2024-04-11 08:00:00', '2024-07-30 23:59:59')


INSERT INTO HoaDon 
VALUES
('HD123450030204', '2024-04-01', 'KH001', 'NV004', N'WELCOME', 10, '2024-04-01','A01'),
('HD987650030304', '2024-04-01', 'KH002', 'NV005', N'BIRTHDAYTREAT', 10, '2024-04-01','B11'),
('HD246800030104', '2024-04-01', 'KH003', 'NV001', NULL, 10, null,'C21'),
('HD556550030904', '2024-04-01', 'KH004', 'NV002', NULL, 10, '2024-04-01','A02'),
('HD111410030704', '2024-04-01', 'KH005', 'NV007', NULL, 10, null,'B12'),
('HD727770031004', '2024-04-01', 'KH006', 'NV008', N'WELCOME', 10, '2024-04-01','C22'),
('HD353330030504', '2024-04-01', 'KH007', 'NV012', NULL, 10, '2024-04-01','A03'),
('HD898880030904', '2024-04-01', 'KH008', 'NV014', NULL, 10, '2024-04-01','B13'),
('HD213220030304', '2024-04-01', 'KH009', 'NV019', NULL, 10, '2024-04-01','C23'),
('HD654660030204', '2024-04-01', 'KH010', 'NV017', NULL, 10, '2024-04-01','A04'),
('HD439440030704', '2024-04-01', 'KH011', 'NV030', N'COMBOFAMILY', 10, '2024-04-01','B14'),
('HD978990030804', '2024-04-01', 'KH012', 'NV027', NULL, 10, null,'C24'),
('HD353330030804', '2024-04-02', 'KH013', 'NV023', NULL, 10, '2024-04-02','A05'),
('HD435550030204', '2024-04-02', 'KH014', 'NV025', N'SV15', 10, '2024-04-02','B15'),
('HD687770030404', '2024-04-02', 'KH015', 'NV026', NULL, 10, '2024-04-02','C25'),
('HD298880030504', '2024-04-02', 'KH016', 'NV017', NULL, 10, null,'A06'),
('HD145110030604', '2024-04-02', 'KH017', 'NV013', NULL, 10, '2024-04-02','B16'),
('HD123450030704', '2024-04-02', 'KH018', 'NV002', NULL, 10, '2024-04-02','C26'),
('HD987650030204', '2024-04-02', 'KH019', 'NV001', NULL, 10, '2024-04-02','A07'),
('HD246800030404', '2024-04-02', 'KH020', 'NV025', N'BIRTHDAYTREAT', 10, '2024-04-02','B17'),
('HD239220030504', '2024-04-02', 'KH021', 'NV028', NULL, 10, '2024-04-02','C27'),
('HD658660030804', '2024-04-02', 'KH022', 'NV022', NULL, 10, '2024-04-02','A08'),
('HD475440030104', '2024-04-02', 'KH023', 'NV023', NULL, 10, '2024-04-02','B18'),
('HD926990030704', '2024-04-02', 'KH024', 'NV028', N'SV15', 10, '2024-04-02','C28'),
('HD397330030604', '2024-04-03', 'KH025', 'NV024', NULL, 10, '2024-04-03','A09'),
('HD528550030804', '2024-04-03', 'KH026', 'NV015', NULL, 10, '2024-04-03','B19'),
('HD739770030704', '2024-04-03', 'KH027', 'NV008', N'COMBOFAMILY', 10, '2024-04-03','C29'),
('HD841880030204', '2024-04-03', 'KH028', 'NV007', NULL, 10, '2024-04-03','A10'),
('HD167110030404', '2024-04-03', 'KH029', 'NV009', NULL, 10, null,'B20'),
('HD123450030304', '2024-04-03', 'KH030', 'NV003', NULL, 10, '2024-04-03','C30')


INSERT INTO CHITIET_KHUYENMAI_HOADON
VALUES
('HD123450030204', N'WELCOME'),
('HD727770031004', N'WELCOME'),
('HD987650030304', N'BIRTHDAYTREAT'),
('HD439440030704', N'COMBOFAMILY'),
('HD435550030204', N'SV15'),
('HD246800030404', N'BIRTHDAYTREAT'),
('HD926990030704',  N'SV15'),
('HD739770030704',N'COMBOFAMILY')



-- Chèn dữ liệu vào bảng CHI_TIET_HOADON
INSERT INTO CHI_TIET_HOADON
VALUES 
('CTHD001', 'HD123450030204', 'TD0526', 2),
('CTHD002', 'HD987650030304', 'TD0527', 1),
('CTHD003', 'HD123450030304', 'TD0528', 3),
('CTHD004', 'HD556550030904', 'TD0529', 1),
('CTHD005', 'HD841880030204', 'TD0530', 2),
('CTHD006', 'HD727770031004', 'TD0531', 2),
('CTHD007', 'HD353330030504', 'TD0532', 1),
('CTHD008', 'HD898880030904', 'TD0533', 2),
('CTHD009', 'HD213220030304', 'TD0534', 1),
('CTHD010', 'HD654660030204', 'TD0535', 4),
('CTHD011', 'HD439440030704', 'TD0536', 2),
('CTHD012', 'HD528550030804', 'TD0537', 2),
('CTHD013', 'HD353330030804', 'TD0538', 3),
('CTHD014', 'HD435550030204', 'TD0539', 1),
('CTHD015', 'HD687770030404', 'TD0540', 1),
('CTHD016', 'HD475440030104', 'TD0541', 2),
('CTHD017', 'HD145110030604', 'TD0542', 2),
('CTHD018', 'HD123450030704', 'TD0543', 1),
('CTHD019', 'HD987650030204', 'TD0544', 3),
('CTHD020', 'HD246800030404', 'TD0545', 2);
									

-- Chèn dữ liệu vào bảng PHIEU
INSERT INTO PHIEU 
VALUES
    ('P010324', '2024-03-01', 5, 7, 19, 12, 1, 15, 4, 20, 10 , 100000, 'HD123450030204'),
    ('P020324', '2024-03-02', 14, 9 , 17, 6 , 19, 4, 1, 10, 5, 200000, 'HD987650030304'),
    ('P030324', '2024-03-03', 3, 16, 12, 18, 7, 13, 11, 2, 8, 250000,'HD246800030104'),
    ('P040324', '2024-03-04', 20, 14, 5, 1, 9, 10, 17, 15, 3, 280000, 'HD556550030904'),
    ('P050324', '2024-03-05', 6, 19, 2, 11, 8, 18, 7, 12, 4, 150000,'HD111410030704'),
    ('P060324', '2024-03-06', 13, 15, 20, 17, 4, 6, 14, 9, 8, 700000, 'HD727770031004'),
    ('P070324', '2024-03-07', 10, 1, 3, 12, 5, 11, 2, 8, 7, 390000, 'HD353330030504'),
    ('P080324', '2024-03-08', 18, 13, 6, 9, 16, 20, 15, 19, 1, 870000, 'HD898880030904'),
    ('P090324', '2024-03-09', 5, 14, 7, 4, 10, 3, 12, 11, 2, 560000,'HD213220030304'),
    ('P100324', '2024-03-10', 16, 8, 1, 19, 17, 13, 18, 6, 15, 650000,'HD654660030204'),
    ('P110324', '2024-03-11', 20, 9, 10, 11, 2, 4, 12, 3, 8, 330000,'HD439440030704'),
    ('P120324', '2024-03-12', 18, 3, 19, 2, 8, 11, 10,  4, 9, 400000,'HD978990030804'),
    ('P130324', '2024-03-13', 14, 5, 7, 15, 1, 13, 6, 16, 17, 750000,'HD353330030804'),
    ('P140324', '2024-03-14', 20, 12, 1, 17, 5, 6, 15,  13, 14, 900000,'HD435550030204'),
    ('P150324', '2024-03-15', 10, 7, 12, 15, 8, 5, 3, 2, 16, 780000,'HD687770030404'),
    ('P160324', '2024-03-16', 4, 18, 6, 9, 11, 13, 20, 19, 1, 560000,'HD298880030504'),
    ('P170324', '2024-03-17', 14, 17, 3, 10, 2, 16, 8, 5, 12, 680000,'HD145110030604'),
    ('P180324', '2024-03-18', 19, 4, 7, 1, 20, 9, 15, 13, 6, 590000,'HD123450030704'),
    ('P190324', '2024-03-19', 11, 16, 5, 2, 8, 3, 10, 12, 14, 780000,'HD987650030204'),
    ('P200324', '2024-03-20', 18, 6, 13, 15, 1, 17, 19, 20, 4, 990000,'HD246800030404'),
    ('P210324', '2024-03-21', 7, 11, 9, 14, 10, 5, 6, 8, 12, 950000,'HD239220030504'),
    ('P220324', '2024-03-22', 20, 4, 7, 12, 8, 9, 15, 10, 6, 370000,'HD658660030804'),
    ('P230324', '2024-03-23', 5, 18, 3, 1, 11, 14, 16, 19, 2, 470000,'HD475440030104'),
    ('P240324', '2024-03-24', 20, 8, 4, 9, 3, 10, 7, 6, 15, 870000,'HD926990030704'),
    ('P250324', '2024-03-25', 13, 3, 16, 11, 5, 14, 20, 9, 7, 880000,'HD397330030604'),
    ('P260324', '2024-03-26', 18, 1, 19, 8, 2, 17, 6, 12, 10, 120000,'HD528550030804'),
    ('P270324', '2024-03-27', 11, 6, 2, 8, 3, 16, 18, 14, 1, 470000,'HD739770030704'),
    ('P280324', '2024-03-28', 17, 7, 15, 10, 19, 4, 12, 5, 13, 580000,'HD841880030204'),
	('P290324', '2024-03-29', 20, 9, 6, 1, 18, 3, 13, 8,  17, 390000, 'HD167110030404'),
	('P300324', '2024-03-30', 16, 14, 11, 7, 4, 19, 5, 2, 8, 1000000,'HD123450030304')


INSERT INTO PHANCONGNHANVIEN 
VALUES
('NV001', 1, '2024-05-01 08:00:00', 1),
('NV002', 1, '2024-05-01 14:00:00', 1),
('NV003', 2, '2024-05-01 22:00:00', 1),
('NV004', 3, '2024-05-02 08:00:00', 1),
('NV005', 1, '2024-05-02 14:00:00', 1),
('NV006', 2, '2024-05-02 22:00:00', 0),
('NV007', 3, '2024-05-03 08:00:00', 1),
('NV008', 1, '2024-05-03 14:00:00', 1),
('NV009', 2, '2024-05-03 22:00:00', 1),
('NV010', 3, '2024-05-04 08:00:00', 1),
('NV011', 1, '2024-05-04 14:00:00', 1),
('NV012', 2, '2024-05-04 22:00:00', 0),
('NV013', 3, '2024-05-05 08:00:00', 1),
('NV014', 1, '2024-05-05 14:00:00', 1),
('NV015', 2, '2024-05-05 22:00:00', 1),
('NV016', 3, '2024-05-06 08:00:00', 0),
('NV017', 1, '2024-05-06 14:00:00', 1),
('NV018', 2, '2024-05-06 22:00:00', 1),
('NV019', 3, '2024-05-07 08:00:00', 1),
('NV020', 1, '2024-05-07 14:00:00', 0),
('NV021', 2, '2024-05-07 22:00:00', 1),
('NV022', 3, '2024-05-08 08:00:00', 0),
('NV023', 1, '2024-05-08 14:00:00', 1),
('NV024', 2, '2024-05-08 22:00:00', 1),
('NV025', 3, '2024-05-09 08:00:00', 1),
('NV026', 1, '2024-05-09 14:00:00', 1),
('NV027', 2, '2024-05-09 22:00:00', 1),
('NV028', 3, '2024-05-10 08:00:00', 1),
('NV029', 1, '2024-05-10 14:00:00', 1),
('NV030', 2, '2024-05-10 22:00:00', 0);





package javaapplication8.model;

public class HoaDon_Model {
    
    private int id;
    private String maHD;
    private int idKH;
    private int idNV;
    private int idPGG;
    private int idTT;
    private String tenKhachHang;
    private String maNV;
    private String ngayTao;
    private String sdtKH;
    private String tongTien;
    private String tongTienKhiGiam;
    private String diaChiKhachHang;
    private boolean trangThai;
    private int tongSP;

    public HoaDon_Model() {
    }

    public HoaDon_Model(int id, String maHD, int idKH, int idNV, int idPGG, int idTT, String tenKhachHang, String maNV, String ngayTao, String sdtKH, String tongTien, String tongTienKhiGiam, String diaChiKhachHang, boolean trangThai, int tongSP) {
        this.id = id;
        this.maHD = maHD;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idPGG = idPGG;
        this.idTT = idTT;
        this.tenKhachHang = tenKhachHang;
        this.maNV = maNV;
        this.ngayTao = ngayTao;
        this.sdtKH = sdtKH;
        this.tongTien = tongTien;
        this.tongTienKhiGiam = tongTienKhiGiam;
        this.diaChiKhachHang = diaChiKhachHang;
        this.trangThai = trangThai;
        this.tongSP = tongSP;
    }

    public int getTongSP() {
        return tongSP;
    }

    public void setTongSP(int tongSP) {
        this.tongSP = tongSP;
    }

    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public int getIdPGG() {
        return idPGG;
    }

    public void setIdPGG(int idPGG) {
        this.idPGG = idPGG;
    }

    public int getIdTT() {
        return idTT;
    }

    public void setIdTT(int idTT) {
        this.idTT = idTT;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getTongTienKhiGiam() {
        return tongTienKhiGiam;
    }

    public void setTongTienKhiGiam(String tongTienKhiGiam) {
        this.tongTienKhiGiam = tongTienKhiGiam;
    }

    public String getDiaChiKhachHang() {
        return diaChiKhachHang;
    }

    public void setDiaChiKhachHang(String diaChiKhachHang) {
        this.diaChiKhachHang = diaChiKhachHang;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}

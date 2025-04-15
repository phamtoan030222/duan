
package javaapplication8.model;

public class PhieuGiamGiaModel {
    
    private int id;
    private String maPGG;
    private String ngayDB;
    private String ngayKT;
    private int soLuong;
    private double HDToiThieu;
    private int phantramgiam;
    private double giamToiDa;
    private String ngayTao;
    private String maNV;
    private int trangThai;

    public PhieuGiamGiaModel() {
    }

    public PhieuGiamGiaModel(int id, String maPGG, String ngayDB, String ngayKT, int soLuong, double HDToiThieu, int phantramgiam, double giamToiDa, String ngayTao, String maNV, int trangThai) {
        this.id = id;
        this.maPGG = maPGG;
        this.ngayDB = ngayDB;
        this.ngayKT = ngayKT;
        this.soLuong = soLuong;
        this.HDToiThieu = HDToiThieu;
        this.phantramgiam = phantramgiam;
        this.giamToiDa = giamToiDa;
        this.ngayTao = ngayTao;
        this.maNV = maNV;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaPGG() {
        return maPGG;
    }

    public void setMaPGG(String maPGG) {
        this.maPGG = maPGG;
    }

    public String getNgayDB() {
        return ngayDB;
    }

    public void setNgayDB(String ngayDB) {
        this.ngayDB = ngayDB;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getHDToiThieu() {
        return HDToiThieu;
    }

    public void setHDToiThieu(double HDToiThieu) {
        this.HDToiThieu = HDToiThieu;
    }

    public int getPhantramgiam() {
        return phantramgiam;
    }

    public void setPhantramgiam(int phantramgiam) {
        this.phantramgiam = phantramgiam;
    }

    public double getGiamToiDa() {
        return giamToiDa;
    }

    public void setGiamToiDa(double giamToiDa) {
        this.giamToiDa = giamToiDa;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
      
    
}

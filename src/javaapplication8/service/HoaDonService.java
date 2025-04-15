package javaapplication8.service;

import java.math.BigDecimal;
import java.util.List;
import javaapplication8.model.HoaDonChiTiet_Model;
import javaapplication8.model.HoaDon_Model;

public interface HoaDonService {
    
    int taoNhanhHoaDonS(String mahd, int idNV, String ngay);
    
    List<HoaDon_Model> danhSachHoaDon();
    
    List<HoaDonChiTiet_Model> layChiTietHoaDonTheoId(int idHoaDon);
    
    int laySoLuongTheoSPCT(int idHD, int idSPCT);
    
    boolean capNhatSoLuong(int idHD, int IdSPCT, int soLuongMoi);
    
    boolean themSanPhamVaoHoaDon(int idHD, int idSPCT, int soLuong, BigDecimal donGia, String maHDCT);
    
    boolean xoaSanPhamKhoiHoaDon(int idHD,int idSPCT);

}

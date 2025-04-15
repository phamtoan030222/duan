package javaapplication8.service.serviceimpl;

import java.math.BigDecimal;
import java.util.List;
import javaapplication8.dao.HoaDonDao;
import javaapplication8.model.HoaDonChiTiet_Model;
import javaapplication8.model.HoaDon_Model;
import javaapplication8.service.HoaDonService;

public class HoaDonServiceImpl implements HoaDonService {

    private final HoaDonDao hoaDonDao = new HoaDonDao();

    @Override
    public int taoNhanhHoaDonS(String mahd, int idNV, String ngay) {
        return hoaDonDao.taoNhanhHoaDon(mahd, idNV, ngay);
    }

    @Override
    public List<HoaDon_Model> danhSachHoaDon() {
        return hoaDonDao.danhSachHoaDon();
    }

    @Override
    public List<HoaDonChiTiet_Model> layChiTietHoaDonTheoId(int idHoaDon) {
        return hoaDonDao.layChiTietHoaDonTheoID(idHoaDon);
    }

    @Override
    public int laySoLuongTheoSPCT(int idHD, int idSPCT) {
        return hoaDonDao.laySoLuongTheoSPCT(idHD, idSPCT);
    }

    @Override
    public boolean capNhatSoLuong(int idHD, int IdSPCT, int soLuongMoi) {
        return hoaDonDao.capNhatSoLuong(idHD, IdSPCT, soLuongMoi);
    }

    @Override
    public boolean themSanPhamVaoHoaDon(int idHD, int idSPCT, int soLuong, BigDecimal donGia, String maHDCT) {
        return hoaDonDao.themSanPhamVaoHoaDon(idHD, idSPCT, soLuong, donGia, maHDCT);
    }

    @Override
    public boolean xoaSanPhamKhoiHoaDon(int idHD, int idSPCT) {
        return hoaDonDao.xoaSanPhamKhoiHoaDon(idHD, idSPCT);
    }

    @Override
    public boolean updateHoaDon(String maHD, String ngayThanhToan, int idKH, BigDecimal tongTien, int idPhieuGG, int hinhTHucThanhToan, BigDecimal tongTienThucTra) {
        return hoaDonDao.updateHoaDon(maHD, ngayThanhToan, idKH, tongTien, idPhieuGG, hinhTHucThanhToan, tongTienThucTra);
    }

    @Override
    public boolean huyHoaDon(String maHD) {
         return hoaDonDao.huyHoaDon(maHD);
    }

    @Override
    public HoaDon_Model layIdHoaDonTheoMa(String ma) {
        return hoaDonDao.layIdHoaDonTheoMa(ma);
    }

    

}

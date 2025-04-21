package javaapplication8.service.serviceimpl;

import java.util.List;
import javaapplication8.dao.KhachHangDao;
import javaapplication8.model.KhachHangModel;
import javaapplication8.service.KhachHangService;

public class KhachHangServiceImpl implements KhachHangService {
    
    private KhachHangDao dao = new KhachHangDao();
    
    @Override
    public List<KhachHangModel> danhSachKhachHang() {
        return dao.danhSachKhachHang();
    }
    
    @Override
    public boolean addKhachHang(KhachHangModel kh) {
        return dao.addKhachHang(kh);
    }
    
    @Override
    public KhachHangModel layKhachHangTheoMa(String makh) {
        return dao.layKhachHangTheoMa(makh);
    }
    
    @Override
    public boolean capNhatKhachHang(KhachHangModel kh) {
        return dao.capNhatKhachHang(kh);
    }
    
    @Override
    public boolean xoaKhachHang(String maHk) {
        return dao.xoaKhachHang(maHk);
    }
    @Override
    public List<KhachHangModel> timKiem(String timKiem) {
       return dao.timKiem(timKiem); }

    
}

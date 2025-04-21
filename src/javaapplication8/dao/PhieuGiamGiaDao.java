package javaapplication8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaapplication8.model.HoaDon_Model;
import javaapplication8.model.PhieuGiamGiaModel;
import javaapplication8.until.CurrentUser;
import javaapplication8.until.DBConnect;

public class PhieuGiamGiaDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private List<PhieuGiamGiaModel> list;

    public PhieuGiamGiaDao() {
        conn = DBConnect.getConnection();
        list = new ArrayList<>();
    }

    public List<PhieuGiamGiaModel> getAll() {
        List<PhieuGiamGiaModel> list = new ArrayList<>();

        String sql = """
        SELECT 
            pgg.ID,
            pgg.ma_phieu,
            pgg.ngay_bat_dau,
            pgg.ngay_het_han,
            pgg.ten_phieu,
            pgg.so_luong,
            pgg.hoa_don_toi_thieu,
            pgg.so_phan_tram_giam,
            pgg.so_tien_giam_toi_da,
            pgg.ngay_tao,
            pgg.id_NV,
            nv.Ma_NV,
            pgg.trang_thai
        FROM 
            Phieu_Giam_Gia pgg
        JOIN 
            NhanVien nv ON pgg.id_NV = nv.id
        WHERE 
            pgg.trang_thai <> 4;
    """;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRowToPhieuGiamGia(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<PhieuGiamGiaModel> getByTrangThai(int value) {
        List<PhieuGiamGiaModel> list = new ArrayList<>();

        String sql = """
    SELECT 
        pgg.ID,
        pgg.ma_phieu,
        pgg.ngay_bat_dau,
        pgg.ngay_het_han,
        pgg.ten_phieu,
        pgg.so_luong,
        pgg.hoa_don_toi_thieu,
        pgg.so_phan_tram_giam,
        pgg.so_tien_giam_toi_da,
        pgg.ngay_tao,
        pgg.id_NV,
        nv.Ma_NV,
        pgg.trang_thai
    FROM 
        Phieu_Giam_Gia pgg
    JOIN 
        NhanVien nv ON pgg.id_NV = nv.id
    WHERE 
        (? = 0 AND pgg.ngay_bat_dau > GETDATE())  -- Sử dụng GETDATE() thay thế CURRENT_DATE
     OR (? = 1 AND pgg.ngay_bat_dau <= GETDATE() AND pgg.ngay_het_han >= GETDATE())
     OR (? = 2 AND pgg.ngay_het_han < GETDATE())
""";

        try {

            ps = conn.prepareStatement(sql);
            ps.setInt(1, value);
            ps.setInt(2, value);
            ps.setInt(3, value);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRowToPhieuGiamGia(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    private PhieuGiamGiaModel mapRowToPhieuGiamGia(ResultSet rs) throws SQLException {
        PhieuGiamGiaModel p = new PhieuGiamGiaModel();
        p.setId(rs.getInt("ID"));
        p.setMaPGG(rs.getString("ma_phieu"));
        p.setNgayDB(rs.getDate("ngay_bat_dau").toString());
        p.setNgayKT(rs.getDate("ngay_het_han").toString());
        p.setTenPGG(rs.getString("ten_phieu"));
        p.setSoLuong(rs.getInt("so_luong"));
        p.setHDToiThieu(rs.getBigDecimal("hoa_don_toi_thieu"));
        p.setPhantramgiam(rs.getInt("so_phan_tram_giam"));
        p.setGiamToiDa(rs.getBigDecimal("so_tien_giam_toi_da"));
        p.setNgayTao(rs.getDate("ngay_tao").toString());
        p.setId(rs.getInt("id_NV"));
        p.setMaNV(rs.getString("Ma_NV"));
        p.setTrangThai(rs.getInt("trang_thai"));
        return p;
    }

    public PhieuGiamGiaModel layPhieuGiamGiaTheoTen(String phieuGiamGia) {
        PhieuGiamGiaModel pgg = new PhieuGiamGiaModel();
        String sql = """
                     SELECT 
                                 pgg.ID,
                                 pgg.ma_phieu,
                                 pgg.ngay_bat_dau,
                                 pgg.ngay_het_han,
                                 pgg.ten_phieu,
                                 pgg.so_luong,
                                 pgg.hoa_don_toi_thieu,
                                 pgg.so_phan_tram_giam,
                                 pgg.so_tien_giam_toi_da,
                                 pgg.ngay_tao,
                                 pgg.id_NV,
                                 nv.Ma_NV,
                                 pgg.trang_thai
                             FROM 
                                 Phieu_Giam_Gia pgg
                             JOIN 
                                 NhanVien nv ON pgg.id_NV = nv.id
                             WHERE pgg.ten_phieu = ?
                     """;
        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, phieuGiamGia);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pgg = mapRowToPhieuGiamGia(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pgg;
    }

    public boolean capNhatSoLuongPhieuGiamGia(int idPGG) {
        if (idPGG != -1) {
            String sql = """
                         UPDATE Phieu_Giam_Gia SET So_Luong = So_luong - 1
                         WHERE id = ?
                         """;
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, idPGG);
                return ps.executeUpdate() > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean themMoiPGG(PhieuGiamGiaModel pgg) {
        String sql = """
                     INSERT INTO Phieu_Giam_Gia (MA_PHIEU, TEN_PHIEU, SO_LUONG, HOA_DON_TOI_THIEU, 
                                                                 SO_PHAN_TRAM_GIAM, SO_TIEN_GIAM_TOI_DA, NGAY_BAT_DAU, 
                                                                 NGAY_HET_HAN, NGAY_TAO, ID_NV, TRANG_THAI)
                                      VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                     """;
        try {
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, pgg.getMaPGG());
            ps.setString(2, pgg.getTenPGG());
            ps.setInt(3, pgg.getSoLuong());
            ps.setBigDecimal(4, pgg.getHDToiThieu());
            ps.setInt(5, pgg.getPhantramgiam());
            ps.setBigDecimal(6, pgg.getGiamToiDa());
            ps.setString(7, pgg.getNgayDB());        // lấy từ JDateChooser
            ps.setString(8, pgg.getNgayKT());        // lấy từ JDateChooser
            ps.setString(9, pgg.getNgayTao());       // ngày hôm nay
            ps.setInt(10, CurrentUser.get().getId()); // gán ID_NV từ người đăng nhập
            ps.setInt(11, pgg.getTrangThai());   


            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean xoaPhieuGiamGia(String maPGG) {
        String sql = """
              update Phieu_Giam_Gia
              set TRANG_THAI = 4
              where MA_PHIEU = ?
              """;

        try {
            ps = conn.prepareStatement(sql);

            ps.setNString(1, maPGG);

            return ps.executeUpdate() > 0;//thêm/sửa/xoá:executeUpđate()

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}

package javaapplication8.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaapplication8.model.HoaDonChiTiet_Model;
import javaapplication8.model.HoaDon_Model;
import javaapplication8.until.DBConnect;

public class HoaDonDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private List<HoaDon_Model> list;

    public HoaDonDao() {
        conn = DBConnect.getConnection();

        list = new ArrayList<>();
    }

    //Tạo nhanh hóa đơn:
    public int taoNhanhHoaDon(String mahd, int idNV, String ngay) {
        String countSql = "SELECT COUNT(*) FROM Hoa_Don WHERE TRANG_THAI = 0";
        String insertSql = "INSERT INTO Hoa_Don(MA_HD, ID_NV, NGAY_TAO, TRANG_THAI) VALUES (?, ?, ?, 0)";
        int idHD = -1;

        try {
            // 1. Kiểm tra số lượng hóa đơn chưa thanh toán
            ps = conn.prepareStatement(countSql);
            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count >= 10) {
                    return -1; // Quá 10 hóa đơn chưa thanh toán
                }
            }

            // 2. Thêm hóa đơn mới và lấy ID tự tăng
            ps = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, mahd);
            ps.setInt(2, idNV);
            ps.setString(3, ngay);

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    idHD = rs.getInt(1); // Lấy ID hóa đơn vừa insert
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return idHD; // Trả về ID nếu thành công, -1 nếu thất bại
    }

    public List<HoaDon_Model> danhSachHoaDon() {
        List<HoaDon_Model> list = new ArrayList<>();

        String sql = """
    SELECT 
        Hoa_Don.ID,
        Hoa_Don.ID_KH,
        Hoa_Don.ID_NV,
        Hoa_Don.ID_PGG,
        Hoa_Don.ID_THANH_TOAN,
        Hoa_Don.TONG_TIEN,
        Hoa_Don.MA_HD,
        Hoa_Don.NGAY_TAO,
        NhanVien.MA_NV AS MA_NV,
        Khach_Hang.TEN_KHACH_HANG AS TEN_KH,
        SUM(Hoa_Don_Chi_Tiet.SO_LUONG) AS TONG_SO_SAN_PHAM
    FROM Hoa_Don 
    LEFT JOIN Khach_Hang ON Khach_Hang.id = Hoa_Don.ID_KH
    LEFT JOIN NhanVien ON NhanVien.id = Hoa_Don.ID_NV
    LEFT JOIN Phieu_Giam_Gia ON Phieu_Giam_Gia.id = Hoa_Don.ID_PGG
    LEFT JOIN Hinh_Thuc_Thanh_Toan ON Hinh_Thuc_Thanh_Toan.id = Hoa_Don.ID_THANH_TOAN
    LEFT JOIN Hoa_Don_Chi_Tiet ON Hoa_Don_Chi_Tiet.ID_HD = Hoa_Don.ID
    WHERE Hoa_Don.TRANG_THAI = 0
    GROUP BY 
        Hoa_Don.ID,
        Hoa_Don.ID_KH,
        Hoa_Don.ID_NV,
        Hoa_Don.ID_PGG,
        Hoa_Don.ID_THANH_TOAN,
        Hoa_Don.TONG_TIEN,
        Hoa_Don.MA_HD,
        Hoa_Don.NGAY_TAO,
        NhanVien.MA_NV,
        Khach_Hang.TEN_KHACH_HANG
""";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_Model model = new HoaDon_Model();
                model.setId(rs.getInt("ID"));
                model.setIdKH(rs.getInt("ID_KH"));
                model.setMaNV(rs.getString("MA_NV"));
                model.setIdNV(rs.getInt("ID_NV"));
                model.setIdPGG(rs.getInt("ID_PGG"));
                model.setIdTT(rs.getInt("ID_THANH_TOAN"));
                model.setTenKhachHang(rs.getString("TEN_KH"));
                model.setTongTien(rs.getString("TONG_TIEN"));
                model.setNgayTao(rs.getString("NGAY_TAO"));
                model.setMaHD(rs.getString("MA_HD"));
                model.setTongSP(rs.getInt("TONG_SO_SAN_PHAM"));
                list.add(model);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi truy vấn danh sách hóa đơn:");
            e.printStackTrace();
        }

        return list;
    }

    public List<HoaDonChiTiet_Model> layChiTietHoaDonTheoID(int idHoaDon) {
        List<HoaDonChiTiet_Model> dsGioHang = new ArrayList<>();
        String sql = """
                    SELECT 
                        hdct.ID_SPCT,
                        spct.MA_SPCT,
                        sp.TEN AS TEN_SP,
                        ms.TEN AS MAU_SAC,
                        cl.TEN AS CHAT_LIEU,
                        kt.TEN AS KICH_THUOC,
                        FORMAT(hdct.DON_GIA, 'N0') + ' VND' AS DON_GIA,
                        hdct.SO_LUONG,
                        FORMAT(hdct.DON_GIA * hdct.SO_LUONG, 'N0') + ' VND' AS THANH_TIEN
                    FROM Hoa_Don_Chi_Tiet hdct
                    JOIN San_Pham_Chi_Tiet spct ON hdct.ID_SPCT = spct.ID
                    JOIN San_Pham sp ON spct.ID_SAN_PHAM = sp.ID
                    JOIN Mau_Sac ms ON spct.ID_MAU_SAC = ms.ID
                    JOIN Chat_Lieu cl ON spct.ID_CHAT_LIEU = cl.ID
                    JOIN Kich_Thuoc kt ON spct.ID_KICH_THUOC = kt.ID
                    WHERE hdct.ID_HD = ?;
                    """;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idHoaDon);
            rs = ps.executeQuery();

            while (rs.next()) {
                HoaDonChiTiet_Model hdct = new HoaDonChiTiet_Model();
                hdct.setMaSPCT(rs.getString("MA_SPCT"));
                hdct.setTenSP(rs.getString("TEN_SP"));
                hdct.setMauSac(rs.getString("MAU_SAC"));
                hdct.setChatLieu(rs.getString("CHAT_LIEU"));
                hdct.setKichThuoc(rs.getString("KICH_THUOC"));
                hdct.setDonGia(rs.getString("DON_GIA"));
                hdct.setSoLuong(rs.getInt("SO_LUONG"));
                hdct.setThanhTien(rs.getString("THANH_TIEN"));
                hdct.setIdSPCT(rs.getInt("ID_SPCT"));
                dsGioHang.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsGioHang;
    }
    //Kiểm tra số lượng trong giỏ hàng

    public int laySoLuongTheoSPCT(int idHD, int idSPCT) {
        String sql = """
                     SELECT SO_LUONG FROM Hoa_Don_Chi_Tiet 
                     WHERE ID_HD = ? AND ID_SPCT = ?
                     """;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idHD);
            ps.setInt(2, idSPCT);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("SO_LUONG");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Cập nhật số lượng khi đã có trong giỏ hàng
    public boolean capNhatSoLuong(int idHD, int IdSPCT, int soLuongMoi) {
        String sql = """
                     UPDATE Hoa_Don_Chi_Tiet SET SO_LUONG = ?
                     WHERE ID_HD = ? AND ID_SPCT = ?
                     """;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuongMoi);
            ps.setInt(2, idHD);
            ps.setInt(3, IdSPCT);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean themSanPhamVaoHoaDon(int idHD, int idSPCT, int soLuong, BigDecimal donGia, String maHDCT) {
        System.out.println("So luong: " + soLuong);
        String sql = """
                     INSERT INTO Hoa_Don_Chi_Tiet (ID_HD, ID_SPCT, SO_LUONG, DON_GIA, MA_HDCT)
                     VALUES (?,?,?,?,?);
                     """;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idHD);
            ps.setInt(2, idSPCT);
            ps.setInt(3, soLuong);
            ps.setBigDecimal(4, donGia);
            ps.setString(5, maHDCT);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Xoa Sản phẩm khỏi hóa đơn:
    public boolean xoaSanPhamKhoiHoaDon(int idHD, int idSPCT) {
        String sql = """
                DELETE FROM Hoa_Don_Chi_Tiet WHERE ID_HD = ? AND ID_SPCT = ?
                """;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idHD);
            ps.setInt(2, idSPCT);
            int rows = ps.executeUpdate();
            System.out.println("++++" + rows + " - " + idHD + " - " + idSPCT);
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    

}

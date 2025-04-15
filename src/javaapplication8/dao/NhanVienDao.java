package javaapplication8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaapplication8.model.Model_NhanVien;
import javaapplication8.until.DBConnect;

public class NhanVienDao implements PhanTrangDao<Model_NhanVien>{
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ArrayList<Model_NhanVien> list;

    public NhanVienDao() {
       conn = DBConnect.getConnection();
       list = new ArrayList<>();
    }
    
    //
    
    
    
    //Kiem tra dang nhap:
    public Model_NhanVien kiemTraDangNhap(String tenDN, String mk){
        String sql = """
                     SELECT * FROM NhanVien
                     WHERE TEN_DANG_NHAP = ? AND MAT_KHAU = ? AND TRANG_THAI = 0
              """;
        Model_NhanVien nv = new Model_NhanVien();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tenDN);
            ps.setString(2, mk);
            
            rs = ps.executeQuery();
            while (rs.next()) {                
                nv.setId(rs.getInt("ID"));
                nv.setMaNV(rs.getString("MA_NV"));
                nv.setTenNV(rs.getString("TEN_NV"));
                nv.setGioiTinh(rs.getBoolean("GIOI_TINH"));
                nv.setNgaySinh(rs.getString("NGAY_SINH"));
                nv.setSodienThoai(rs.getString("SO_DIEN_THOAI"));
                nv.setEmail(rs.getString("EMAIL"));
                nv.setDiaChi(rs.getString("DIA_CHI"));
                nv.setTenDN(rs.getString("TEN_DANG_NHAP"));
                nv.setMk(rs.getString("MAT_KHAU"));
                nv.setVaiTro(rs.getBoolean("VAI_TRO"));
                nv.setTrangThai(rs.getBoolean("TRANG_THAI"));
                return nv;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
  

    public Model_NhanVien kiemTraEmail(String email) {
     String sql = """
                     SELECT EMAIL from NhanVien 
                     WHERE EMAIL = ? AND TRANG_THAI = 0
                     """;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Model_NhanVien nv = new Model_NhanVien();
                nv.setEmail(rs.getString("EMAIL"));
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;}
    
    public boolean capNhatMatKhau(String email, String newPassword) {
        String sql = "UPDATE NhanVien SET MAT_KHAU = ? WHERE EMAIL = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newPassword);
            ps.setString(2, email);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int countAll() throws SQLException {
        rs = conn.createStatement().executeQuery("SELECT COUNT (*) FROM NhanVien");
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public List<Model_NhanVien> getPage(int offset, int limit) throws SQLException {
    List<Model_NhanVien> list = new ArrayList<>();
    
    String sql = """
        SELECT * FROM (
            SELECT *, ROW_NUMBER() OVER (ORDER BY ID) AS rn
            FROM NhanVien
        ) AS temp
        WHERE rn BETWEEN ? AND ?
    """;

    ps = conn.prepareStatement(sql);
    ps.setInt(1, offset + 1);              // SQL Server dùng 1-based index
    ps.setInt(2, offset + limit);          // offset = (page - 1) * limit

    rs = ps.executeQuery();

    while (rs.next()) {
        Model_NhanVien nv = new Model_NhanVien(); // ✅ Mỗi lần tạo mới!
        nv.setId(rs.getInt("ID"));
        nv.setMaNV(rs.getString("MA_NV"));
        nv.setTenNV(rs.getString("TEN_NV"));
        nv.setGioiTinh(rs.getBoolean("GIOI_TINH"));
        nv.setNgaySinh(rs.getString("NGAY_SINH"));
        nv.setSodienThoai(rs.getString("SO_DIEN_THOAI"));
        nv.setEmail(rs.getString("EMAIL"));
        nv.setDiaChi(rs.getString("DIA_CHI"));
        nv.setTenDN(rs.getString("TEN_DANG_NHAP"));
        nv.setMk(rs.getString("MAT_KHAU"));
        nv.setVaiTro(rs.getBoolean("VAI_TRO"));
        nv.setTrangThai(rs.getBoolean("TRANG_THAI"));
        list.add(nv);
    }

    rs.close();
    ps.close();
    return list;
}

}

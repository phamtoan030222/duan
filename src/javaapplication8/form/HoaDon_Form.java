package javaapplication8.form;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javaapplication8.model.HoaDonChiTiet_Model;
import javaapplication8.model.HoaDon_Model;
import javaapplication8.model.Model_NhanVien;
import javaapplication8.model.PhuongThucThanhToan;
import javaapplication8.model.SanPham_ChiTiet;
import javaapplication8.service.HoaDonService;
import javaapplication8.service.PhuongThucThanhToanService;
import javaapplication8.service.SanPhamChiTietService;
import javaapplication8.service.serviceimpl.HoaDonServiceImpl;
import javaapplication8.service.serviceimpl.PhuongThucThanhToanServiceImp;
import javaapplication8.service.serviceimpl.SanPhamChiTietServiceImpl;
import javaapplication8.until.CodeGeneratorUtil;
import javaapplication8.until.STT;
import javaapplication8.until.Text;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HoaDon_Form extends javax.swing.JPanel {

    private SanPhamChiTietService snctService = new SanPhamChiTietServiceImpl();
    private Model_NhanVien nhanVien;
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private PhuongThucThanhToanService ptttService = new PhuongThucThanhToanServiceImp();
    private String currentMaHD;
    private int currentIdHD = -1;

    public void setNhanVien(Model_NhanVien nv) {
        this.nhanVien = nv;
    }

    public HoaDon_Form(Model_NhanVien nv) {
        initComponents();

        //fill bảng sản phẩm chi tiết
        fillSanPhamChiTiet(snctService.getAllSanPhamChiTiet());
        fillBangHoaDon(hoaDonService.danhSachHoaDon());

        //ẩn cot id cua bang hoa don
        tableHoaDon.getColumnModel().getColumn(6).setMinWidth(0);
        tableHoaDon.getColumnModel().getColumn(6).setMaxWidth(0);
        tableHoaDon.getColumnModel().getColumn(6).setWidth(0);
        
        cbo_httt.removeAllItems();
        List<PhuongThucThanhToan> pt = ptttService.layPhuongThucThanhToan();
        cbo_httt.addItem("Cả 2");
        for (PhuongThucThanhToan phuongThucThanhToan : pt) {
            cbo_httt.addItem(phuongThucThanhToan.getTenPT());
        }

    }

    //Phương thức fill san phẩm chi tiết:
    void fillSanPhamChiTiet(List<SanPham_ChiTiet> list) {
        DefaultTableModel model = (DefaultTableModel) tbl_bangsanphamchitiet.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        for (SanPham_ChiTiet sp : list) {
            model.addTableModelListener(e -> STT.updateSTT(model));
            model.addRow(new Object[]{
                null,
                sp.getMaSp(),
                sp.getTenSp(),
                sp.getMauSac(),
                sp.getChatLieu(),
                sp.getKichThuoc(),
                sp.getSoLuong(),
                sp.getDonGia(),
                sp.getId()});
            System.out.println("" + sp.getId());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btn_taohoadon = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHoaDon = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableGioHang = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_bangsanphamchitiet = new javax.swing.JTable();
        txt_timkiem = new javax.swing.JTextField();
        cbo_mausac = new javax.swing.JComboBox<>();
        cbo_chatlieu = new javax.swing.JComboBox<>();
        cbo_kichthuoc = new javax.swing.JComboBox<>();
        cbo_gia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txt_ngaytao = new javax.swing.JTextField();
        txt_ngaythanhtoan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_manv = new javax.swing.JTextField();
        txt_mahd = new javax.swing.JTextField();
        txt_tongtien = new javax.swing.JTextField();
        txt_tenkhachhang = new javax.swing.JTextField();
        cbo_phieugiamgia = new javax.swing.JComboBox<>();
        cbo_httt = new javax.swing.JComboBox<>();
        txt_tienkhachdua = new javax.swing.JTextField();
        txt_tienkhachchuyenkhoan = new javax.swing.JTextField();
        txt_tienthua = new javax.swing.JTextField();
        lbl_tongtienthuc = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("BÁN HÀNG");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Hóa đơn");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
        jButton1.setText("Quét mã SP");

        btn_taohoadon.setBackground(new java.awt.Color(153, 255, 255));
        btn_taohoadon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_taohoadon.setForeground(new java.awt.Color(0, 0, 204));
        btn_taohoadon.setText("Tạo hóa đơn");
        btn_taohoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taohoadonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 204));
        jButton3.setText("Làm mới");

        tableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Mã hóa đơn", "Ngày tạo", "Nhân viên", "Tổng SP", "Trạng thái", "ID"
            }
        ));
        tableHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableHoaDon);
        if (tableHoaDon.getColumnModel().getColumnCount() > 0) {
            tableHoaDon.getColumnModel().getColumn(0).setMinWidth(30);
            tableHoaDon.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableHoaDon.getColumnModel().getColumn(0).setMaxWidth(30);
            tableHoaDon.getColumnModel().getColumn(1).setResizable(false);
            tableHoaDon.getColumnModel().getColumn(6).setMinWidth(0);
            tableHoaDon.getColumnModel().getColumn(6).setPreferredWidth(0);
            tableHoaDon.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btn_taohoadon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btn_taohoadon)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Giỏ hàng");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tableGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Mã SPCT", "Tên SP", "Màu sắc", "Chất liệu", "Kích thước", "Giá bán", "Số lượng", "Thành tiền", "idSPCT"
            }
        ));
        tableGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableGioHang);
        if (tableGioHang.getColumnModel().getColumnCount() > 0) {
            tableGioHang.getColumnModel().getColumn(0).setMinWidth(30);
            tableGioHang.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableGioHang.getColumnModel().getColumn(0).setMaxWidth(30);
            tableGioHang.getColumnModel().getColumn(1).setResizable(false);
            tableGioHang.getColumnModel().getColumn(7).setMinWidth(70);
            tableGioHang.getColumnModel().getColumn(7).setPreferredWidth(70);
            tableGioHang.getColumnModel().getColumn(7).setMaxWidth(70);
            tableGioHang.getColumnModel().getColumn(8).setMinWidth(150);
            tableGioHang.getColumnModel().getColumn(8).setPreferredWidth(150);
            tableGioHang.getColumnModel().getColumn(8).setMaxWidth(150);
            tableGioHang.getColumnModel().getColumn(9).setMinWidth(0);
            tableGioHang.getColumnModel().getColumn(9).setPreferredWidth(0);
            tableGioHang.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Danh sách sản phẩm");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_bangsanphamchitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Mã SPCT", "Tên SP", "Màu sắc", "Chất liệu", "Kích thước", "SL tồn", "Đơn giá", "idSPCT"
            }
        ));
        tbl_bangsanphamchitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bangsanphamchitietMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_bangsanphamchitiet);
        if (tbl_bangsanphamchitiet.getColumnModel().getColumnCount() > 0) {
            tbl_bangsanphamchitiet.getColumnModel().getColumn(0).setMinWidth(30);
            tbl_bangsanphamchitiet.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl_bangsanphamchitiet.getColumnModel().getColumn(0).setMaxWidth(30);
            tbl_bangsanphamchitiet.getColumnModel().getColumn(1).setResizable(false);
            tbl_bangsanphamchitiet.getColumnModel().getColumn(6).setMinWidth(50);
            tbl_bangsanphamchitiet.getColumnModel().getColumn(6).setPreferredWidth(50);
            tbl_bangsanphamchitiet.getColumnModel().getColumn(6).setMaxWidth(50);
            tbl_bangsanphamchitiet.getColumnModel().getColumn(8).setMinWidth(0);
            tbl_bangsanphamchitiet.getColumnModel().getColumn(8).setPreferredWidth(0);
            tbl_bangsanphamchitiet.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        txt_timkiem.setText("jTextField1");

        cbo_mausac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_chatlieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_kichthuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_gia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(cbo_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(cbo_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(cbo_kichthuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(cbo_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_kichthuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Đơn hàng");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("Thông tin khách hàng");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Mã KH");

        jTextField1.setEditable(false);
        jTextField1.setText("###");
        jTextField1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)), null));

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Tên KH");

        jTextField2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)), null));

        jButton4.setBackground(new java.awt.Color(153, 255, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 255));
        jButton4.setText("Chọn");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setText("Thông tin hóa đơn");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton5.setBackground(new java.awt.Color(153, 255, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 255));
        jButton5.setText("Hủy HD");

        jLabel12.setText("Mã hóa đơn");

        txt_ngaytao.setEditable(false);
        txt_ngaytao.setText("###");
        txt_ngaytao.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)), null));
        txt_ngaytao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngaytaoActionPerformed(evt);
            }
        });

        txt_ngaythanhtoan.setEditable(false);
        txt_ngaythanhtoan.setText("###");
        txt_ngaythanhtoan.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)), null));
        txt_ngaythanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngaythanhtoanActionPerformed(evt);
            }
        });

        jLabel13.setText("Ngày thanh toán");

        jLabel14.setText("Mã nhân viên");

        jLabel15.setText("Tên khách hàng");

        jLabel16.setText("Tổng tiền");

        jLabel17.setText("Ngày tạo");

        jLabel18.setText("Phiếu giảm giá");

        jLabel19.setText("HT thanh toán");

        jLabel20.setText("Tiền khách đưa");

        jLabel21.setText("Tiền khách CK");

        jLabel22.setText("Tiền thừa");

        txt_manv.setEditable(false);
        txt_manv.setText("###");
        txt_manv.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)), null));
        txt_manv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_manvActionPerformed(evt);
            }
        });

        txt_mahd.setEditable(false);
        txt_mahd.setText("###");
        txt_mahd.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)), null));
        txt_mahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mahdActionPerformed(evt);
            }
        });

        txt_tongtien.setEditable(false);
        txt_tongtien.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)), null));
        txt_tongtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tongtienActionPerformed(evt);
            }
        });

        txt_tenkhachhang.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)), null));
        txt_tenkhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenkhachhangActionPerformed(evt);
            }
        });

        cbo_phieugiamgia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_httt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_tienkhachdua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_tienkhachduaCaretUpdate(evt);
            }
        });
        txt_tienkhachdua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tienkhachduaKeyReleased(evt);
            }
        });

        txt_tienthua.setEditable(false);
        txt_tienthua.setBorder(null);

        lbl_tongtienthuc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_tongtienthuc.setForeground(new java.awt.Color(255, 0, 0));
        lbl_tongtienthuc.setText("Tổng: 0 VND");

        jButton6.setBackground(new java.awt.Color(153, 255, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 255));
        jButton6.setText("Thanh toán");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(txt_ngaythanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_phieugiamgia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tongtien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_httt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tienkhachdua)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(33, 33, 33)
                        .addComponent(txt_tienkhachchuyenkhoan))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(57, 57, 57)
                        .addComponent(txt_tienthua))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbl_tongtienthuc)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ngaythanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbo_phieugiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbo_httt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_tienkhachdua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_tienkhachchuyenkhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txt_tienthua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_tongtienthuc)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(380, 380, 380)
                        .addComponent(jLabel1))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ngaytaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaytaoActionPerformed
    }//GEN-LAST:event_txt_ngaytaoActionPerformed

    private void txt_ngaythanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaythanhtoanActionPerformed
    }//GEN-LAST:event_txt_ngaythanhtoanActionPerformed

    private void txt_manvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_manvActionPerformed
    }//GEN-LAST:event_txt_manvActionPerformed

    private void txt_mahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mahdActionPerformed
    }//GEN-LAST:event_txt_mahdActionPerformed

    private void txt_tongtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tongtienActionPerformed
    }//GEN-LAST:event_txt_tongtienActionPerformed

    private void txt_tenkhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenkhachhangActionPerformed
    }//GEN-LAST:event_txt_tenkhachhangActionPerformed

    private void btn_taohoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taohoadonActionPerformed

        String maHD = CodeGeneratorUtil.generateHoaDon();
        Date today = new Date();
        String formatted = new SimpleDateFormat("yyyy-MM-dd").format(today);
        String maNV = nhanVien.getMaNV();
        int idNV = nhanVien.getId();
        int tongSP = 0;
        String trangThai = Text.CHUA_THANH_TOAN;

        int xacNhanTaoHoaDon = JOptionPane.showConfirmDialog(this, Text.TAO_NHANH_HOA_DON, Text.XAC_NHAN, JOptionPane.YES_NO_OPTION);

        if (xacNhanTaoHoaDon == JOptionPane.YES_OPTION) {
            int taoHoaDon = hoaDonService.taoNhanhHoaDonS(maHD, idNV, formatted);

            if (taoHoaDon > 0) {
                JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
                fillBangHoaDon(hoaDonService.danhSachHoaDon());
            } else {
                JOptionPane.showMessageDialog(this, Text.SO_LUONG_HOA_DON, Text.CANH_BAO, JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btn_taohoadonActionPerformed

    private void tableHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHoaDonMouseClicked

        int hangHoaDon = tableHoaDon.getSelectedRow();
        if (hangHoaDon >= 0) {
            String maHD = tableHoaDon.getValueAt(hangHoaDon, 1).toString();
            int idHD = Integer.parseInt(tableHoaDon.getValueAt(hangHoaDon, 6).toString());

            this.currentMaHD = maHD;
            this.currentIdHD = idHD;

            loadGioHang(idHD);

            txt_mahd.setText(maHD);
            txt_ngaytao.setText(tableHoaDon.getValueAt(hangHoaDon, 2).toString());
            Date ngayThanhToan = new Date(); // Ngày hiện tại
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày
            txt_ngaythanhtoan.setText(sdf.format(ngayThanhToan));
            txt_manv.setText(nhanVien.getMaNV());
            txt_tenkhachhang.setText("");
            tinhTongTienTuGioHang();
        }


    }//GEN-LAST:event_tableHoaDonMouseClicked


    private void tbl_bangsanphamchitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bangsanphamchitietMouseClicked
        int sanPhamChiTiet = tbl_bangsanphamchitiet.getSelectedRow();
        System.out.println("crrr" + currentIdHD);
        if (currentIdHD < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn trước.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idSPCT = (int) tbl_bangsanphamchitiet.getValueAt(sanPhamChiTiet, 8);
        if (sanPhamChiTiet >= 0) {
            NhapSoLuongMuonMua nhap = new NhapSoLuongMuonMua(idSPCT, currentIdHD, () -> {
                fillBangHoaDon(hoaDonService.danhSachHoaDon());
                fillBangGioHang(hoaDonService.layChiTietHoaDonTheoId(currentIdHD));
                fillSanPhamChiTiet(snctService.getAllSanPhamChiTiet());
                tinhTongTienTuGioHang();

            });
            nhap.setVisible(true);
        }

    }//GEN-LAST:event_tbl_bangsanphamchitietMouseClicked

    private void tableGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGioHangMouseClicked
        int row = tableGioHang.getSelectedRow();
        if (row < 0) {
            return;
        }

        int idSPCT = Integer.parseInt(tableGioHang.getValueAt(row, 9).toString());
        System.out.println("idSPCT===" + idSPCT);
        int soLuongCu = Integer.parseInt(tableGioHang.getValueAt(row, 7).toString());

        new CapNhatSoLuongSanPham(currentIdHD, idSPCT, soLuongCu, soLuongMoi -> {
            int chenhLech = soLuongMoi - soLuongCu;

//            if (soLuongMoi == 0) {
//                hoaDonService.xoaSanPhamKhoiHoaDon(currentIdHD, idSPCT);
//                snctService.congSoLuongTon(idSPCT, soLuongCu); // trả lại toàn bộ tồn kho
//            } else {
//                hoaDonService.capNhatSoLuong(currentIdHD, idSPCT, soLuongMoi);
//                if (chenhLech > 0) {
//                    snctService.truSoLuongTon(idSPCT, chenhLech); // mua thêm → trừ tồn kho
//                } else if (chenhLech < 0) {
//                    snctService.congSoLuongTon(idSPCT, -chenhLech); // giảm bớt → cộng lại
//                }
//            }
            // Refresh lại bảng
            fillBangGioHang(hoaDonService.layChiTietHoaDonTheoId(currentIdHD));
            fillSanPhamChiTiet(snctService.getAllSanPhamChiTiet());
            fillBangHoaDon(hoaDonService.danhSachHoaDon());
            tinhTongTienTuGioHang();
        }).setVisible(true);

    }//GEN-LAST:event_tableGioHangMouseClicked

    private void txt_tienkhachduaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienkhachduaKeyReleased

    }//GEN-LAST:event_txt_tienkhachduaKeyReleased

    private void txt_tienkhachduaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_tienkhachduaCaretUpdate
        try {
            // Lấy và làm sạch chuỗi nhập vào
            String tienKhachDuaStr = txt_tienkhachdua.getText().trim().replace("VND", "").replace(",", "").replace(" ", "");
            String tongTienStr = txt_tongtien.getText().trim().replace("VND", "").replace(",", "").replace(" ", "");

            // Nếu chưa nhập đủ, thoát
            if (tienKhachDuaStr.isEmpty() || tongTienStr.isEmpty()) {
                txt_tienkhachchuyenkhoan.setText("0 VND");
                return;
            }

            // Parse số
            int tienKhachDua = Integer.parseInt(tienKhachDuaStr);
            int tongTien = Integer.parseInt(tongTienStr);

            // Tính phần chuyển khoản
            int tienChuyenKhoan = tongTien - tienKhachDua;
            if (tienChuyenKhoan < 0) {
                tienChuyenKhoan = 0;
            }

            // Hiển thị lại kết quả
            DecimalFormat df = new DecimalFormat("#,###");
            txt_tienkhachchuyenkhoan.setText(df.format(tienChuyenKhoan) + " VND");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Gợi ý thêm:
            // JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền hợp lệ!", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_txt_tienkhachduaCaretUpdate

    //fill bang gio hang
    private void loadGioHang(int idHD) {
        List<HoaDonChiTiet_Model> listHDCT = hoaDonService.layChiTietHoaDonTheoId(idHD);
        if (listHDCT.size() == 0) {
            JOptionPane.showMessageDialog(this, "Hóa đơn chưa có sản phẩm!");
            fillBangGioHang(listHDCT);
            return;
        } else {
            fillBangGioHang(listHDCT);
        }
    }

    //fill Bang Gio Hang
    private void fillBangGioHang(List<HoaDonChiTiet_Model> listHDCT) {
        DefaultTableModel model = (DefaultTableModel) tableGioHang.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        System.out.println("Số lượng sp: " + listHDCT.size());

        for (HoaDonChiTiet_Model hd : listHDCT) {
            model.addRow(new Object[]{
                null, // STT
                hd.getMaSPCT(), // Mã hóa đơn
                hd.getTenSP(), // Ngày tạo
                hd.getMauSac(),
                hd.getChatLieu(),
                hd.getKichThuoc(),
                hd.getDonGia(),
                hd.getSoLuong(),
                hd.getThanhTien(),
                hd.getIdSPCT()
            });
        }

        // Cập nhật STT sau khi đổ dữ liệu xong
        STT.updateSTT(model);
    }

    //fill Bang Hoa Don
    private void fillBangHoaDon(List<HoaDon_Model> listHD) {
        DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        System.out.println("Số lượng hóa đơn: " + listHD.size());

        for (HoaDon_Model hd : listHD) {
            model.addRow(new Object[]{
                null, // STT
                hd.getMaHD(), // Mã hóa đơn
                hd.getNgayTao(), // Ngày tạo
                hd.getMaNV(), // Nhân viên
                hd.getTongSP(), // Tổng SP
                "Chưa thanh toán", // Trạng thái (nếu có thể hiển thị rõ ràng hơn thì map thành chuỗi)
                hd.getId()
            });
        }

        // Cập nhật STT sau khi đổ dữ liệu xong
        STT.updateSTT(model);
    }

    public void tinhTongTienTuGioHang() {
        double tongTien = 0;
        DecimalFormat df = new DecimalFormat("#,###");

        for (int i = 0; i < tableGioHang.getRowCount(); i++) {
            String thanhTienStr = tableGioHang.getValueAt(i, 8).toString(); // Cột 'Thành tiền'

            // Loại bỏ ký tự "VND" và dấu phẩy nếu có
            thanhTienStr = thanhTienStr.replace("VND", "").replace(",", "").trim();

            try {
                double thanhTien = Double.parseDouble(thanhTienStr);
                tongTien += thanhTien;
            } catch (NumberFormatException e) {
                e.printStackTrace(); // Log lỗi nếu có dữ liệu sai
            }
        }

        txt_tongtien.setText(df.format(tongTien) + " VND");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_taohoadon;
    private javax.swing.JComboBox<String> cbo_chatlieu;
    private javax.swing.JComboBox<String> cbo_gia;
    private javax.swing.JComboBox<String> cbo_httt;
    private javax.swing.JComboBox<String> cbo_kichthuoc;
    private javax.swing.JComboBox<String> cbo_mausac;
    private javax.swing.JComboBox<String> cbo_phieugiamgia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_tongtienthuc;
    private javax.swing.JTable tableGioHang;
    private javax.swing.JTable tableHoaDon;
    private javax.swing.JTable tbl_bangsanphamchitiet;
    private javax.swing.JTextField txt_mahd;
    private javax.swing.JTextField txt_manv;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_ngaythanhtoan;
    private javax.swing.JTextField txt_tenkhachhang;
    private javax.swing.JTextField txt_tienkhachchuyenkhoan;
    private javax.swing.JTextField txt_tienkhachdua;
    private javax.swing.JTextField txt_tienthua;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txt_tongtien;
    // End of variables declaration//GEN-END:variables
}

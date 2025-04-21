package javaapplication8.form;

import java.text.DecimalFormat;
import java.util.List;
import javaapplication8.model.KhachHangModel;
import javaapplication8.service.KhachHangService;
import javaapplication8.service.serviceimpl.KhachHangServiceImpl;
import javaapplication8.until.CodeGeneratorUtil;
import javaapplication8.until.STT;
import javaapplication8.until.Text;
import javaapplication8.until.ValidationUtil;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class KhachHangForm extends javax.swing.JPanel {

    private KhachHangService khachHangService = new KhachHangServiceImpl();

    public KhachHangForm() {
        initComponents();

        loadDanhSachThongTinKhachHang(khachHangService.danhSachKhachHang());
//        loadDanhSachLichSuGiaoDich(khachHangService.danhSachKhachHang());

        txt_timkiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                timKhachHang();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                timKhachHang();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                timKhachHang();
            }
        });
    }

    public void loadDanhSachThongTinKhachHang(List<KhachHangModel> list) {
        DefaultTableModel model = (DefaultTableModel) tbl_danhSachKhachHang.getModel();
        model.setRowCount(0);
        for (KhachHangModel khachHangModel : list) {
            model.addTableModelListener(e -> STT.updateSTT(model, 1));
            model.addRow(new Object[]{
                null,
                khachHangModel.getMaKH(),
                khachHangModel.getHoTen(),
                khachHangModel.isGioiTinh() ? "Nam" : "Nữ",
                khachHangModel.getSdt(),
                khachHangModel.getDiaChi(),});
        }
    }

    public void loadDanhSachLichSuGiaoDich(List<KhachHangModel> list) {
        DefaultTableModel model = (DefaultTableModel) tbl_danhSachKhachHang.getModel();
        model.setRowCount(0);
        DecimalFormat df = new DecimalFormat("#,###");
        for (KhachHangModel khachHangModel : list) {
            model.addTableModelListener(e -> STT.updateSTT(model, 1));
            model.addRow(new Object[]{
                null,
                khachHangModel.getMaKH(),
                khachHangModel.getMaHD(),
                khachHangModel.getHoTen(),
                khachHangModel.getSdt(),
                khachHangModel.getDiaChi(),
                khachHangModel.getNgayTao(),
                df.format(khachHangModel.getTongTien()) + "VND",
                khachHangModel.getTrangThai() > 0 ? "Đã thanh toán" : "Chưa thanh toán",});
        }
    }

    private void timKhachHang() {
        String tuKhoa = txt_timkiem.getText().trim();
        List<KhachHangModel> ketQua = khachHangService.timKiem(tuKhoa);
        loadDanhSachThongTinKhachHang(ketQua);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_makh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdo_nam = new javax.swing.JRadioButton();
        rdo_nu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_diachi = new javax.swing.JTextField();
        btn_themkhachhang = new javax.swing.JButton();
        btn_xoakhachhang = new javax.swing.JButton();
        btn_capnhatkhachhang = new javax.swing.JButton();
        btn_lammoikhachhang = new javax.swing.JButton();
        lbl_hoTen = new javax.swing.JLabel();
        lbl_sdt = new javax.swing.JLabel();
        lbl_diaChi = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_danhSachKhachHang = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txt_timkiem = new javax.swing.JTextField();
        btn_dau = new javax.swing.JButton();
        btn_truoc = new javax.swing.JButton();
        lbl_trang = new javax.swing.JLabel();
        btn_Sau = new javax.swing.JButton();
        btn_cuoi = new javax.swing.JButton();
        btn_dau1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btn_dau8 = new javax.swing.JButton();
        btn_cuoi4 = new javax.swing.JButton();
        btn_Sau4 = new javax.swing.JButton();
        lbl_trang4 = new javax.swing.JLabel();
        btn_truoc4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txt_timkiem4 = new javax.swing.JTextField();
        txt_hoten3 = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Quản lý khách hàng");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txt_makh.setEditable(false);
        txt_makh.setText("###");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mã khách hàng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Họ tên");

        txt_hoten.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_hotenCaretUpdate(evt);
            }
        });
        txt_hoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hotenActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Giới tính");

        buttonGroup1.add(rdo_nam);
        rdo_nam.setSelected(true);
        rdo_nam.setText("Nam");

        buttonGroup1.add(rdo_nu);
        rdo_nu.setText("Nữ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Số điện thoại");

        txt_sdt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_sdtCaretUpdate(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Địa chỉ");

        txt_diachi.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_diachiCaretUpdate(evt);
            }
        });

        btn_themkhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/material-symbols--add-circle-outline.png"))); // NOI18N
        btn_themkhachhang.setText("Thêm");
        btn_themkhachhang.setBorder(null);
        btn_themkhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themkhachhangActionPerformed(evt);
            }
        });

        btn_xoakhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/delete.png"))); // NOI18N
        btn_xoakhachhang.setText("Xóa");
        btn_xoakhachhang.setBorder(null);
        btn_xoakhachhang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_xoakhachhangMouseMoved(evt);
            }
        });
        btn_xoakhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoakhachhangActionPerformed(evt);
            }
        });

        btn_capnhatkhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/capnhat.png"))); // NOI18N
        btn_capnhatkhachhang.setText("Cập nhật");
        btn_capnhatkhachhang.setBorder(null);
        btn_capnhatkhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatkhachhangActionPerformed(evt);
            }
        });

        btn_lammoikhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/lammoi.png"))); // NOI18N
        btn_lammoikhachhang.setText("Làm mới");
        btn_lammoikhachhang.setBorder(null);
        btn_lammoikhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoikhachhangActionPerformed(evt);
            }
        });

        lbl_hoTen.setForeground(new java.awt.Color(255, 0, 51));

        lbl_sdt.setForeground(new java.awt.Color(255, 0, 51));

        lbl_diaChi.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(txt_makh)
                            .addComponent(txt_hoten, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(lbl_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(lbl_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(rdo_nam))
                        .addGap(72, 72, 72)
                        .addComponent(rdo_nu)
                        .addGap(97, 97, 97)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_xoakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btn_lammoikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_themkhachhang)
                        .addGap(51, 51, 51)
                        .addComponent(btn_capnhatkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_diachi, txt_hoten, txt_makh, txt_sdt});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_capnhatkhachhang, btn_lammoikhachhang, btn_themkhachhang, btn_xoakhachhang});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_capnhatkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_xoakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_lammoikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_nam)
                    .addComponent(rdo_nu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_diachi, txt_hoten, txt_makh, txt_sdt});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_capnhatkhachhang, btn_lammoikhachhang, btn_themkhachhang, btn_xoakhachhang});

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Thiết lập thông tin khách hàng");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Thông tin khách hàng");

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tbl_danhSachKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã KH", "Họ tên", "Giới tính", "SĐT", "Địa chỉ"
            }
        ));
        tbl_danhSachKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_danhSachKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_danhSachKhachHang);
        if (tbl_danhSachKhachHang.getColumnModel().getColumnCount() > 0) {
            tbl_danhSachKhachHang.getColumnModel().getColumn(0).setMinWidth(70);
            tbl_danhSachKhachHang.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbl_danhSachKhachHang.getColumnModel().getColumn(0).setMaxWidth(70);
            tbl_danhSachKhachHang.getColumnModel().getColumn(1).setMinWidth(150);
            tbl_danhSachKhachHang.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbl_danhSachKhachHang.getColumnModel().getColumn(1).setMaxWidth(150);
            tbl_danhSachKhachHang.getColumnModel().getColumn(2).setMinWidth(200);
            tbl_danhSachKhachHang.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbl_danhSachKhachHang.getColumnModel().getColumn(2).setMaxWidth(200);
            tbl_danhSachKhachHang.getColumnModel().getColumn(3).setMinWidth(100);
            tbl_danhSachKhachHang.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbl_danhSachKhachHang.getColumnModel().getColumn(3).setMaxWidth(100);
            tbl_danhSachKhachHang.getColumnModel().getColumn(4).setMinWidth(150);
            tbl_danhSachKhachHang.getColumnModel().getColumn(4).setPreferredWidth(150);
            tbl_danhSachKhachHang.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 51));
        jLabel9.setText("Tìm kiếm");

        txt_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timkiemActionPerformed(evt);
            }
        });

        btn_dau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/first.png"))); // NOI18N
        btn_dau.setBorder(null);

        btn_truoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/before.png"))); // NOI18N
        btn_truoc.setBorder(null);
        btn_truoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_truocActionPerformed(evt);
            }
        });

        lbl_trang.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lbl_trang.setForeground(new java.awt.Color(0, 204, 255));
        lbl_trang.setText("jLabel6");

        btn_Sau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/next.png"))); // NOI18N
        btn_Sau.setBorder(null);

        btn_cuoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/last.png"))); // NOI18N
        btn_cuoi.setBorder(null);

        btn_dau1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/first.png"))); // NOI18N
        btn_dau1.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(btn_dau1)
                .addGap(18, 18, 18)
                .addComponent(btn_truoc)
                .addGap(18, 18, 18)
                .addComponent(lbl_trang)
                .addGap(18, 18, 18)
                .addComponent(btn_Sau)
                .addGap(18, 18, 18)
                .addComponent(btn_cuoi)
                .addContainerGap(486, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(424, 424, 424)
                    .addComponent(btn_dau)
                    .addContainerGap(666, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_truoc)
                    .addComponent(lbl_trang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dau1)
                    .addComponent(btn_Sau)
                    .addComponent(btn_cuoi))
                .addGap(8, 8, 8))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(155, 155, 155)
                    .addComponent(btn_dau)
                    .addContainerGap(152, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Thông tin khách hàng", jPanel3);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã KH", "Mã HD", "Tên KH", "SDT", "Địa chỉ", "Ngày giao dịch", "Tổng tiền", "Trạng thái"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(50);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btn_dau8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/first.png"))); // NOI18N
        btn_dau8.setBorder(null);

        btn_cuoi4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/last.png"))); // NOI18N
        btn_cuoi4.setBorder(null);

        btn_Sau4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/next.png"))); // NOI18N
        btn_Sau4.setBorder(null);

        lbl_trang4.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lbl_trang4.setForeground(new java.awt.Color(0, 204, 255));
        lbl_trang4.setText("jLabel6");

        btn_truoc4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/icon/before.png"))); // NOI18N
        btn_truoc4.setBorder(null);
        btn_truoc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_truoc4ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 51));
        jLabel13.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(429, 429, 429)
                        .addComponent(btn_dau8)
                        .addGap(18, 18, 18)
                        .addComponent(btn_truoc4)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_trang4)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Sau4)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cuoi4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txt_hoten3, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(397, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(439, 439, 439)
                    .addComponent(txt_timkiem4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(446, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_hoten3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_truoc4)
                    .addComponent(lbl_trang4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dau8)
                    .addComponent(btn_Sau4)
                    .addComponent(btn_cuoi4)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(158, 158, 158)
                    .addComponent(txt_timkiem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(161, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Lịch sử giao dịch", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(242, 242, 242)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themkhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themkhachhangActionPerformed

        String maKH = CodeGeneratorUtil.generateKhachHang();
        String hoTen = txt_hoten.getText().trim();
        boolean gioiTinh;
        if (rdo_nam.isSelected()) {
            gioiTinh = true;
        } else {
            gioiTinh = false;
        }
        String sdt = txt_sdt.getText();
        String diaChi = txt_diachi.getText();

        if (ValidationUtil.isEmpty(hoTen)) {
            lbl_hoTen.setText(Text.TRONG);
            return;
        }
        if (ValidationUtil.isEmpty(sdt)) {
            lbl_sdt.setText(Text.TRONG);
            return;
        }
        if (ValidationUtil.isEmpty(diaChi)) {
            lbl_diaChi.setText(Text.TRONG);
            return;
        }
        KhachHangModel kh = new KhachHangModel(maKH, hoTen, gioiTinh, sdt, diaChi);
        int xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm Khách Hàng mới không?", Text.XAC_NHAN, JOptionPane.YES_NO_OPTION);
        if (xacNhan == JOptionPane.NO_OPTION) {
            return;
        }
        boolean themMoi = khachHangService.addKhachHang(kh);
        if (themMoi) {
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công.");
            loadDanhSachThongTinKhachHang(khachHangService.danhSachKhachHang());
        } else {
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại");
        }

    }//GEN-LAST:event_btn_themkhachhangActionPerformed

    private void btn_xoakhachhangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xoakhachhangMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xoakhachhangMouseMoved

    private void btn_xoakhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoakhachhangActionPerformed
        int chonDong = tbl_danhSachKhachHang.getSelectedRow();
        if (chonDong < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để xóa");
            return;
        }

        String maKh = txt_makh.getText().trim();

        int xacNhan = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa khách hàng không?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (xacNhan == JOptionPane.NO_OPTION) {
            return;
        }
        boolean xoaKH = khachHangService.xoaKhachHang(maKh);
        if (xoaKH) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadDanhSachThongTinKhachHang(khachHangService.danhSachKhachHang());
            txt_makh.setText("###");
            txt_hoten.setText("");
            txt_sdt.setText("");
            txt_diachi.setText("");
            rdo_nam.setSelected(true); // mặc định về Nam

        }
    }//GEN-LAST:event_btn_xoakhachhangActionPerformed

    private void btn_capnhatkhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatkhachhangActionPerformed
        int chon = tbl_danhSachKhachHang.getSelectedRow();

        if (chon == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng để cập nhật!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Lấy dữ liệu từ form
        String ma = txt_makh.getText().trim();
        String ten = txt_hoten.getText().trim();
        String sdt = txt_sdt.getText().trim();
        String diaChi = txt_diachi.getText().trim();

        // Lấy giới tính bằng if else
        boolean gioiTinh = false;
        if (rdo_nam.isSelected()) {
            gioiTinh = true;
        } else if (rdo_nu.isSelected()) {
            gioiTinh = true;
        }

        // Reset cảnh báo
        lbl_hoTen.setText("");
        lbl_sdt.setText("");
        lbl_diaChi.setText("");

        // Kiểm tra rỗng
        boolean valid = true;
        if (ValidationUtil.isEmpty(ten)) {
            lbl_hoTen.setText(Text.TRONG);
            valid = false;
        }

        if (ValidationUtil.isEmpty(sdt)) {
            lbl_sdt.setText(Text.TRONG);
            valid = false;
        }

        if (ValidationUtil.isEmpty(diaChi)) {
            lbl_diaChi.setText(Text.TRONG);
            valid = false;
        }

        if (!valid) {
            return;
        }

        // Tạo đối tượng khách hàng
        KhachHangModel kh = new KhachHangModel();
        kh.setMaKH(ma);
        kh.setHoTen(ten);
        kh.setSdt(sdt);
        kh.setDiaChi(diaChi);
        kh.setGioiTinh(gioiTinh);

        // Xác nhận cập nhật
        int xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn cập nhật khách hàng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (xacNhan == JOptionPane.YES_OPTION) {
            boolean capNhatThanhCong = khachHangService.capNhatKhachHang(kh);

            if (capNhatThanhCong) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");

                // Cập nhật lại bảng
                loadDanhSachThongTinKhachHang(khachHangService.danhSachKhachHang());

                // Reset form
                txt_makh.setText("###");
                txt_hoten.setText("");
                txt_sdt.setText("");
                txt_diachi.setText("");
                rdo_nam.setSelected(true); // mặc định về Nam
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại. Vui lòng thử lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_capnhatkhachhangActionPerformed

    private void btn_lammoikhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoikhachhangActionPerformed
        txt_makh.setText("###");
        txt_hoten.setText("");
        txt_sdt.setText("");
        txt_diachi.setText("");
        txt_hoten3.setText("");
        rdo_nam.setSelected(true);
    }//GEN-LAST:event_btn_lammoikhachhangActionPerformed

    private void btn_truocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_truocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_truocActionPerformed

    private void btn_truoc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_truoc4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_truoc4ActionPerformed

    private void txt_hotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hotenActionPerformed

    }//GEN-LAST:event_txt_hotenActionPerformed

    private void txt_hotenCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_hotenCaretUpdate
        lbl_diaChi.setText("");
        lbl_hoTen.setText("");
        lbl_sdt.setText("");
    }//GEN-LAST:event_txt_hotenCaretUpdate

    private void txt_sdtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_sdtCaretUpdate
        // TODO add your handling code here:
        lbl_diaChi.setText("");
        lbl_hoTen.setText("");
        lbl_sdt.setText("");
    }//GEN-LAST:event_txt_sdtCaretUpdate

    private void txt_diachiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_diachiCaretUpdate
        // TODO add your handling code here:
        lbl_diaChi.setText("");
        lbl_hoTen.setText("");
        lbl_sdt.setText("");
    }//GEN-LAST:event_txt_diachiCaretUpdate

    private void tbl_danhSachKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhSachKhachHangMouseClicked

        int chonDong = tbl_danhSachKhachHang.getSelectedRow();
        txt_makh.setText(tbl_danhSachKhachHang.getValueAt(chonDong, 1).toString());
        txt_hoten.setText(tbl_danhSachKhachHang.getValueAt(chonDong, 2).toString());
        if (tbl_danhSachKhachHang.getValueAt(chonDong, 3).toString().equals("Nam")) {
            rdo_nam.setSelected(true);
        } else {
            rdo_nu.setSelected(true);
        }

        txt_sdt.setText(tbl_danhSachKhachHang.getValueAt(chonDong, 4).toString());
        txt_diachi.setText(tbl_danhSachKhachHang.getValueAt(chonDong, 5).toString());

    }//GEN-LAST:event_tbl_danhSachKhachHangMouseClicked

    private void txt_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timkiemActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sau;
    private javax.swing.JButton btn_Sau4;
    private javax.swing.JButton btn_capnhatkhachhang;
    private javax.swing.JButton btn_cuoi;
    private javax.swing.JButton btn_cuoi4;
    private javax.swing.JButton btn_dau;
    private javax.swing.JButton btn_dau1;
    private javax.swing.JButton btn_dau8;
    private javax.swing.JButton btn_lammoikhachhang;
    private javax.swing.JButton btn_themkhachhang;
    private javax.swing.JButton btn_truoc;
    private javax.swing.JButton btn_truoc4;
    private javax.swing.JButton btn_xoakhachhang;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbl_diaChi;
    private javax.swing.JLabel lbl_hoTen;
    private javax.swing.JLabel lbl_sdt;
    private javax.swing.JLabel lbl_trang;
    private javax.swing.JLabel lbl_trang4;
    private javax.swing.JRadioButton rdo_nam;
    private javax.swing.JRadioButton rdo_nu;
    private javax.swing.JTable tbl_danhSachKhachHang;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_hoten3;
    private javax.swing.JTextField txt_makh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txt_timkiem4;
    // End of variables declaration//GEN-END:variables
}

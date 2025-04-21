package javaapplication8.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javaapplication8.model.PhieuGiamGiaModel;
import javaapplication8.service.PhieuGiamGiaService;
import javaapplication8.service.serviceimpl.PhieuGiamGiaServiceImpl;
import javaapplication8.until.CodeGeneratorUtil;
import javaapplication8.until.CurrentUser;
import javaapplication8.until.STT;
import javaapplication8.until.Text;
import javaapplication8.until.ValidationUtil;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class KhuyenMai_Form extends javax.swing.JPanel {

    private PhieuGiamGiaService pggService = new PhieuGiamGiaServiceImpl();
    private String selected;
    int trangThai = 0;

    public KhuyenMai_Form() {
        initComponents();

        cbo_trangthai.removeAllItems();
        cbo_trangthai.addItem("Tất cả");
        cbo_trangthai.addItem("Sắp diễn ra");
        cbo_trangthai.addItem("Đang diễn ra");
        cbo_trangthai.addItem("Đã kết thúc");

        selected = cbo_trangthai.getSelectedItem().toString();
        switch (selected) {
            case "Sắp diễn ra":
                trangThai = 0;
                break;
            case "Đang diễn ra":
                trangThai = 1;
                break;
            case "Đã diễn ra":
                trangThai = 2;
                break;
            default:
                trangThai = -1;
                break;
        }
        fillTablePhieuGiamGiaTheoTrangThai(trangThai);
        // Thêm sự kiện khi chọn một item trong ComboBox
        cbo_trangthai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected = cbo_trangthai.getSelectedItem().toString();
                switch (selected) {
                    case "Sắp diễn ra":
                        trangThai = 0;
                        break;
                    case "Đang diễn ra":
                        trangThai = 1;
                        break;
                    case "Đã kết thúc":
                        trangThai = 2;
                        break;
                    default:
                        trangThai = -1;
                        break;
                }

                // Gọi lại phương thức để fill bảng dữ liệu khi trạng thái thay đổi
                fillTablePhieuGiamGiaTheoTrangThai(trangThai);
            }
        });

    }

    private void fillTablePhieuGiamGiaTheoTrangThai(int trangThai) {
        List<PhieuGiamGiaModel> list;

        if (trangThai == -1) {
            list = pggService.getAll();
        } else {
            list = pggService.getByTrangThai(trangThai);
        }

        DefaultTableModel model = (DefaultTableModel) tblPhieuGiamGia.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ
        DecimalFormat df = new DecimalFormat("#,###");
        for (PhieuGiamGiaModel p : list) {
            model.addTableModelListener(e -> STT.updateSTT(model, 1));
            Object[] row = {
                null,
                p.getMaPGG(),
                p.getTenPGG(),
                p.getNgayDB(),
                p.getNgayKT(),
                p.getSoLuong(),
                df.format(p.getHDToiThieu()) + " VNĐ",
                p.getPhantramgiam() + " %",
                df.format(p.getGiamToiDa()) + " VNĐ",
                p.getNgayTao(),
                p.getMaNV(),
                p.getTrangThai() == 0 ? "Sắp diễn ra"
                : p.getTrangThai() == 1 ? "Đang diễn ra"
                : "Đã diễn ra"
            };
            model.addRow(row);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_thempgg = new javax.swing.JButton();
        btn_huypgg = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txt_makm = new javax.swing.JTextField();
        txt_tenkm = new javax.swing.JTextField();
        lbl_hoadontt = new javax.swing.JLabel();
        lbl_ngaybatdau = new javax.swing.JLabel();
        txt_soluongduocphepsudung = new javax.swing.JTextField();
        lbl_tenkm1 = new javax.swing.JLabel();
        txt_hoadontt = new javax.swing.JTextField();
        lbl_sotiengiamtoida = new javax.swing.JLabel();
        lbl_ngayketthuc = new javax.swing.JLabel();
        txt_phantramgiam = new javax.swing.JTextField();
        lbl_soluong2 = new javax.swing.JLabel();
        txt_sotiengiamtoida = new javax.swing.JTextField();
        lbl_phantramgiam1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbo_trangthai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuGiamGia = new javax.swing.JTable();
        jdc_bd = new com.toedter.calendar.JDateChooser();
        jdc_kt = new com.toedter.calendar.JDateChooser();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("PHIẾU GIẢM GIÁ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 255));
        jLabel2.setText("Mã khuyến mại");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 204, 255));
        jLabel3.setText("Tên khuyến mại");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 204, 255));
        jLabel4.setText("Ngày bắt đầu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 255));
        jLabel5.setText("Hóa đơn tối thiểu");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 255));
        jLabel6.setText("Ngày kết thúc");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 204, 255));
        jLabel7.setText("Số lượng được phép sử dụng");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 204, 255));
        jLabel8.setText("Phần trăm giảm");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 204, 255));
        jLabel9.setText("Số tiền được giảm tối đa");

        btn_thempgg.setBackground(new java.awt.Color(0, 0, 204));
        btn_thempgg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_thempgg.setForeground(new java.awt.Color(255, 255, 255));
        btn_thempgg.setText("Thêm");
        btn_thempgg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thempggActionPerformed(evt);
            }
        });

        btn_huypgg.setBackground(new java.awt.Color(255, 0, 0));
        btn_huypgg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_huypgg.setForeground(new java.awt.Color(255, 255, 255));
        btn_huypgg.setText("Hủy");
        btn_huypgg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huypggActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Làm mới");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txt_makm.setEditable(false);
        txt_makm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_makm.setForeground(new java.awt.Color(0, 0, 255));
        txt_makm.setText("###");

        txt_tenkm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_tenkm.setForeground(new java.awt.Color(0, 0, 255));
        txt_tenkm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenkmActionPerformed(evt);
            }
        });

        lbl_hoadontt.setForeground(new java.awt.Color(255, 0, 51));

        lbl_ngaybatdau.setForeground(new java.awt.Color(255, 0, 51));

        txt_soluongduocphepsudung.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_soluongduocphepsudung.setForeground(new java.awt.Color(0, 0, 255));
        txt_soluongduocphepsudung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soluongduocphepsudungActionPerformed(evt);
            }
        });

        lbl_tenkm1.setForeground(new java.awt.Color(255, 0, 51));

        txt_hoadontt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_hoadontt.setForeground(new java.awt.Color(0, 0, 255));
        txt_hoadontt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hoadonttActionPerformed(evt);
            }
        });

        lbl_sotiengiamtoida.setForeground(new java.awt.Color(255, 0, 51));

        lbl_ngayketthuc.setForeground(new java.awt.Color(255, 0, 51));

        txt_phantramgiam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_phantramgiam.setForeground(new java.awt.Color(0, 0, 255));
        txt_phantramgiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_phantramgiamActionPerformed(evt);
            }
        });

        lbl_soluong2.setForeground(new java.awt.Color(255, 0, 51));

        txt_sotiengiamtoida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_sotiengiamtoida.setForeground(new java.awt.Color(0, 0, 255));
        txt_sotiengiamtoida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sotiengiamtoidaActionPerformed(evt);
            }
        });

        lbl_phantramgiam1.setForeground(new java.awt.Color(255, 0, 51));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Trạng thái");

        cbo_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_trangthai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_trangthaiMouseClicked(evt);
            }
        });

        tblPhieuGiamGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã KM", "Tên KM", "Ngày BD", "Ngày KT", "Số lượng", "HD tối thiểu", "Số % giảm", "Giảm tối đa", "Ngày tạo", "Người tạo", "Trạng thái"
            }
        ));
        tblPhieuGiamGia.setPreferredSize(new java.awt.Dimension(865, 120));
        tblPhieuGiamGia.setRowHeight(30);
        tblPhieuGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuGiamGiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuGiamGia);
        if (tblPhieuGiamGia.getColumnModel().getColumnCount() > 0) {
            tblPhieuGiamGia.getColumnModel().getColumn(0).setMinWidth(50);
            tblPhieuGiamGia.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblPhieuGiamGia.getColumnModel().getColumn(0).setMaxWidth(50);
            tblPhieuGiamGia.getColumnModel().getColumn(5).setMinWidth(70);
            tblPhieuGiamGia.getColumnModel().getColumn(5).setPreferredWidth(70);
            tblPhieuGiamGia.getColumnModel().getColumn(5).setMaxWidth(70);
            tblPhieuGiamGia.getColumnModel().getColumn(7).setMinWidth(70);
            tblPhieuGiamGia.getColumnModel().getColumn(7).setPreferredWidth(70);
            tblPhieuGiamGia.getColumnModel().getColumn(7).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(txt_makm)
                        .addComponent(txt_tenkm, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(28, 28, 28)
                            .addComponent(cbo_trangthai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jdc_bd, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ngaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tenkm1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_ngayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(txt_hoadontt, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(lbl_hoadontt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(txt_soluongduocphepsudung)
                            .addComponent(lbl_soluong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdc_kt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(131, 131, 131)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(txt_phantramgiam, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_phantramgiam1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)
                                            .addComponent(txt_sotiengiamtoida, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_sotiengiamtoida, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(92, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_huypgg)
                                        .addGap(190, 190, 190))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_thempgg)
                                    .addComponent(jButton3))
                                .addGap(297, 297, 297))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(492, 492, 492)
                .addComponent(jLabel1)
                .addGap(142, 142, 142))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jdc_bd, jdc_kt});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbl_ngaybatdau, lbl_tenkm1});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_huypgg, btn_thempgg, jButton3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_makm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_soluongduocphepsudung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_phantramgiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_soluong2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tenkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_hoadontt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sotiengiamtoida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_phantramgiam1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_hoadontt, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_sotiengiamtoida, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)))
                    .addComponent(lbl_tenkm1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdc_kt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_thempgg)
                                .addComponent(btn_huypgg))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jdc_bd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_ngaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ngayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(cbo_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jdc_bd, jdc_kt});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_huypgg, btn_thempgg, jButton3});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tenkmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenkmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenkmActionPerformed

    private void txt_soluongduocphepsudungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soluongduocphepsudungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soluongduocphepsudungActionPerformed

    private void txt_hoadonttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hoadonttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hoadonttActionPerformed

    private void txt_phantramgiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phantramgiamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phantramgiamActionPerformed

    private void txt_sotiengiamtoidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sotiengiamtoidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sotiengiamtoidaActionPerformed

    private void cbo_trangthaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_trangthaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_trangthaiMouseClicked

    private void btn_thempggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thempggActionPerformed
        String maPGG = CodeGeneratorUtil.generatePhieuGiamGia();      // TextField cho mã phiếu giảm giá
        String tenPGG = txt_tenkm.getText().trim();    // TextField cho tên phiếu
        Date dateBD = jdc_bd.getDate();
        Date dateKT = jdc_kt.getDate();
        String ngayTao = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));  // Ngày hôm nay
        int soLuong = 0, phanTramGiam = 0;
        BigDecimal hdToiThieu = BigDecimal.ZERO, giamToiDa = BigDecimal.ZERO;

        if (tenPGG.isEmpty()) {
            lbl_tenkm1.setText("Tên phiếu giảm giá không được để trống.");
            return;
        }

        try {
            // Kiểm tra xem người dùng có nhập giá trị cho số lượng hay không
            String soLuongText = txt_soluongduocphepsudung.getText().trim();
            if (soLuongText.isEmpty()) {
                lbl_soluong2.setText("Số lượng không được để trống.");
                return;
            }

            soLuong = Integer.parseInt(soLuongText);
            if (soLuong <= 0) {
                lbl_soluong2.setText("Số lượng phải là một số dương.");
                return;
            }
        } catch (NumberFormatException e) {
            lbl_soluong2.setText("Vui lòng nhập số hợp lệ cho số lượng.");
            return;
        }

        try {
            // Kiểm tra xem người dùng có nhập giá trị cho hóa đơn tối thiểu hay không
            String hdToiThieuText = txt_hoadontt.getText().trim();
            if (hdToiThieuText.isEmpty()) {
                lbl_hoadontt.setText("Hóa đơn tối thiểu không được để trống.");
                return;
            }

            hdToiThieu = new BigDecimal(hdToiThieuText);
            if (hdToiThieu.compareTo(BigDecimal.ZERO) <= 0) {
                lbl_hoadontt.setText("Hóa đơn tối thiểu phải lớn hơn 0.");
                return;
            }
        } catch (NumberFormatException e) {
            lbl_hoadontt.setText("Vui lòng nhập số hợp lệ cho hóa đơn tối thiểu.");
            return;
        }

        try {
            // Kiểm tra xem người dùng có nhập giá trị cho phần trăm giảm hay không
            String phanTramGiamText = txt_phantramgiam.getText().trim();
            if (phanTramGiamText.isEmpty()) {
                lbl_phantramgiam1.setText("Phần trăm giảm không được để trống.");
                return;
            }

            phanTramGiam = Integer.parseInt(phanTramGiamText);
            if (phanTramGiam <= 0 || phanTramGiam > 100) {
                lbl_phantramgiam1.setText("Phần trăm giảm trong khoảng từ 1 - 100.");
                return;
            }
        } catch (NumberFormatException e) {
            lbl_phantramgiam1.setText("Vui lòng nhập số hợp lệ.");
            return;
        }

        try {
            String giamToiDaText = txt_sotiengiamtoida.getText().trim();
            if (giamToiDaText.isEmpty()) {
                lbl_sotiengiamtoida.setText("Số tiền giảm tối đa không được để trống.");
                return;
            }

            giamToiDa = new BigDecimal(giamToiDaText);
            if (giamToiDa.compareTo(BigDecimal.ZERO) <= 0) {
                lbl_sotiengiamtoida.setText("Số tiền giảm tối đa phải lớn hơn 0.");
                return;
            }

            // So sánh với hóa đơn tối thiểu
            if (giamToiDa.compareTo(hdToiThieu) >= 0) {
                lbl_sotiengiamtoida.setText("Số tiền giảm tối đa phải nhỏ hơn hóa đơn tối thiểu.");
                return;
            }

        } catch (NumberFormatException e) {
            lbl_sotiengiamtoida.setText("Vui lòng nhập số hợp lệ cho số tiền giảm tối đa.");
            return;
        }

        if (dateBD == null || dateKT == null) {
            lbl_ngayketthuc.setText("Vui lòng chọn đầy đủ ngày bắt đầu và ngày kết thúc.");
            return;
        }

        LocalDate ngayBatDau1 = dateBD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ngayKetThuc1 = dateKT.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();

        if (ngayBatDau1.isBefore(today)) {
            lbl_ngaybatdau.setText("Ngày bắt đầu phải lớn hơn hoặc bằng ngày hôm nay.");
            return;
        }

        if (ngayKetThuc1.isBefore(ngayBatDau1)) {
            lbl_ngayketthuc.setText("Ngày kết thúc phải lớn hơn hoặc bằng ngày bắt đầu.");
            return;
        }

        // Chuyển ngày về chuỗi định dạng giống trong giao diện nếu cần lưu
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);
        String ngayBatDau = ngayBatDau1.format(formatter);
        String ngayKetThuc = ngayKetThuc1.format(formatter);

        int trangThai;
        if (ngayBatDau1.isAfter(today)) {
            trangThai = 0; // Sắp diễn ra
        } else if ((ngayBatDau1.isEqual(today) || ngayBatDau1.isBefore(today))
                && (ngayKetThuc1.isEqual(today) || ngayKetThuc1.isAfter(today))) {
            trangThai = 1; // Đang diễn ra
        } else {
            trangThai = 2; // Đã kết thúc
        }

        // Tạo đối tượng PhieuGiamGiaModel
        PhieuGiamGiaModel pgg = new PhieuGiamGiaModel();
        pgg.setMaPGG(maPGG);
        pgg.setTenPGG(tenPGG);
        pgg.setSoLuong(soLuong);
        pgg.setHDToiThieu(hdToiThieu);
        pgg.setPhantramgiam(phanTramGiam);
        pgg.setGiamToiDa(giamToiDa);
        pgg.setNgayDB(ngayBatDau);
        pgg.setNgayKT(ngayKetThuc);
        pgg.setNgayTao(ngayTao);
        pgg.setTrangThai(trangThai);

        // Lấy ID nhân viên từ CurrentUser
        int idNV = CurrentUser.get().getId();

        int luachon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm phiếu giảm giá không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (luachon == JOptionPane.YES_OPTION) {
            // Gọi phương thức thêm mới phiếu giảm giá trong DAO
            boolean ketQua = pggService.themMoiPGG(pgg);  // Giả sử bạn có một service pggService gọi DAO

            // Kiểm tra kết quả và thông báo
            if (ketQua) {
                JOptionPane.showMessageDialog(this, "Thêm mới phiếu giảm giá thành công!");
                lammoi();
                
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra. Vui lòng thử lại.");
            }
        }
    }//GEN-LAST:event_btn_thempggActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        lammoi();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblPhieuGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuGiamGiaMouseClicked

        int chonDong = tblPhieuGiamGia.getSelectedRow();
        txt_makm.setText(tblPhieuGiamGia.getValueAt(chonDong, 1).toString());
        txt_tenkm.setText(tblPhieuGiamGia.getValueAt(chonDong, 2).toString());
        try {
            String ngayBDStr = tblPhieuGiamGia.getValueAt(chonDong, 3).toString(); // cột ngày bắt đầu
            String ngayKTStr = tblPhieuGiamGia.getValueAt(chonDong, 4).toString(); // cột ngày kết thúc

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // đúng với định dạng trong DB
            Date ngayBD = sdf.parse(ngayBDStr);
            Date ngayKT = sdf.parse(ngayKTStr);

            jdc_bd.setDate(ngayBD);
            jdc_kt.setDate(ngayKT);
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi định dạng ngày!");
        }
        txt_soluongduocphepsudung.setText(tblPhieuGiamGia.getValueAt(chonDong, 5).toString());
        txt_hoadontt.setText(tblPhieuGiamGia.getValueAt(chonDong, 6).toString());
        txt_phantramgiam.setText(tblPhieuGiamGia.getValueAt(chonDong, 7).toString());
        txt_sotiengiamtoida.setText(tblPhieuGiamGia.getValueAt(chonDong, 8).toString());
    }//GEN-LAST:event_tblPhieuGiamGiaMouseClicked

    private void btn_huypggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huypggActionPerformed
      int chon = tblPhieuGiamGia.getSelectedRow();

        if (chon == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một phiếu giảm giá để xóa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String ma = tblPhieuGiamGia.getValueAt(chon, 1).toString(); // Lấy TÊN thuộc tính

        int luachon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (luachon == JOptionPane.YES_OPTION) {
            boolean xoaThanhCong = pggService.xoaPhieuGiamGia(ma); // ← Gọi theo ID

            if (xoaThanhCong) {
                JOptionPane.showMessageDialog(this, "Xóa phiếu giảm giá thành công!");
                lammoi();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại. Vui lòng thử lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_huypggActionPerformed
    void lammoi() {

        Calendar today = Calendar.getInstance();
        jdc_bd.setCalendar(today);
        jdc_kt.setCalendar(today);

        txt_tenkm.setText("");
        txt_makm.setText("###");
        txt_hoadontt.setText("");
        txt_phantramgiam.setText("");
        txt_soluongduocphepsudung.setText("");
        txt_sotiengiamtoida.setText("");
        lbl_hoadontt.setText("");
        lbl_ngaybatdau.setText("");
        lbl_ngayketthuc.setText("");
        lbl_phantramgiam1.setText("");
        lbl_soluong2.setText("");
        lbl_sotiengiamtoida.setText("");
        lbl_tenkm1.setText("");
        fillTablePhieuGiamGiaTheoTrangThai(-1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_huypgg;
    private javax.swing.JButton btn_thempgg;
    private javax.swing.JComboBox<String> cbo_trangthai;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdc_bd;
    private com.toedter.calendar.JDateChooser jdc_kt;
    private javax.swing.JLabel lbl_hoadontt;
    private javax.swing.JLabel lbl_ngaybatdau;
    private javax.swing.JLabel lbl_ngayketthuc;
    private javax.swing.JLabel lbl_phantramgiam1;
    private javax.swing.JLabel lbl_soluong2;
    private javax.swing.JLabel lbl_sotiengiamtoida;
    private javax.swing.JLabel lbl_tenkm1;
    private javax.swing.JTable tblPhieuGiamGia;
    private javax.swing.JTextField txt_hoadontt;
    private javax.swing.JTextField txt_makm;
    private javax.swing.JTextField txt_phantramgiam;
    private javax.swing.JTextField txt_soluongduocphepsudung;
    private javax.swing.JTextField txt_sotiengiamtoida;
    private javax.swing.JTextField txt_tenkm;
    // End of variables declaration//GEN-END:variables
}

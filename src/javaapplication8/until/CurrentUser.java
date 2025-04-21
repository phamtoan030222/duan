/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8.until;

import javaapplication8.model.Model_NhanVien;

/**
 *
 * @author dungc
 */
public class CurrentUser {
     private static Model_NhanVien currentNV;

    public static void set(Model_NhanVien nv) {
        currentNV = nv;
    }

    public static Model_NhanVien get() {
        return currentNV;
    }

    public static int getId() {
        return currentNV.getId(); // hoặc getMaNV nếu cần
    }
    
    public static String getTenDangNhap() {
        return currentNV.getTenDN();
    }
    
    public static String getMaNV() {
        return currentNV.getMaNV();
    }
}

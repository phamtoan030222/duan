
package javaapplication8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javaapplication8.model.HoaDon_Model;
import javaapplication8.model.PhieuGiamGiaModel;
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
    
//    public List<PhieuGi
//    
//    
}

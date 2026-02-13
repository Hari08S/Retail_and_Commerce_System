package com.wipro.retail.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.wipro.retail.bean.RetailBean;
import com.wipro.retail.util.DBUtil;
public class RetailDAO {
    public String createRecord(RetailBean bean) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getDBConnection();
            String sql = "insert into retail_tb values(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, bean.getRecordId());
            ps.setString(2, bean.getCustomerName());
            ps.setString(3, bean.getProductName());
            ps.setDate(4, new java.sql.Date(bean.getPurchaseDate().getTime()));
            ps.setInt(5, bean.getQuantity());
            ps.setDouble(6, bean.getPrice());
            ps.setString(7, bean.getRemarks());
            int rows = ps.executeUpdate();
            if (rows > 0)
                return bean.getRecordId();
            else
                return "FAIL";
        } catch (Exception e) {
            e.printStackTrace();
            return "FAIL";
        }
    }
    public RetailBean fetchRecord(String customerName, java.util.Date purchaseDate) {
        RetailBean bean = null;
        try {
            Connection con = DBUtil.getDBConnection();
            String sql = "select * from retail_tb where customername=? and purchase_date=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customerName);
            ps.setDate(2, new java.sql.Date(purchaseDate.getTime()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bean = new RetailBean();
                bean.setRecordId(rs.getString(1));
                bean.setCustomerName(rs.getString(2));
                bean.setProductName(rs.getString(3));
                bean.setPurchaseDate(rs.getDate(4));
                bean.setQuantity(rs.getInt(5));
                bean.setPrice(rs.getDouble(6));
                bean.setRemarks(rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public boolean recordExists(String customerName, java.util.Date purchaseDate) {
        RetailBean bean = fetchRecord(customerName, purchaseDate);
        return bean != null;
    }
    public String generateRecordID(String customerName, java.util.Date purchaseDate) {
        String id = "";
        try {
            Connection con = DBUtil.getDBConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select retail_seq.nextval from dual");
            if (rs.next()) {
                int seq = rs.getInt(1);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String datePart = sdf.format(purchaseDate);
                String namePart = customerName.substring(0, 2).toUpperCase();
                id = datePart + namePart + seq;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    public List<RetailBean> fetchAllRecords() {
        List<RetailBean> list = new ArrayList<>();
        try {
            Connection con = DBUtil.getDBConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from retail_tb");
            while (rs.next()) {
                RetailBean bean = new RetailBean();
                bean.setRecordId(rs.getString(1));
                bean.setCustomerName(rs.getString(2));
                bean.setProductName(rs.getString(3));
                bean.setPurchaseDate(rs.getDate(4));
                bean.setQuantity(rs.getInt(5));
                bean.setPrice(rs.getDouble(6));
                bean.setRemarks(rs.getString(7));
                list.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

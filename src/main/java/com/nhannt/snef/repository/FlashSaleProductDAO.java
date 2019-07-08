package com.nhannt.snef.repository;


import com.nhannt.snef.connection.MyConnection;
import com.nhannt.snef.model.FlashSaleProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class FlashSaleProductDAO {
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;


    // 6/17/2019 TinLM Create
    // Get top 10 hot flash sale product
    public List<FlashSaleProduct> getTopFlashSaleProduct() throws SQLException, ClassNotFoundException {
        List<FlashSaleProduct> result = new ArrayList<>();
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "select top 10 fsp.FlashSaleProductId, fsp.Quantity, sp.StoreProductId, sp.ProductName, sp.Quantity as SpQuantity, sp.Price ,\n" +
                        "fs.StoreId, fs.Discount , fs.EndDate\n" +
                        " from FlashSaleProduct fsp, StoreProduct sp, FlashSales fs \n" +
                        "where fsp.FlashSalesId = fs.FlashSalesId and fsp.StoreProductId = sp.StoreProductId \n" +
                        "order by fs.Discount desc";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int flashSaleProductId = rs.getInt("FlashSaleProductId");
                    int quantity = rs.getInt("Quantity");
                    int storeProductId = rs.getInt("StoreProductId");
                    int spQuantity = rs.getInt("SpQuantity");
                    int storeId = rs.getInt("StoreId");
                    int discount = rs.getInt("Discount");
                    float price = rs.getFloat("Price");
                    Date endDate = rs.getDate("EndDate");
                    String productName = rs.getString("ProductName");

                    result.add(new FlashSaleProduct(flashSaleProductId, quantity, storeProductId,
                            productName, spQuantity, price, storeId, discount, endDate
                    ));

                }
            }
        } finally {
            MyConnection.closeConnection(rs, stm, con);
        }
        return result;
    }

    // 6/17/2019 TinLM Create
    // Get top 10 hot flash sale product
    public List<FlashSaleProduct> getFSPByStoreId(int storeId) throws SQLException, ClassNotFoundException {
        List<FlashSaleProduct> result = new ArrayList<>();
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "select fsp.FlashSaleProductId, fsp.Quantity , fsp.StoreProductId " +
                        "from Store s, StoreProduct sp, FlashSaleProduct fsp \n" +
                        "where s.StoreId = sp.StoreId and sp.StoreProductId = fsp.StoreProductId\n" +
                        " and s.StoreId = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, storeId);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int flashSaleProductId = rs.getInt("FlashSaleProductId");
                    int quantity = rs.getInt("Quantity");
                    int storeProductId = rs.getInt("StoreProductId");
                    result.add(new FlashSaleProduct(flashSaleProductId, quantity, storeProductId));
                }
            }
        } finally {
            MyConnection.closeConnection(rs, stm, con);
        }
        return result;
    }

    // get all flash sale product
    public List<FlashSaleProduct> getAllFSP() {
        List<FlashSaleProduct> result = new ArrayList<>();
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "select top 10 fsp.FlashSaleProductId, fsp.Quantity, sp.StoreProductId, sp.ProductName, sp.Quantity as SpQuantity, sp.Price ,\n" +
                        "fs.StoreId, fs.Discount , fs.EndDate\n" +
                        " from FlashSaleProduct fsp, StoreProduct sp, FlashSales fs \n" +
                        "where fsp.FlashSalesId = fs.FlashSalesId and fsp.StoreProductId = sp.StoreProductId \n";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int flashSaleProductId = rs.getInt("FlashSaleProductId");
                    int quantity = rs.getInt("Quantity");
                    int storeProductId = rs.getInt("StoreProductId");
                    int spQuantity = rs.getInt("SpQuantity");
                    int storeId = rs.getInt("StoreId");
                    int discount = rs.getInt("Discount");
                    float price = rs.getFloat("Price");
                    Date endDate = rs.getDate("EndDate");
                    String productName = rs.getString("ProductName");

                    result.add(new FlashSaleProduct(flashSaleProductId, quantity, storeProductId,
                            productName, spQuantity, price, storeId, discount, endDate
                    ));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            MyConnection.closeConnection(rs, stm, con);
        }
        return result;
    }

}

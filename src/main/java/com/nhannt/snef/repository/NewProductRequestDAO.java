package com.nhannt.snef.repository;

import com.nhannt.snef.connection.MyConnection;
import com.nhannt.snef.model.NewProductRequest;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NewProductRequestDAO {
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public List<NewProductRequest> getAllRequest() throws SQLException, ClassNotFoundException {
        List<NewProductRequest> listRequest = null;
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "SELECT n.NPRId, s.StoreName, p.ProductName, p.ImageSrc, n.Status, n.ProductId " +
                        "FROM NewProductRequest n, Store s, Product p " +
                        "where s.StoreId = n.StoreId " +
                        "AND n.ProductId = p.ProductId " +
                        "AND n.Status = 0 AND  (Message =\"\" OR Message IS NULL)";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int nprId = rs.getInt("NPRId");
                    String storeName = rs.getString("StoreName");
                    String productName = rs.getString("ProductName");
                    String proImage = rs.getString("ImageSrc");
                    boolean status = rs.getBoolean("Status");
                    int proId = rs.getInt("ProductId");
                    NewProductRequest dto = new NewProductRequest(nprId, status, storeName, productName, proImage, proId);
                    if (listRequest == null)
                        listRequest = new ArrayList<>();
                    listRequest.add(dto);
                }
                return listRequest;
            }

        } finally {
            closeConnection();
        }
        return null;
    }

    /**
     * If status == true => Update Product => Status = true
     * <p>
     * If Status == false => Insert Description
     */
    public boolean acceptRequest(int nprId, String adminName, boolean statusProduct, int proId)
            throws SQLException, ClassNotFoundException {
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "update NewProductRequest " +
                        "set status = ?, AdminId = (select AccountId from Account Where UserName = ?) " +
                        "Where nprId = ? And ProductId = ?";
                stm = con.prepareStatement(sql);
                stm.setBoolean(1, statusProduct);
                stm.setString(2, adminName);
                stm.setInt(3, nprId);
                stm.setInt(4, proId);
                int row = stm.executeUpdate();
                if (row > 0) {
                    //If success => change status trong bảng product
                    String query = "UPDATE Product SET Status = 1 WHERE ProductId = ?";
                    stm = con.prepareStatement(query);
                    stm.setInt(1, proId);
                    int success = stm.executeUpdate();
                    if (success > 0) {
                        return true;
                    }
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean denyRequest(int nprId, String adminName, boolean statusProduct, String message, int proId) throws SQLException, ClassNotFoundException {
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "update NewProductRequest SET Message = ?, Status = ?, adminId = (Select AccountId From Account WHERE UserName = ?) " +
                        "where nprId = ? AND productId =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, message);
                stm.setBoolean(2, statusProduct);
                stm.setString(3, adminName);
                stm.setInt(4, nprId);
                stm.setInt(5, proId);
                int row = stm.executeUpdate();
                if (row > 0){
                    return true;
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }
}

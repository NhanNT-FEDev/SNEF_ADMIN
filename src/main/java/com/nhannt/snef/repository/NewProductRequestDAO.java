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
            if (con != null){
                String sql = "SELECT n.NPRId, s.StoreName, p.ProductName, n.Status FROM NewProductRequest n, Store s, Product p " +
                        "where s.StoreId = n.StoreId AND n.ProductId = p.ProductId AND n.Status = 0 ORDER BY n.NPRId DESC ";
                stm = con.prepareStatement(sql);
                rs =stm.executeQuery();
                while (rs.next()){
                    int nprId = rs.getInt("NPRId");
                    String storeName = rs.getString("StoreName");
                    String productName = rs.getString("ProductName");
                    boolean status = rs.getBoolean("Status");

                    NewProductRequest dto = new NewProductRequest(nprId, status, storeName, productName);
                    if (listRequest == null)
                        listRequest = new ArrayList<>();
                    listRequest.add(dto);
                }
                return listRequest;
            }

        }finally {
            closeConnection();
        }
        return null;
    }
}

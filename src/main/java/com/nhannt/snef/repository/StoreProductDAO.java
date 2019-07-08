package com.nhannt.snef.repository;

import com.nhannt.snef.connection.MyConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StoreProductDAO {

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    public int getQuantityById(int storeProductId) throws SQLException, ClassNotFoundException {
        int result = 0;
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "select Quantity from StoreProduct where StoreProductId = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, storeProductId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("Quantity");
                }
            }
        } finally {
            MyConnection.closeConnection(rs, stm, con);
        }
        return result;
    }
}

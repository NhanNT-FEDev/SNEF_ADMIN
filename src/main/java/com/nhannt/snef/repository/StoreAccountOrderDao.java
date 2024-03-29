package com.nhannt.snef.repository;

import com.nhannt.snef.connection.MyConnection;
import com.nhannt.snef.model.*;
import com.nhannt.snef.model.StoreAccountOrder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StoreAccountOrderDao {

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

    //Load Per Page
    public List<StoreAccountOrder> getAllComment(int storeId, int offset, int noOfRecord)
            throws SQLException, ClassNotFoundException {
        List<StoreAccountOrder> listComment = null;
        try{
            con = MyConnection.myConnection();
            if (con != null){
                String sql =
                        "Select SQL_CALC_FOUND_ROWS s.StoreId, s.StoreName, s.Phone, s.Address , o.Comment, a.UserName, a.Phone as UserContact " +
                                "From `snef_part2`.Order o, Account a, Store s " +
                                "Where  o.storeId = s.StoreId " +
                                "AND o.accountId = a.AccountId " +
                                "AND s.storeId = ? " +
                                "AND o.Comment IS NOT NULL limit ?, ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, storeId);
                stm.setInt(2, offset);
                stm.setInt(3, noOfRecord);
                rs = stm.executeQuery();
                while (rs.next()){
                    int stId = rs.getInt("StoreId");
                    String storeName = rs.getString("StoreName");
                    String phone = rs.getString("Phone");
                    String address =rs.getString("Address");
                    String comment = rs.getString("Comment");
                    String username = rs.getString("UserName");
                    String userPhone = rs.getString("UserContact");

                    StoreAccountOrder dto = new StoreAccountOrder(stId, storeName, phone, address, comment, username, userPhone);
                    if (listComment == null){
                        listComment = new ArrayList<>();
                    }
                    listComment.add(dto);
                }
                return  listComment;
            }
        }finally {
            closeConnection();
        }
        return null;
    }

    //Get total
    public int countRecords(int storeId) throws SQLException, ClassNotFoundException {
        try{
            con = MyConnection.myConnection();
            if (con != null){
                String sql = "Select COUNT(s.StoreId) AS TotalRecords " +
                        "From `snef_part2`.Order o, Account a, Store s " +
                        "Where  o.storeId = s.StoreId " +
                        "AND o.accountId = a.AccountId AND s.storeId = ? " +
                        "AND o.Comment IS NOT NULL";
                stm = con.prepareStatement(sql);
                stm.setInt(1, storeId);
                rs = stm.executeQuery();
                if (rs.next()){
                    int count = rs.getInt("TotalRecords");
                    return count;
                }
            }
        }finally {
            closeConnection();
        }
        return 0;
    }
}

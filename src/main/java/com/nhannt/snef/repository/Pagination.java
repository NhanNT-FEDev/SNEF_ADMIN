package com.nhannt.snef.repository;


import com.nhannt.snef.connection.MyConnection;


import com.nhannt.snef.model.Store;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Pagination {

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

    public List<Store> getListByPage(int offset, int noOfRecords) throws SQLException, ClassNotFoundException {
        List<Store> getList = null;
        try{
            con = MyConnection.myConnection();
            if (con != null){
                String sql = "SELECT SQL_CALC_FOUND_ROWS StoreId, StoreName, Address, Phone FROM Store limit ?, ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, offset);
                stm.setInt(2, noOfRecords);
                rs = stm.executeQuery();
                while (rs.next()){
                    int storeId = rs.getInt("StoreId");
                    String storeName = rs.getString("StoreName");
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    Store dto = new Store(storeId, storeName, address, phone);
                    if (getList == null){
                        getList = new ArrayList<>();
                    }
                    getList.add(dto);
                }
                return getList;
            }

        }finally {
            closeConnection();
        }
        return null;
    }

    public int getTotalPage() throws SQLException, ClassNotFoundException {
        try{
            con = MyConnection.myConnection();
            if (con != null){
                String sql = "Select COUNT(StoreId) AS TotalRecords From Store";
                stm = con.prepareStatement(sql);
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

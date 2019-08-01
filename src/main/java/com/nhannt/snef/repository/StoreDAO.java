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

public class StoreDAO {

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

    public List<Store> getAllStore() throws SQLException, ClassNotFoundException {

        List<Store> result = null;
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "Select s.StoreId, s.StoreName, s.Address, s.RatingPoint, s.Avatar, s.OpenHour, s.CloseHour, s.Status, s.Phone, a.UserName " +
                        "From Store s, Account a " +
                        "WHERE s.accountId = a.AccountId";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int storeId = rs.getInt("StoreId");
                    String storeName = rs.getString("StoreName");
                    String address = rs.getString("Address");
                    float rating = rs.getFloat("RatingPoint");
                    String avatar = rs.getString("Avatar");
                    String open = rs.getString("OpenHour");
                    String close = rs.getString("CloseHour");
                    boolean status = rs.getBoolean("Status");
                    String phone = rs.getString("Phone");
                    String storeManager = rs.getString("Username");

                    Store dto = new Store(storeId, storeName, address, rating, avatar, open, close, status, phone, storeManager);
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(dto);
                }
                return result;
            }
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<Store> searchStoreByName(String name) throws SQLException, ClassNotFoundException {
        List<Store> searchValue = null;
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "Select s.StoreId, s.StoreName, s.Address, s.RatingPoint, s.Avatar, s.OpenHour, s.CloseHour, s.Status, s.Phone, a.UserName " +
                        "From Store s, Account a " +
                        "WHERE s.accountId = a.AccountId " +
                        "AND StoreName LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int storeId = rs.getInt("StoreId");
                    String storeName = rs.getString("StoreName");
                    String address = rs.getString("Address");
                    float rating = rs.getFloat("RatingPoint");
                    String avatar = rs.getString("Avatar");
                    String open = rs.getString("OpenHour");
                    String close = rs.getString("CloseHour");
                    boolean status = rs.getBoolean("Status");
                    String phone = rs.getString("Phone");
                    String storeManager = rs.getString("Username");

                    Store dto = new Store(storeId, storeName, address, rating, avatar, open, close, status, phone, storeManager);
                    if (searchValue == null) {
                        searchValue = new ArrayList<>();
                    }
                    searchValue.add(dto);

                }
                return searchValue;

            }
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<Store> getStoreById(int id) throws SQLException, ClassNotFoundException {
        List<Store> storeById = null;
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "Select s.StoreId, s.StoreName, s.Address, s.RatingPoint, s.Avatar, s.OpenHour, s.CloseHour, s.Status, s.Phone, a.UserName " +
                        "From Store s, Account a " +
                        "WHERE s.accountId = a.AccountId " +
                        "AND s.StoreId = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int storeId = rs.getInt("StoreId");
                    String storeName = rs.getString("StoreName");
                    String address = rs.getString("Address");
                    float rating = rs.getFloat("RatingPoint");
                    String avatar = rs.getString("Avatar");
                    String open = rs.getString("OpenHour");
                    String close = rs.getString("CloseHour");
                    boolean status = rs.getBoolean("Status");
                    String phone = rs.getString("Phone");
                    String storeManager = rs.getString("Username");

                    Store dto = new Store(storeId, storeName, address, rating, avatar, open, close, status, phone, storeManager);
                    if (storeById == null) {
                        storeById = new ArrayList<>();
                    }
                    storeById.add(dto);

                }
                return storeById;
            }
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean
    updateStoreById(int id, String storeName, String address, String avatar, String openHour,
                    String closeHour, boolean status, String account, String phone) throws SQLException, ClassNotFoundException {
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "UPDATE (Store s, Account a) " +
                        "SET s.StoreName = ?, s.Address =?, s.Avatar=?, s.OpenHour= ?, s.CloseHour= ?, a.Username= ?, s.Status= ?, s.Phone = ? " +
                        "WHERE s.StoreId = ? " +
                        "AND s.AccountId = a.AccountID";
                stm = con.prepareStatement(sql);
                stm.setString(1, storeName);
                stm.setString(2, address);
                stm.setString(3, avatar);
                stm.setString(4, openHour);
                stm.setString(5, closeHour);
                stm.setString(6, account);
                stm.setBoolean(7, status);
                stm.setString(8, phone );
                stm.setInt(9, id);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean checkExistName(String storeName) throws SQLException, ClassNotFoundException {
            try{
                con = MyConnection.myConnection();
                if (con != null){
                    String sql = "Select StoreName From Store WHERE StoreName = ?";
                    stm = con.prepareStatement(sql);
                    stm.setString(1, storeName);
                    rs = stm.executeQuery();
                    if (rs.next()){
                        return true;
                    }

                }
            }finally {
                closeConnection();
            }

        return false;
    }

    public boolean insertNewStore
            (String storeName, String address, String avatar, String open, String close, String phone, int accountId) throws SQLException, ClassNotFoundException {
        try{
            con = MyConnection.myConnection();
            if (con != null){
                String sql =
                        "INSERT INTO Store(StoreName, Address, Avatar, OpenHour, CloseHour, Status, Phone, AccountId) " +
                        "VALUES(?,?,?,?,?,1,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, storeName);
                stm.setString(2, address);
                stm.setString(3, avatar);
                stm.setString(4, open);
                stm.setString(5, close);
                stm.setString(6, phone);
                stm.setInt(7, accountId);
                int row = stm.executeUpdate();
                if (row > 0){
                    return true;
                }

            }
        }finally {
            closeConnection();
        }
        return false;
    }
}

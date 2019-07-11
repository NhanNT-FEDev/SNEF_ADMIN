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
                String sql = "SELECT StoreId, StoreName,StoreManagerId, LocationId, RatingPoint, Avatar, OpenHour, CloseHour, Status " +
                        "FROM Store";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int storeId = rs.getInt("StoreId");
                    String storeName = rs.getString("StoreName");
                    int storeManagerId = rs.getInt("StoreManagerId");
                    int loId = rs.getInt("LocationId");
                    float rating = rs.getFloat("RatingPoint");
                    String avatar = rs.getString("Avatar");
                    String open = rs.getString("OpenHour");
                    String close = rs.getString("CloseHour");
                    boolean status = rs.getBoolean("Status");

                    Store dto = new Store(storeId, storeName, storeManagerId, loId, rating, avatar, open, close, status);
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
        try{
            con = MyConnection.myConnection();
            if (con != null){
                String sql = "SELECT * FROM dbo.Store WHERE StoreName LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                rs = stm.executeQuery();
                while (rs.next()){
                    int storeId = rs.getInt("StoreId");
                    String storeName = rs.getString("StoreName");
                    int storeManagerId = rs.getInt("StoreManagerId");
                    int loId = rs.getInt("LocationId");
                    float rating = rs.getFloat("RatingPoint");
                    String avatar = rs.getString("Avatar");
                    String open = rs.getString("OpenHour");
                    String close = rs.getString("CloseHour");
                    boolean status = rs.getBoolean("Status");

                    Store dto = new Store(storeId, storeName, storeManagerId, loId, rating, avatar, open, close, status);
                    if (searchValue == null){
                        searchValue = new ArrayList<>();
                    }
                    searchValue.add(dto);

                }
                return  searchValue;

            }
        }finally {
            closeConnection();
        }
        return null;
    }

    public List<Store> getStoreById(int id) throws SQLException, ClassNotFoundException {
        List<Store> storeById = null;
        try{
            con = MyConnection.myConnection();
            if (con != null){
                String sql = "SELECT storeId, StoreName, LocationId, RatingPoint, Avatar, OpenHour, CloseHour, StoreManagerId, status " +
                        "FROM dbo.Store " +
                        "WHERE store.StoreId = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                rs = stm.executeQuery();
                while (rs.next()){
                    int storeId = rs.getInt("StoreId");
                    String storeName = rs.getString("StoreName");
                    int storeManagerId = rs.getInt("StoreManagerId");
                    int loId = rs.getInt("LocationId");
                    float rating = rs.getFloat("RatingPoint");
                    String avatar = rs.getString("Avatar");
                    String open = rs.getString("OpenHour");
                    String close = rs.getString("CloseHour");
                    boolean status = rs.getBoolean("Status");

                    Store dto = new Store(storeId, storeName, storeManagerId, loId, rating, avatar, open, close, status);
                    if (storeById == null){
                        storeById = new ArrayList<>();
                    }
                    storeById.add(dto);

                }
                return storeById;
            }
        }finally {
            closeConnection();
        }
        return  null;
    }

    public boolean
    updateStoreById(int id, String name, int storeManager, int local, float rating, String avata,  String open,
                    String close, boolean status) throws SQLException, ClassNotFoundException {
        try{
            con = MyConnection.myConnection();
            if (con != null){
                String sql = "UPDATE dbo.Store " +
                        "SET StoreName = ?, LocationId =?, RatingPoint =?, Avatar= ?, OpenHour= ?, CloseHour= ?, StoreManagerId= ?, Status= ? " +
                        "WHERE dbo.Store.StoreId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setInt(2, local);
                stm.setFloat(3, rating);
                stm.setString(4, avata);
                stm.setString(5, open);
                stm.setString(6, close);
                stm.setInt(7, storeManager);
                stm.setBoolean(8, status);
                stm.setInt(9, id);
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

    public boolean
    insertNewStore(String name, int local, float rating, String ava, String open, String close, int storeMana, boolean status) throws SQLException, ClassNotFoundException {
        try{
            con = MyConnection.myConnection();
            if (con != null){
                String sql = "INSERT INTO dbo.Store VALUES( ?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setInt(2, local);
                stm.setFloat(3, rating);
                stm.setString(4, ava);
                stm.setString(5, open);
                stm.setString(6, close);
                stm.setInt(7, storeMana);
                stm.setBoolean(8, status);
                int row = stm.executeUpdate();
                if (row > 0){
                    return  true;
                }
            }
        }finally {
            closeConnection();
        }
        return false;
    }
}

package com.nhannt.snef.repository;

import com.nhannt.snef.connection.MyConnection;
import com.nhannt.snef.model.Configuration;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfigurationDAO {

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

    public List<Configuration> getAllCf(int offset, int noOfRecords) throws SQLException, ClassNotFoundException {
        List<Configuration> listCon = null;
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "SELECT SQL_CALC_FOUND_ROWS configurationId, configurationName, configurationValue FROM Configuration limit ?, ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, offset);
                stm.setInt(2, noOfRecords);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int conId = rs.getInt("configurationId");
                    String conName = rs.getString("configurationName");
                    String conValue = rs.getString("configurationValue");
                    Configuration dto = new Configuration(conId, conName, conValue);
                    if (listCon == null) {
                        listCon = new ArrayList<>();
                    }
                    listCon.add(dto);

                }

                return listCon;
            }
        } finally {
            closeConnection();
        }
        return null;
    }

    //Get Total
    public int getTotalCf() throws SQLException, ClassNotFoundException {
        try {
            con = MyConnection.myConnection();
            if (con != null){
                String sql = "SELECT COUNT(configurationId) AS TotalCf FROM Configuration";
                stm  = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()){
                    int count = rs.getInt("TotalCf");
                    return count;
                }
            }
        }finally {
            closeConnection();
        }
        return 0;
    }

    public boolean checkExistCf(String cfName) throws SQLException, ClassNotFoundException {
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "SELECT configurationId, configurationName, configurationValue " +
                        "FROM Configuration " +
                        "WHERE configurationName = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, cfName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean insertNewCf(String cfName, String cfValue) throws SQLException, ClassNotFoundException {
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "INSERT INTO Configuration(configurationName, configurationValue) VALUES(?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, cfName);
                stm.setString(2, cfValue);
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

    public boolean updateCf(int cfId, String cfName, String cfValue) throws SQLException, ClassNotFoundException {
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "UPDATE (Configuration) SET configurationName = ?, configurationValue = ? WHERE configurationId=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, cfName);
                stm.setString(2, cfValue);
                stm.setInt(3, cfId);
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


    public List<Configuration> getCfById(int cfId) throws SQLException, ClassNotFoundException {
        List<Configuration> getList = null;
        try {
            con = MyConnection.myConnection();
            if (con != null){
                String sql = "SELECT configurationId,configurationName, configurationValue FROM Configuration WHERE configurationId = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, cfId);
                rs = stm.executeQuery();
                while (rs.next()){
                    int configurationIdfId = rs.getInt("configurationId");
                    String cfName = rs.getString("configurationName");
                    String cfValue = rs.getString("configurationValue");

                    Configuration dto = new Configuration(configurationIdfId,cfName, cfValue);
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
}

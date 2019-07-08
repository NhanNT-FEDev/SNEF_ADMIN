package com.nhannt.snef.repository;

import com.nhannt.snef.connection.MyConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 6/22/2019 TinLM Create class
// 6/22/2019 TinLM Create getValueByName
public class ConfigurationDAO {

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    // 6/22/2019 TinLM Create
    public String getValueByName(String configurationName) {
        String result = "";
        try {
            con = MyConnection.myConnection();
            String sql = "select configurationValue from Configuration where configurationName = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, configurationName);
            rs = stm.executeQuery();
            if (rs.next()) {
                result = rs.getString("configurationValue");
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

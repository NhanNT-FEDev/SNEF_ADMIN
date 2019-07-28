package com.nhannt.snef.connection;

import java.io.Serializable;
import java.sql.*;

public class MyConnection implements Serializable {
    public static Connection myConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=SNEF_DEMO";
        String url = "jdbc:mysql://snef.cvkbe5tc6xkf.ap-southeast-1.rds.amazonaws.com:3306/snef_part2";
            Connection con = DriverManager.getConnection(url, "TinLM", "Chaulen3");
//        Connection con = DriverManager.getConnection(url, "sa", "chaulenba");
        return con;
    }

    public static void closeConnection(ResultSet rs, PreparedStatement stm, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


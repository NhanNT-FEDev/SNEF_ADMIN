package com.nhannt.snef.repository;

import com.nhannt.snef.connection.MyConnection;
import com.nhannt.snef.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
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

    public List<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {
        List<Customer> getList = null;
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "SELECT Username, FirstName, LastName, Phone, Email, IsActive, Avatar, Gender FROM Customer c, Account a WHERE c.AccountId = a.AccountId";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("Username");
                    String firstname = rs.getString("FirstName");
                    String lastname = rs.getString("LastName");
                    String phone = rs.getString("Phone");
                    String email = rs.getString("Email");
                    boolean isactive = rs.getBoolean("IsActive");
                    String avatar = rs.getString("Avatar");
                    boolean gender = rs.getBoolean("Gender");
                    Customer dto = new Customer(username, firstname, lastname, phone, email, isactive, avatar, gender);
                    if (getList == null) {
                        getList = new ArrayList<>();
                    }
                    getList.add(dto);

                }
                return getList;
            }
        } finally {
            closeConnection();
        }
        return null;
    }
}

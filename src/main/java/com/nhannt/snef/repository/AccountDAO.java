package com.nhannt.snef.repository;

import com.nhannt.snef.connection.MyConnection;
import com.nhannt.snef.model.Account;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAO {
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

    //Load All Account
    public List<Account> getAllAccount() throws SQLException, ClassNotFoundException {
        List<Account> listAccount = null;
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql =
                        "Select AccountId,UserName, Password, FirstName, LastName, Phone, Email, Avatar, Gender, isActive " +
                                "From Account WHERE roleId = 3";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int accountId = rs.getInt("AccountId");
                    String username = rs.getString("UserName");

                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String phone = rs.getString("Phone");
                    boolean isActive = rs.getBoolean("isActive");
                    String email = rs.getString("Email");
                    String avatar = rs.getString("Avatar");
                    boolean gender = rs.getBoolean("Gender");
                    Account dto = new Account(accountId, username, firstName, lastName, phone, email, isActive, avatar, gender);
                    if (listAccount == null) {
                        listAccount = new ArrayList<>();
                    }
                    listAccount.add(dto);
                }
                return listAccount;
            }
        } finally {
            closeConnection();
        }
        return null;
    }

    //Check If Account Exist
    public boolean checkExistAccount(String accountName) throws SQLException, ClassNotFoundException {
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "SELECT Username FROM Account WHERE UserName = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, accountName);
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

    //Insert new Store Account Information
    public int
    insertNewStoreAccount(String username, String password, String firstName,
                          String lastName, String phone,
                          String email, int gender)
            throws SQLException, ClassNotFoundException {
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "INSERT INTO Account(Username,Password,FirstName,LastName,Phone,Email,isActive,Gender,RoleId) " +
                        "VALUES (?,?,?,?,?, ?,?,1, (Select roleId From Role where roleId = 2 ))";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, firstName);
                stm.setString(4, lastName);
                stm.setString(5, phone);
                stm.setString(6, email);
                stm.setInt(7, gender);

                int row = stm.executeUpdate();
                if (row > 0) {
                    String query = "Select AccountId From Account WHERE UserName = ?";
                    stm = con.prepareStatement(query);
                    stm.setString(1, username);
                    rs = stm.executeQuery();
                    if (rs.next()) {
                        int accountId = rs.getInt("AccountId");
                        System.out.println("accountID: " + accountId);
                        return accountId;

                    }
                }

            }

        } finally {
            closeConnection();
        }
        return 0;
    }


    //Deactive Account
    public boolean changeStatusAccount(int accountId, boolean stt) throws SQLException, ClassNotFoundException {
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "Update (Account) SET isActive = ? WHERE AccountId = ? ";
                stm = con.prepareStatement(sql);
                stm.setBoolean(1, stt);
                stm.setInt(2, accountId);
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

    //Check account login
    public String checkAccount(String username, String password) throws SQLException, ClassNotFoundException {
        try {
            con = MyConnection.myConnection();
            if (con != null) {
                String sql = "SELECT username, password FROM Account WHERE username = ? AND password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("username");
                    return name;
                }
            }
        }finally {
            closeConnection();
        }
        return null;
    }
}

package com.nhannt.snef.service;

import com.nhannt.snef.model.Account;
import com.nhannt.snef.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class AccountService {

    @Autowired
    AccountDAO accountDAO = new AccountDAO();

    public int insertNewAccount(String username, String password, String firstName, String lastName, String phone, String email, int gender) throws SQLException, ClassNotFoundException {
        boolean checkExistName = accountDAO.checkExistAccount(username);
        //If true -> this name is used
        //If false -> create
        if (!checkExistName){
            int accountId = accountDAO.insertNewStoreAccount(username, password, firstName, lastName, phone, email, gender );

            return accountId;
        }
        return 0;
    }

    public List<Account> getAllAccount() throws SQLException, ClassNotFoundException {
        List<Account> result = accountDAO.getAllAccount();
        return result;
    }

    public boolean changeStatus(int accountId, boolean status) throws SQLException, ClassNotFoundException {
        boolean rs = accountDAO.changeStatusAccount(accountId, status);
        if (rs){
            return true;
        }
        return false;
    }

    public String checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        String name = accountDAO.checkAccount(username, password);
        if (name != null){
            return name;
        }
        return null;
    }
}

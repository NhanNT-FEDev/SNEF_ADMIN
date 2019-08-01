package com.nhannt.snef.service;

import com.nhannt.snef.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

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




}

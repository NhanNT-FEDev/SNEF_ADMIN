package com.nhannt.snef.controller;

import com.nhannt.snef.repository.AccountDAO;
import com.nhannt.snef.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
@RequestMapping(value = {"/","/login"})
public class LoginController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET, produces = "application/json")
    public String loginPage (){
        return "login";
    }

    @RequestMapping(value = {"/check"}, method = RequestMethod.POST)
    public String checkLogin(@RequestParam(value = "txtName") String name,
                             @RequestParam(value = "txtPass") String pass,
                             HttpSession session
                             ) throws SQLException, ClassNotFoundException {
        String username = accountService.checkLogin(name, pass);
        if (username != null){
            session.setAttribute("USERNAME", username);
            return "redirect:/home";
        }
        return "login";
    }
}

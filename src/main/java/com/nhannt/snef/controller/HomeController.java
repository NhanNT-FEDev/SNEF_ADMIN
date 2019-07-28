package com.nhannt.snef.controller;

import com.nhannt.snef.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
public class HomeController {
    @Autowired
    StoreService storeService;

    @RequestMapping(method = RequestMethod.GET, value = {"/", "/home","/admin"}, produces = "application/json")
    public String home(Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("LISTSTORE", storeService.getAllStores());
        //Set dường dẫn chạy file jsp
        return "homepage";
    }
}

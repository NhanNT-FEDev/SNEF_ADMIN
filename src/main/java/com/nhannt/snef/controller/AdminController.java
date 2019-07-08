package com.nhannt.snef.controller;

import com.nhannt.snef.model.Store;
import com.nhannt.snef.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/search")
    public String searchByName(@RequestParam(value = "name") String name, Model model) throws SQLException, ClassNotFoundException {
        List<Store> getList = storeService.searchByName(name);

        model.addAttribute("SEARCHVALUE", getList);
        return "home";
    }

    @RequestMapping(value = "edit")
    public String editStore(@RequestParam(value = "storeId") String storeId, Model model) throws SQLException, ClassNotFoundException {
        int getId = Integer.parseInt(storeId);
        List<Store> getDetail = storeService.getStoreById(getId);

        model.addAttribute("STOREDETAIL", getDetail);
        return "edit";
    }



}

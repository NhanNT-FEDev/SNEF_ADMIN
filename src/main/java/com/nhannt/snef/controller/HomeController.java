package com.nhannt.snef.controller;

import com.nhannt.snef.model.Store;
import com.nhannt.snef.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    StoreService storeService;

    //Show ALl Store Using Paginator
    @RequestMapping(method = RequestMethod.GET, value = {"/home","/admin"}, produces = "application/json")
    public String home(Model model) throws SQLException, ClassNotFoundException {
        int page = 1;
        int recordPerPage = 3;

        //Get Total Records From DB
        int totalRecords = storeService.getRecords();

        //Calculate numbers of pages
        int noOfPage = (int) Math.ceil(totalRecords * 1.0/recordPerPage);

        //Formula of pagination
        List<Store> getList = storeService.getPaginator((page - 1) * recordPerPage, recordPerPage);

        model.addAttribute("LISTSTORE", getList);
        model.addAttribute("NOOFPAGE", noOfPage);
        model.addAttribute("CURRENTPAGE", page);
        //Set dường dẫn chạy file jsp
        return "homepage";
    }
}

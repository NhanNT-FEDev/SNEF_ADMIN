package com.nhannt.snef.controller;

import com.nhannt.snef.model.Store;
import com.nhannt.snef.repository.AccountDAO;
import com.nhannt.snef.service.AccountService;
import com.nhannt.snef.service.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(value = {"/","/login"})
public class LoginController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaginationService paginationService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET, produces = "application/json")
    public String loginPage (Model model) throws SQLException, ClassNotFoundException {
//        int page = 1;
//        int recordsPage  = 3;
//
//        //Total records from DB
//        int totalRecords = paginationService.countRecords();
//
//        //Calculate number of pages
//        int noOfPage = (int) Math.ceil(totalRecords * 1.0/recordsPage);
//        System.out.println("noOfPage: " + noOfPage);
//
//        List<Store> result = paginationService
//                .showAllList((page - 1) * recordsPage, recordsPage);
//
//        model.addAttribute("LIST", result);
//        model.addAttribute("PAGE", noOfPage);
//        model.addAttribute("CURRENTPAGE", page);

        return "login";
    }

    @RequestMapping(value = {"/page"}, method = RequestMethod.GET, produces = "application/json")
    public String receivePage(
            @RequestParam(value = "page")String page,

            Model model){
        int currentPage = Integer.parseInt(page);


        return "pagination";
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

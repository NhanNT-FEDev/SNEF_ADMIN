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

import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchByName(@RequestParam(value = "name") String name, Model model) throws SQLException, ClassNotFoundException {
        List<Store> getList = storeService.searchByName(name);

        model.addAttribute("SEARCHVALUE", getList);
        return "home";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editStore(@RequestParam(value = "storeId") String storeId, Model model)
            throws SQLException, ClassNotFoundException {
        int getId = Integer.parseInt(storeId);
        List<Store> getDetail = storeService.getStoreById(getId);

        model.addAttribute("STOREDETAIL", getDetail);
        return "edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  String saveStore(@RequestParam(value = "txtId") String id,
                             @RequestParam(value = "txtName") String name,
                             @RequestParam(value = "txtManager") String manager,
                             @RequestParam(value = "txtLocation") String local,
                             @RequestParam(value = "txtRating") String rating,
//                             @RequestParam(value = "txtAva") String ava,
                             @RequestParam(value = "txtOpen") String open,
                             @RequestParam(value = "txtClose") String close,
                             @RequestParam(name = "chkStatus") String chkStatus,
                             Model model) throws SQLException, ClassNotFoundException {
        int parseId = Integer.parseInt(id);

        int storeManager = Integer.parseInt(manager);
        int location = Integer.parseInt(local);
        float rat = Float.parseFloat(rating);
        boolean status = Boolean.parseBoolean(chkStatus);
        System.out.println("Status: " + chkStatus );

        boolean rs = storeService.updateStoreById(parseId,name, storeManager, location, rat, null, open, close, status);
        System.out.println("rs: " + rs);
        if (rs){
            return "redirect:/home";
        }

        model.addAttribute("msg", "Update not successful");
        return "edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String reDirectCreate(){
        return "create";
    }

//    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    public String insertNewStore(){
//
//        return "redirect:/home";
//    }

}

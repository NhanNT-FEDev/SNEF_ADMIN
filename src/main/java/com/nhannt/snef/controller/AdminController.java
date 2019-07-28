package com.nhannt.snef.controller;

import com.cloudinary.utils.ObjectUtils;
import com.nhannt.snef.model.Store;
import com.nhannt.snef.service.StoreService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.cloudinary.Cloudinary;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final String CLOUDINARY_CLOUD_NAME = "dr4hpc9gi";
    private static final String CLOUDINARY_API_KEY = "166957351197671";
    private static final String CLOUDINARY_API_SECRET = "zakaWJRkTxjvVutIlhrhqOxpWDk";

    /**
     * All function belong to Management Store
     * At this moment some field still not update validation
     *
     * */

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchByName(@RequestParam(value = "name") String name, Model model) throws SQLException, ClassNotFoundException {
        List<Store> getList = storeService.searchByName(name);

        model.addAttribute("SEARCHVALUE", getList);
        return "homepage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editStore(@RequestParam(value = "storeId") String storeId, Model model)
            throws SQLException, ClassNotFoundException {
        int getId = Integer.parseInt(storeId);
        List<Store> getDetail = storeService.getStoreById(getId);

        model.addAttribute("STOREDETAIL", getDetail);
        return "createpage";
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
            return "redirect:/homepage";
        }

        model.addAttribute("msg", "Update not successful");
        return "createpage";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String reDirectCreate() {
        return "createpage";
    }

    /**
     * Insert has 2 ways
     * 1:
     * Process Param of Address => return locationId
     * Insert Store Information
     *
     * 2:
     * Write one query method to insert Store
     * */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertNewStore(@RequestParam(name = "stName") String name,
                                 @RequestParam(name = "stLocal") String local,
                                 @RequestParam(name = "stRat") String rat,
                                 @RequestParam(name = "file") MultipartFile file,
                                 @RequestParam(name = "stOpen") String open,
                                 @RequestParam(name = "stClose") String close,
                                 @RequestParam(name = "stMana") String mana,
                                 @RequestParam(name = "chkStatus") Boolean status, Model model) throws SQLException, ClassNotFoundException {
        try{
            int parseLocal = Integer.parseInt(local);
            float parseRating = Float.parseFloat(rat);
            int parseManager = Integer.parseInt(mana);
//            boolean status = Boolean.parseBoolean(stt);
            //INsert address to Location

            //Insert Image to DB
            byte[] bytes =file.getBytes();
            Path path = Paths.get("" + file.getOriginalFilename());
            File myFile = new File(String.valueOf(Files.write(path, bytes)));
            HashMap<String, String> config = new HashMap<>();
            config.put("cloud_name", CLOUDINARY_CLOUD_NAME);
            config.put("api_key", CLOUDINARY_API_KEY);
            config.put("api_secret", CLOUDINARY_API_SECRET);
            Cloudinary cloudinary = new Cloudinary(config);
            HashMap<String, String> uploadResult = (HashMap<String, String>) cloudinary.uploader().upload(myFile, ObjectUtils.emptyMap());
            String getUrl = String.valueOf(uploadResult.get("url"));

            //Call Service
            boolean rs = storeService.insertNewStore(name, parseLocal, parseRating, getUrl, open, close, parseManager, status);
            if (rs){
                return "redirect:/home";
            }
            model.addAttribute("ERR", "Insert not successful");
        }catch (IOException e){
            e.printStackTrace();
        }
        return "create";
    }

    /*
     * End of Management Store
     * */

    /**
     * Manage all request about customer
     * At the moment some field still not validation
     * */

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String loadAllCustomer(Model model){

        return "home";
    }
}

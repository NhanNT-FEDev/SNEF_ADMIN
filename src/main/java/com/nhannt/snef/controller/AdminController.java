package com.nhannt.snef.controller;

import com.cloudinary.utils.ObjectUtils;
import com.nhannt.snef.model.Store;
import com.nhannt.snef.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cloudinary.Cloudinary;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final String CLOUDINARY_CLOUD_NAME = "dr4hpc9gi";
    private static final String CLOUDINARY_API_KEY = "166957351197671";
    private static final String CLOUDINARY_API_SECRET = "zakaWJRkTxjvVutIlhrhqOxpWDk";

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
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
    public String reDirectCreate() throws SQLException, ClassNotFoundException {


        return "create";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertNewStore(@RequestParam(name = "stName") String name,
                                 @RequestParam(name = "stLocal") String local,
                                 @RequestParam(name = "stRat") String rat,
                                 @RequestParam(name = "stAva") String ava,
                                 @RequestParam(name = "stOpen") String open,
                                 @RequestParam(name = "stClose") String close,
                                 @RequestParam(name = "stMana") String mana,
                                 @RequestParam(name = "chkStatus") String stt, Model model) throws SQLException, ClassNotFoundException {
        int parseLocal = Integer.parseInt(local);
        float parseRating = Float.parseFloat(rat);
        int parseManager = Integer.parseInt(mana);
        boolean status = Boolean.parseBoolean(stt);

        boolean rs = storeService.insertNewStore(name, parseLocal, parseRating, ava, open, close, parseManager, status);
        if (rs){
            return "redirect:/home";
        }
        model.addAttribute("ERR", "Insert not successful");
        return "create";
    }

    @RequestMapping(value = "/cloud", method = RequestMethod.GET)
    public String getPath(){
        return "uploadcloud";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadImg(@RequestParam(value = "file") MultipartFile file){
        try{
            //Get the file
            byte[] bytes =file.getBytes();
            Path path = Paths.get("" + file.getOriginalFilename());
            System.out.println("Rs: " + Files.write(path, bytes));
//            Cloudinary cloudinary = new Cloudinary();
            File myFile = new File(String.valueOf(Files.write(path, bytes)));
//
            HashMap<String, String> config = new HashMap<>();
            config.put("cloud_name", CLOUDINARY_CLOUD_NAME);
            config.put("api_key", CLOUDINARY_API_KEY);
            config.put("api_secret", CLOUDINARY_API_SECRET);
            Cloudinary cloudinary = new Cloudinary(config);
            System.out.println("Cloudinary: " + cloudinary);
            HashMap<String, String> uploadResult= (HashMap<String, String>) cloudinary.uploader().upload(myFile, ObjectUtils.emptyMap());
            System.out.println("Upload File: " + uploadResult.values());

            String getUrl = String.valueOf(uploadResult.get("url"));
            System.out.println("Get Url: " + getUrl);

        }catch (IOException e){
            e.printStackTrace();
        }

        return "uploadcloud";
    }
}

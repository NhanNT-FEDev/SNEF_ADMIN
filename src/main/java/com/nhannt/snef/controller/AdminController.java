package com.nhannt.snef.controller;

import com.cloudinary.utils.ObjectUtils;
import com.nhannt.snef.model.*;
import com.nhannt.snef.service.AccountService;
import com.nhannt.snef.service.ConfigurationService;
import com.nhannt.snef.service.NewProductRequestService;
import com.nhannt.snef.service.StoreService;
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
import java.util.Map;
import java.util.logging.Logger;

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
     */
    @Autowired
    private ConfigurationService service;


    @Autowired
    private StoreService storeService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private NewProductRequestService nprService;

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

    //Edit Store
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStore(@RequestParam(value = "txtId") String id,
                            @RequestParam(value = "editStoreName") String name,

                            @RequestParam(value = "editStoreAddress") String address,
//                            @RequestParam(value = "txtRating") String rating,
//                            @RequestParam(value = "file") MultipartFile file,
                            @RequestParam(value = "editOpenHour") String open,
                            @RequestParam(value = "editCloseHour") String close,
//                            @RequestParam(value = "txtAccount") String account,
                            @RequestParam(value = "editPhoneStore") String phone,
                            @RequestParam(name = "chkStatus") String chkStatus,
                            Model model) throws SQLException, ClassNotFoundException {
        int parseId = Integer.parseInt(id);

//        int storeManager = Integer.parseInt(manager);
//        int location = Integer.parseInt(local);
//        float rat = Float.parseFloat(rating);
        boolean status = Boolean.parseBoolean(chkStatus);
        try {
            //Insert Image to DB
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get("" + file.getOriginalFilename());
//            File myFile = new File(String.valueOf(Files.write(path, bytes)));
//            HashMap<String, String> config = new HashMap<>();
//            config.put("cloud_name", CLOUDINARY_CLOUD_NAME);
//            config.put("api_key", CLOUDINARY_API_KEY);
//            config.put("api_secret", CLOUDINARY_API_SECRET);
//            Cloudinary cloudinary = new Cloudinary(config);
//            HashMap<String, String> uploadResult = (HashMap<String, String>) cloudinary.uploader().upload(myFile, ObjectUtils.emptyMap());
//            String getUrl = String.valueOf(uploadResult.get("url"));
            boolean rs = storeService.updateStoreById(parseId, name, address, open, close, status, phone);
            if (rs) {
                return "redirect:/home";
            }


        } catch (Exception e) {
            Logger.getLogger("SERVER ERROR" + e);
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
     * <p>
     * 2:
     * Write one query method to insert Store
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String
    insertNewStore(
            @RequestParam(value = "txtUsername") String username,
            @RequestParam(value = "txtPassword") String password,
            @RequestParam(value = "txtFirstname") String firstName,
            @RequestParam(value = "txtLastName") String lastName,
            @RequestParam(value = "txtContact") String phone,
            @RequestParam(value = "txtEmail") String email,
            @RequestParam(value = "slGender") String gender,
            @RequestParam(value = "txtStoreName")String storeName,
            @RequestParam(value = "txtStoreAddress") String address,
            @RequestParam(value = "file") MultipartFile file,
            @RequestParam(value = "txtOpenHour") String open,
            @RequestParam(value = "txtCloseHour") String close,
            @RequestParam(value = "txtPhoneStore") String phoneStore,
            Model model) throws SQLException, ClassNotFoundException {
        try {
            int parseGender = Integer.parseInt(gender);
            int accountId = accountService.insertNewAccount(username, password, firstName, lastName, phone, email, parseGender);
            System.out.println("Insert Account Success: " + accountId);
            //If accountId == null -> message error name
            if (accountId > 0){

                /**
                 * Upload image to cloudinary
                 * => return url and pass to service
                 * */
                byte[] bytes = file.getBytes();
                Path path = Paths.get("" + file.getOriginalFilename());
                File myFile = new File(String.valueOf(Files.write(path, bytes)));
                HashMap<String, String> config = new HashMap<>();
                config.put("cloud_name", CLOUDINARY_CLOUD_NAME);
                config.put("api_key", CLOUDINARY_API_KEY);
                config.put("api_secret", CLOUDINARY_API_SECRET);
                Cloudinary cloudinary = new Cloudinary(config);
                HashMap<String, String> uploadResult = (HashMap<String, String>) cloudinary.uploader().upload(myFile, ObjectUtils.emptyMap());
                String getUrl = String.valueOf(uploadResult.get("url"));
                /**
                 * Get param address
                 * Convert to longitude and latitude
                 * */
                Map<String, Double> coords;
                coords = LatLon.getInstance().getCoordinates(address);

                System.out.println("latitude :" + coords.get("lat"));
                System.out.println("longitude:" + coords.get("lon"));
                String longitude = String.valueOf(coords.get("lon"));
                String latitude = String.valueOf(coords.get("lat"));

                // Create new Store
                boolean createStore =
                        storeService.insertNewStore(storeName, address,getUrl ,open, close,longitude, latitude, phoneStore, accountId);
                if (createStore){
                    return "redirect:/home";
                }

            }
            model.addAttribute("ERR", "Insert not successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "createpage";
    }

    /*
     * End of Management Store
     * */

    /**
     * Manage all request about customer
     * At the moment some field still not validation
     */

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String loadAllCustomer(Model model) throws SQLException, ClassNotFoundException {
        List<Account> rs = accountService.getAllAccount();
        model.addAttribute("CUSTOMER", rs);
        return "customerpage";
    }

    /**
    * Manage all CRUD of Configuration
    *
    * */
    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String showAllConfi(Model model) throws SQLException, ClassNotFoundException {
        List<Configuration> list = service.getAllConfi();
        model.addAttribute("CONFIGURATION", list);
        return "configpage";
    }

    @RequestMapping(value = "/config/create", method = RequestMethod.GET)
    public String addNewConfig(){
        return "createconfigpage";
    }

    /** Manage all CRUD of Process new Request
     *
     * */
    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String showAllRequest(Model model) throws SQLException, ClassNotFoundException {
        List<NewProductRequest> list = nprService.getAllRequest();
        model.addAttribute("REQUEST", list);
        return "processpage";
    }

}

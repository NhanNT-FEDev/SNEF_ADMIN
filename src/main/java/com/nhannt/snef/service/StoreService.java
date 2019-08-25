package com.nhannt.snef.service;


import com.nhannt.snef.model.Store;
import com.nhannt.snef.repository.StoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;


@RestController
public class StoreService {
    @Autowired
    StoreDAO storeDAO = new StoreDAO();


    //    @RequestMapping(method = RequestMethod.GET, path = "/store", produces = "application/json")
    public List<Store> getAllStores() throws SQLException, ClassNotFoundException {
        List<Store> getList = storeDAO.getAllStore();
        return getList;
    }

    public List<Store> searchByName(String name) throws SQLException, ClassNotFoundException {
        List<Store> rs = storeDAO.searchStoreByName(name);
        return rs;
    }

    public List<Store> getStoreById(int id) throws SQLException, ClassNotFoundException {
        List<Store> storeDetail = storeDAO.getStoreById(id);
        return storeDetail;
    }

    public boolean updateStoreById(int id, String storeName, String address,  String openHour,
                                   String closeHour, String longtitude, String latitude ,boolean status, String phone)
            throws SQLException, ClassNotFoundException {

            boolean rs = storeDAO.updateStoreById(id, storeName, address, openHour, closeHour, longtitude, latitude, status, phone);
            if (rs) {
                return true;
            }
        return false;
    }

    public boolean checkExistStoreName(String storename) throws SQLException, ClassNotFoundException {
        boolean existName =  storeDAO.checkExistName(storename);
        if (!existName){
            // Name is not exist
            return false;
        }
        // Name is exist
        return true;
    }

    public boolean insertNewStore(String storeName, String address, String avatar, String openHour, String closeHour, String longitude, String latitude, String phone, int accountID) throws SQLException, ClassNotFoundException {
        boolean checkExist = storeDAO.checkExistName(storeName);
        if (!checkExist){
        boolean result = storeDAO.insertNewStore(storeName, address, avatar, openHour, closeHour, longitude, latitude, phone, accountID);
            if (result) {
                return true;
            }
        }
        return false;
    }

    public List<Store> getPaginator(int offset, int noOfRecord) throws SQLException, ClassNotFoundException {
        List<Store> getList = storeDAO.getStoreByPage(offset, noOfRecord);
        return getList;
    }

    public int getRecords() throws SQLException, ClassNotFoundException {
        int totalRecords = storeDAO.getTotal();
        return totalRecords;
    }
}

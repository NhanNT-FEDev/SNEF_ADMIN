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

    // 6/17/2019 TinLM Create getAllStores
//    @RequestMapping(method = RequestMethod.GET, path = "/store", produces = "application/json")
    public List<Store> getAllStores() throws SQLException, ClassNotFoundException {
        List<Store> getList = storeDAO.getAllStore();
        return getList;
    }

    public List<Store> searchByName(String name) throws SQLException, ClassNotFoundException {
        List<Store> rs = storeDAO.searchStoreByName(name);
        return  rs;
    }

    public List<Store> getStoreById (int id) throws SQLException, ClassNotFoundException{
        List<Store> storeDetail = storeDAO.getStoreById(id);
        return storeDetail;
    }
}

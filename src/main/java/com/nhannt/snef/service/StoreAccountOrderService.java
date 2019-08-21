package com.nhannt.snef.service;

import com.nhannt.snef.model.StoreAccountOrder;
import com.nhannt.snef.repository.StoreAccountOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class StoreAccountOrderService {

    @Autowired
    private StoreAccountOrderDao storeAccountOrder;

    public List<StoreAccountOrder> getAllFeedBack(int storeId) throws SQLException, ClassNotFoundException {
        List<StoreAccountOrder> rs = storeAccountOrder.getAllComment(storeId);

        return rs;

    }
}

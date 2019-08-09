package com.nhannt.snef.service;

import com.nhannt.snef.model.NewProductRequest;
import com.nhannt.snef.repository.NewProductRequestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class NewProductRequestService {

    @Autowired
    private NewProductRequestDAO nprDao;

    public List<NewProductRequest> getAllRequest() throws SQLException, ClassNotFoundException {
        List<NewProductRequest> listRequest = nprDao.getAllRequest();
        return listRequest;
    }
}

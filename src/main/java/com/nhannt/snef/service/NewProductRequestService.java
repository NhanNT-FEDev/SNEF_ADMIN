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


    /**
     * If status == true => Update Product => Status = true
     * Field: nprId, Admin name, status, productId,
     * <p>
     * If Status == false => Insert Description
     * Field: productId, message,admin name,nprId
     */

    public boolean getAcceptRequest(int nprId, String adminName, boolean status, int productId) throws SQLException, ClassNotFoundException {
        boolean rs = nprDao.acceptRequest(nprId, adminName, status, productId);
        if (rs) {
            return true;
        }
        return false;
    }

    //Deny Process
    public boolean getDenyRequest(int nprId, String adminName, boolean status, int productId, String message) throws SQLException, ClassNotFoundException {
        boolean rs = nprDao.denyRequest(nprId, adminName, status, message, productId);
        if (rs) {
            return true;
        }
        return false;
    }

}

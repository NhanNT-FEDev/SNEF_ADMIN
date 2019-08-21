package com.nhannt.snef.service;

import com.nhannt.snef.model.Configuration;
import com.nhannt.snef.repository.ConfigurationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ConfigurationService {
    @Autowired
    private ConfigurationDAO dao;

    public List<Configuration> getAllConfi() throws SQLException, ClassNotFoundException {
        List<Configuration> getListConfi = dao.getAllCf();
        return getListConfi;
    }

    public boolean editConfiguration(int cfId, String cfName, String cfValue) throws SQLException, ClassNotFoundException {

            boolean editCf = dao.updateCf(cfId, cfName, cfValue);
            if (editCf){
                return true;
            }
        return false;
    }

    public boolean addNewConfiguration(String cfName, String cfValue) throws SQLException, ClassNotFoundException {
        boolean checkExistName = dao.checkExistCf(cfName);
        if (!checkExistName){
            boolean addCf = dao.insertNewCf(cfName, cfValue);
            if (addCf){
                return true;
            }
        }
        return false;
    }

    public List<Configuration> getCfById(int cfId) throws SQLException, ClassNotFoundException {
        List<Configuration> cfInfor = dao.getCfById(cfId);
        return cfInfor;

    }
}

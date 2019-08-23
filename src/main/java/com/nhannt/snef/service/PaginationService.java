package com.nhannt.snef.service;

import com.nhannt.snef.model.Store;
import com.nhannt.snef.repository.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PaginationService {
    @Autowired
    private Pagination paDao;

    public List<Store> showAllList(int offset, int noOfRecords) throws SQLException, ClassNotFoundException {
        List<Store> getStore = paDao.getListByPage(offset, noOfRecords);
        return getStore;
    }

    public int countRecords() throws SQLException, ClassNotFoundException {
        int records = paDao.getTotalPage();
        return records;
    }
}

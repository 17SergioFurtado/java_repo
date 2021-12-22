package com.webdevelopment.webcustomertracker.dao;

import com.webdevelopment.webcustomertracker.Data;
import com.webdevelopment.webcustomertracker.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private Data crmData;

    @Override
    public List<Customer> getCustomers() {
        return null;
    }
}

package org.javadev.clubmanagement.service;

import org.javadev.clubmanagement.dao.ProductsDao;
import org.javadev.clubmanagement.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductsDao productDao;

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDao.getProducts();
    }
}

package org.javadev.clubmanagement.controller;

import org.javadev.clubmanagement.dao.ProductsDao;
import org.javadev.clubmanagement.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("/product")
public class ProductController {


    public ProductsDao productsDao;

    @Autowired
    public void setProductsDao(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    @GetMapping ("/list")
    public String listProducts(Model model){

        List<Product> products = productsDao.getProducts();
        System.out.println(products.get(1).getId());
        model.addAttribute("products", products);

        return "view/list";
    }
}

package org.javadev.clubmanagement.controller;

import org.javadev.clubmanagement.model.Product;
import org.javadev.clubmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("/product")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping ("/list")
    public String listProducts(Model model){

        List<Product> products = productService.getProducts();
        System.out.println(products.get(1).getId());
        model.addAttribute("products", products);

        return "view/list";
    }
}

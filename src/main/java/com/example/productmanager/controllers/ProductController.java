package com.example.productmanager.controllers;

import com.example.productmanager.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService ps;

    @GetMapping()
    public String loadProductManager(){
        ps.getAllproducts();
        return "ProductManager";
    }
}

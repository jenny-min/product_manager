package com.example.productmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("categories")
public class CategoryController {
    @GetMapping()
    private String getAllCategories(){
        System.out.println("getAllCategories");
        return  "CategoryManager";
    }
}

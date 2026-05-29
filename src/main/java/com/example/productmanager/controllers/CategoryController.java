package com.example.productmanager.controllers;

import com.example.productmanager.models.Category;
import com.example.productmanager.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService cs;

    @GetMapping()
    private String getAllCategories(Model model){
        model.addAttribute("categories", cs.getAllCategories());
        return  "CategoryManager";
    }

    @GetMapping("/create")
    private String createCategory(Model model){
        model.addAttribute("category", new Category());
        return "FormCreateCategory";
    }

    @PostMapping()
    private String createCategory(@ModelAttribute("category") Category category){
        cs.addCategory(category);
        return "redirect:/categories";
    }
}

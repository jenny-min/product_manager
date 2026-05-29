package com.example.productmanager.controllers;

import com.example.productmanager.models.Category;
import com.example.productmanager.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/delete/{id}")
    private String deleteCategory(@PathVariable Long id){
        cs.deleteCategory(id);
        return "redirect:/categories";
    }

    @GetMapping("/update/{id}")
    private String createCategory(@PathVariable("id") Long id, Model model){
        Optional<Category> categoryOptional = cs.getCategoryById(id);
        categoryOptional.ifPresent(category -> model.addAttribute("updateCategory", category));
        return "FormUpdateCategory";
    }

    @PostMapping("save")
    private String saveUpdateCategory(@ModelAttribute("category") Category category){
        cs.addCategory(category);
        return "redirect:/categories";
    }
}

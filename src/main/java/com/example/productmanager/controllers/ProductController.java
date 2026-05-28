package com.example.productmanager.controllers;

import com.example.productmanager.models.Product;
import com.example.productmanager.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService ps;

    @GetMapping()
    public String loadProductManager(Model model){
        model.addAttribute("products", ps.getAllproducts());
        return "ProductManager";
    }

    @GetMapping("/create")
    public String createProduct(Model model){
        model.addAttribute("product", new Product());
        return "FormCreateProduct";
    }

    @PostMapping()
    public String saveProduct(@ModelAttribute("product") Product product){
        ps.createProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        ps.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, Model model){
        Optional<Product> productOptional = ps.getProductById(id);
        productOptional.ifPresent(updateProduct ->
                model.addAttribute("updateProduct", updateProduct));
        return "FormUpdateProduct";
    }

    @PostMapping("save")
    public String saveUpdateProduct(@ModelAttribute("updateProduct") Product product){
        ps.createProduct(product);
        return "redirect:/products";
    }
}

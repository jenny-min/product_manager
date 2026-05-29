package com.example.productmanager.services;

import com.example.productmanager.models.Category;
import com.example.productmanager.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository cr;

    public List<Category> getAllCategories(){
        return cr.findAll();
    }

    public Category addCategory(Category newCategory){
        return cr.save(newCategory);
    }
}

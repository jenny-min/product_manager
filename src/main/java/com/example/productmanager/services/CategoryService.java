package com.example.productmanager.services;

import com.example.productmanager.models.Category;
import com.example.productmanager.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteCategory(Long id){
        cr.deleteById(id);
    }

    public Optional<Category> getCategoryById(Long id){
        return cr.findById(id);
    }
}

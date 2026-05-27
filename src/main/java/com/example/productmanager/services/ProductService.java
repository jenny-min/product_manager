package com.example.productmanager.services;

import com.example.productmanager.models.Product;
import com.example.productmanager.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository pr;

    public List<Product> getAllproducts(){
        return pr.findAll();
    }
}

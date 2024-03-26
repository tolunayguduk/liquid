package com.liquid.product.service;

import com.liquid.product.entity.CategoryEntity;
import com.liquid.product.entity.ProductEntity;
import com.liquid.product.repository.CategoryRepository;
import com.liquid.product.repository.ProductRepository;
import com.liquid.util.exception.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CategoryEntity> categories(String key) {
        return categoryRepository.findByOwner(key).orElseThrow(Exception.PARAMETER_NOT_FOUND::raise);
    }

    @Override
    public List<ProductEntity> productsByCategoryId(String key, Long categoryId) {
        return productRepository.findByOwnerAndCategoryId(key, categoryId).orElseThrow(Exception.PARAMETER_NOT_FOUND::raise);
    }

    @Override
    public List<ProductEntity> products(String key) {
        return productRepository.findByOwner(key).orElseThrow(Exception.PARAMETER_NOT_FOUND::raise);
    }
}

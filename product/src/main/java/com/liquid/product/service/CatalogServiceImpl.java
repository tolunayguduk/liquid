package com.liquid.product.service;

import com.liquid.product.entity.CategoryEntity;
import com.liquid.product.repository.CategoryRepository;
import com.liquid.util.exception.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> list(String key) {
        return categoryRepository.findByOwner(key).orElseThrow(Exception.PARAMETER_NOT_FOUND::raise);
    }
}

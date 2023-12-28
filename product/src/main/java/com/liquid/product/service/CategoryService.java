package com.liquid.product.service;

import com.liquid.product.entity.CategoryEntity;
import com.liquid.util.exception.CustomException;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> list();
    CategoryEntity find(Long id) throws CustomException;
    List<CategoryEntity> retrieve(Jwt jwt) throws CustomException;
    CategoryEntity create(CategoryEntity entity, Jwt jwt) throws CustomException;
    CategoryEntity update(Long id, CategoryEntity entity, Jwt jwt) throws CustomException;
    void delete(Long id, Jwt jwt) throws CustomException;
}

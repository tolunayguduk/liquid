package com.liquid.product.service;

import com.liquid.product.entity.ProductEntity;
import com.liquid.util.exception.CustomException;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public interface ProductService {
    List<ProductEntity> list();
    ProductEntity find(Long id) throws CustomException;
    List<ProductEntity> retrieve(Jwt jwt) throws CustomException;
    ProductEntity create(ProductEntity entity, Jwt jwt) throws CustomException;
    ProductEntity update(Long id, ProductEntity entity, Jwt jwt) throws CustomException;
    void delete(Long id, Jwt jwt) throws CustomException;
}

package com.liquid.product.service;

import com.liquid.product.entity.CatagoryEntity;
import com.liquid.util.exception.CustomException;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public interface CategoryService {

    List<CatagoryEntity> list();

    CatagoryEntity find(Long id) throws CustomException;

    List<CatagoryEntity> retrieve(Jwt jwt) throws CustomException;

    CatagoryEntity create(CatagoryEntity entity, Jwt jwt) throws CustomException;

    CatagoryEntity update(Long id, CatagoryEntity entity, Jwt jwt) throws CustomException;

    void delete(Long id, Jwt jwt) throws CustomException;

}

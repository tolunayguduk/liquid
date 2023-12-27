package com.liquid.product.service;

import com.liquid.product.entity.CatagoryEntity;
import com.liquid.product.repository.CategoryRepository;
import com.liquid.util.exception.CustomException;
import com.liquid.util.exception.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CatagoryEntity> list() {
        return categoryRepository.findAll();
    }

    @Override
    public CatagoryEntity find(Long id) throws CustomException {
        return categoryRepository.findOneById(id).orElseThrow(()->Exception.PARAMETER_NOT_FOUND.raise());
    }

    @Override
    public List<CatagoryEntity> retrieve(Jwt jwt) throws CustomException {
        return categoryRepository.findByOwner(jwt.getClaimAsString("preferred_username")).orElseThrow(()->Exception.PARAMETER_NOT_FOUND.raise());
    }

    @Override
    public CatagoryEntity create(CatagoryEntity entity, Jwt jwt) throws CustomException {
        entity.setOwner(jwt.getClaimAsString("preferred_username"));
        entity.setStatus(true);
        return categoryRepository.save(entity);
    }

    @Override
    public CatagoryEntity update(Long id, CatagoryEntity entity, Jwt jwt) throws CustomException {
        Optional<CatagoryEntity> category = categoryRepository.findOneById(id);
        if(!category.orElseThrow(()-> Exception.PARAMETER_NOT_FOUND.raise()).getOwner().equals(jwt.getClaimAsString("preferred_username"))){
            throw Exception.PARAMETER_NOT_FOUND.raise();
        }
        category.get().setName(entity.getName());
        return categoryRepository.save(category.get());
    }

    @Override
    public void delete(Long id, Jwt jwt) throws CustomException {
        Optional<CatagoryEntity> category = categoryRepository.findOneById(id);
        if(!category.orElseThrow(()-> Exception.PARAMETER_NOT_FOUND.raise()).getOwner().equals(jwt.getClaimAsString("preferred_username"))){
            throw Exception.PARAMETER_NOT_FOUND.raise();
        }
        categoryRepository.deleteOneById(id);
    }
}

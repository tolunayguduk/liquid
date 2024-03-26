package com.liquid.product.service;

import com.liquid.product.entity.CategoryEntity;
import com.liquid.product.entity.ProductEntity;
import com.liquid.product.repository.CategoryRepository;
import com.liquid.product.repository.ProductRepository;
import com.liquid.util.exception.CustomException;
import com.liquid.util.exception.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CategoryEntity> list() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity find(Long id) throws CustomException {
        return categoryRepository.findOneById(id).orElseThrow(Exception.PARAMETER_NOT_FOUND::raise);
    }

    @Override
    public List<CategoryEntity> retrieve(Jwt jwt) throws CustomException {
        return categoryRepository.findByOwner(jwt.getClaimAsString("preferred_username")).orElseThrow(Exception.PARAMETER_NOT_FOUND::raise);
    }

    @Override
    @Transactional
    public CategoryEntity create(CategoryEntity entity, Jwt jwt) throws CustomException {
        entity.setOwner(jwt.getClaimAsString("preferred_username"));
        return categoryRepository.save(entity);
    }

    @Override
    @Transactional
    public CategoryEntity update(Long id, CategoryEntity entity, Jwt jwt) throws CustomException {
        Optional<CategoryEntity> category = categoryRepository.findOneById(id);
        if(!category.orElseThrow(Exception.PARAMETER_NOT_FOUND::raise).getOwner().equals(jwt.getClaimAsString("preferred_username"))){
            throw Exception.PARAMETER_NOT_FOUND.raise();
        }
        category.get().setName(entity.getName());
        category.get().setStatus(entity.getStatus());
        return categoryRepository.save(category.get());
    }

    @Override
    @Transactional
    public void delete(Long id, Jwt jwt) throws CustomException {
        Optional<CategoryEntity> category = categoryRepository.findOneById(id);
        if(!category.orElseThrow(Exception.PARAMETER_NOT_FOUND::raise).getOwner().equals(jwt.getClaimAsString("preferred_username"))){
            throw Exception.PARAMETER_NOT_FOUND.raise();
        }
        Optional<List<ProductEntity>> products = productRepository.findByCategoryId(category.get().getId());
        if(products.isEmpty()){
            categoryRepository.deleteOneById(id);
        }else{
            throw Exception.PARAMETER_NOT_FOUND.raise();
        }
    }
}

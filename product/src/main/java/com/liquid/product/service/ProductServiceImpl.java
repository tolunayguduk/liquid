package com.liquid.product.service;

import com.liquid.product.entity.ProductEntity;
import com.liquid.product.repository.CategoryRepository;
import com.liquid.product.repository.ProductRepository;
import com.liquid.util.exception.CustomException;
import com.liquid.util.exception.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductEntity> list() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity find(Long id) throws CustomException {
        return productRepository.findOneById(id).orElseThrow(()-> Exception.PARAMETER_NOT_FOUND.raise());
    }

    @Override
    public List<ProductEntity> retrieve(Jwt jwt) throws CustomException {
        return productRepository.findByOwner(jwt.getClaimAsString("preferred_username")).orElseThrow(()->Exception.PARAMETER_NOT_FOUND.raise());
    }

    @Override
    public ProductEntity create(ProductEntity entity, Jwt jwt) throws CustomException {
        entity.getCategory().setOwner(jwt.getClaimAsString("preferred_username"));
        entity.getCategory().setStatus(true);
        entity.setOwner(jwt.getClaimAsString("preferred_username"));
        entity.setStatus(true);
        //entity.setCreatedBy(jwt.getClaimAsString("preferred_username"));
        //entity.setCreateDate(LocalDateTime.now());
        return productRepository.save(entity);
    }

    @Override
    public ProductEntity update(Long id, ProductEntity entity, Jwt jwt) throws CustomException {
        Optional<ProductEntity> product = productRepository.findOneById(id);
        if(!product.orElseThrow(()-> Exception.PARAMETER_NOT_FOUND.raise()).getOwner().equals(jwt.getClaimAsString("preferred_username"))){
            throw Exception.PARAMETER_NOT_FOUND.raise();
        }
        product.get().setName(entity.getName());
        product.get().setCategory(categoryRepository.findOneById(entity.getCategoryId()).orElseThrow(()-> Exception.PARAMETER_NOT_FOUND.raise()));
        product.get().setPrice(entity.getPrice());
        product.get().setImageLink(entity.getImageLink());
        product.get().setStatus(true);
        //product.get().setUpdatedBy(jwt.getClaimAsString("preferred_username"));
        //product.get().setUpdateDate(LocalDateTime.now());
        return productRepository.save(product.get());
    }

    @Override
    public void delete(Long id, Jwt jwt) throws CustomException {
        Optional<ProductEntity> product = productRepository.findOneById(id);
        if(!product.orElseThrow(()-> Exception.PARAMETER_NOT_FOUND.raise()).getOwner().equals(jwt.getClaimAsString("preferred_username"))){
            throw Exception.PARAMETER_NOT_FOUND.raise();
        }
        productRepository.deleteOneById(id);
    }
}

package com.liquid.product.service;

import com.liquid.product.entity.CategoryEntity;
import com.liquid.product.entity.ProductEntity;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<ProductEntity> list() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity find(Long id) throws CustomException {
        return productRepository.findOneById(id).orElseThrow(Exception.PARAMETER_NOT_FOUND::raise);
    }

    @Override
    public List<ProductEntity> retrieve(Jwt jwt) throws CustomException {
        return productRepository.findByOwner(jwt.getClaimAsString("preferred_username")).orElseThrow(Exception.PARAMETER_NOT_FOUND::raise);
    }

    @Override
    @Transactional
    public ProductEntity create(ProductEntity entity, Jwt jwt) throws CustomException {
        if (entity.getCategory() == null){
            CategoryEntity category = categoryService.find(entity.getCategoryId());
            entity.setCategory(category);
        }else{
            //TODO:CHILD ID COuLDNT SAVE
            entity.getCategory().setOwner(jwt.getClaimAsString("preferred_username"));
        }
        entity.setOwner(jwt.getClaimAsString("preferred_username"));
        return productRepository.save(entity);
    }

    @Override
    @Transactional
    public ProductEntity update(Long id, ProductEntity entity, Jwt jwt) throws CustomException {
        Optional<ProductEntity> product = productRepository.findOneById(id);
        if(!product.orElseThrow(Exception.PARAMETER_NOT_FOUND::raise).getOwner().equals(jwt.getClaimAsString("preferred_username"))){
            throw Exception.PARAMETER_NOT_FOUND.raise();
        }
        product.get().setName(entity.getName());
        product.get().setCategoryId(entity.getCategoryId());
        product.get().setPrice(entity.getPrice());
        product.get().setImageLink(entity.getImageLink());
        return productRepository.save(product.get());
    }

    @Override
    @Transactional
    public void delete(Long id, Jwt jwt) throws CustomException {
        Optional<ProductEntity> product = productRepository.findOneById(id);
        if(!product.orElseThrow(Exception.PARAMETER_NOT_FOUND::raise).getOwner().equals(jwt.getClaimAsString("preferred_username"))){
            throw Exception.PARAMETER_NOT_FOUND.raise();
        }
        productRepository.deleteOneById(id);
    }
}

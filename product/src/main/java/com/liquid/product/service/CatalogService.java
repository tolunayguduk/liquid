package com.liquid.product.service;

import com.liquid.product.entity.CategoryEntity;
import com.liquid.product.entity.ProductEntity;

import java.util.List;

public interface CatalogService {

    List<CategoryEntity> categories(String key);

    List<ProductEntity> productsByCategoryId(String key, Long categoryId);

    List<ProductEntity> products(String key);
}

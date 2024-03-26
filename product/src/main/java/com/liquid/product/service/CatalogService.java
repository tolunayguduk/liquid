package com.liquid.product.service;

import com.liquid.product.entity.CategoryEntity;

import java.util.List;

public interface CatalogService {

    List<CategoryEntity> list(String key);
}

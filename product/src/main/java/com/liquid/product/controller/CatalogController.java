package com.liquid.product.controller;

import com.liquid.product.entity.CategoryEntity;
import com.liquid.product.entity.ProductEntity;
import com.liquid.product.mapper.CatalogMapper;
import com.liquid.product.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {


    @Autowired
    private CatalogService catalogService;

    @Autowired
    private CatalogMapper catalogMapper;

    @GetMapping("/{key}/categories")
    public ResponseEntity<?> retreveCategories(@PathVariable("key") String key) {
        List<CategoryEntity> entities = catalogService.categories(key);
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/{key}/products/{categoryId}")
    public ResponseEntity<?> retreveProductsByCategoryId(@PathVariable("key") String key, @PathVariable("categoryId") Long categoryId) {
        List<ProductEntity> entities = catalogService.productsByCategoryId(key, categoryId);
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/{key}/products")
    public ResponseEntity<?> retreveProducts(@PathVariable("key") String key) {
        List<ProductEntity> entities = catalogService.products(key);
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}

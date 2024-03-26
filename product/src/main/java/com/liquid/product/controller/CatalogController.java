package com.liquid.product.controller;

import com.liquid.product.entity.CategoryEntity;
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

    @GetMapping("/{key}")
    public ResponseEntity<?> retreve(@PathVariable("key") String key) {
        List<CategoryEntity> entities = catalogService.list(key);
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}

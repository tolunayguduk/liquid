package com.liquid.product.controller;

import com.liquid.product.dto.ProductDto;
import com.liquid.product.entity.ProductEntity;
import com.liquid.product.mapper.ProductMapper;
import com.liquid.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/retrieve")
    public ResponseEntity<?> retreve(@AuthenticationPrincipal Jwt jwt) {
        List<ProductEntity> entities = productService.retrieve(jwt);
        return new ResponseEntity<>(productMapper.toDto(entities), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductDto dto, @AuthenticationPrincipal Jwt jwt) {
        ProductEntity entity = productService.create(productMapper.toEntity(dto), jwt);
        return new ResponseEntity<>(productMapper.toDto(entity), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProductDto dto, @AuthenticationPrincipal Jwt jwt) {
        ProductEntity entity = productService.update(id, productMapper.toEntity(dto), jwt);
        return new ResponseEntity<>(productMapper.toDto(entity), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id, @AuthenticationPrincipal Jwt jwt) {
        productService.delete(id, jwt);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

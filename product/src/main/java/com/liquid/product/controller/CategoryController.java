package com.liquid.product.controller;

import com.liquid.product.dto.CatagoryDto;
import com.liquid.product.entity.CatagoryEntity;
import com.liquid.product.mapper.CategoryMapper;
import com.liquid.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catagory")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryMapper categoryMapper;

	@GetMapping("/retrieve")
	public ResponseEntity<?> retreve(@AuthenticationPrincipal Jwt jwt) {
		List<CatagoryEntity> entities = categoryService.retrieve(jwt);
		return new ResponseEntity<>(categoryMapper.toDto(entities), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CatagoryDto dto, @AuthenticationPrincipal Jwt jwt) {
		CatagoryEntity entity = categoryService.create(categoryMapper.toEntity(dto), jwt);
		return new ResponseEntity<>(categoryMapper.toDto(entity), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody CatagoryDto dto, @AuthenticationPrincipal Jwt jwt) {
		CatagoryEntity entity = categoryService.update(id, categoryMapper.toEntity(dto), jwt);
		return new ResponseEntity<>(categoryMapper.toDto(entity), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id, @AuthenticationPrincipal Jwt jwt) {
		categoryService.delete(id, jwt);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

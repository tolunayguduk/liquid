package com.liquid.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private Long categoryId;
    private CategoryDto category;
    private String price;
    private String imageLink;
    private String owner;
    private Boolean status;
}

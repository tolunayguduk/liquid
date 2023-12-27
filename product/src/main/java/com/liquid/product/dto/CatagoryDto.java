package com.liquid.product.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatagoryDto {

    private Long id;
    private String name;
    private String owner;
    private Boolean status;
}

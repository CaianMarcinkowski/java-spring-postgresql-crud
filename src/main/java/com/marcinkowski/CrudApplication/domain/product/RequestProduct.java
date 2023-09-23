package com.marcinkowski.CrudApplication.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduct(
        Integer id,
        @NotBlank
        String name,
        @NotNull
        Integer price) {

}

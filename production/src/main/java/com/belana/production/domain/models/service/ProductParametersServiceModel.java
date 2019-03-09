package com.belana.production.domain.models.service;

import com.belana.production.domain.entities.product.ProductParameters;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductParametersServiceModel {

    private ProductParameters id;
    private int plays;
    private Double format;

}

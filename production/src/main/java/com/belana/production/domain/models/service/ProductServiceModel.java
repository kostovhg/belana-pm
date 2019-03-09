package com.belana.production.domain.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductServiceModel {

    private String id;
    private ProductPropertiesServiceModel productProperties;
    private ProductParametersServiceModel productParameters;
    private Double core;
    private Double diameter;
    private BigDecimal price;

}

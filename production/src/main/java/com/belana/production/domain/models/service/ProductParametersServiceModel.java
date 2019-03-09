package com.belana.production.domain.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductParametersServiceModel {

    private int format;
    private int diameter;
    private int core;
    private int plays;
    private double weight;
    private BigDecimal price;

}

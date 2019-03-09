package com.belana.production.domain.models.binding;

import com.belana.production.domain.entities.enums.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class ProductCreateBindingModel {

    private ProductType type;
    private int baseWeight;
    private int elongation;
    private int format;
    private int diameter;
    private int core;
    private int plays;
    private double weight;
    private BigDecimal price;
}

package com.belana.production.domain.models.binding;

import com.belana.production.domain.entities.enums.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class ProductRegisterBindingModel {

    private ProductType type;
    private int baseWeight;
    private int elongation;
    private int plays;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Double format;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Double diameter;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Double core;
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal price;
}

package com.belana.production.domain.models.service;

import com.belana.production.domain.entities.base.PropertiesKey;
import com.belana.production.domain.entities.base.UUIDStringEntity;
import com.belana.production.domain.entities.enums.ProductType;
import com.belana.production.domain.entities.product.ProductProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class ProductPropertiesServiceModel {

    private PropertiesKey id;
    private ProductType type;
    private int baseWeight;
    private int elongation;

}

package com.belana.production.domain.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductServiceModel {

    private String id;
    private ProductPropertiesServiceModel productProperties;
    private ProductParametersServiceModel productParameters;

}

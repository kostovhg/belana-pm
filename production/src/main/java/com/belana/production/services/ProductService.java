package com.belana.production.services;

import com.belana.production.domain.models.service.ProductServiceModel;

import java.util.List;

public interface ProductService {
    List<ProductServiceModel> findAll();

    ProductServiceModel register(ProductServiceModel product);
}

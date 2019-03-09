package com.belana.production.domain.models.service;

import com.belana.production.domain.entities.enums.OrderType;
import com.belana.production.domain.entities.orders.Client;
import com.belana.production.domain.entities.product.Product;

import java.util.List;

public class OrderServiceModel {

    private ClientServiceModel client;
    private List<ProductServiceModel> products;
    private OrderType orderType;
    private int orderAmount;
}

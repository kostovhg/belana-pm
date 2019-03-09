package com.belana.production.domain.models.binding;

import com.belana.production.domain.entities.enums.OrderType;
import com.belana.production.domain.entities.orders.Client;
import com.belana.production.domain.entities.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderCreateBindingModel {

    private Client client;
    private List<Product> products;
    private OrderType orderType;
    private int orderAmount;
}

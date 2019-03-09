package com.belana.production.domain.entities.orders;

import com.belana.production.domain.entities.base.TemporalEntity;
import com.belana.production.domain.entities.enums.OrderType;
import com.belana.production.domain.entities.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Orders would be
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_orders")
public class ProductOrder extends TemporalEntity {

    /*
    ToConsider: id to be composite between client id and temporal id:
    0001 02-03-2019 14:40
     */
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns(
            {@JoinColumn(name = "product_date", referencedColumnName = "date"),
                    @JoinColumn(name = "product_time", referencedColumnName = "time")
            })
    private List<Product> products;

    @Enumerated(EnumType.STRING)
    @Column(name = "oder_type", columnDefinition = "VARCHAR(10) default 'WEIGHT'")
    private OrderType orderType;

    @Column(name = "order_amount", nullable = false)
    private int orderAmount;

}

package com.belana.production.domain.entities.product;

import com.belana.production.domain.entities.base.TemporalEntity;
import com.belana.production.domain.entities.base.UUIDStringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Standardized parameters of products or goal parameters for production
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_parameters")
public class ProductParameters extends UUIDStringEntity {

    @Column(name = "format", nullable = false, columnDefinition = "smallint default '270'")
    private int format;

    @Column(name = "diameter", nullable = false, columnDefinition = "smallint default '270'")
    private int diameter;

    @Column(name = "core", nullable = false, columnDefinition = "smallint default '270'")
    private int core;

    @Column(name = "plays", nullable = false, columnDefinition = "smallint default '270'")
    private int plays;

    @Column(name = "weight", nullable = false, columnDefinition = "smallint default '270'")
    private double weight;

    @Column(name = "price", columnDefinition = "DECIMAL(10,2) default '0.0'")
    private BigDecimal price;
}

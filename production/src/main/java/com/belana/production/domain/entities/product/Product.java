package com.belana.production.domain.entities.product;

import com.belana.production.domain.entities.base.UUIDStringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Product as would be described as standardized order
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "products")
public class Product extends UUIDStringEntity {

    /*
    ToConsider: id to be composite of properties and parameters. The products are finite count, and in current implementation there will be duplicates.
     */

    @ManyToOne
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns(
            {
                    @JoinColumn(name = "product_product_type", referencedColumnName = "product_type"),
                    @JoinColumn(name = "product_base_weight", referencedColumnName = "base_weight"),
                    @JoinColumn(name = "product_elongation", referencedColumnName = "elongation")
            })
    private ProductProperties productProperties;

    @ManyToOne
    @JoinColumns(
            {
                    @JoinColumn(name = "product_parameter_play", referencedColumnName = "plays"),
                    @JoinColumn(name = "product_parameter_format", referencedColumnName = "format")
            }
    )
    private ProductParameters productParameters;

    /**
     * Ready roll diameter in meters
     */
    @Column(name = "diameter", columnDefinition = "DECIMAL(5,3) default '1.6'")
    private Double diameter;

    /**
     * Core outer diameter in meters
     */
    @Column(name = "core", columnDefinition = "DECIMAL(5,3) default '0.096'")
    private Double core;

    @Column(name = "price", columnDefinition = "DECIMAL(19,3) default '0.0'")
    private BigDecimal price;

}

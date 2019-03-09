package com.belana.production.domain.entities.product;

import com.belana.production.domain.entities.base.UUIDStringEntity;
import com.belana.production.domain.entities.enums.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Standard parameters goals according the production orders
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_properties")
public class ProductProperties extends UUIDStringEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "type")
    private ProductType type;

    @Column(name = "base_weight", nullable = false, columnDefinition = "TINYINT default '15'")
    private int baseWeight;

    @Column(name = "elongation", nullable = false, columnDefinition = "TINYINT default '10'")
    private int elongation;

//    @Column(name = "moisture", columnDefinition = "TINYINT default '4'")
//    private int moisture;

}

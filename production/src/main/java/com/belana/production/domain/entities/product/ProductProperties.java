package com.belana.production.domain.entities.product;

import com.belana.production.domain.entities.base.PropertiesKey;
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
public class ProductProperties {

    @EmbeddedId
    private PropertiesKey id;

//    @Column(name = "moisture", columnDefinition = "TINYINT default '4'")
//    private int moisture;

}

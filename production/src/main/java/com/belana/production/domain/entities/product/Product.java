package com.belana.production.domain.entities.product;

import com.belana.production.domain.entities.base.UUIDStringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Product as would be described as standardized order
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "products")
public class Product extends UUIDStringEntity {

    @ManyToOne
    @JoinColumn(name="properties_id")
    private ProductProperties productProperties;

    @ManyToOne
    @JoinColumn(name="parameters_id")
    private ProductParameters productParameters;

}

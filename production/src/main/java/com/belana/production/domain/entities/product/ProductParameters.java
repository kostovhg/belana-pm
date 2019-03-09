package com.belana.production.domain.entities.product;

import com.belana.production.domain.entities.base.TemporalEntity;
import com.belana.production.domain.entities.base.UUIDStringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

import static com.belana.production.utils.Constants.*;

/**
 * Standardized parameters of products or goal parameters for production
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_parameters")
@IdClass(ProductParameters.class)
public class ProductParameters implements Serializable {

    /*
    ToConsider: this is also finite entity
     */
    @Id
    @Column(name = "plays", columnDefinition = "smallint default '2'")
    private int plays;

    @Id
    @Column(name = "format", columnDefinition = "DECIMAL(3,2) DEFAULT '2.74'")
    private Double format;


}

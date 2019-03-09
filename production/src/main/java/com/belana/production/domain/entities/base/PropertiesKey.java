package com.belana.production.domain.entities.base;

import com.belana.production.domain.entities.enums.ProductType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PropertiesKey implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "product_type")
    private ProductType type;

    @Column(name = "base_weight", nullable = false, columnDefinition = "TINYINT default '15'")
    private int baseWeight;

    @Column(name = "elongation", nullable = false, columnDefinition = "TINYINT default '10'")
    private int elongation;


    public ProductType getType() {
        return this.type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public int getBaseWeight() {
        return this.baseWeight;
    }

    public void setBaseWeight(int baseWeight) {
        this.baseWeight = baseWeight;
    }

    public int getElongation() {
        return this.elongation;
    }

    public void setElongation(int elongation) {
        this.elongation = elongation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemporalEntity)) return false;
        PropertiesKey that = (PropertiesKey) o;
        return Objects.equals(this.getType(), that.getType()) &&
                this.getBaseWeight() == that.getBaseWeight() &&
                this.getElongation() == that.getElongation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getBaseWeight(), getElongation());
    }


}

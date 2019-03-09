package com.belana.production.repositories;

import com.belana.production.domain.entities.product.ProductProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPropertiesRepository extends JpaRepository<ProductProperties, String> {
}

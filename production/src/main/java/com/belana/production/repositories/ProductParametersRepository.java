package com.belana.production.repositories;

import com.belana.production.domain.entities.product.ProductParameters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductParametersRepository extends GenericRepository<ProductParameters, String> {
}

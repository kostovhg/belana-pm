package com.belana.production.repositories;

import com.belana.production.domain.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends GenericRepository<Product, String> {
}

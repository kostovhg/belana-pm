package com.belana.production.repositories;

import com.belana.production.domain.entities.orders.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}

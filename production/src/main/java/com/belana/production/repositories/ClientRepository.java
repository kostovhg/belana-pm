package com.belana.production.repositories;

import com.belana.production.domain.entities.orders.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {

    /**
     * Find client by name
     * @param keyword -
     * @return -
     */
    @Query("SELECT name FROM Client c WHERE c.name LIKE %:keyword%")
    List<String> search(@Param("keyword") String keyword);
}

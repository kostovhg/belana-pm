package com.belana.production.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface GenericRepository<Entity, ID> extends JpaRepository<Entity, ID> {

    @Query("SELECT p FROM Product p WHERE :param like %:keyword%")
    List<Entity> search(@Param("param")String param, @Param("keyword")String keyword);

}

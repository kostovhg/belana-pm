package com.belana.production.domain.entities.orders;

import com.belana.production.domain.entities.base.UUIDStringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clients", schema = "belana_clients_db")
public class Client extends UUIDStringEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "comment")
    private String comment;
}

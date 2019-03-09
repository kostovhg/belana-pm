package com.belana.production.domain.models.service;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientServiceModel {

    private String id;
    private String name;
    private String address;
    private String comment;
}
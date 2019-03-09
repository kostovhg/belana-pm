package com.belana.production.services;

import com.belana.production.domain.models.service.ClientServiceModel;

import java.util.List;

public interface ClientService {
    ClientServiceModel register(ClientServiceModel client);

    List<ClientServiceModel> findAll();

    List<String> search(String keyword);
}

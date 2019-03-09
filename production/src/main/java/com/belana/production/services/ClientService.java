package com.belana.production.services;

import com.belana.production.domain.entities.orders.Client;
import com.belana.production.domain.models.service.ClientServiceModel;
import com.belana.production.domain.models.view.ClientListViewModel;
import com.belana.production.repositories.ClientRepository;
import com.belana.production.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private MapperUtil mapper;
    private ClientRepository clientRepository;

    @Autowired
    public ClientService(MapperUtil mapper, ClientRepository clientRepository) {
        this.mapper = mapper;
        this.clientRepository = clientRepository;
    }

    public ClientServiceModel register(ClientServiceModel client) {
        try {
            this.clientRepository.saveAndFlush(this.mapper.map(client, Client.class));
            return client;
        } catch (Exception e) {
            throw new IllegalArgumentException("Client cant be created.");
        }
    }

    public List<ClientServiceModel> findAll() {
        return this.mapper.map(this.clientRepository.findAll(), ClientServiceModel.class);
    }
}

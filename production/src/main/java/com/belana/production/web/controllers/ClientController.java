package com.belana.production.web.controllers;

import com.belana.production.domain.models.binding.ClientRegisterBindingModel;
import com.belana.production.domain.models.service.ClientServiceModel;
import com.belana.production.services.ClientService;
import com.belana.production.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

    private final MapperUtil mapper;
    private final ClientService clientService;

    @Autowired
    public ClientController(MapperUtil mapper, ClientService clientService){
        this.mapper = mapper;
        this.clientService = clientService;
    }

    @GetMapping("/register-client")
    public ModelAndView getRegisterClient(ModelAndView modelAndView) {
        modelAndView.setViewName("register-client");
        return modelAndView;
    }

    @PostMapping("/register-client")
    public ModelAndView postRegisterClient(@ModelAttribute ClientRegisterBindingModel model, ModelAndView modelAndView) {

        ClientServiceModel clientModel = this.clientService.register(this.mapper.map(model, ClientServiceModel.class));
        modelAndView.setViewName("register-client");
        return modelAndView;
    }
}

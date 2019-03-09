package com.belana.production.web.controllers;

import com.belana.production.domain.entities.orders.Client;
import com.belana.production.domain.models.binding.ClientRegisterBindingModel;
import com.belana.production.domain.models.service.ClientServiceModel;
import com.belana.production.services.ClientServiceImpl;
import com.belana.production.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ClientController {

    private final MapperUtil mapper;
    private final ClientServiceImpl clientService;

    @Autowired
    public ClientController(MapperUtil mapper, ClientServiceImpl clientService){
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

    @GetMapping("/client/search")
    @ResponseBody
    public List<String> search(HttpServletRequest request){
        List<String> clients = this.clientService.search(request.getParameter("term"));
        return this.clientService.search(request.getParameter("term"));
    }
}

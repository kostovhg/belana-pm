package com.belana.production.web.controllers;

import com.belana.production.domain.models.binding.OrderCreateBindingModel;
import com.belana.production.domain.models.view.ClientListViewModel;
import com.belana.production.domain.models.view.ProductListViewModel;
import com.belana.production.services.ClientService;
import com.belana.production.services.ProductService;
import com.belana.production.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RegisterOrderController {

    private MapperUtil mapper;
    private ClientService clientService;
    private ProductService productsService;

    @Autowired
    public RegisterOrderController(MapperUtil mapper, ClientService clientService, ProductService productsService) {
        this.mapper = mapper;
        this.clientService = clientService;
        this.productsService = productsService;
    }

    @GetMapping("/register-order")
    public ModelAndView getRegisterOrder(ModelAndView modelAndView) {
        List<ClientListViewModel> clientsList = this.mapper.map(this.clientService.findAll(), ClientListViewModel.class);
        List<ProductListViewModel> productsList = this.mapper.map(this.productsService.findAll(), ProductListViewModel.class);
        modelAndView.setViewName("register-order");
        modelAndView.addObject("clients", clientsList);
        modelAndView.addObject("products", productsList);

        return modelAndView;
    }

    @PostMapping("/register-order")
    public ModelAndView postRegisterOrder(@ModelAttribute OrderCreateBindingModel model, ModelAndView modelAndView){

        modelAndView.setViewName("register-order");

        return modelAndView;
    }
}

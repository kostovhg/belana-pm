package com.belana.production.web.controllers;

import com.belana.production.domain.entities.product.ProductProperties;
import com.belana.production.domain.models.binding.OrderCreateBindingModel;
import com.belana.production.domain.models.binding.ProductCreateBindingModel;
import com.belana.production.domain.models.service.ProductParametersServiceModel;
import com.belana.production.domain.models.service.ProductPropertiesServiceModel;
import com.belana.production.domain.models.service.ProductServiceModel;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterProductController {

    private MapperUtil mapper;
    private ClientService clientService;
    private ProductService productsService;

    @Autowired
    public RegisterProductController(MapperUtil mapper, ClientService clientService, ProductService productsService) {
        this.mapper = mapper;
        this.clientService = clientService;
        this.productsService = productsService;
    }

    @GetMapping("/register-product")
    public ModelAndView getRegisterProduct(ModelAndView modelAndView) {

        modelAndView.setViewName("register-product");
        modelAndView.addObject("weights", new ArrayList<>());
        modelAndView.addObject("elongations", new ArrayList<>());

        return modelAndView;
    }

    @PostMapping("/register-product")
    public ModelAndView postRegisterOrder(@ModelAttribute ProductCreateBindingModel model, ModelAndView modelAndView){

        ProductPropertiesServiceModel productProperties = new ProductPropertiesServiceModel();
        productProperties.setType(model.getType());
        productProperties.setElongation(model.getElongation());
        productProperties.setBaseWeight(model.getBaseWeight());
        ProductParametersServiceModel productParameters = this.mapper.map(model, ProductParametersServiceModel.class);

        ProductServiceModel product = new ProductServiceModel();
        product.setProductParameters(productParameters);
        product.setProductProperties(productProperties);

        this.productsService.register(product);
        modelAndView.setViewName("register-product");

        return modelAndView;
    }
}

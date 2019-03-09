package com.belana.production.web.controllers;

import com.belana.production.domain.models.binding.ProductRegisterBindingModel;
import com.belana.production.domain.models.service.ProductServiceModel;
import com.belana.production.services.ProductServiceImpl;
import com.belana.production.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class RegisterProductController {

    private MapperUtil mapper;
    private ProductServiceImpl productsService;

    @Autowired
    public RegisterProductController(MapperUtil mapper, ProductServiceImpl productsService) {
        this.mapper = mapper;
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
    public ModelAndView postRegisterOrder(@ModelAttribute ProductRegisterBindingModel model, ModelAndView modelAndView){

//        ProductPropertiesServiceModel productProperties = this.mapper.map(model, ProductPropertiesServiceModel.class);
//        ProductParametersServiceModel productParameters = this.mapper.map(model, ProductParametersServiceModel.class);
//
//        ProductServiceModel product = new ProductServiceModel();
//        product.setProductParameters(productParameters);
//        product.setProductProperties(productProperties);


        ProductServiceModel serviceModel = this.mapper.map(model, ProductServiceModel.class);
        this.productsService.register(serviceModel);
        modelAndView.setViewName("register-product");

        return modelAndView;
    }
}

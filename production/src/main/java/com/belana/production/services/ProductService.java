package com.belana.production.services;

import com.belana.production.domain.entities.product.Product;
import com.belana.production.domain.entities.product.ProductParameters;
import com.belana.production.domain.entities.product.ProductProperties;
import com.belana.production.domain.models.service.ProductServiceModel;
import com.belana.production.repositories.ProductParametersRepository;
import com.belana.production.repositories.ProductPropertiesRepository;
import com.belana.production.repositories.ProductRepository;
import com.belana.production.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductPropertiesRepository productPropertiesRepository;
    private ProductParametersRepository productParametersRepository;
    private MapperUtil mapper;


    @Autowired
    public ProductService(ProductRepository productRepository, ProductPropertiesRepository productPropertiesRepository, ProductParametersRepository productParametersRepository, MapperUtil mapper) {
        this.productRepository = productRepository;
        this.productPropertiesRepository = productPropertiesRepository;
        this.productParametersRepository = productParametersRepository;
        this.mapper = mapper;
    }

    @PostConstruct
    private void init() {


//        PropertyMap<ProductCreateBindingModel, ProductServiceModel> productBindingToServiceModel = new PropertyMap<>() {
//            @Override
//            protected void configure() {
//                ProductPropertiesServiceModel properties = new ProductPropertiesServiceModel();
//                ProductParametersServiceModel parameters = new ProductParametersServiceModel();
//                properties.setType(source.getType());
//                properties.setBaseWeight(source.getBaseWeight());
//                properties.setElongation(source.getElongation());
//                parameters.setFormat(source.getFormat());
//                parameters.setDiameter(source.getDiameter());
//                parameters.setCore(source.getCore());
//                parameters.setPlays(source.getPlays());
//                parameters.setWeight(source.getWeight());
//                parameters.setPlays(source.getPlays());
//
//                map().setProductParameters(parameters);
//                map().setProductProperties(properties);
//            }
//        };
//
//        this.mapper.addMappings(productBindingToServiceModel);

    }

    public List<ProductServiceModel> findAll() {

        return this.mapper.map(this.productRepository.findAll(), ProductServiceModel.class);
    }

    public ProductServiceModel register(ProductServiceModel product) {

        ProductProperties properties = this.productPropertiesRepository.saveAndFlush(this.mapper.map(product.getProductProperties(), ProductProperties.class));
        ProductParameters parameters = this.productParametersRepository.saveAndFlush(this.mapper.map(product.getProductParameters(), ProductParameters.class));

        Product p = new Product();
        p.setProductParameters(parameters);
        p.setProductProperties(properties);
        Product existingProduct = this.productRepository.saveAndFlush(p);
        return this.mapper.map(existingProduct, ProductServiceModel.class);
    }
}

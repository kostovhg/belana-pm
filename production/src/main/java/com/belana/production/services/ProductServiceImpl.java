package com.belana.production.services;

import com.belana.production.domain.entities.base.PropertiesKey;
import com.belana.production.domain.entities.product.Product;
import com.belana.production.domain.entities.product.ProductParameters;
import com.belana.production.domain.entities.product.ProductProperties;
import com.belana.production.domain.models.service.ProductServiceModel;
import com.belana.production.repositories.ProductParametersRepository;
import com.belana.production.repositories.ProductPropertiesRepository;
import com.belana.production.repositories.ProductRepository;
import com.belana.production.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private ProductPropertiesRepository productPropertiesRepository;
    private ProductParametersRepository productParametersRepository;
    private MapperUtil mapper;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductPropertiesRepository productPropertiesRepository, ProductParametersRepository productParametersRepository, MapperUtil mapper) {
        this.productRepository = productRepository;
        this.productPropertiesRepository = productPropertiesRepository;
        this.productParametersRepository = productParametersRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductServiceModel> findAll() {

        return this.mapper.map(this.productRepository.findAll(), ProductServiceModel.class);
    }

    @Override
    public ProductServiceModel register(ProductServiceModel product) {

        PropertiesKey propertiesKey = new PropertiesKey();
        propertiesKey.setType(product.getProductProperties().getType());
        propertiesKey.setBaseWeight(product.getProductProperties().getBaseWeight());
        propertiesKey.setElongation(product.getProductProperties().getElongation());
        ProductProperties properties = this.productPropertiesRepository.findById(propertiesKey).orElse(null);
        if (properties == null) {
            ProductProperties apRoperties = this.mapper.map(product.getProductProperties(), ProductProperties.class);
            properties = new ProductProperties();
            properties.setId(propertiesKey);
            properties = this.productPropertiesRepository.saveAndFlush(properties);
        }
        ProductParameters parameters = this.mapper.map(product, ProductParameters.class);
        Example<ProductParameters> exampleParameters = Example.of(parameters);
        ProductParameters existingParameters = this.productParametersRepository.findOne(exampleParameters).orElse(null);
        if ( existingParameters == null){
            parameters.setFormat(product.getProductParameters().getFormat());
            parameters.setPlays(product.getProductParameters().getPlays());
            existingParameters = this.productParametersRepository.saveAndFlush(parameters);
        } else {
            parameters = existingParameters;
        }

        Product p = new Product();
        p.setProductParameters(parameters);
        p.setProductProperties(properties);
        p.setDiameter(product.getDiameter());
        p.setCore(product.getCore());
        p.setPrice(product.getPrice());
        Product existingProduct = this.productRepository.saveAndFlush(p);
        return this.mapper.map(existingProduct, ProductServiceModel.class);
    }
}

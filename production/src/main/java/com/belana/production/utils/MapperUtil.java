package com.belana.production.utils;

import com.belana.production.domain.entities.product.ProductParameters;
import com.belana.production.domain.entities.product.ProductProperties;
import com.belana.production.domain.models.binding.ProductRegisterBindingModel;
import com.belana.production.domain.models.service.ProductParametersServiceModel;
import com.belana.production.domain.models.service.ProductPropertiesServiceModel;
import com.belana.production.domain.models.service.ProductServiceModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

import java.util.List;
import java.util.stream.Collectors;


public class MapperUtil {

    private ModelMapper mapper;

    public MapperUtil() {
        mapper = new ModelMapper();
        mapProduct();
    }

    public <S, D> D map(S source, Class<D> destinationClass) {
        return this.mapper.map(source, destinationClass);
    }

    public <S, D> List<D> map(List<S> sourceList, Class<D> destinationClass){
        return sourceList.stream()
                .map(s -> this.mapper.map(s, destinationClass)).collect(Collectors.toList());
    }

    private void mapProduct(){

//        Pattern pattern = Pattern.compile(PRODUCT_PROPERTIES_NAME_PATTERN);
//        PropertyMap<ProductServiceModel, ProductListViewModel> mapProductToString = new PropertyMap<>() {
//            @Override
//            protected void configure() {
//                map().setName(String
//                        .format("%dg %d%%",
//                                source.getProductProperties().getBaseWeight(),
//                                source.getProductProperties().getElongation()));
//                map(source.getId(), destination.getId());
//            }
//        };
//
//        this.mapper.addMappings(mapProductToString);
//
//        PropertyMap<ProductListViewModel, ProductServiceModel> mapStringToProduct = new PropertyMap<>() {
//            @Override
//            protected void configure() {
//                ProductPropertiesServiceModel properties = new ProductPropertiesServiceModel();
//                Matcher matcher = pattern.matcher(source.getName());
//                properties.setBaseWeight(Integer.valueOf(matcher.group(1)));
//                properties.setElongation(Integer.valueOf(matcher.group(2)));
//                map().setProductProperties(properties);
//            }
//        };
//
//        this.mapper.addMappings(mapStringToProduct);

        TypeMap<ProductRegisterBindingModel, ProductServiceModel>  productRegisterToServiceModel = mapper.createTypeMap(ProductRegisterBindingModel.class, ProductServiceModel.class)
                .addMappings(new PropertyMap<ProductRegisterBindingModel, ProductServiceModel>() {
                    @Override
                    protected void configure() {
                        map().getProductProperties().setType(this.source.getType());
                        map().getProductProperties().setBaseWeight(this.source.getBaseWeight());
                        map().getProductProperties().setElongation(this.source.getElongation());
                        map().getProductParameters().setFormat(this.source.getFormat());
                        map().getProductParameters().setPlays(this.source.getPlays());
                        map().setDiameter(this.source.getDiameter());
                        map().setCore(this.source.getCore());
                        map().setPrice(this.source.getPrice());
                    }
                });

    }

    public void addMappings(PropertyMap mappings) {
        this.mapper.addMappings(mappings);
    }
}

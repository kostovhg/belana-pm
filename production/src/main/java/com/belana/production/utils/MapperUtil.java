package com.belana.production.utils;

import com.belana.production.domain.models.service.ProductPropertiesServiceModel;
import com.belana.production.domain.models.service.ProductServiceModel;
import com.belana.production.domain.models.view.ProductListViewModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.belana.production.utils.Constants.PRODUCT_PROPERTIES_NAME_PATTERN;


public class MapperUtil {

    private ModelMapper mapper;

    public MapperUtil() {
        mapper = new ModelMapper();
//        mapProduct();
    }

    public <S, D> D map(S source, Class<D> destinationClass) {
        return this.mapper.map(source, destinationClass);
    }

    public <S, D> List<D> map(List<S> sourceList, Class<D> destinationClass){
        return sourceList.stream()
                .map(s -> this.mapper.map(s, destinationClass)).collect(Collectors.toList());
    }

//    private void mapProduct(){
//
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
//
//    }
//
    public void addMappings(PropertyMap mappings) {
        this.mapper.addMappings(mappings);
    }
}

package com.belana.production.conf;

import com.belana.production.utils.MapperUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeanConf {

    @Bean
    public MapperUtil mapper() {
        return new MapperUtil();
    }

}

package com.intr.basic.Config;

import com.intr.basic.serialization.converter.YamlJackson2HttpMesageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("applicaiton/x-yaml");

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {



        //Query Param http://localhost:8081/hardware?mediaType=xml
//        configurer.favorParameter(true).parameterName("mediaType")
//                .ignoreAcceptHeader(true)
//                .useRegisteredExtensionsOnly(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json",MediaType.APPLICATION_JSON)
//                .mediaType("xml",MediaType.APPLICATION_XML);

        //Header Param http://localhost:8081/hardware/1
        configurer.favorParameter(false).parameterName("mediaType")
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json",MediaType.APPLICATION_JSON)
                .mediaType("xml",MediaType.APPLICATION_XML)
                .mediaType("x-yaml",MEDIA_TYPE_APPLICATION_YML);

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(new YamlJackson2HttpMesageConverter());

    }
}

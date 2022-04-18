package com.imikasa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Mikasa
 */
@Configuration
@EnableWebMvc
public class MyConfig implements WebMvcConfigurer {

    @Value("${upload.url}")
    private String url;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploadUrl/**").addResourceLocations("file:"+url);
    }
}

package com.odontologos.odonto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer{

    public WebConfig(){

    }

    public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**").allowedOrigins(new String[]{"http://localhost:4200"}).allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"}).allowedHeaders(new String[]{"X-Requested-width", "Origin", "Content-Type", "Accept", "Authorization"});
   }
}

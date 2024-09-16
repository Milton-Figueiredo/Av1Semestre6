package com.prova.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder().group("prova1").pathsToMatch("/**").packagesToScan("com.prova.resources").build();
    }

    @Bean
    public io.swagger.v3.oas.models.OpenAPI customOpenAPI(){
        return new io.swagger.v3.oas.models.OpenAPI().info(new Info().title("prova1").description("prova1").version("1.0").contact(new Contact()
        .name("Prova").url("http://www.prova1.com.br").email("prova1@email.com")));
    }

}

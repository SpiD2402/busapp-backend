package com.example.retotecnico.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Productos y Clientes")
                        .description("API REST para la gestión de productos y clientes")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Desarrollador")
                                .url("https://www.civa.com")
                                .email("ramirezpiero2402@gmail.com")));
    }
}
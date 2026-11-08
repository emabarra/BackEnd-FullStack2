package com.duoc.huerto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

// Importaciones correctas de los modelos OpenAPI
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration 
public class OpenApiConfiguration {
    @Value("${app.version}")
    private String versionApp; 

    @Bean 
    public OpenAPI documentacionApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Gestión de Huerto Hogar")
                .version(versionApp)
                .description("Agregar, Editar, Eliminar y listar")
                .contact(new Contact()
                    .email("yzspa@gmail.com")
                    .name("Emanuel Barra y Benjamín Vargas")));
    }
}
package com.inditex.products.infraestructure.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition(
        servers = { @Server(url = "/api") }
)
public class OpenApiConfig {

    @Bean
    public OpenAPI springShopOpenApi() {
        return new OpenAPI().info(new Info().title("Prices").description("Prices API.").version("v1.0.0"));
    }

}

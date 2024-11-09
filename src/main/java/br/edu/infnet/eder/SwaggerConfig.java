package br.edu.infnet.eder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
     @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API: livraria")
                .version("1.0")
                .description("API para gestão da livraria")
                .contact(new Contact()
                    .name("Éder Jatobá de Oliveira Reis")
                    .email("eder.joliveira@al.infnet.edu.br")));
    }
}

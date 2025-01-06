package com.coderhouse.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	//http://localhost:8080/swagger-ui.html#
	//http://localhost:8080/swagger-ui/

	@Bean
	OpenAPI customOpenAPI () {
		return new OpenAPI()
				.info(new Info()
						.title("API REST Full | Java | CoderHouse")
						.version("3.0.0")
						.description("La API REST proporciona endpoints para administrar clientes y "
                        		+ "locales en una plataforma comercial. Permite realizar operaciones "
                        		+ "CRUD (Crear, Leer, Actualizar, Eliminar) tanto para productos y clientes como "
                        		+ "para locales. Los endpoints permiten listar, agregar, mostrar, "
                        		+ "editar y eliminar productos, alumnos y locales. La API está documentada utilizando "
                        		+ "Swagger, lo que facilita la comprensión de los endpoints y su uso.")
						.contact(new Contact()
								.name("Franco Kaliszczak Benitez")
								.email("francokaliszczakbenitez@gmail.com")
								.url("https://coderhouse.com.ar"))
						)
						.servers(List.of(new Server()
								.url("http://localhost:8080")
								.description("Servidor Local")));
				
	}
	
}
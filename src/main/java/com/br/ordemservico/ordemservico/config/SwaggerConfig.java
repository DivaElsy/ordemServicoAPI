package com.br.ordemservico.ordemservico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurationSupport {
	
	@Bean
    public Docket api(TypeResolver resolver) {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
	

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        System.out.println("******************************Configuring swagger resource handler");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api Rest para Sistema de controle de manutenção de equipamento")
                .description("Permite o registro dos clientes, equipamentos e ordens de serviços bem como do acompanhamento da sua execução")
                .version("Versão 1.0.0")
                .license("Licencia: Diva Elsy Arias Cardona")
                .contact(new springfox.documentation.service.Contact("Diva Elsy Arias Cardona", "","divaelsy@gmail.com"))
                .build();
    }
}
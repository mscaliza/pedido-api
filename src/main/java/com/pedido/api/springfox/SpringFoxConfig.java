package com.pedido.api.springfox;

import com.google.common.base.Predicate;
import lombok.var;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.fasterxml.classmate.TypeResolver;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import springfox.documentation.service.Tag;

@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        var typeResolver = new TypeResolver();
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("v1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pedido.api.resource"))
                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, globalGetResponseMessages())
                .additionalModels(typeResolver.resolve(Problem.class))
                .ignoredParameterTypes(ServletWebRequest.class,
                        URL.class, URI.class, URLStreamHandler.class, Resource.class,
                        File.class, InputStream.class)
                .apiInfo(apiInfoV1());
    }

    private ApiInfo apiInfoV1() {
        return new ApiInfoBuilder()
                .title("Pedido API")
                .description("API desenvolvida para solicitação de pedidos")
                .version("1")
                .contact(new Contact("Mariana Scaliza", "https://www.pedido-api.com", "mariana.scalica@gmail.com"))
                .build();
    }

    private List<ResponseMessage> globalGetResponseMessages() {
        return Arrays.asList(
                new ResponseMessageBuilder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message("Foi gerada uma exceção não tratada")
                        //.responseModel(new ModelRef("Problem"))
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.NOT_ACCEPTABLE.value())
                        .message("Recurso não possui representação que poderia ser aceita pelo consumidor")
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.FORBIDDEN.value())
                        .message("Você não tem permissão para acessar este recurso")
                        //.responseModel(new ModelRef("Problem"))
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .message("Não encontrado")
                        //.responseModel(new ModelRef("Problem"))
                        .build()
        );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

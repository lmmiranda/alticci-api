package com.lmmiranda.alticciapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.List;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lmmiranda.alticciapi"))
                .build()
                .useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.GET, globalGetResponseMessages())
                .apiInfo(apiInfo())
                .tags(new Tag("Alticci", "Controller responsible for the sequence."));
    }

    private List<Response> globalGetResponseMessages() {
        return Arrays.asList(new ResponseBuilder()
                        .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                        .description("Internal server error.")
                        .build());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Alticci sequence API")
                .description("API to calculate alticci sequence.")
                .version("1")
                .contact(new Contact("Lmmiranda", "https://github.com/lmmiranda", "lmmiranda@gmail.com"))
                .build();
    }

}

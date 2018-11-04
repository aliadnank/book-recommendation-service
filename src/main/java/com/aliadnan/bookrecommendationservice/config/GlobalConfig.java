package com.aliadnan.bookrecommendationservice.config;

import com.aliadnan.bookrecommendationservice.util.FeedbackEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
@Configuration
@EnableSwagger2
public class GlobalConfig {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(FeedbackEnum.class, new FeedbackTypeEditor());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Book Recommendation Service REST API",
                "API provides User Registration and Books Recommendation to the users",
                "1.0",
                "",
                new Contact("Ali Adnan", "www.techconfigs.com", "ali@techconfigs.com"),
                "License of API", "www.techconfigs.com", Collections.emptyList());
    }

}

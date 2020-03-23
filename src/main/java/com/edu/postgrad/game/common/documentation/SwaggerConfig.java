package com.edu.postgrad.game.common.documentation;

import java.util.Collection;

import com.google.common.collect.Lists;
import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final Contact CUSTOM_CONTACT = new Contact("R", "url", "email");
    public static final ApiInfo APP_INFO = new ApiInfo("My api docs", "decsription", "V1", "Terms of Service URL", CUSTOM_CONTACT,
            "License", "LicenseURL", Lists.newArrayList());

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(APP_INFO);
    }
}

package com.hr.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Config of swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  /**
   * API of APP
   */
  @Bean public Docket appApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName(APP)
        .genericModelSubstitutes(DeferredResult.class)
        .useDefaultResponseMessages(false)
        .forCodeGeneration(false)
        .pathMapping("/")
        .select()
        .paths(or(regex("/api/.*/app/.*")))
        .build()
        .apiInfo(appApiInfo());
  }

  /**
   * API of open
   */
  @Bean public Docket openApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName(OPEN)
        .genericModelSubstitutes(DeferredResult.class)
        .useDefaultResponseMessages(false)
        .forCodeGeneration(false)
        .pathMapping("/")
        .select()
        .paths(or(regex("/api/.*/open/.*")))
        .build()
        .apiInfo(openApiInfo());
  }

  /**
   * API of management
   */
  @Bean public Docket managementApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName(MANAGEMENT)
        .genericModelSubstitutes(DeferredResult.class)
        .useDefaultResponseMessages(false)
        .forCodeGeneration(false)
        .pathMapping("/")
        .select()
        .paths(or(regex("/api/.*/management/.*")))
        .build()
        .apiInfo(managementApiInfo());
  }


  private ApiInfo appApiInfo() {
    return new ApiInfo(TITLE, DESCRIPTION_APP, VERSION, TERMS, new Contact(NAME, URL, EMAIL),
        LICENSE, LICENSE_URL
    );
  }

  private ApiInfo openApiInfo() {
    return new ApiInfo(TITLE, DESCRIPTION_OPEN, VERSION, TERMS, new Contact(NAME, URL, EMAIL),
        LICENSE, LICENSE_URL);
  }

  private ApiInfo managementApiInfo() {
    return new ApiInfo(TITLE, DESCRIPTION_MANAGEMENT, VERSION, TERMS, new Contact(NAME, URL, EMAIL),
        LICENSE, LICENSE_URL);
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  private static final String VERSION = "v1";
  private static final String TITLE = "Spring rest oauth2 sample API";
  private static final String TERMS = "NO terms of service";
  private static final String LICENSE = "MIT";
  private static final String LICENSE_URL = "github";
  private static final String NAME = "github";
  private static final String URL = "github";
  private static final String EMAIL = "github";
  private static final String OPEN = "open";
  private static final String APP = "app";
  private static final String MANAGEMENT = "management";
  private static final String DESCRIPTION_APP = "App API";
  private static final String DESCRIPTION_OPEN = "Open API";
  private static final String DESCRIPTION_MANAGEMENT = "Management API";
}

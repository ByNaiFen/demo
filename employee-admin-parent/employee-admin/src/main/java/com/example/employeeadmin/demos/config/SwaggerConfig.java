package com.example.employeeadmin.demos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author YeShaoKang
 * @date 2023/9/2 16:38
 */
@Configuration
@EnableOpenApi
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)   // 使用使用 swagger 开关。默认 true ，可省略。
                .select()

//              .apis(RequestHandlerSelectors.any())    // 扫描所有所有路径
//              .apis(RequestHandlerSelectors.none())   // 所有路径都不扫描
                .apis(RequestHandlerSelectors.basePackage("com.example.employeeadmin.demos.web.controller")) // 扫描指定包路径

                .paths(PathSelectors.any())     // 过滤器：对外暴露所有 uri
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("职员信息管理 项目接口文挡") //  可以用来自定义API的主标题
                .description("Project Swagger3 Service Interface") // 可以用来描述整体的API
                .termsOfServiceUrl("http://localhost:9000/swagger-ui/index.html") // 用于定义服务的域名
                .version("1.0")
                .build();
    }
}

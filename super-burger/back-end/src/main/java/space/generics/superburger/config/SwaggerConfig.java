package space.generics.superburger.config;

import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(this.details());
        return docket;
    }
    
    private ApiInfo details() {
        final String title = "Super Burger API";
        final String description = "Repository: https://github.com/yehorbk/portfolio_projects/super-burger/back-end";
        final String version = "v1.0.0";
        final String termsOfServiceUrl = "";
        final Contact contact = new Contact(
                "Yehor Bublyk",
                "https://github.com/yehorbk",
                "yehor.bk@gmail.com"
        );
        final String license = "MIT";
        final String licenseUrl = "https://github.com/yehorbk/portfolio_projects/blob/master/LICENSE";
        final List<VendorExtension> vendorExtensions = Collections.emptyList();
        ApiInfo apiInfo = new ApiInfo(
                title,
                description,
                version,
                termsOfServiceUrl,
                contact,
                license,
                licenseUrl,
                vendorExtensions
        );
        return apiInfo;
    }
    
}

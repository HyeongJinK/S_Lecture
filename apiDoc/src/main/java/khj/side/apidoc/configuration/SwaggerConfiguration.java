package khj.side.apidoc.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Value("${url.boardUrl}")
    private String boardUrl;
    @Value("${url.todoUrl}")
    private String todoUrl;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("첫화면")
                .description("API EXAMPLE")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("example")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("khj.side"))
                .paths(PathSelectors.any())
                .build();
    }

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
        return () -> {
            List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
            resources.add(getSwaggerResource("Board", boardUrl));
            resources.add(getSwaggerResource("Todo", todoUrl));
            return resources;
        };
    }

    private SwaggerResource getSwaggerResource(String name, String url) {
        SwaggerResource wsResource = new SwaggerResource();
        wsResource.setName(name);
        wsResource.setSwaggerVersion("2.0");
        wsResource.setUrl(url);
        return wsResource;
    }
}

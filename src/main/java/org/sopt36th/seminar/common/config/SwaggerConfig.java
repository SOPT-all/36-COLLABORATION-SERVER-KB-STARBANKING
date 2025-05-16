package org.sopt36th.seminar.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("합동세미나 모바일 앱 6조 Swagger")
                .description("AT SOPT 36기 | 합동세미나 모바일 앱 6조 swagger")
                .version("1.0.0");
    }
}

package app.diegoGarcia_evaluation.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Examen")
                        .version("1")
                        .description("API de Diego para evaluación"));
    }

    //Para entrar al swagger hay que usar esta direción:
    // http://localhost:8080/swagger-ui/index.html#/
}

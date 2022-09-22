package sorbie.jon.springwebopenapi.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.*;

import static io.swagger.v3.oas.models.security.SecurityScheme.Type.*;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        SecurityScheme securityScheme = oauth();
        Contact contact = new Contact()
            .email("a@b.com")
            .name("Joe Developer")
            .url("http://myDocumentationUrl");
        Info info = new Info()
            .title("Spring Web OpenAPI Demo")
            .description("An API with items and customers")
            .version("1.2")
            .contact(contact);
        return new OpenAPI()
            .components(new Components())
            .schemaRequirement("Spring Web OpenAPI Demo", securityScheme)
            .info(info);
    }

    private static SecurityScheme oauth() {
        Scopes fullReadAccess = new Scopes()
            .addString("TBD", "Full Read Access");
        OAuthFlow oAuthFlow = new OAuthFlow()
            .authorizationUrl("https://myOauthTokenUrl")
            .scopes(fullReadAccess)
            .tokenUrl("https://myOauthServerUrl")
            .scopes(fullReadAccess);
        OAuthFlows oAuthFlows = new OAuthFlows()
            .clientCredentials(oAuthFlow);
        return new SecurityScheme()
            .type(OAUTH2)
            .flows(oAuthFlows);
    }
}

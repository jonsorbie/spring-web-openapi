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
        return customOpenApi("http://myDocumentationUrl",
                             "An API with items and customers",
                             "a@b.com",
                             "Joe Developer",
                             "Spring Web OpenAPI Demo",
                             "1.2",
                             "TBD",
                             "https://myOauthTokenUrl",
                             "https://myOauthServerUrl");
    }

    private static OpenAPI customOpenApi(String confluenceUrl,
                                         String description,
                                         String contactEmail,
                                         String contactName,
                                         String applicationName,
                                         String applicationVersion,
                                         String scope,
                                         String accessTokenUrl,
                                         String oAuthServerUrl) {
        SecurityScheme securityScheme = oauth(scope, accessTokenUrl, oAuthServerUrl);
        Contact contact = new Contact()
            .email(contactEmail)
            .name(contactName)
            .url(confluenceUrl);
        Info info = new Info()
            .title(applicationName)
            .description(description)
            .version(applicationVersion)
            .contact(contact);
        return new OpenAPI()
            .components(new Components())
            .schemaRequirement(applicationName, securityScheme)
            .info(info);
    }

    private static SecurityScheme oauth(String scope, String accessTokenUrl, String oAuthServerUrl) {
        Scopes fullReadAccess = new Scopes()
            .addString(scope, "Full Read Access");
        OAuthFlow oAuthFlow = new OAuthFlow()
            .authorizationUrl(accessTokenUrl)
            .scopes(fullReadAccess)
            .tokenUrl(oAuthServerUrl)
            .scopes(fullReadAccess);
        OAuthFlows oAuthFlows = new OAuthFlows()
            .clientCredentials(oAuthFlow);
        return new SecurityScheme()
            .type(OAUTH2)
            .flows(oAuthFlows);
    }
}

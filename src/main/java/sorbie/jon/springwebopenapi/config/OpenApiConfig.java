package sorbie.jon.springwebopenapi.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition( //
		info = @Info( //
				title = "Open API Demo", //
				description = "A demo of using OpenAPI to automatically generate documentation", //
				version = "1.0.0", //
				contact = @Contact(name = "Christopher Peterson", //
						email = "christopher.peterson@thrivent.com") //
		), //
		externalDocs = @ExternalDocumentation( //
				url = "https://confluence.digital.thrivent.com/example/", //
				description = "Consumption Guide"), //
		servers = { //
				@Server( //
						url = "https://example.com/api/", //
						description = "API URL") //
		} //
)
@SecurityScheme( //
type = SecuritySchemeType.OAUTH2, //
name = "oauth2", //
description = "Open Authorization version 2", //
flows = @OAuthFlows( //
		clientCredentials = @OAuthFlow( //
				authorizationUrl = "https://www.example.com/authorize", //
				tokenUrl = "https://www.example.com/token", //
				refreshUrl = "https://www.example.com/refresh", //
				scopes = { //
						@OAuthScope(name = "openapidemo.view", description = "allows GET requests only"), //
						@OAuthScope(name = "openapidemo.all", description = "allows ALL requests") //
						} //
				) //
		) //
)
public class OpenApiConfig {
}

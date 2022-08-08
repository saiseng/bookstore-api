package com.saiseng.bookstoreapi.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
		name = "basicAuthOpenAPI",
		type = SecuritySchemeType.HTTP,
		scheme = "basic"
)
public class OpenApiConfig {
}


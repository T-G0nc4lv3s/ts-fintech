package br.dev.tsantana.ftcloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
				.routes().route(r -> r.path("/clients/**").uri("lb://ft-client"))
				.build();
	}
}

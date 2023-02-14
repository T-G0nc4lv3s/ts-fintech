package br.dev.tsantana.ftcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class FtCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtCloudGatewayApplication.class, args);
	}

}

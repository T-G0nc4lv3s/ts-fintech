package br.dev.tsantana.fteurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FtEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtEurekaServerApplication.class, args);
	}

}

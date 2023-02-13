package br.dev.tsantana.ftclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FtClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtClientApplication.class, args);
	}

}

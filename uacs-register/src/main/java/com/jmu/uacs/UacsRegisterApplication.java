package com.jmu.uacs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class UacsRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UacsRegisterApplication.class, args);
	}

	// TODO: 2021/9/21  项目入口——注册中心
}

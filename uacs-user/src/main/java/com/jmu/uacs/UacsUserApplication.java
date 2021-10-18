package com.jmu.uacs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableFeignClients
@EnableTransactionManagement
@MapperScan("com.jmu.uacs.user.mapper") // 扫描dao包
@EnableDiscoveryClient // 服务注册发现
@SpringBootApplication
public class UacsUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UacsUserApplication.class, args);
	}

}

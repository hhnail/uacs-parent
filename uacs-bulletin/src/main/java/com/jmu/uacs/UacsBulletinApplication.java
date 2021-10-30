package com.jmu.uacs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.jmu.uacs.bulletin.mapper") // 扫描dao包
@EnableDiscoveryClient // 开启服务注册发现
@SpringBootApplication
public class UacsBulletinApplication {

	public static void main(String[] args) {
		SpringApplication.run(UacsBulletinApplication.class, args);
	}

}

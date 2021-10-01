package com.jmu.uacs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients
@EnableTransactionManagement
@MapperScan("com.jmu.uacs.association.mapper") // 扫描dao包
@EnableDiscoveryClient // 开启服务注册发现
@SpringBootApplication
public class UacsAssociationApplication {

	// TODO: 2021/9/21  项目入口——社团模块
	public static void main(String[] args) {
		SpringApplication.run(UacsAssociationApplication.class, args);
	}


}

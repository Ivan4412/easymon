package com.meerkat.easymon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@ComponentScan("com.meerkat")
@ImportResource({ "classpath:spring-config.xml", "classpath:spring-client.xml", "classpath:spring-data.xml" })
public class EasymonServiceApp  extends WebMvcConfigurerAdapter {

	// 启动服务
	public static void main(String[] args) {
		// 注意：SystemInitBean是系统初始化类，在@ComponentScan路径下，会被初始化
		SpringApplication.run(EasymonServiceApp.class);
	}

}

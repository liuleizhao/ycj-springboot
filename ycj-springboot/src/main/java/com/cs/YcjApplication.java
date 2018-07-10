package com.cs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  //开启定时任务
@EnableAsync  //开启异步调用方法
public class YcjApplication {

	public static void main(String[] args) {
		SpringApplication.run(YcjApplication.class, args);    
	}
}
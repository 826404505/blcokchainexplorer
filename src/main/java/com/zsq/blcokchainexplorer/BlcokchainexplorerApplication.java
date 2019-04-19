package com.zsq.blcokchainexplorer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableFeignClients
@EnableAsync
@MapperScan("com.zsq.blcokchainexplorer.dao")
public class BlcokchainexplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlcokchainexplorerApplication.class, args);
    }

}

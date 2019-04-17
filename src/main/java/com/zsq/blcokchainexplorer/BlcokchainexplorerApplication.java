package com.zsq.blcokchainexplorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BlcokchainexplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlcokchainexplorerApplication.class, args);
    }

}

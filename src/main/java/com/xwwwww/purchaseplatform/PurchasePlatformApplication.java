package com.xwwwww.purchaseplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan( "com.xwwwww.purchaseplatform.mapper")
public class PurchasePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PurchasePlatformApplication.class, args);
    }

}

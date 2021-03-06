package com.imikasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Mikasa
 */
@SpringBootApplication
@EnableFeignClients
public class ProductBrandApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductBrandApplication.class,args);
    }
}

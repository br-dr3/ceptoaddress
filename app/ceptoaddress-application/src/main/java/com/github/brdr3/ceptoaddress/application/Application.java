package com.github.brdr3.ceptoaddress.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.github.brdr3.ceptoaddress")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

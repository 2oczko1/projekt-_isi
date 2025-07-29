package com.systemzarzadzaniaapteka;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan("com.systemzarzadzaniaapteka.model") // Explicitly scan your entity package

public class SystemZarzadzaniaAptekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemZarzadzaniaAptekaApplication.class, args);
    }
}


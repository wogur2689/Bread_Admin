package com.example.bread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableJpaAuditing
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(BreadApplication.class, args);
    }

}

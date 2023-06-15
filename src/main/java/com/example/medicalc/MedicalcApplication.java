package com.example.medicalc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MedicalcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalcApplication.class, args);
        log.info("Application started");
    }

}

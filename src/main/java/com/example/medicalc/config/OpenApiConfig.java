package com.example.medicalc.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "medicalc",
                description = "Medical Calculator", version = "1.0.0",
                contact = @Contact(
                        name = "Kurenkov Vyacheslav",
                        email = "slava.kurenkov@bk.ru"
                )
        )
)

public class OpenApiConfig {

}
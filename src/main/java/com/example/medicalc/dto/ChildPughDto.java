package com.example.medicalc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Objects;

@Data
@Schema(description = "Сущность калькулятора ChildPugh")
public class ChildPughDto extends BaseCalcDto {
    private String bilirubin;
    private String albumin;
    private String inr;
    private String ascites;
    private String encephalopathy;

    public ChildPughDto(String bilirubin, String albumin, String inr, String ascites, String encephalopathy) {
        this.bilirubin = bilirubin;
        this.albumin = albumin;
        this.inr = inr;
        this.ascites = ascites;
        this.encephalopathy = encephalopathy;
    }
}

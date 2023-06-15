package com.example.medicalc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Сущность калькулятора Grace")
public class GraceDto extends BaseCalcDto {
    private Double age;
    private Double hr;
    private Double systolic;
    private Double plasmaCreatinine;
    private Integer cardiacArrest;
    private Integer stsegmentoffset;
    private Integer elevatedMarkerLevels;
    private Integer heartFailure;

    public GraceDto(Double age, Double hr, Double systolic, Double plasmaCreatinine, Integer cardiacArrest, Integer stsegmentoffset, Integer elevatedMarkerLevels, Integer heartFailure) {
        this.age = age;
        this.hr = hr;
        this.systolic = systolic;
        this.plasmaCreatinine = plasmaCreatinine;
        this.cardiacArrest = cardiacArrest;
        this.stsegmentoffset = stsegmentoffset;
        this.elevatedMarkerLevels = elevatedMarkerLevels;
        this.heartFailure = heartFailure;
    }
}

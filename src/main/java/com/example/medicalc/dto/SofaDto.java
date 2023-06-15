package com.example.medicalc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Schema(description = "Сущность калькулятора Sofa")
@Data
public class SofaDto extends BaseCalcDto {
    private Double paO2;
    private Double fio2;
    private Integer ventilation;
    private Double platelets;
    private Double bilirubin;
    private Integer bloodPressure;
    private Double glasgowScale;
    private Double creatinine;
    private Double diuresis;

    public SofaDto(Double paO2, Double fio2, Integer ventilation, Double platelets, Double bilirubin, Integer bloodPressure, Double glasgowScale, Double creatinine, Double diuresis) {
        this.paO2 = paO2;
        this.fio2 = fio2;
        this.ventilation = ventilation;
        this.platelets = platelets;
        this.bilirubin = bilirubin;
        this.bloodPressure = bloodPressure;
        this.glasgowScale = glasgowScale;
        this.creatinine = creatinine;
        this.diuresis = diuresis;
    }

}

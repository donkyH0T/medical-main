package com.example.medicalc.service.impl;


import com.example.medicalc.dto.ResultDto;
import com.example.medicalc.dto.SofaDto;
import com.example.medicalc.service.MedicalCalculatorService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
@Schema(description = "Сервис для Sofa")
public class SofaService implements MedicalCalculatorService<SofaDto> {
    public Integer calculate(SofaDto obj) {
        Integer sum = obj.getBloodPressure();
        Double Pao2Fio2 = 100 * obj.getPaO2() / obj.getFio2();
        if ((Pao2Fio2 <= 100) && obj.getVentilation() == 1) {
            sum += 4;
        } else if ((Pao2Fio2 <= 200) && obj.getVentilation() == 1) {
            sum += 3;
        } else if (Pao2Fio2 <= 300) {
            sum += 2;
        } else if (Pao2Fio2 <= 400) {
            sum += 1;
        }
        if (obj.getPlatelets() < 20) {
            sum += 4;
        } else if (obj.getPlatelets() < 50) {
            sum += 3;
        } else if (obj.getPlatelets() < 100) {
            sum += 2;
        } else if (obj.getPlatelets() < 150) {
            sum += 1;
        }

        if (obj.getBilirubin() < 1.2) {
            sum += 0;
        } else if (obj.getBilirubin() < 2) {
            sum += 1;
        } else if (obj.getBilirubin() < 6) {
            sum += 2;
        } else if (obj.getBilirubin() < 12) {
            sum += 3;
        } else {
            sum += 4;
        }

        if (obj.getGlasgowScale() > 14) {
            sum += 0;
        } else if (obj.getGlasgowScale() > 12) {
            sum += 1;
        } else if (obj.getGlasgowScale() > 9) {
            sum += 2;
        } else if (obj.getGlasgowScale() > 5) {
            sum += 3;
        } else {
            sum += 4;
        }
        if (obj.getCreatinine() != 0) {
            if (obj.getCreatinine() < 1.2) {
                sum += 0;
            } else if (obj.getCreatinine() < 2) {
                sum += 1;
            } else if (obj.getCreatinine() < 3.5) {
                sum += 2;
            } else if (obj.getCreatinine() < 5) {
                sum += 3;
            } else {
                sum += 4;
            }
        } else {
            if (obj.getDiuresis() < 200) {
                sum += 4;
            } else if (obj.getDiuresis() < 500) {
                sum += 3;
            }
        }
        return sum;
    }

    @Override
    public ResultDto calculateResult(SofaDto dto) {
        Integer offset;
        offset=calculate(dto);
        if(offset==null || offset==0){
            return null;
        }
        return result(offset);
    }

    @Override
    public ResultDto result(Integer calc) {
        if(calc==null){
            return null;
        }
        ResultDto res = new ResultDto();
        res.setTitle(String.format("%s баллов по шкале SOFA", calc));
        if (calc >= 12) {
            res.setDetails(" Летальность: 95%");
        } else if (calc <= 11 && calc >= 9) {
            res.setDetails("Летальность: 40 - 50%");
        } else {
            res.setDetails("Летальность: <33%");
        }
        return res;
    }
}

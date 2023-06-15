package com.example.medicalc.service.impl;

import com.example.medicalc.dto.GraceDto;
import com.example.medicalc.dto.ResultDto;
import com.example.medicalc.service.MedicalCalculatorService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
@Schema(description = "Сервис для Grace")
public class GraceService implements MedicalCalculatorService<GraceDto> {
    private Integer STSegmentOffset;

    public Integer calculate(GraceDto obj) {
        this.STSegmentOffset = obj.getStsegmentoffset();
        int sum = 0;
        if (obj.getAge() < 30) {
            sum += 0;
        } else if (obj.getAge() >= 30 && obj.getAge() <= 39) {
            sum += 8;
        } else if (obj.getAge() >= 40 && obj.getAge() <= 49) {
            sum += 25;
        } else if (obj.getAge() >= 50 && obj.getAge() <= 59) {
            sum += 41;
        } else if (obj.getAge() >= 60 && obj.getAge() <= 69) {
            sum += 58;
        } else if (obj.getAge() >= 70 && obj.getAge() <= 79) {
            sum += 75;
        } else if (obj.getAge() >= 80 && obj.getAge() <= 89) {
            sum += 91;
        } else if (obj.getAge() >= 90) {
            sum += 100;
        }

        if (obj.getHr() < 50) {
            sum += 0;
        } else if (obj.getHr() >= 50 && obj.getHr() <= 69) {
            sum += 3;
        } else if (obj.getHr() >= 70 && obj.getHr() <= 89) {
            sum += 9;
        } else if (obj.getHr() >= 90 && obj.getHr() <= 109) {
            sum += 15;
        } else if (obj.getHr() >= 110 && obj.getHr() <= 149) {
            sum += 24;
        } else if (obj.getHr() >= 150 && obj.getHr() <= 199) {
            sum += 38;
        } else if (obj.getHr() >= 200) {
            sum += 46;
        }

        if (obj.getSystolic() < 80) {
            sum += 58;
        } else if (obj.getSystolic() >= 80 && obj.getSystolic() <= 99) {
            sum += 53;
        } else if (obj.getSystolic() >= 100 && obj.getSystolic() <= 119) {
            sum += 43;
        } else if (obj.getSystolic() >= 120 && obj.getSystolic() <= 139) {
            sum += 34;
        } else if (obj.getSystolic() >= 140 && obj.getSystolic() <= 159) {
            sum += 24;
        } else if (obj.getSystolic() >= 160 && obj.getSystolic() <= 199) {
            sum += 10;
        }

        if (obj.getPlasmaCreatinine() < 35.36) {
            sum += 1;
        } else if (obj.getPlasmaCreatinine() >= 35.36 && obj.getPlasmaCreatinine() <= 70.71) {
            sum += 4;
        } else if (obj.getPlasmaCreatinine() >= 70.72 && obj.getPlasmaCreatinine() <= 106.07) {
            sum += 7;
        } else if (obj.getPlasmaCreatinine() >= 106.08 && obj.getPlasmaCreatinine() <= 141.43) {
            sum += 10;
        } else if (obj.getPlasmaCreatinine() >= 141.43 && obj.getPlasmaCreatinine() <= 176.7) {
            sum += 13;
        } else if (obj.getPlasmaCreatinine() >= 176.8 && obj.getPlasmaCreatinine() <= 353) {
            sum += 21;
        } else if (obj.getPlasmaCreatinine() >= 354) {
            sum += 28;
        }

        switch (obj.getHeartFailure()) {
            case 4 -> sum += 59;
            case 3 -> sum += 39;
            case 2 -> sum += 20;
        }

        if (obj.getCardiacArrest() == 1) {
            sum += 39;
        }
        if (obj.getElevatedMarkerLevels() == 1) {
            sum += 14;
        }
        if (obj.getStsegmentoffset() == 1) {
            sum += 28;
        }
        return sum;
    }

    @Override
    public ResultDto result(Integer calc) {
        ResultDto res = new ResultDto();
        res.setTitle(String.format("%s баллов по шкале GRACE", calc));
        StringBuilder stringBuilder = new StringBuilder();
        if (STSegmentOffset == 1) {
            if (calc < 126) {
                stringBuilder.append("Внутригоспитальная летальность: менее 2%, риск летального исхода - низкий.");
                if (calc < 100) {
                    stringBuilder.append("6-ти месячная летальность: менее 4.5%, риск летального исхода - низкий.");
                } else if (calc >= 100 && calc <= 127) {
                    stringBuilder.append("6-ти месячная летальность: 4.5-11%, риск летального исхода - средний.");
                } else if (calc > 127) {
                    stringBuilder.append("6-ти месячная летальность: более 11%, риск летального исхода - высокий.");
                }
            } else if (calc >= 126 && calc <= 154) {
                stringBuilder.append("Внутригоспитальная летальность: 2-5%, риск летального исхода - средний.");
                if (calc <= 127) {
                    stringBuilder.append("6-ти месячная летальность: 4.5-11%, риск летального исхода - средний.");
                } else {
                    stringBuilder.append("6-ти месячная летальность: более 11%, риск летального исхода - высокий.");
                }
            } else {
                stringBuilder.append("Внутригоспитальная летальность: более 5%, риск летального исхода - высокий.");
                stringBuilder.append("6-ти месячная летальность: более 11%, риск летального исхода - высокий.");
            }
        } else {
            if (calc < 109) {
                stringBuilder.append("Внутригоспитальная летальность: менее 1%, риск летального исхода - низкий.");
                if (calc < 89) {
                    stringBuilder.append("6-ти месячная летальность: менее 3%, риск летального исхода - низкий.");
                } else if (calc >= 89 && calc <= 118) {
                    stringBuilder.append("6-ти месячная летальность: 3-8%, риск летального исхода - средний.");
                } else if (calc > 118) {
                    stringBuilder.append("6-ти месячная летальность: более 8%, риск летального исхода - высокий.");
                }
            } else if (calc >= 109 && calc <= 140) {
                stringBuilder.append("Внутригоспитальная летальность: 1-3%, риск летального исхода - средний.");
                if (calc < 118) {
                    stringBuilder.append("6-ти месячная летальность: 3-8%, риск летального исхода - средний.");
                } else {
                    stringBuilder.append("6-ти месячная летальность: более 8%, риск летального исхода - высокий.");
                }
            } else {
                stringBuilder.append("Внутригоспитальная летальность: более 3%, риск летального исхода - высокий.");
                stringBuilder.append("6-ти месячная летальность: более 8%, риск летального исхода - высокий.");
            }
        }
        res.setDetails(stringBuilder.toString());
        return res;
    }
}

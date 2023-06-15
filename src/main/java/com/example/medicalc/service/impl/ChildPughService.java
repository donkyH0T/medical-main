package com.example.medicalc.service.impl;

import com.example.medicalc.dto.ChildPughDto;
import com.example.medicalc.dto.ResultDto;
import com.example.medicalc.service.MedicalCalculatorService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Data
@Service
@Schema(description = "Сервис для ChildPugh")
public class ChildPughService implements MedicalCalculatorService<ChildPughDto> {
    public Integer calculate(ChildPughDto obj) {
        int sum = 0;
        switch (obj.getBilirubin()) {
            case "<34.2" -> sum += 1;
            case "34.2 - 51.3" -> sum += 2;
            case ">51.3" -> sum += 3;
        }
        switch (obj.getAlbumin()) {
            case ">35" -> sum += 1;
            case "28 - 35" -> sum += 2;
            case "<28" -> sum += 3;
        }
        switch (obj.getInr()) {
            case "<1.7" -> sum += 1;
            case "1.7 - 2.2" -> sum += 2;
            case ">2.2" -> sum += 3;
        }
        switch (obj.getAscites()) {
            case "Нет" -> sum += 1;
            case "Легкий" -> sum += 2;
            case "Средний или тяжелый" -> sum += 3;
        }
        switch (obj.getEncephalopathy()) {
            case "Нет" -> sum += 1;
            case "1 - 2 степень" -> sum += 2;
            case "3 - 4 степень" -> sum += 3;
        }
        return sum;
    }

    @Override
    public ResultDto result(Integer calc) {
        ResultDto res = new ResultDto();
        res.setTitle(calc + " баллов по шкале Чайлд-Пью");
        if (calc < 7) {
            res.setDetails("Класс A. Продолжительность жизни: 15-20 лет. Периоперационная летальность при абдоминальных операциях: 10%.");
        } else if (calc >= 7 && calc < 10) {
            res.setDetails("Класс B. Значительное функциональное ухудшение. Периоперационная летальность при абдоминальных операциях: 30%.");
        } else if (calc >= 10) {
            res.setDetails("Класс C. Продолжительность жизни: 1-3 года. Периоперационная летальность при абдоминальных операциях: 82%.");
        }
        return res;
    }
}

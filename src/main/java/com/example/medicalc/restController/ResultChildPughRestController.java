package com.example.medicalc.restController;

import com.example.medicalc.dto.ChildPughDto;
import com.example.medicalc.dto.ResultDto;
import com.example.medicalc.service.impl.ChildPughService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("calculator/")
@Log4j2
public class ResultChildPughRestController {
    private final ChildPughService childPughService;

    @Autowired
    protected ResultChildPughRestController(ChildPughService srv) {
        this.childPughService = srv;
    }


    @Qualifier("ChildPughService")
    @Tag(name = "resultChild-Pugh", description = "POST запрос для ChildPugh в формате json")
    @PostMapping("Child-Pugh/result")
    @SneakyThrows
    public ResultDto result(@NonNull @RequestBody ChildPughDto childPughDto) {
        log.info("Request to /Child-Pugh/result");
        ResultDto resultDto;
        try {
            resultDto=childPughService.calculateResult(childPughDto);
        }catch (Exception e){
            return (new ResultDto("Ошибка расчета Child-Pugh"));
        }
        return resultDto;
    }
}

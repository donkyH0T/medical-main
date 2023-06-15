package com.example.medicalc.restController;

import com.example.medicalc.dto.ResultDto;
import com.example.medicalc.dto.SofaDto;
import com.example.medicalc.service.impl.SofaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculator/")
@Log4j2
public class ResultSofaRestController {
    private final SofaService sofaService;

    @Autowired
    protected ResultSofaRestController(SofaService srv) {
        this.sofaService = srv;
    }

    @Qualifier("SofaService")
    @Tag(name = "resultSOFA", description = "POST запрос для SOFA в формате json")
    @PostMapping("SOFA/result")
    public ResponseEntity<ResultDto> result(@NonNull @RequestBody SofaDto sofaDto) {
        log.info("Request to /SOFA/result");
        Integer calc=sofaService.calculate(sofaDto);
        if(calc==null){
            return ResponseEntity.badRequest().body(new ResultDto("Ошибка расчета SOFA"));
        }
        ResultDto resultDto=sofaService.result(calc);
        return ResponseEntity.ok(resultDto);
    }
}

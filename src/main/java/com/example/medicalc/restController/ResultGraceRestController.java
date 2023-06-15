package com.example.medicalc.restController;

import com.example.medicalc.dto.GraceDto;
import com.example.medicalc.dto.ResultDto;
import com.example.medicalc.service.impl.GraceService;
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

@RestController
@RequestMapping("calculator/")
@Log4j2
public class ResultGraceRestController {
    private final GraceService graceService;

    @Autowired
    protected ResultGraceRestController(GraceService srv) {
        this.graceService = srv;
    }

    @Qualifier("graceService")
    @Tag(name = "resultGRACE", description = "POST запрос для GRACE в формате json")
    @PostMapping("GRACE/result")
    @SneakyThrows
    public ResponseEntity<ResultDto> result(@NonNull @RequestBody GraceDto graceDto) {
        log.info("Request to /GRACE/result");
        Integer calc = graceService.calculate(graceDto);
        if (calc == null) {
            return ResponseEntity.badRequest().body(new ResultDto("Ошибка расчета GRACE"));
        }
        ResultDto result = graceService.result(calc);
        return ResponseEntity.ok(result);
    }
}

package com.canteenvisit.controller;

import com.canteenvisit.controller.dto.DailyReportDto;
import com.canteenvisit.service.DailyReportService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DailyReportController {

    private final DailyReportService service;

    @GetMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DailyReportDto>> read(
            @RequestParam @Schema(example = "2022-04-17")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam @Schema(example = "8а") String className) {
        return new ResponseEntity<>(service.findByDateAndClass(date, className), HttpStatus.OK);
    }
}

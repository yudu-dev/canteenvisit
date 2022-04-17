package com.canteenvisit.controller;

import com.canteenvisit.controller.dto.DailyReportDto;
import com.canteenvisit.service.DailyReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DailyReportController {

    private final DailyReportService service;

    @GetMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DailyReportDto>> read(@RequestParam LocalDate date, @RequestParam String className) {
        return new ResponseEntity<>(service.findByDateAndClass(date, className), HttpStatus.OK);
    }

    @PutMapping(value = "/report")
    public ResponseEntity<?> update(@RequestBody List<DailyReportDto> reports) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

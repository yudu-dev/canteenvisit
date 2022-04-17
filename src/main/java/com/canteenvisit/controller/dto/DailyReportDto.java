package com.canteenvisit.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DailyReportDto {
    private Long id;
    private Boolean meal;
    private Boolean milk;
    private String fullName;
    private LocalDate dateOfBirth;
}

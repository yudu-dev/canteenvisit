package com.canteenvisit.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DailyReportRowModel {
    private Long studentId;
    private LocalDate dateOfMeal;
    private LocalDate dateOfBirth;
    private Boolean ateMeal;
    private Boolean drankMilk;
    private String firstName;
    private String lastName;
    private String middleName;
}

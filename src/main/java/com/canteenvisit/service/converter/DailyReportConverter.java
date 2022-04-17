package com.canteenvisit.service.converter;

import com.canteenvisit.controller.dto.DailyReportDto;
import com.canteenvisit.model.DailyReportRowModel;
import org.springframework.stereotype.Service;

@Service
public class DailyReportConverter {
    public DailyReportDto convert(DailyReportRowModel model) {
        DailyReportDto result = new DailyReportDto();
        result.setId(model.getStudentId());
        result.setMeal(model.getAteMeal());
        result.setMilk(model.getDrankMilk());
        result.setDateOfBirth(model.getDateOfBirth());
        result.setFullName(model.getLastName() + " " + model.getFirstName() + " " + model.getMiddleName());
        return result;
    }
}

package com.canteenvisit.service;

import com.canteenvisit.controller.dto.DailyReportDto;
import com.canteenvisit.repository.DailyReportRepository;
import com.canteenvisit.service.converter.DailyReportConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyReportService {
    private final DailyReportRepository repository;
    private final DailyReportConverter converter;

    public List<DailyReportDto> findByDateAndClass(LocalDate date, String className) {
        return repository.findByDateAndClass(date, className.toLowerCase()).stream()
                .map(converter::convert)
                .toList();
    }
}

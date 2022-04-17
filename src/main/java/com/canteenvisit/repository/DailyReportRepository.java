package com.canteenvisit.repository;

import com.canteenvisit.model.DailyReportRowModel;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyReportRepository {
    List<DailyReportRowModel> findByDateAndClass(LocalDate date, String className);
}

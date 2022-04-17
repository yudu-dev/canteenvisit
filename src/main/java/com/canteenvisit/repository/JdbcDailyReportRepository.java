package com.canteenvisit.repository;

import com.canteenvisit.model.DailyReportRowModel;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcDailyReportRepository implements DailyReportRepository {

    private static final String FIND_BY_DATE_AND_CLASS = "select\n" +
            "\tv.*,\n" +
            "\tss.first_name,\n" +
            "\tss.last_name,\n" +
            "\tss.middle_name,\n" +
            "\tss.date_of_birth\n" +
            "from\n" +
            "\tvisits v\n" +
            "left join students ss on\n" +
            "\tss.student_id = v.student_id\n" +
            "where\n" +
            "\tdate_of_meals = :date";

    private static final BeanPropertyRowMapper<DailyReportRowModel> ROW_MAPPER =
            new BeanPropertyRowMapper<>(DailyReportRowModel.class);

    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public List<DailyReportRowModel> findByDateAndClass(LocalDate date, String className) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("date", date);
        parameters.addValue("className", className);

        return jdbc.query(
                FIND_BY_DATE_AND_CLASS,
                parameters,
                ROW_MAPPER);
    }
}

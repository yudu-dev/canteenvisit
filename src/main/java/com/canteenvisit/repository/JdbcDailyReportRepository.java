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

    private static final String FIND_BY_DATE_AND_CLASS = "select " +
            "     s.student_id , " +
            "     s.first_name, " +
            "     s.last_name, " +
            "     s.middle_name, " +
            "     s.date_of_birth, " +
            "     coalesce (v.ate_meal,false) as ate_meal, " +
            "     coalesce (v.drank_milk,false) as drank_milk " +
            "from " +
            "     students s " +
            "left outer join ( " +
            "     select " +
            "          * " +
            "     from visits v " +
            "     where v.date_of_meals = :date " +
            ") v on s.student_id = v.student_id " +
            "where s.class_name = :className ";

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

package com.canteenvisit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
// @Entity указывает, что данный бин (класс) является сущностью
@Entity
// @Table указывает на имя таблицы, которая будет отображаться в этой сущности
@Table(name="visits")
// след строка позволяет избавиться от ошибки ленивой инициализации Hibernate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(Visit.VisitPK.class)
public class Visit {
    // @Id id колонки
    @Id
    // @Column указывает на имя колонки, которая отображается в свойство сущности
    @Column(name = "student_id")
    private Integer studentId;
    @Id
    @Column(name = "date_of_meals")
    private LocalDate dateOfMeals;
    @Column(name = "ate_meal")
    private boolean ateMeal;
    @Column(name = "drank_milk")
    private boolean drankMilk;
    @Column(name = "last_update")
    private LocalDate lastUpdate;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Visit{");
        sb.append("student_id=").append(studentId);
        sb.append(", date_of_meals='").append(dateOfMeals).append('\'');
        sb.append(", ate_food='").append(ateMeal).append('\'');
        sb.append(", drank_milk='").append(drankMilk).append('\'');
        sb.append(", last_update='").append(lastUpdate).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Data
    public static class VisitPK implements Serializable {
        protected Integer studentId;
        protected LocalDate dateOfMeals;
    }

}



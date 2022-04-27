package com.canteenvisit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;

@Getter
@Setter
// @Entity указывает, что данный бин (класс) является сущностью
@Entity
// @Table указывает на имя таблицы, которая будет отображаться в этой сущности
@Table(name = "students")
// след строка позволяет избавиться от ошибки ленивой инициализации Hibernate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {
    // @Id id колонки
    @Id
    // @Column указывает на имя колонки, которая отображается в свойство сущности
    @Column(name = "student_id")
    // @GeneratedValue — указывает, что данное свойство будет создаваться согласно указанной стратегии
    // тип стратегии, подходящей для PostgresSQL или Oracle - SEQUENCE
    // тип стратегии, подходящий для MySQL или DB2 - IDENTITY
    @SequenceGenerator(name = "studentIdSeq", sequenceName = "students_student_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentIdSeq")
    private Integer studentId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "class_name")
    private String className;
    @Column(name = "limited_health_options")
    private boolean limitedHealthOptions;
    @Column(name = "disability")
    private boolean disability;
    @Column(name = "paid_meals")
    private int paidMeals;
    @Column(name = "social_help_before")
    private LocalDate socialHelpBefore;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("student_id=").append(studentId);
        sb.append(", first_name='").append(firstName).append('\'');
        sb.append(", second_name='").append(lastName).append('\'');
        sb.append(", middle_name='").append(middleName).append('\'');
        sb.append(", date_of_birth='").append(dateOfBirth).append('\'');
        sb.append(", class_name='").append(className).append('\'');
        sb.append(", limited_health_options='").append(limitedHealthOptions).append('\'');
        sb.append(", disability='").append(disability).append('\'');
        sb.append(", paid_meals='").append(paidMeals).append('\'');
        sb.append(", social_help_before='").append(socialHelpBefore).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

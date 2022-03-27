package com.canteenvisit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
// @Entity указывает, что данный бин (класс) является сущностью.
@Entity
// @Table указывает на имя таблицы, которая будет отображаться в этой сущности
@Table(name="students")
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer student_id;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "second_name")
    private String second_name;
    @Column(name = "middle_name")
    private String middle_name;
    @Column(name = "date_of_birth")
    private LocalDate date_of_birth;
    @Column(name = "class_name")
    private String class_name;
    @Column(name = "limited_health_options")
    private boolean limited_health_options;
    @Column(name = "disability")
    private boolean disability;
    @Column(name = "paid_meals")
    private int paid_meals;
    @Column(name = "social_help_before")
    private LocalDate social_help_before;
    @Column(name = "ate_food")
    private Boolean ate_food;
    @Column(name = "drank_milk")
    private boolean drank_milk;

    @Override
    public boolean equals(Object obj) {
        // сравнивает текущий экземпляр объекта this с переданным объектом
        // если это один и тот же объект, то вернет true
        if (this == obj) {
            return true;
        }
        // является ли переданный объекта null и какой у него тип
        // если переданный объект другого типа, то объекты не равны
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // сравнивает поля объектов
        // если два объекта имеют одинаковые значения полей "Имя, Фамилия, Отчество"
        // то объекты совпадают
        final Student other = (Student) obj;
        return first_name.equals(other.first_name) &&
                second_name.equals(other.second_name) &&
                middle_name.equals(other.middle_name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("student_id=").append(student_id);
        sb.append(", first_name='").append(first_name).append('\'');
        sb.append(", second_name='").append(second_name).append('\'');
        sb.append(", middle_name='").append(middle_name).append('\'');
        sb.append(", date_of_birth='").append(date_of_birth).append('\'');
        sb.append(", class_name='").append(class_name).append('\'');
        sb.append(", limited_health_options='").append(limited_health_options).append('\'');
        sb.append(", disability='").append(disability).append('\'');
        sb.append(", paid_meals='").append(paid_meals).append('\'');
        sb.append(", social_help_before='").append(social_help_before).append('\'');
        sb.append(", ate_food='").append(ate_food).append('\'');
        sb.append(", drank_milk=").append(drank_milk);
        sb.append('}');
        return sb.toString();
    }
}

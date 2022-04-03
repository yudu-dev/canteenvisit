package com.canteenvisit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
// @Entity указывает, что данный бин (класс) является сущностью
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
    private Integer studentId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
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
    @Column(name = "ate_food")
    private Boolean ateFood;
    @Column(name = "drank_milk")
    private boolean drankMilk;

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
        return firstName.equals(other.firstName) &&
                secondName.equals(other.secondName) &&
                middleName.equals(other.middleName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("student_id=").append(studentId);
        sb.append(", first_name='").append(firstName).append('\'');
        sb.append(", second_name='").append(secondName).append('\'');
        sb.append(", middle_name='").append(middleName).append('\'');
        sb.append(", date_of_birth='").append(dateOfBirth).append('\'');
        sb.append(", class_name='").append(className).append('\'');
        sb.append(", limited_health_options='").append(limitedHealthOptions).append('\'');
        sb.append(", disability='").append(disability).append('\'');
        sb.append(", paid_meals='").append(paidMeals).append('\'');
        sb.append(", social_help_before='").append(socialHelpBefore).append('\'');
        sb.append(", ate_food='").append(ateFood).append('\'');
        sb.append(", drank_milk=").append(drankMilk);
        sb.append('}');
        return sb.toString();
    }
}

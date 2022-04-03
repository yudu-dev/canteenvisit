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
@Table(name="visits")
// след строка позволяет избавиться от ошибки ленивой инициализации Hibernate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Visit {
    // @Id id колонки
    @Id
    // @Column указывает на имя колонки, которая отображается в свойство сущности
    @Column(name = "student_id")
    // @GeneratedValue — указывает, что данное свойство будет создаваться согласно указанной стратегии
    // тип стратегии, подходящей для PostgresSQL или Oracle - SEQUENCE
    // тип стратегии, подходящий для MySQL или DB2 - IDENTITY
    @SequenceGenerator(name = "studentIdSeq", sequenceName = "visits_student_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentIdSeq")
    private Integer studentId;

    @Column(name = "date_of_meals")
    private LocalDate dateOfMeals;
    @Column(name = "ate_food")
    private boolean ateFood;
    @Column(name = "drank_milk")
    private boolean drankMilk;
    @Column(name = "last_update")
    private LocalDate lastUpdate;

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
        // если два объекта имеют одинаковые значения полей "ID и дата приема пищи"
        // то объекты совпадают
        final Visit other = (Visit) obj;
        return studentId.equals(other.studentId) &&
                dateOfMeals.equals(other.dateOfMeals);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Visit{");
        sb.append("student_id=").append(studentId);
        sb.append(", date_of_meals='").append(dateOfMeals).append('\'');
        sb.append(", ate_food='").append(ateFood).append('\'');
        sb.append(", drank_milk='").append(drankMilk).append('\'');
        sb.append(", last_update='").append(lastUpdate).append('\'');
        sb.append('}');
        return sb.toString();
    }

}

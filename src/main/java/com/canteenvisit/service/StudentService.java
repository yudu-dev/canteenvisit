package com.canteenvisit.service;

import com.canteenvisit.model.Student;

import java.util.List;

public interface StudentService {
    /**
     * Создает нового ученика
     * @param student ученик для создания
     */
    void create(Student student);

    /**
     * Возвращает список всех имеющихся учеников
     * @return список учеников
     */
    List<Student> findAll();

    /**
     * Возвращает ученика по его ID
     * @param id ID ученика
     * @return объект ученика с заданным ID
     */
    Student read(int id);

    /**
     * Обновляет ученика с заданным ID,
     * в соответствии с переданным учеником
     * @param student ученик в соответсвии с которым нужно обновить данные
     * @param id id ученика которого нужно обновить
     * @return true если данные были обновлены, иначе false
     */
    boolean update(Student student, int id);

    /**
     * Удаляет ученика с заданным ID
     * @param id id ученика, которого нужно удалить
     * @return true если клиент был удален, иначе false
     */
    boolean delete(int id);
}

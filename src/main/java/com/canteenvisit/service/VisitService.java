package com.canteenvisit.service;

import com.canteenvisit.model.Visit;

import java.util.List;

public interface VisitService {
    /**
     * Создает новый объект класса Visit
     * @param visit объект класса Visit
     */
    void create(Visit visit);

    /**
     * Возвращает список всех имеющихся объектов класса Visit
     * @return список объектов класса Visit
     */
    List<Visit> findAll();

    /**
     * Возвращает объект класса Visit по ID ученика
     * @param id ID ученика
     * @return объект класса Visit с заданным ID ученика
     */
    Visit read(int id);

    /**
     * Обновляет объект класса Visit с заданным ID ученика
     * @param visit объект класса Visit в соответсвии с которым нужно обновить данные другого объекта класса Visit
     * @param id id ученика объект класса Visit которого нужно обновить
     * @return true если данные были обновлены, иначе false
     */
    boolean update(Visit visit, int id);

    /**
     * Удаляет объект класса Visit с заданным ID ученика
     * @param id id ученика, объект класса Visit которого нужно удалить
     * @return true если клиент был удален, иначе false
     */
    boolean delete(int id);
}

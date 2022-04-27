package com.canteenvisit.repository;

import com.canteenvisit.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    boolean existsByStudentId(Integer studentId);
}

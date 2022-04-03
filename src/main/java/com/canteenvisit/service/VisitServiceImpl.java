package com.canteenvisit.service;

import com.canteenvisit.model.Visit;
import com.canteenvisit.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    @Override
    public void create(Visit visit) {
        visitRepository.save(visit);
    }

    @Override
    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    @Override
    public Visit read(int studentId) {
        return visitRepository.getById(studentId);
    }

    @Override
    public boolean update(Visit visit, int studentId) {
        if (visitRepository.existsById(studentId)) {
            visit.setStudentId(studentId);
            visitRepository.save(visit);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int studentId) {
        if (visitRepository.existsById(studentId)) {
            visitRepository.deleteById(studentId);
            return true;
        }
        return false;
    }
}

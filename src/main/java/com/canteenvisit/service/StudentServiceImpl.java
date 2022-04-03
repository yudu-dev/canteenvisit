package com.canteenvisit.service;

import com.canteenvisit.model.Student;
import com.canteenvisit.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student read(int studentId) {
        return studentRepository.getById(studentId);
    }

    @Override
    public boolean update(Student student, int studentId) {
        if (studentRepository.existsById(studentId)) {
            student.setStudentId(studentId);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }
}

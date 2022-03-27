package com.canteenvisit.service;

import com.canteenvisit.model.Student;
import com.canteenvisit.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Student read(int student_id) {
        return studentRepository.getById(student_id);
    }

    @Override
    public boolean update(Student student, int student_id) {
        if (studentRepository.existsById(student_id)) {
            student.setStudent_id(student_id);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int student_id) {
        if (studentRepository.existsById(student_id)) {
            studentRepository.deleteById(student_id);
            return true;
        }
        return false;
    }
}

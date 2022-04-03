package com.canteenvisit.controller;

import com.canteenvisit.service.StudentService;
import com.canteenvisit.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // Заменил produces = "application/json; charset=UTF-8" на produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    // но так как этот параметр устаревший для браузера хром, но актуальный для Safari пришлось добавить @Deprecated
    @Deprecated
    @PostMapping(value = "/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> create(@RequestBody Student student) {
        studentService.create(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Deprecated
    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Student>> read() {
        final List<Student> students = studentService.findAll();

        return students != null && !CollectionUtils.isEmpty(students)
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Deprecated
    @GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Student> read(@PathVariable(name = "id") int id) {
        final Student student = studentService.read(id);

        return student != null
                ? new ResponseEntity<>(student, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Deprecated
    @PutMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Student student) {
        final boolean updated = studentService.update(student, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Deprecated
    @DeleteMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = studentService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

package com.canteenvisit.controller;

import com.canteenvisit.model.Visit;
import com.canteenvisit.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    // Заменил produces = "application/json; charset=UTF-8" на produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    // но так как этот параметр устаревший для браузера хром, но актуальный для Safari пришлось добавить @Deprecated
    @Deprecated
    @PostMapping(value = "/visits", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> create(@RequestBody Visit visit) {
        visitService.create(visit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Deprecated
    @GetMapping(value = "/visits", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Visit>> read() {
        final List<Visit> visits = visitService.findAll();

        return visits != null && !CollectionUtils.isEmpty(visits)
                ? new ResponseEntity<>(visits, HttpStatus.OK)
                : new ResponseEntity<>(visits, HttpStatus.NOT_FOUND);
    }

    @Deprecated
    @GetMapping(value = "/visits/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Visit> read(@PathVariable(name = "id") int id, @RequestBody Visit visit) {
        final boolean updated = visitService.update(visit, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Deprecated
    @DeleteMapping(value = "/visits/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = visitService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

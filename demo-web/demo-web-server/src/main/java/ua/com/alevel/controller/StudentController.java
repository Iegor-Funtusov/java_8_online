package ua.com.alevel.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    @GetMapping
    public ResponseEntity<Collection<Student>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody Student student) {
        service.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@RequestBody Student student, @PathVariable Long id) {
        student.setId(id);
        service.update(student);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(true);
    }
}

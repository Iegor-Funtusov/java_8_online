package ua.com.alevel.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.entity.Student;
import ua.com.alevel.repository.StudentRepository;
import ua.com.alevel.service.StudentService;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void create(Student entity) {
        studentRepository.save(entity);
    }

    @Override
    public void update(Student entity) {
        studentRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }
}

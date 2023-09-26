package ua.com.alevel.service.impl;

import ua.com.alevel.annotations.BeanClass;
import ua.com.alevel.annotations.InjectBean;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentCrudService;

import java.util.Collection;
import java.util.Optional;

@BeanClass
public class StudentCrudServiceImpl implements StudentCrudService {

    @InjectBean
    private StudentDao studentDao;

    @Override
    public void create(Student student) {
        studentDao.create(student);
    }

    @Override
    public void update(Student student) {
        if (!studentDao.existsById(student.getId())) {
            throw new RuntimeException("Student not found");
        }
        studentDao.update(student);
    }

    @Override
    public void delete(String id) {
        if (!studentDao.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentDao.delete(id);
    }

    @Override
    public Student findOne(String id) {
        Optional<Student> optionalStudent = studentDao.findById(id);
        if (optionalStudent.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        return optionalStudent.get();
    }

    @Override
    public Collection<Student> findAll() {
        return studentDao.findAll();
    }
}

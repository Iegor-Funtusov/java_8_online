package ua.com.alevel.service.impl;

import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentCrudService;

public class StudentCrudServiceImpl2 implements StudentCrudService {

    @Override
    public void create(Student student) {
        System.out.println("StudentCrudServiceImpl2.create");
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Student findOne(String id) {
        return null;
    }

    @Override
    public Student[] findAll() {
        return new Student[0];
    }
}

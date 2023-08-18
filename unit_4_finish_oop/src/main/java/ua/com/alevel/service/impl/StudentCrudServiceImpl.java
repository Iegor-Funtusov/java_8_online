package ua.com.alevel.service.impl;

import ua.com.alevel.db.StudentDb;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentCrudService;

public class StudentCrudServiceImpl implements StudentCrudService {

    private StudentDb studentDb = new StudentDb();

    @Override
    public void create(Student student) {
        studentDb.create(student);
        System.out.println("StudentCrudServiceImpl.create");
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
        return studentDb.findAll();
    }
}

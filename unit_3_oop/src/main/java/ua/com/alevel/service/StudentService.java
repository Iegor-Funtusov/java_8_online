package ua.com.alevel.service;

import ua.com.alevel.db.StudentDb;
import ua.com.alevel.entity.Student;

public class StudentService {

    private StudentDb studentDb = new StudentDb();

    public void creqte(String firstName, String lastName, int age) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        studentDb.create(student);
    }

    public Student[] findAll() {
        return studentDb.findAll();
    }
}

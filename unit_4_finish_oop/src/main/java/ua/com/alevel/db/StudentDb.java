package ua.com.alevel.db;

import ua.com.alevel.entity.Student;

public class StudentDb {

    private Student[] students = new Student[10];

    public void create(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    public Student[] findAll() {
        return students;
    }
}

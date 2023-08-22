package ua.com.alevel.db;

import ua.com.alevel.entity.Group;
import ua.com.alevel.entity.GroupStudent;
import ua.com.alevel.entity.Student;

import java.util.UUID;

public class StudentDb {

    private Student[] students = new Student[2];
    private Group[] groups = new Group[2];
    private GroupStudent[] groupStudents = new GroupStudent[2];
    private int lastStudentIndex = 0;

    public void create(Student student) {
        if (lastStudentIndex == students.length - 1) {
            Student[] newStudents = new Student[students.length * 2];
            System.arraycopy(students, 0, newStudents, 0, students.length);
            students = newStudents;
            add(student);
        } else {
            add(student);
        }
    }

    public Student[] findAll() {
        return students;
    }

    private void add(Student student) {
        student.setId(UUID.randomUUID().toString());
        students[lastStudentIndex] = student;
        lastStudentIndex++;
    }
}

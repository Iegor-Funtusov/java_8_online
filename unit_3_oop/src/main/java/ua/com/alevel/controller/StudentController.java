package ua.com.alevel.controller;

import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentController {

    private StudentService studentService = new StudentService();

    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while ((position = bufferedReader.readLine()) != null) {
            crud(position, bufferedReader);
            menu();
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("If you want create student please enter 1");
        System.out.println("If you want find students please enter 2");
        System.out.println("If you want close app please enter 3");
    }

    private void crud(String position, BufferedReader bufferedReader) throws IOException {
        switch (position) {
            case "1" -> create(bufferedReader);
            case "2" -> findAll();
            case "3" -> System.exit(0);
        }
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter first name");
        String fn = reader.readLine();
        System.out.println("Please enter last name");
        String ln = reader.readLine();
        System.out.println("Please enter age");
        int age = Integer.parseInt(reader.readLine());
        studentService.creqte(fn, ln, age);
    }

    private void findAll() {
        Student[] students = studentService.findAll();
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (student != null) {
                System.out.println("first name = " + student.getFirstName());
                System.out.println("last name = " + student.getLastName());
                System.out.println("age = " + student.getAge());
            }
        }
    }
}

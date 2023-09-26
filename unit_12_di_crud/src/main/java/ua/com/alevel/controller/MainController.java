package ua.com.alevel.controller;

import ua.com.alevel.annotations.BeanClass;
import ua.com.alevel.annotations.BeanStarter;
import ua.com.alevel.annotations.InjectBean;
import ua.com.alevel.annotations.StartApplication;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentCrudService;
import ua.com.alevel.service.impl.StudentCrudServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

@BeanClass
@BeanStarter
public class MainController implements Controller {

    @InjectBean
    private StudentCrudService studentCrudService;

    @StartApplication
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
        System.out.println("If you want find student please enter 2");
        System.out.println("If you want delete student please enter 3");
        System.out.println("If you want update student please enter 4");
        System.out.println("If you want find all students please enter 5");
        System.out.println("If you want close app please enter 6");
    }

    private void crud(String position, BufferedReader bufferedReader) throws IOException {
        switch (position) {
            case "1" -> create(bufferedReader);
            case "2" -> findOne(bufferedReader);
            case "3" -> delete(bufferedReader);
            case "4" -> update(bufferedReader);
            case "5" -> findAll();
            case "6" -> System.exit(0);
        }
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter first name");
        String fn = reader.readLine();
        System.out.println("Please enter last name");
        String ln = reader.readLine();
        System.out.println("Please enter age");
        int age = Integer.parseInt(reader.readLine());
        Student student = new Student();
        student.setFirstName(fn);
        student.setLastName(ln);
        student.setAge(age);
        studentCrudService.create(student);
    }

    private void update(BufferedReader reader) throws IOException {
        System.out.println("MainController.update");
        System.out.println("Please enter id");
        String id = reader.readLine();
        System.out.println("Please enter first name");
        String fn = reader.readLine();
        System.out.println("Please enter last name");
        String ln = reader.readLine();
        System.out.println("Please enter age");
        int age = Integer.parseInt(reader.readLine());
        Student student = new Student();
        student.setId(id);
        student.setFirstName(fn);
        student.setLastName(ln);
        student.setAge(age);
        studentCrudService.update(student);
    }

    private void findOne(BufferedReader reader) throws IOException {
        System.out.println("MainController.findOne");
        System.out.println("Please enter id");
        String id = reader.readLine();
        Student student = studentCrudService.findOne(id);
        System.out.println("id = " + student.getId());
        System.out.println("first name = " + student.getFirstName());
        System.out.println("last name = " + student.getLastName());
        System.out.println("age = " + student.getAge());
    }

    private void delete(BufferedReader reader) throws IOException {
        System.out.println("MainController.delete");
        System.out.println("Please enter id");
        String id = reader.readLine();
        studentCrudService.delete(id);
    }

    private void findAll() {
        Collection<Student> students = studentCrudService.findAll();
        students.forEach(student -> {
            System.out.println("id = " + student.getId());
            System.out.println("first name = " + student.getFirstName());
            System.out.println("last name = " + student.getLastName());
            System.out.println("age = " + student.getAge());
        });
    }
}

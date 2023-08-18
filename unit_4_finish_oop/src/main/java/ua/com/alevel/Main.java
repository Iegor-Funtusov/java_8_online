package ua.com.alevel;

import ua.com.alevel.controller.MainController;
import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.entity.Group;
import ua.com.alevel.entity.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        MainController mainController = new MainController();
        mainController.start();


        // Student student = new Student(); Success
        // BaseEntity baseEntity = new Student(); Success

        // Student student1 = new BaseEntity();
        // BaseEntity baseEntity = new BaseEntity();


//        Student[] students = new Student[10];
//        BaseEntity[] entities = new BaseEntity[10];
//        entities[0] = new Student();
//        entities[1] = new Group();
    }
}

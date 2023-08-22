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
//        MainController mainController = new MainController();
//        mainController.start();

        String s = "fgdg87fdd8";

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            byte b = (byte) charArray[i];
            if (b >= 48 && b <= 57) {
                System.out.println("i = " + charArray[i]);
            }
        }

        String res = s.replaceAll("[A-Za-z]", "");
        System.out.println("res = " + res);

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

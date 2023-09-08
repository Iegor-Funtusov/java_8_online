package ua.com.alevel;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        StringTest stringTest = new StringTest();
        stringTest.test();
//        final Student s1 = new Student("test1", 23);
//        StudentRecord studentRecord = new StudentRecord("test1", 23);
//        System.out.println("s1 = " + s1);
//        Class<? extends Student> aClass = s1.getClass();
//        Field[] declaredFields = aClass.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            declaredField.setAccessible(true);
//            if (declaredField.getType().isAssignableFrom(String.class)) {
//                declaredField.set(s1, "Bla bla");
//            }
//        }
//        System.out.println("s1 = " + s1);
//
//        System.out.println("studentRecord = " + studentRecord);
//        Class<? extends StudentRecord> aClass1 = studentRecord.getClass();
//        Field[] declaredFields1 = aClass1.getDeclaredFields();
//        for (Field declaredField : declaredFields1) {
//            declaredField.setAccessible(true);
//            if (declaredField.getType().isAssignableFrom(String.class)) {
//                declaredField.set(s1, "Bla bla");
//            }
//        }
//        System.out.println("studentRecord = " + studentRecord);
    }
}

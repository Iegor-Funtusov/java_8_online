package ua.com.alevel;

import java.io.*;

public class SerialTest {

    private final Student student = generateStudent();

    public void test() {
        serial();
        deserial();
    }

    private void serial() {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(AppUtil.STUDENT_NAME.getPath()))) {
            outputStream.writeObject(student);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void deserial() {
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(AppUtil.STUDENT_NAME.getPath()))) {
            Object o = inputStream.readObject();
            Student s = (Student) o;
            System.out.println("s = " + s);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Student generateStudent() {
        Student student = new Student();
        student.setFirstName("Iehor");
        student.setLastName("Funtusov");
        student.setFullName("Iehor Funtusov");
        return student;
    }
}

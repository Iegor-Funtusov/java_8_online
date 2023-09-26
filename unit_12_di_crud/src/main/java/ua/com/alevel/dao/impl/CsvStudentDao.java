package ua.com.alevel.dao.impl;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import ua.com.alevel.annotations.BeanClass;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;
import ua.com.alevel.util.DbUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@BeanClass
//@Deprecated
public class CsvStudentDao implements StudentDao {

    private List<Student> students = new ArrayList<>();

    @Override
    public void create(Student student) {
        readCsv();
        student.setId(DbUtil.generateId(students));
        students.add(student);
        writeCsv();
    }

    @Override
    public void update(Student student) {
        readCsv();
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(student.getId())) {
                index = i;
            }
        }
        if (index != -1) {
            students.set(index, student);
        }
        writeCsv();
    }

    @Override
    public void delete(String id) {
        readCsv();
        students.removeIf(student -> student.getId().equals(id));
        writeCsv();
    }

    @Override
    public boolean existsById(String id) {
        readCsv();
        return students.stream().anyMatch(student -> student.getId().equals(id));
    }

    @Override
    public Optional<Student> findById(String id) {
        readCsv();
        return students.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public Collection<Student> findAll() {
        readCsv();
        return this.students;
    }

    private void readCsv() {
        try(CSVReader csvReader = new CSVReader(new FileReader("students.csv"), ';')) {

            List<String[]> list = csvReader.readAll();
            students = new ArrayList<>();
            for (String[] strings : list) {
                Student student = new Student();
                student.setId(strings[0]);
                student.setFirstName(strings[1]);
                student.setLastName(strings[2]);
                student.setAge(Integer.parseInt(strings[3]));
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void writeCsv() {
        try(CSVWriter csvWriter = new CSVWriter(new FileWriter("students.csv"), ';')) {
            List<String[]> list = new ArrayList<>();
            for (Student student : students) {
                String[] strings = new String[] {
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        String.valueOf(student.getAge())
                };
                list.add(strings);
            }
            csvWriter.writeAll(list);
            csvWriter.flush();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}

package ua.com.alevel.dao.impl;

import com.google.gson.Gson;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;
import ua.com.alevel.util.DbUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JsonStudentDao implements StudentDao {

    private List<Student> students = new ArrayList<>();

    @Override
    public void create(Student student) {
        readJson();
        student.setId(DbUtil.generateId(students));
        students.add(student);
        writeJson();
    }

    @Override
    public void update(Student student) {
        readJson();
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(student.getId())) {
                index = i;
            }
        }
        if (index != -1) {
            students.set(index, student);
        }
        writeJson();
    }

    @Override
    public void delete(String id) {
        readJson();
        students.removeIf(student -> student.getId().equals(id));
        writeJson();
    }

    @Override
    public boolean existsById(String id) {
        readJson();
        return students.stream().anyMatch(student -> student.getId().equals(id));
    }

    @Override
    public Optional<Student> findById(String id) {
        readJson();
        return students.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public Collection<Student> findAll() {
        readJson();
        return this.students;
    }

    private void readJson() {
        Gson gson = new Gson();
        try {
            Student[] from = gson.fromJson(new FileReader("students.json"), Student[].class);
            if (from != null) {
                this.students = new ArrayList<>();
                this.students.addAll(Arrays.asList(from));
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void writeJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this.students);
        try(FileWriter fileWriter = new FileWriter("students.json")) {
            fileWriter.write(json);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}

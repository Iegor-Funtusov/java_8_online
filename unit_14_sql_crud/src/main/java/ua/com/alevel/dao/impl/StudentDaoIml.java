package ua.com.alevel.dao.impl;

import ua.com.alevel.config.SqlConfig;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StudentDaoIml implements StudentDao {

    private final SqlConfig sqlConfig = SqlConfig.getInstance();

    @Override
    public void create(Student student) {
        try(PreparedStatement ps = sqlConfig.getConnection().prepareStatement("insert into students values (default, ?, ?, ?)")) {
            ps.setInt(1, student.getAge());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void update(Student student) {
        try(PreparedStatement ps = sqlConfig.getConnection().prepareStatement("update students set age = ?, first_name = ?, last_name = ? where id = ?")) {
            ps.setInt(1, student.getAge());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setLong(4, student.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = sqlConfig.getConnection().prepareStatement("delete from students where id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public boolean existsById(Long id) {
        try(ResultSet rs = sqlConfig.getStatement().executeQuery("select count(id) as count_of_students from students where id =" + id)) {
            rs.next();
            long count = rs.getLong("count_of_students");
            return count == 1;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return false;
    }

    @Override
    public Optional<Student> findById(Long id) {
        try(ResultSet rs = sqlConfig.getStatement().executeQuery("select * from students where id = " + id)) {
            rs.next();
            return Optional.of(generateStudentByResultSet(rs));
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Collection<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try(ResultSet rs = sqlConfig.getStatement().executeQuery("select * from students")) {
            while (rs.next()) {
                students.add(generateStudentByResultSet(rs));
            }
            return students;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return Collections.emptyList();
    }

    private Student generateStudentByResultSet(ResultSet rs) throws SQLException {
        Student student = new Student();
        Long id = rs.getLong("id");
        String fn = rs.getString("first_name");
        String ln = rs.getString("last_name");
        int age = rs.getInt("age");
        student.setId(id);
        student.setFirstName(fn);
        student.setLastName(ln);
        student.setAge(age);
        return student;
    }
}

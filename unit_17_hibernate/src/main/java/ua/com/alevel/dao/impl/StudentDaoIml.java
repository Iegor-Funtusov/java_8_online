package ua.com.alevel.dao.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;

import java.util.*;

public class StudentDaoIml implements StudentDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void create(Student student) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Student student) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
            System.out.println("student = " + student);
        } catch (Exception e) {
            System.out.println("e = " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Optional<Student> optionalStudent = findById(id);
            if (optionalStudent.isPresent()) {
                session.delete(optionalStudent.get());
                transaction.commit();
            }
        } catch (Exception e) {
            System.out.println("e = " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public boolean existsById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select count(s) from Student s where s.id = :studentId")
                    .setParameter("studentId", id);
            long res = (Long) query.getSingleResult();
            transaction.commit();
            return res == 1;
        } catch (Exception e) {
            System.out.println("e = " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public Optional<Student> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            transaction.commit();
            return Optional.of(student);
        } catch (Exception e) {
            System.out.println("e = " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return Optional.empty();
    }

    @Override
    public Collection<Student> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select s from Student s");
            List<Student> students = query.getResultList();
            transaction.commit();
            return students;
        } catch (Exception e) {
            System.out.println("e = " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return Collections.emptyList();
    }
}

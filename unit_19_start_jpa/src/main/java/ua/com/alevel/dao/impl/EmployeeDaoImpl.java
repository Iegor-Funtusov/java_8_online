package ua.com.alevel.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.entity.Employee;

import java.util.Collection;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jpa-hibernate-mysql");
    private final EntityManager entityManager = emf.createEntityManager();

    @Override
    public void create(Employee entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Employee entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Employee.class, id));
    }

    @Override
    public Collection<Employee> findAll() {
        // HQL -> JPQL
        Query query = entityManager.createQuery("select d from Department d where d.name like ''");
        return entityManager.createQuery("select e from Employee e").getResultList();
    }
}

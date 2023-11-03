package ua.com.alevel.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.entity.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public class DepartmentDaoImpl implements DepartmentDao {

    private final EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jpa-hibernate-mysql");
    private final EntityManager entityManager = emf.createEntityManager();

    @Override
    public void create(Department entity) {
        entityManager.getTransaction().begin();
        Session session = entityManager.unwrap(Session.class);
        session.doWork(new DepartmentCreateWork(entity.getName()));
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Department entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Department> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Department> findAll() {
        return null;
    }

    private record DepartmentCreateWork(String name) implements Work {

        @Override
            public void execute(Connection connection) throws SQLException {
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                try (PreparedStatement ps = connection.prepareStatement("insert into departments values (default,?)")) {
                    ps.setString(1, name);
                    ps.executeUpdate();
                } catch (SQLException e) {
                }
            }
        }
}

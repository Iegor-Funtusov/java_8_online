package ua.com.alevel.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.alevel.entity.Department;

import java.util.Collection;

@Repository
public interface DepartmentRepository extends BaseRepository<Department> {

    @Query("select d from Department d where d.name like %:n%")
    Collection<Department> getDepartments(@Param("n") String n);

    @Query(value = "select * from departments where name like %?%", nativeQuery = true)
    Collection<Department> getDepartments1(String n);

    Collection<Department> findAllByNameContaining(String name);
    Collection<Department> findByNameContaining(String name);

    void deleteByNameContainingIgnoreCase(String name);
    long countAllByNameContainingIgnoreCase(String name);
    boolean existsAllByNameContainingIgnoreCase(String name);
}

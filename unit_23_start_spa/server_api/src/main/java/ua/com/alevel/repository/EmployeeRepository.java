package ua.com.alevel.repository;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.alevel.entity.Employee;

import java.util.Collection;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee> {

//    @Query(value = "select * from employees where firstName like sw% or lastName %c% and age between l and r", nativeQuery = true)
    Collection<Employee> findAllByFirstNameStartingWithIgnoreCaseOrLastNameContainingIgnoreCaseAndAgeBetween(String sw, String c, int l, int r);
}

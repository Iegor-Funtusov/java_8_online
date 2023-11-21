package ua.com.alevel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "departments")
public class Department extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "dep_emp",
            joinColumns = @JoinColumn(name = "dep_id"),
            inverseJoinColumns = @JoinColumn(name = "emp_id")
    )
    @ToString.Exclude
    private Set<Employee> employees;

    public Department() {
        employees = new HashSet<>();
    }
}

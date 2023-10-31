package ua.com.alevel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Min(18)
    private Integer age;

    @ManyToMany(mappedBy = "employees")
    @ToString.Exclude
    private Set<Department> departments;

    @OneToOne(cascade = CascadeType.ALL)
    private Salary salary;

    public Employee() {
        this.departments = new HashSet<>();
    }
}

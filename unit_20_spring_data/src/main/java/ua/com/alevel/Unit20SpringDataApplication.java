package ua.com.alevel;

import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.repository.EmployeeRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Transactional
@AllArgsConstructor
@SpringBootApplication
public class Unit20SpringDataApplication {

	private final RepositoryTest repositoryTest;
	private final EmployeeRepository employeeRepository;
	private final EmployeeDao employeeDao;

	public static void main(String[] args) {
		SpringApplication.run(Unit20SpringDataApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void start() {
//		repositoryTest.test();
//		for (int i = 0; i < 1_000; i++) {
//			Employee employee = new Employee();
//			employee.setAge(i + 18);
//			employee.setLastName(UUID.randomUUID().toString());
//			employee.setFirstName(UUID.randomUUID().toString());
//			employeeRepository.save(employee);
//		}
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("firstName", "fc");
		parameters.put("lastName", "72");
		parameters.put("age", 100);
		Collection<Employee> employees = employeeDao.findAllByCriteria(1, 10, "id", "asc", parameters);
		if (CollectionUtils.isNotEmpty(employees)) {
			for (Employee employee : employees) {
//				System.out.println("employee = " + employee.getId());
				System.out.println("employee = " + employee.getFirstName());
				System.out.println("employee = " + employee.getLastName());
				System.out.println("employee = " + employee.getAge());
			}
		}
	}
}

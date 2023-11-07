package ua.com.alevel.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.entity.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Employee> findAllByJPQL(int page, int size, String sort, String order, Map<String, Object> parameters) {
//        select * from employees where age >= 18 and age < 100 and first_name like '%fc%' and last_name like '%72%' order by id asc limit 0, 10;
        StringBuilder stringBuilder = new StringBuilder("select * from employees");
        if (MapUtils.isNotEmpty(parameters)) {
            stringBuilder.append(" where ");
            parameters.forEach((k, v) -> {
                if (v.getClass().isAssignableFrom(String.class)) {
                    stringBuilder.append(k);
                    stringBuilder.append(" like ");
                    stringBuilder.append("%");
                    stringBuilder.append(v);
                    stringBuilder.append("% and ");
                }
            });
        }
        stringBuilder.append("order by ");
        stringBuilder.append(sort);
        stringBuilder.append(" ");
        stringBuilder.append(order);
        stringBuilder.append(" limit ");

        int pageParameter = (page - 1) * size;

        stringBuilder.append(pageParameter);
        stringBuilder.append(", ");
        stringBuilder.append(size);

        System.out.println("stringBuilder = " + stringBuilder);

        Query query = entityManager.createNativeQuery(stringBuilder.toString());
        return query.getResultList();
    }

    @Override
    public Collection<Employee> findAllByCriteria(int page, int size, String sort, String order, Map<String, Object> parameters) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = criteriaQuery.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();

        if (MapUtils.isNotEmpty(parameters)) {
            parameters.forEach((k, v) -> {
                if (v.getClass().isAssignableFrom(String.class)) {
                    Predicate predicate = criteriaBuilder.like(criteriaBuilder.lower(from.get(k)), "%" + v + "%");
                    predicates.add(predicate);
                }
                if (v.getClass().isAssignableFrom(Integer.class)) {
                    Predicate predicate = criteriaBuilder.lessThan(from.get(k), String.valueOf(v));
                    predicates.add(predicate);
                }
            });
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        if (order.equals("desc")) {
            criteriaQuery.orderBy(criteriaBuilder.desc(from.get(sort)));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.asc(from.get(sort)));
        }
        int pageParameter = (page - 1) * size;

        Collection<Employee> employees = entityManager.createQuery(criteriaQuery)
                .setFirstResult(pageParameter)
                .setMaxResults(size)
                .getResultList();

        return employees;
    }
}

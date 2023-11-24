package ua.com.alevel.facade.impl;

import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.dto.request.EmployeeRequestDto;
import ua.com.alevel.dto.request.PageRequestDto;
import ua.com.alevel.dto.response.EmployeeResponseDto;
import ua.com.alevel.dto.response.PageResponseDto;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.facade.EmployeeFacade;
import ua.com.alevel.service.EmployeeService;
import ua.com.alevel.util.WebRequestUtil;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeFacadeImpl implements EmployeeFacade {

    private final EmployeeService employeeService;

    @Override
    public void create(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setAge(employeeRequestDto.getAge());
        employeeService.create(employee);
    }

    @Override
    public void update(EmployeeRequestDto employeeRequestDto, Long id) {
        Employee employee = employeeService.findById(id);
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setAge(employeeRequestDto.getAge());
        employeeService.update(employee);
    }

    @Override
    public void delete(Long id) {
        employeeService.delete(id);
    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        return new EmployeeResponseDto(employeeService.findById(id));
    }

    @Override
    public PageResponseDto<EmployeeResponseDto> findAll(WebRequest webRequest) {
        PageResponseDto<EmployeeResponseDto> pageResponseDto = new PageResponseDto<>();
        PageRequestDto pageRequestDto = WebRequestUtil.generatePageRequestDto(webRequest);
        Page<Employee> page = employeeService.findAll(pageRequestDto);
        pageResponseDto.setCurrentPage(pageRequestDto.getPage());
        pageResponseDto.setPageSize(page.getSize());
        pageResponseDto.setTotalPages(page.getTotalPages());
        pageResponseDto.setTotalElements(page.getTotalElements());
        pageResponseDto.setHasNext(page.hasNext());
        pageResponseDto.setFirst(page.isFirst());
        pageResponseDto.setLast(page.isLast());
        pageResponseDto.setHasPrevious(page.hasPrevious());
        pageResponseDto.setSortBy(pageRequestDto.getSortBy());
        pageResponseDto.setSortType(pageRequestDto.getSortType());
        Collection<EmployeeResponseDto> items = Collections.emptyList();
        List<Employee> employees = page.getContent();
        if (CollectionUtils.isNotEmpty(employees)) {
            items = employees.stream().map(EmployeeResponseDto::new).toList();
        }
        pageResponseDto.setItems(items);
        return pageResponseDto;
    }
}

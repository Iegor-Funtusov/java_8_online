package ua.com.alevel.facade;

import ua.com.alevel.dto.request.EmployeeRequestDto;
import ua.com.alevel.dto.response.EmployeeResponseDto;

public interface EmployeeFacade extends CrudFacade<EmployeeRequestDto, EmployeeResponseDto> { }

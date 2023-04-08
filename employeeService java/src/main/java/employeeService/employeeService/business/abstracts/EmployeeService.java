package employeeService.employeeService.business.abstracts;


import employeeService.employeeService.entities.dtos.EmployeeCreateDto;
import employeeService.employeeService.entities.dtos.EmployeeDto;
import employeeService.employeeService.entities.dtos.EmployeeUpdateDto;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface EmployeeService {
    EmployeeDto getEmployeeById(Long id);

    EmployeeDto createEmployee(EmployeeCreateDto employeeCreateDto);

    List<EmployeeDto> getAll();

    EmployeeDto updateEmployee(Long id, EmployeeUpdateDto employeeUpdateDto);

    void deleteEmployee(Long id);

    List<EmployeeDto> slice(Pageable pageable);

}

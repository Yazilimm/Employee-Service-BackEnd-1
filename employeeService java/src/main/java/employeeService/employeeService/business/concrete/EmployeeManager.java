package employeeService.employeeService.business.concrete;

import employeeService.employeeService.business.abstracts.EmployeeService;
import employeeService.employeeService.dataAccess.abstracts.EmployeeDao;
import employeeService.employeeService.entities.concrete.Employee;
import employeeService.employeeService.entities.dtos.EmployeeCreateDto;
import employeeService.employeeService.entities.dtos.EmployeeDto;
import employeeService.employeeService.entities.dtos.EmployeeUpdateDto;
import employeeService.employeeService.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeManager implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        super();
        this.employeeDao = employeeDao;
    }


    @Override
    public EmployeeDto getEmployeeById(Long id) {
          final  Employee employee = employeeDao.findById(id).orElseThrow(() -> new NotFoundException("Employee Not Found"));
        return EmployeeDto.of(employee);
    }
 
    @Override
    @Transactional
    public EmployeeDto createEmployee(EmployeeCreateDto employeeCreateDto) {

    	final Employee employee = employeeDao.save(new Employee(0, employeeCreateDto.getFirstName(),employeeCreateDto.getLastName(),
                employeeCreateDto.getEmail(), employeeCreateDto.getIdentityNumber(),employeeCreateDto.getPhoneNumber()));
        return EmployeeDto.of(employee);
    }

    @Override
    public List<EmployeeDto> getAll() {

        return employeeDao.findAll().stream().map(EmployeeDto::of).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeUpdateDto employeeUpdateDto) {
        final Employee employee = employeeDao.findById(id).orElseThrow(()-> new NotFoundException("Employee Not Found"));
        employee.setFirstName(employeeUpdateDto.getFirstName());
        employee.setLastName(employeeUpdateDto.getLastName());
        employee.setPhoneNumber(employeeUpdateDto.getPhoneNumber());
        final Employee updatedEmployee = employeeDao.save(employee);
        return EmployeeDto.of(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        final Employee employee = employeeDao.findById(id).orElseThrow(()-> new NotFoundException("Employee Not Found"));
        employeeDao.deleteById(employee.getId());

    }

    @Override
    public List<EmployeeDto> slice(Pageable pageable) {
        return employeeDao.findAll(pageable).stream().map(EmployeeDto::of).collect(Collectors.toList());
    }


}

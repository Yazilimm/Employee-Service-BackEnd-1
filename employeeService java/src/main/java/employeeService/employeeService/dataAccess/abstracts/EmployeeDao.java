package employeeService.employeeService.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import employeeService.employeeService.entities.concrete.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Long> {
	
	
	

}

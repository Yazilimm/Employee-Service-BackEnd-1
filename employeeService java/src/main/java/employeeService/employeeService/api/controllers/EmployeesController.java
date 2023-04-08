package employeeService.employeeService.api.controllers;

import employeeService.employeeService.business.abstracts.EmployeeService;
import employeeService.employeeService.core.GenericResponse;
import employeeService.employeeService.entities.dtos.EmployeeCreateDto;
import employeeService.employeeService.entities.dtos.EmployeeDto;
import employeeService.employeeService.entities.dtos.EmployeeUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;



@RestController
@RequestMapping("/api/employee")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    
    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDto>> getAll(){
         final List<EmployeeDto> employee = employeeService.getAll();
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        final EmployeeDto employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeCreateDto employeeCreateDto){
        employeeService.createEmployee(employeeCreateDto);
        return ResponseEntity.ok(new GenericResponse("User Created", LocalDate.now()));
    }

    @PutMapping("/updateEmployee/{id}")
    public  ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeUpdateDto employeeUpdateDto, @PathVariable("id") Long id){
        final EmployeeDto employee = employeeService.updateEmployee(id,employeeUpdateDto);
        return  ResponseEntity.ok(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(new GenericResponse("User Deleted", LocalDate.now()));
    }

    @GetMapping("/pagination")
    public  ResponseEntity<List<EmployeeDto>> slice(Pageable pageable){
        final List<EmployeeDto> employees = employeeService.slice(pageable);
        return  ResponseEntity.ok(employees);
    }
}

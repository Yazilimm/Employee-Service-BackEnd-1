package employeeService.employeeService.entities.dtos;

import employeeService.employeeService.entities.concrete.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import employeeService.employeeService.entities.concrete.Employee;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class EmployeeDto  implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String firstName;
    private String lastName;
    private String identityNumber;
    private List<Address> address;
    private  String phoneNumber;
    private String email;

  

    public static EmployeeDto of(Employee employee){
    	return  new EmployeeDto(employee.getFirstName(), employee.getLastName(),employee.getIdentityNumber(),employee.getPhoneNumber(),employee.getEmail(),);
    }

  




}

package employeeService.employeeService.entities.dtos;


import javax.validation.constraints.NotNull;

import employeeService.employeeService.entities.concrete.Address;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeUpdateDto {

	@NotNull(message="backend.constraints.firstName.NotNull.message=First name cannot be null")
    private String firstName;

	@NotNull(message="backend.constraints.lastName.NotNull.message")
    private String lastName;

     private List<Address> address;

    private  String phoneNumber;
}

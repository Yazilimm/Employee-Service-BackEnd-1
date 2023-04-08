package employeeService.employeeService.entities.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import employeeService.employeeService.entities.concrete.Address;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

import java.util.List;


@Data
public class EmployeeCreateDto  {


	@NotNull(message="backend.constraints.firstName.NotNull.message=First name cannot be null")
	@Size(min =4 , max=32, message = "{backend.constraints.firstName.Size.message}")
    private String firstName;
	
	@NotNull(message="backend.constraints.lastName.NotNull.message")
	@Size(min =4 , max=32, message = "{backend.constraints.lastName.Size.message}")
    private String lastName;

	
	@NotNull(message="{backend.constraints.identityNumber.NotNull.message}")
	@NotBlank(message="{backend.constraints.identityNumber.NotBlank.message}")
	@Length(min=11,max=11,message="{backend.constrainrs.identityNumber.Length.message}")
    private String identityNumber;

    private List<Address> address;
	
	
    private  String phoneNumber;
    
    @NotNull(message="{backend.constraints.email.NotNull.message}")
    @NotBlank(message="{backend.constraints.email.NotBlank.message}")
    @Pattern(regexp ="^(.+)@(\\S+)$" , message="{backend.constraints.email.Pattern.message}")
    private String email;

   
}

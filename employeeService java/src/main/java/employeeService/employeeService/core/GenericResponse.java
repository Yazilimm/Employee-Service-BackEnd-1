package employeeService.employeeService.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class GenericResponse {


    private String message;
    private LocalDate date;

}

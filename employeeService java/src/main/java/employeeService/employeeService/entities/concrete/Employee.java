package employeeService.employeeService.entities.concrete;

import lombok.*;


import javax.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    @Column(name = "identity_number",nullable=false,length=11,unique=true)
    private String identityNumber;

    @Column(name="first_name")
    private  String firstName;

    @Column(name = "last_name")
    private  String lastName;

    @OneToMany(mappedBy = "address")
    private List<Address> address;

    @Column(name = "phone_number")
    private  String phoneNumber;

    @Column(name = "email", length = 60)
    private String email;

    public Employee(int i, String firstName, String lastName, String email, String identityNumber, String phoneNumber) {
    }
}

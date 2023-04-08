package employeeService.employeeService.entities.concrete;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_address_id")
    private long id;

    @Column(name = "address", length = 100)
    private String address;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employee employee;
}

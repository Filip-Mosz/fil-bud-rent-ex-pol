package pl.rental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.rental.dtos.EmployeeDto;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String companyName;
    String website;
    String address;

    @OneToOne( fetch = FetchType.LAZY)
    private EmployeeEntity ceo;
//    List<EmployeeDto> employees;

}

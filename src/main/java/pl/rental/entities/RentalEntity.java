package pl.rental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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


//    EmployeeEntity ceo;
//    List<EmployeeDto> employees;

}

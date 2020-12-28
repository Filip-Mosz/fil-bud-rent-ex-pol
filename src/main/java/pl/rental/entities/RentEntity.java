package pl.rental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.rental.dtos.EquipmentDto;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Wypozyczenie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private EquipmentEntity machineId;

    @OneToOne
    private ClientEntity clientId;

    @OneToOne
    private EmployeeEntity employeeId;

    private Date dateOfRent;
    private Date estimatedDateOfReturn;

}

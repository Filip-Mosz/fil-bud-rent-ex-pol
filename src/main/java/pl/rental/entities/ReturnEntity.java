package pl.rental.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Zwrot")
public class ReturnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private RentEntity rentId;
    private Long delayInDays;
    private Date dateOfReturn;

//    use field below to validate if rented equipment matches returned equipment
    @OneToOne
    private EquipmentEntity machineId;
    @OneToOne
    private ClientEntity clientId;

}


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

    public Long getId() {
        return id;
    }

    public RentEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public EquipmentEntity getMachineId() {
        return machineId;
    }

    public RentEntity setMachineId(EquipmentEntity machineId) {
        this.machineId = machineId;
        return this;
    }

    public ClientEntity getClientId() {
        return clientId;
    }

    public RentEntity setClientId(ClientEntity clientId) {
        this.clientId = clientId;
        return this;
    }

    public EmployeeEntity getEmployeeId() {
        return employeeId;
    }

    public RentEntity setEmployeeId(EmployeeEntity employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Date getDateOfRent() {
        return dateOfRent;
    }

    public RentEntity setDateOfRent(Date dateOfRent) {
        this.dateOfRent = dateOfRent;
        return this;
    }

    public Date getEstimatedDateOfReturn() {
        return estimatedDateOfReturn;
    }

    public RentEntity setEstimatedDateOfReturn(Date estimatedDateOfReturn) {
        this.estimatedDateOfReturn = estimatedDateOfReturn;
        return this;
    }
}

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

    @OneToOne
    private EmployeeEntity employeeId;

//    use field below to validate if rented equipment matches returned equipment WYWALIĆ
    @OneToOne
    private EquipmentEntity machineId;
    @OneToOne
    private ClientEntity clientId;

    public Long getId() {
        return id;
    }

    public ReturnEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public RentEntity getRentId() {
        return rentId;
    }

    public ReturnEntity setRentId(RentEntity rentId) {
        this.rentId = rentId;
        return this;
    }

    public Long getDelayInDays() {
        return delayInDays;
    }

    public ReturnEntity setDelayInDays(Long delayInDays) {
        this.delayInDays = delayInDays;
        return this;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public ReturnEntity setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
        return this;
    }

    public EquipmentEntity getMachineId() {
        return machineId;
    }

    public ReturnEntity setMachineId(EquipmentEntity machineId) {
        this.machineId = machineId;
        return this;
    }

    public ClientEntity getClientId() {
        return clientId;
    }

    public ReturnEntity setClientId(ClientEntity clientId) {
        this.clientId = clientId;
        return this;
    }

    public EmployeeEntity getEmployeeId() {
        return employeeId;
    }

    public ReturnEntity setEmployeeId(EmployeeEntity employeeId) {
        this.employeeId = employeeId;
        return this;
    }
}


package pl.rental.dtos;

import java.sql.Date;

public class RentDto {

    private Long id;
    private EquipmentDto machineId;
    private ClientDto clientId;
    private EmployeeDto employeeId;
    private Date dateOfRent;
    private Date estimatedDateOfReturn;

    public Long getId() {
        return id;
    }

    public RentDto setId(Long id) {
        this.id = id;
        return this;
    }

    public EquipmentDto getMachineId() {
        return machineId;
    }

    public RentDto setMachineId(EquipmentDto machineId) {
        this.machineId = machineId;
        return this;
    }

    public ClientDto getClientId() {
        return clientId;
    }

    public RentDto setClientId(ClientDto clientId) {
        this.clientId = clientId;
        return this;
    }

    public EmployeeDto getEmployeeId() {
        return employeeId;
    }

    public RentDto setEmployeeId(EmployeeDto employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Date getDateOfRent() {
        return dateOfRent;
    }

    public RentDto setDateOfRent(Date dateOfRent) {
        this.dateOfRent = dateOfRent;
        return this;
    }

    public Date getEstimatedDateOfReturn() {
        return estimatedDateOfReturn;
    }

    public RentDto setEstimatedDateOfReturn(Date estimatedDateOfReturn) {
        this.estimatedDateOfReturn = estimatedDateOfReturn;
        return this;
    }
}

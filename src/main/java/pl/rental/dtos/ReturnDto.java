package pl.rental.dtos;

import java.sql.Date;

public class ReturnDto {

    private Long id;
    private EquipmentDto machineId;
    private ClientDto clientId;
    private EmployeeDto employeeId;
    private Date dateOfReturn;
    private Long delayInDays;

    public Long getId() {
        return id;
    }

    public ReturnDto setId(Long id) {
        this.id = id;
        return this;
    }

    public EquipmentDto getMachineId() {
        return machineId;
    }

    public ReturnDto setMachineId(EquipmentDto machineId) {
        this.machineId = machineId;
        return this;
    }

    public ClientDto getClientId() {
        return clientId;
    }

    public ReturnDto setClientId(ClientDto clientId) {
        this.clientId = clientId;
        return this;
    }

    public EmployeeDto getEmployeeId() {
        return employeeId;
    }

    public ReturnDto setEmployeeId(EmployeeDto employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public ReturnDto setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
        return this;
    }

    public Long getDelayInDays() {
        return delayInDays;
    }

    public ReturnDto setDelayInDays(Long delayInDays) {
        this.delayInDays = delayInDays;
        return this;
    }
}

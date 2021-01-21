package pl.rental.dtos;

import java.sql.Date;
import java.time.LocalDate;

public class RentForm {

    public RentForm(Long clientId, Long equipmentId, Long employeeId, String estimatedDateOfReturn) {
        this.clientId = clientId;
        this.equipmentId = equipmentId;
        this.employeeId = employeeId;
        this.estimatedDateOfReturn = estimatedDateOfReturn;
        this.dateOfRent = Date.valueOf(LocalDate.now());
    }



    public RentForm() {
        this.dateOfRent = Date.valueOf(LocalDate.now());
    }

    private Long clientId;
    private Long equipmentId;
    private Long employeeId;
    private final Date dateOfRent;
    private String estimatedDateOfReturn;

    public Long getClientId() {
        return clientId;
    }

    public RentForm setClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public RentForm setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
        return this;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public RentForm setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Date getDateOfRent() {
        return dateOfRent;
    }

    public String getEstimatedDateOfReturn() {
        return estimatedDateOfReturn;
    }

    public RentForm setEstimatedDateOfReturn(String estimatedDateOfReturn) {
        this.estimatedDateOfReturn = estimatedDateOfReturn;
        return this;
    }


}



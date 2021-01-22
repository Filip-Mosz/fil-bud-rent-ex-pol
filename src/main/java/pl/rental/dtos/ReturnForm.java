package pl.rental.dtos;

import java.sql.Date;
import java.time.LocalDate;

public class ReturnForm {
    public ReturnForm(Long rentId, Long clientId) {
        this.dateOfReturn = Date.valueOf(LocalDate.now());
        this.rentId = rentId;
        this.employeeId = clientId;
    }

    public ReturnForm() {
        this.dateOfReturn = Date.valueOf(LocalDate.now());
    }

    private Date dateOfReturn;
    private Long rentId;
    private Long employeeId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public ReturnForm setEmployeeId(Long clientId) {
        this.employeeId = clientId;
        return this;
    }


    public Long getRentId() {
        return rentId;
    }

    public ReturnForm setRentId(Long rentId) {
        this.rentId = rentId;
        return this;
    }
}

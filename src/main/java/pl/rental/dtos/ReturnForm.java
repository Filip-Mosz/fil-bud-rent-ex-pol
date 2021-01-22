package pl.rental.dtos;

import java.sql.Date;
import java.time.LocalDate;

public class ReturnForm {
    public ReturnForm(Long rentId, Long employeeId) {
        this.dateOfReturn = Date.valueOf(LocalDate.now());
        this.rentId = rentId;
        this.employeeId = employeeId;
    }

    public ReturnForm() {
        this.dateOfReturn = Date.valueOf(LocalDate.now());
    }

    private final Date dateOfReturn;
    private Long rentId;
    private Long employeeId;

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public Long getRentId() {
        return rentId;
    }

    public ReturnForm setRentId(Long rentId) {
        this.rentId = rentId;
        return this;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public ReturnForm setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }
}

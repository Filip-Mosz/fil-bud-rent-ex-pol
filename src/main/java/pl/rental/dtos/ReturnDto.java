package pl.rental.dtos;

import java.sql.Date;

public class ReturnDto {

    private Long id;
    private RentDto rentId;
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

    public RentDto getRentId() {
        return rentId;
    }

    public ReturnDto setRentId(RentDto rentId) {
        this.rentId = rentId;
        return this;
    }
}

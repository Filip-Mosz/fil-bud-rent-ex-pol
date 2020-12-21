package pl.rental.dtos;

import java.util.List;

public class RentalDto {

    String companyName;
    String website;
    String address;
    EmployeeDto ceo;
    List<EmployeeDto> employees;

    public RentalDto() {
    }

    public RentalDto(String companyName, String website, String address, EmployeeDto ceo, List<EmployeeDto> employees) {
        this.companyName = companyName;
        this.website = website;
        this.address = address;
        this.ceo = ceo;
        this.employees = employees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public RentalDto setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public RentalDto setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public RentalDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public EmployeeDto getCeo() {
        return ceo;
    }

    public RentalDto setCeo(EmployeeDto ceo) {
        this.ceo = ceo;
        return this;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public RentalDto setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
        return this;
    }
}

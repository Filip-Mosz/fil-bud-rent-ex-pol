package pl.rental.dtos;

import java.util.List;

public class RentalDto {
    String companyName;
    String website;
    String address;
    EmployeeDto ceo;
    List<EmployeeDto> employees;
}

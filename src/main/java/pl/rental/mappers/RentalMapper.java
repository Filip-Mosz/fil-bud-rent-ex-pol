package pl.rental.mappers;

import pl.rental.dtos.EmployeeDto;
import pl.rental.dtos.RentalDto;
import pl.rental.entities.RentalEntity;

import java.util.List;

public class RentalMapper {

    public static RentalDto toDto(RentalEntity entity){
//        EmployeeDto ceo = new EmployeeDto()
//                .setName(entity.getCeo().getName())
//                .setPosition(entity.getCeo().getPosition())
//                .setSurname(entity.getCeo().getSurname());
        // TODO: 30.12.2020 remove after green test

        EmployeeDto ceo = EmployeeMapper.toDto(entity.getCeo());

        List<EmployeeDto> employees = List.of();
        //stream of employees + use static EmployeeMapper method to transfer employeeDto to EmployeeEntity

        return new RentalDto()
                .setAddress(entity.getAddress())
                .setCompanyName(entity.getCompanyName())
                .setWebsite(entity.getWebsite())
                .setCeo(ceo)
                .setEmployees(employees);
    }

}
//Todo skonsultować konstrukcję metody toDto z Grzegorzem W.

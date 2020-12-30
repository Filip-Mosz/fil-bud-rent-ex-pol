package pl.rental.mappers;

import pl.rental.dtos.EmployeeDto;
import pl.rental.dtos.RentalDto;
import pl.rental.entities.EmployeeEntity;
import pl.rental.entities.RentalEntity;

import java.util.LinkedList;
import java.util.List;

public class RentalMapper {

    public static RentalDto toDto(RentalEntity entity) {

        EmployeeDto ceo = EmployeeMapper.toDto(entity.getCeo());

        List<EmployeeDto> employees = getEmployeeDtoList(entity);

        return new RentalDto()
                .setAddress(entity.getAddress())
                .setCompanyName(entity.getCompanyName())
                .setWebsite(entity.getWebsite())
                .setCeo(ceo)
                .setEmployees(employees);
    }

    public static RentalEntity toEntity(RentalDto dto){

        EmployeeEntity ceo = EmployeeMapper.toEntity(dto.getCeo());

        List<EmployeeEntity> employees = getEmployeeEntityList(dto);

        return new RentalEntity()
                .setAddress(dto.getAddress())
                .setCompanyName(dto.getCompanyName())
                .setWebsite(dto.getWebsite())
                .setCeo(ceo)
                .setEmployees(employees);
    }


    private static List<EmployeeDto> getEmployeeDtoList(RentalEntity entity) {
        List<EmployeeDto> employees = new LinkedList<>();
        entity.getEmployees().forEach(
                eDto -> employees.add(EmployeeMapper.toDto(eDto))
        );
        return employees;
        //tested and green; yet i still have doubts
    }

    private static List<EmployeeEntity> getEmployeeEntityList(RentalDto dto) {
        List<EmployeeEntity> employees = new LinkedList<>();
        dto.getEmployees().forEach(
                eEnt -> employees.add(EmployeeMapper.toEntity(eEnt))
        );
        return employees;
    }

}
//Todo skonsultować konstrukcję metody toDto z Grzegorzem W.

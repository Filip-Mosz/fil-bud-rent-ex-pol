package pl.rental.mappers;

import org.junit.jupiter.api.Test;
import pl.rental.dtos.EmployeeDto;
import pl.rental.dtos.RentalDto;
import pl.rental.entities.EmployeeEntity;
import pl.rental.entities.RentalEntity;
import pl.rental.enums.PositionEnum;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RentalMapperTest {

        EmployeeEntity empEnt1 = new EmployeeEntity()
                .setName("Jan")
                .setSurname("Kowalski")
                .setPosition(PositionEnum.REGULAR.toString());
        EmployeeEntity empEnt2 = new EmployeeEntity()
                .setName("Janina")
                .setSurname("Nowak")
                .setPosition(PositionEnum.CEO.toString());

        EmployeeDto empDto1 = new EmployeeDto()
                .setName("Jan")
                .setSurname("Kowalski")
                .setPosition(PositionEnum.REGULAR.toString());
        EmployeeDto empDto2 = new EmployeeDto()
                .setName("Janina")
                .setSurname("Nowak")
                .setPosition(PositionEnum.CEO.toString());

        List<EmployeeEntity> employeeEntities = List.of(empEnt1,empEnt2);
        List<EmployeeDto> employeeDTOs = List.of(empDto1,empDto2);

    @Test
    void getEmployeeDtoList() {
        //given
        RentalEntity rentalEntity = new RentalEntity();
        rentalEntity
                .setAddress("Neverland")
                .setCeo(empEnt2)
                .setCompanyName("Narnia")
                .setEmployees(employeeEntities);
        //when
        //then
        assertEquals( RentalMapper.toDto(rentalEntity).getEmployees().size(), 2);
        assertEquals( RentalMapper.toDto(rentalEntity).getEmployees().get(1).getName(), employeeDTOs.get(1).getName());

        assertNotEquals( RentalMapper.toDto(rentalEntity).getEmployees().get(1).getName(), employeeDTOs.get(0).getName());
    }

    @Test
    void getEmployeeEntityList() {
        //given
        RentalDto rentalDto = new RentalDto();
        rentalDto
                .setAddress("Neverland")
                .setCeo(empDto2)
                .setCompanyName("Narnia")
                .setEmployees(employeeDTOs);
        //when
        //then
        assertEquals( RentalMapper.toEntity(rentalDto).getEmployees().size(), 2);
        assertEquals( RentalMapper.toEntity(rentalDto).getEmployees().get(1).getName(), employeeDTOs.get(1).getName());

        assertNotEquals( RentalMapper.toEntity(rentalDto).getEmployees().get(1).getName(), employeeDTOs.get(0).getName());
    }


}
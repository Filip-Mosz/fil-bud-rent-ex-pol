package pl.rental.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.rental.entities.EmployeeEntity;
import pl.rental.entities.RentalEntity;
import pl.rental.enums.PositionEnum;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RentalMapperTest {



        EmployeeEntity empEnt1 = new EmployeeEntity()
                .setName("Jan")
                .setSurname("Kowalski")
                .setPosition(PositionEnum.REGULAR.toString());
        EmployeeEntity empEnt2 = new EmployeeEntity()
                .setName("Janina")
                .setSurname("Nowak")
                .setPosition(PositionEnum.CEO.toString());

        EmployeeEntity empDto1 = new EmployeeEntity()
                .setName("Jan")
                .setSurname("Kowalski")
                .setPosition(PositionEnum.REGULAR.toString());
        EmployeeEntity empDto2 = new EmployeeEntity()
                .setName("Janina")
                .setSurname("Nowak")
                .setPosition(PositionEnum.CEO.toString());

        List<EmployeeEntity> employeeEntities = List.of(empEnt1,empEnt2);
        List<EmployeeEntity> employeeDTOs = List.of(empDto1,empDto2);

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


}
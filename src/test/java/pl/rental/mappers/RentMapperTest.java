package pl.rental.mappers;

import org.junit.jupiter.api.Test;
import pl.rental.dtos.ClientDto;
import pl.rental.dtos.EmployeeDto;
import pl.rental.dtos.EquipmentDto;
import pl.rental.dtos.RentDto;
import pl.rental.entities.ClientEntity;
import pl.rental.entities.EmployeeEntity;
import pl.rental.entities.EquipmentEntity;
import pl.rental.entities.RentEntity;
import pl.rental.enums.PositionEnum;
import pl.rental.enums.StatusEnum;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentMapperTest {

    RentDto commissionDto = new RentDto()
            .setDateOfRent(new Date(2020 - 12 - 14))
            .setEstimatedDateOfReturn(new Date(2020 - 12 - 18))
            .setClientId(
                    new ClientDto("Roman", "Romawov", null, "Narnia", null)
            )
            .setEmployeeId(
                    new EmployeeDto("Jan", "Kowalski", PositionEnum.REGULAR.toString())
            )
            .setMachineId(
                    new EquipmentDto("Makiła", "XXL", "Zagęszczarka do betonu", StatusEnum.AVAILABLE.toString(), 15L)
            );

    RentEntity commissionEntity = new RentEntity()
            .setDateOfRent(new Date(2020 - 12 - 14))
            .setEstimatedDateOfReturn(new Date(2020 - 12 - 18))
            .setClientId(
                    new ClientEntity(null, "Roman", "Romawov", null, "Narnia", null)
            )
            .setEmployeeId(
                    new EmployeeEntity(null, "Jan", "Kowalski", PositionEnum.REGULAR.toString())
            )
            .setMachineId(
                    new EquipmentEntity(null, "Makiła", "XXL", "Zagęszczarka do betonu", StatusEnum.AVAILABLE.toString(), 15L)
            );

    @Test
    void toEntityTest() {
        //given
        //when
        RentEntity testEntity = RentMapper.toEntity(commissionDto);
        //then
        assertEquals(testEntity.getEstimatedDateOfReturn(), commissionEntity.getEstimatedDateOfReturn());
        assertEquals(testEntity.getEmployeeId().getName(), commissionEntity.getEmployeeId().getName());
        assertEquals(testEntity.getClientId().getSurname(), commissionEntity.getClientId().getSurname());

    }

    @Test
    void toDtoTest() {
//given
        //when
        RentDto testDto = RentMapper.toDto(commissionEntity);
        //then
        assertEquals(testDto.getEstimatedDateOfReturn(), commissionDto.getEstimatedDateOfReturn());
        assertEquals(testDto.getEmployeeId().getName(), commissionDto.getEmployeeId().getName());
        assertEquals(testDto.getClientId().getSurname(), commissionDto.getClientId().getSurname());

    }
}

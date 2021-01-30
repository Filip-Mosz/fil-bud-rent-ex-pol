package pl.rental.mappers;

import org.junit.jupiter.api.Test;
import pl.rental.dtos.ClientDto;
import pl.rental.dtos.EmployeeDto;
import pl.rental.dtos.EquipmentDto;
import pl.rental.dtos.ReturnDto;
import pl.rental.entities.ClientEntity;
import pl.rental.entities.EmployeeEntity;
import pl.rental.entities.EquipmentEntity;
import pl.rental.entities.ReturnEntity;
import pl.rental.enums.PositionEnum;
import pl.rental.enums.StatusEnum;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ReturnMapperTest {

    ReturnDto testReturnDto = new ReturnDto()
            .setEmployeeId(
                    new EmployeeDto("Jan", "Kowalski", PositionEnum.REGULAR.toString())
            )
            .setDateOfReturn(new Date(121, 0, 4))
            .setDelayInDays(0L);

    ReturnEntity testReturnEntity = new ReturnEntity()
            .setMachineId(
                    new EquipmentEntity(null, "Makiła", "XXL", "Zagęszczarka do betonu", StatusEnum.AVAILABLE.toString(), 15L)
            )
            .setClientId(
                    new ClientEntity(null, "Roman", "Romawov", null, "Narnia", null)
            )
            .setEmployeeId(
                    new EmployeeEntity(null, "Jan", "Kowalski", PositionEnum.REGULAR.toString())
            )
            .setDateOfReturn(new Date(121, 0, 4))
            .setDelayInDays(0L);

    @Test
    void toEntityTest() {
        //given
        //when
        ReturnEntity test = ReturnMapper.toEntity(testReturnDto);
        //then
        assertEquals(test.getDateOfReturn(),testReturnEntity.getDateOfReturn());
        assertEquals(test.getMachineId().getStatus(),testReturnEntity.getMachineId().getStatus());
        assertEquals(test.getEmployeeId(),testReturnEntity.getEmployeeId());
    }

    @Test
    void toDtoTest() {
        //given
        //when
        ReturnDto test = ReturnMapper.toDto(testReturnEntity);
        //then
        assertEquals(test.getDateOfReturn(),testReturnDto.getDateOfReturn());
        assertEquals(test.getDelayInDays(),testReturnDto.getDelayInDays());
    }
}

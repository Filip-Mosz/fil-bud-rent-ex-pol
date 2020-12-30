package pl.rental.mappers;

import pl.rental.dtos.EmployeeDto;
import pl.rental.entities.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeDto toDto(EmployeeEntity entity){
        return new EmployeeDto()
                .setName(entity.getName())
                .setSurname(entity.getSurname())
                .setPosition(entity.getPosition());
    }

    public static EmployeeEntity toEntity(EmployeeDto dto) {
        return new EmployeeEntity()
                .setName(dto.getName())
                .setSurname(dto.getSurname())
                .setPosition(dto.getPosition());
    }

}

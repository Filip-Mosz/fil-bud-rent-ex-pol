package pl.rental.mappers;

import pl.rental.dtos.ReturnDto;
import pl.rental.entities.ReturnEntity;

public class ReturnMapper {

    public static ReturnDto toDto(ReturnEntity entity){
        return new ReturnDto()
                .setMachineId(EquipmentMapper.toDto(entity.getMachineId()))
                .setClientId(ClientMapper.toDto(entity.getClientId()))
                .setEmployeeId(EmployeeMapper.toDto(entity.getEmployeeId()))
                .setDateOfReturn(entity.getDateOfReturn())
                .setDelayInDays(entity.getDelayInDays());
    }

    public static ReturnEntity toEntity(ReturnDto dto){
        return new ReturnEntity()
                .setMachineId(EquipmentMapper.toEntity(dto.getMachineId()))
                .setClientId(ClientMapper.toEntity(dto.getClientId()))
                .setEmployeeId(EmployeeMapper.toEntity(dto.getEmployeeId()))
                .setDateOfReturn(dto.getDateOfReturn())
                .setDelayInDays(dto.getDelayInDays());
    }

}

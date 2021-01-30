package pl.rental.mappers;

import pl.rental.dtos.EquipmentDto;
import pl.rental.entities.EquipmentEntity;

public class EquipmentMapper {

    public static EquipmentDto toDto(EquipmentEntity entity) {
        return new EquipmentDto()
                .setBrand(entity.getBrand())
                .setModel(entity.getModel())
                .setPrizeForDay(entity.getPrizeForDay())
                .setType(entity.getType())
                .setStatus(entity.getStatus())
                .setId(entity.getId());
    }

    public static EquipmentEntity toEntity(EquipmentDto dto){
        return new EquipmentEntity()
                .setBrand(dto.getBrand())
                .setModel(dto.getModel())
                .setPrizeForDay(dto.getPrizeForDay())
                .setType(dto.getType())
                .setStatus(dto.getStatus())
                .setId(dto.getId());
    }

}

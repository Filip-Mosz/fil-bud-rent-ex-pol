package pl.rental.mappers;

import pl.rental.dtos.ClientDto;
import pl.rental.dtos.EquipmentDto;
import pl.rental.entities.ClientEntity;
import pl.rental.entities.EquipmentEntity;

public class ClientMapper {

    public static ClientDto toDto(ClientEntity entity) {
        return new ClientDto()
                .setAddress(entity.getAddress())
                .setName(entity.getName())
                .setSurname(entity.getSurname())
                .setEmail(entity.getEmail())
                .setCompany(entity.getCompany());

    }

    public static ClientEntity toEntity(ClientDto dto) {
        return new ClientEntity()
                .setAddress(dto.getAddress())
                .setName(dto.getName())
                .setSurname(dto.getSurname())
                .setEmail(dto.getEmail())
                .setCompany(dto.getCompany());
    }

}

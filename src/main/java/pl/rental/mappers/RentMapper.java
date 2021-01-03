package pl.rental.mappers;

import pl.rental.dtos.RentDto;
import pl.rental.entities.RentEntity;

public class RentMapper {

    public static RentDto toDto(RentEntity entity){

        return new RentDto()
                .setClientId(ClientMapper.toDto(entity.getClientId()))
                .setDateOfRent(entity.getDateOfRent())
                .setEmployeeId(EmployeeMapper.toDto(entity.getEmployeeId()))
                .setEstimatedDateOfReturn(entity.getEstimatedDateOfReturn())
                .setMachineId(EquipmentMapper.toDto(entity.getMachineId()));

    }

    public static RentEntity toEntity(RentDto dto){

        return new RentEntity()
                .setClientId(ClientMapper.toEntity(dto.getClientId()))
                .setDateOfRent(dto.getDateOfRent())
                .setEmployeeId(EmployeeMapper.toEntity(dto.getEmployeeId()))
                .setEstimatedDateOfReturn(dto.getEstimatedDateOfReturn())
                .setMachineId(EquipmentMapper.toEntity(dto.getMachineId()));

    }

}
//@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne
//    private EquipmentEntity machineId;
//
//    @OneToOne
//    private ClientEntity clientId;
//
//    @OneToOne
//    private EmployeeEntity employeeId;
//
//    private Date dateOfRent;
//    private Date estimatedDateOfReturn;

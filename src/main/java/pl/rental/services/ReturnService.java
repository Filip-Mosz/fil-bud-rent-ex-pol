package pl.rental.services;

import org.springframework.stereotype.Service;
import pl.rental.dtos.ReturnForm;
import pl.rental.entities.*;
import pl.rental.enums.StatusEnum;
import pl.rental.repositories.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class ReturnService {
    // TODO: 30.01.2021 UNIT TESTS

    public ReturnService(EquipmentRepository equipmentRepository, EmployeeRepository employeeRepository, ClientRepository clientRepository, RentRepository rentRepository) {
        this.equipmentRepository = equipmentRepository;
        this.employeeRepository = employeeRepository;
        this.clientRepository = clientRepository;
        this.rentRepository = rentRepository;
    }

    private final EquipmentRepository equipmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ClientRepository clientRepository;
    private final RentRepository rentRepository;

    public void returnEquipment(EquipmentEntity machine) {
        Optional<EquipmentEntity> foundMachine = equipmentRepository.findById(machine.getId());
        EquipmentEntity returnedMachine = foundMachine.orElseGet(EquipmentEntity::new);
        returnedMachine.setStatus(StatusEnum.AVAILABLE.toString());
        equipmentRepository.save(returnedMachine);
    }

    public ReturnEntity createReturn(ReturnForm returnForm) { //zwraca co ma; nie "naprawiać"
        RentEntity rentId;
        EquipmentEntity machineId;
        EmployeeEntity employeeId;
        ClientEntity clientId;
        Date dateOfReturn;
        Long delayInDays;

        Optional<RentEntity> currentRent = rentRepository.findById(returnForm.getRentId());
        if (currentRent.isPresent()) {
            rentId = currentRent.get();
            machineId = currentRent.get().getMachineId();
            dateOfReturn = currentRent.get().getEstimatedDateOfReturn();
            delayInDays = getDatesDifference(dateOfReturn);
            Optional<ClientEntity> clientIdSupply = clientRepository.findById(currentRent.get().getClientId().getId());
            clientId = clientIdSupply.orElseGet(ClientEntity::new);

        } else {
            rentId = null;
            machineId = null;
            dateOfReturn = null;
            delayInDays = null;
            clientId = null;
        }

        Optional<EmployeeEntity> employeeIdSupply = employeeRepository.findById(returnForm.getEmployeeId());
        employeeId = employeeIdSupply.orElseThrow();

        return new ReturnEntity()
                .setRentId(rentId)
                .setMachineId(machineId)
                .setEmployeeId(employeeId)
                .setClientId(clientId)
                .setDateOfReturn(dateOfReturn)
                .setDelayInDays(delayInDays)
                ;
    }

    private Long getDatesDifference(Date dateOfReturn) {

        if (LocalDate.now().isAfter(dateOfReturn.toLocalDate())) {
            //manual test green
            LocalDate convertedDateOfReturn = dateOfReturn.toLocalDate();
            return ChronoUnit.DAYS.between(convertedDateOfReturn, LocalDate.now());
        }

        return 0L;
    }

}

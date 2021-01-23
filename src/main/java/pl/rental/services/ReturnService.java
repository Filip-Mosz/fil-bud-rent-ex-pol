package pl.rental.services;

import org.springframework.stereotype.Service;
import pl.rental.dtos.ReturnForm;
import pl.rental.entities.*;
import pl.rental.enums.StatusEnum;
import pl.rental.repositories.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

@Service
public class ReturnService {

    public ReturnService(ReturnRepository returnRepository, ClientService clientService, EquipmentRepository equipmentRepository, EmployeeRepository employeeRepository, ClientRepository clientRepository, RentRepository rentRepository) {
        this.returnRepository = returnRepository;
        this.clientService = clientService;
        this.equipmentRepository = equipmentRepository;
        this.employeeRepository = employeeRepository;
        this.clientRepository = clientRepository;
        this.rentRepository = rentRepository;
    }

    private final ReturnRepository returnRepository;
    private final ClientService clientService;
    private final EquipmentRepository equipmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ClientRepository clientRepository;
    private final RentRepository rentRepository;

    public ReturnEntity createReturnEntity(ReturnForm form) {
        if (form.getRentId() != null) {
            return returnRepository.getOne(form.getRentId());
        }

        //        return returnRepository.findFirstByNameAndSurname(form.getName(), form.getSurname());
//        1.znaleźć klienta
//        2.przez id klienta znaleźć ostatni wynajem bez pasującego zwrotu
        ClientEntity foundClient = clientService.identifyClient(form);
        if (foundClient.getName() == null) {
            return new ReturnEntity();
        }

        return returnRepository.getOne(foundClient.getId());
    }

    public void returnEquipment(EquipmentEntity machine) {
        Optional<EquipmentEntity> foundMachine = equipmentRepository.findById(machine.getId());
        EquipmentEntity returnedMachine = foundMachine.orElseGet(EquipmentEntity::new);
        returnedMachine.setStatus(StatusEnum.AVAILABLE.toString());
        equipmentRepository.save(returnedMachine);
    }

    public ReturnEntity createReturn(ReturnForm returnForm) {
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

            Optional<EquipmentEntity> machineThing = equipmentRepository.findById(machineId.getId());
            machineThing.ifPresent(this::returnEquipment);
            Optional<EquipmentEntity> rentedMachine = equipmentRepository.findById(machineId.getId());
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

        if (LocalDate.now().isAfter(dateOfReturn.toLocalDate()))   {
            //i tu odejmujemy daty

            LocalDate convertedDateOfReturn = dateOfReturn.toLocalDate();
            return ChronoUnit.DAYS.between(convertedDateOfReturn, LocalDate.now());
        }

        return 0L;
    }

}

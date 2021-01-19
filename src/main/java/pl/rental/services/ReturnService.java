package pl.rental.services;

import org.springframework.stereotype.Service;
import pl.rental.dtos.ReturnForm;
import pl.rental.entities.ClientEntity;
import pl.rental.entities.RentEntity;
import pl.rental.entities.ReturnEntity;
import pl.rental.repositories.ClientRepository;
import pl.rental.repositories.RentRepository;
import pl.rental.repositories.ReturnRepository;

import java.util.LinkedList;
import java.util.List;

@Service
public class ReturnService {

    public ReturnService(ReturnRepository returnRepository, ClientRepository clientRepository, RentRepository rentRepository, ClientService clientService) {
        this.returnRepository = returnRepository;
        this.clientRepository = clientRepository;
        this.rentRepository = rentRepository;
        this.clientService = clientService;
    }

    private final ReturnRepository returnRepository;
    private final ClientRepository clientRepository;
    private final RentRepository rentRepository;
    private final ClientService clientService;

    List<ReturnEntity> returnsOfUser = new LinkedList<>();
    List<RentEntity> rentsOfUser = new LinkedList<>();

    public ReturnEntity createReturnEntity(ReturnForm form) {
        if (form.getRentId() != null) {
            return returnRepository.getOne(form.getRentId());
        }

        //        return returnRepository.findFirstByNameAndSurname(form.getName(), form.getSurname());
//        1.znaleźć klienta
//        2.przez id klienta znaleźć ostatni wynajem bez pasującego zwrotu
        ClientEntity foundClient = clientService.identifyClient(form);
        if (foundClient.getName() == null){
            return new ReturnEntity();
        }

        return returnRepository.getOne(foundClient.getId());
    }


}

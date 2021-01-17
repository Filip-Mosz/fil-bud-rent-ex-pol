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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReturnService {

    public ReturnService(ReturnRepository returnRepository, ClientRepository clientRepository, RentRepository rentRepository) {
        this.returnRepository = returnRepository;
        this.clientRepository = clientRepository;
        this.rentRepository = rentRepository;
    }

    private final ReturnRepository returnRepository;
    private final ClientRepository clientRepository;
    private final RentRepository rentRepository;

    List<ReturnEntity> returnsOfUser = new LinkedList<>();
    List<RentEntity> rentsOfUser = new LinkedList<>();

    public ReturnEntity createReturnEntity(ReturnForm form) {
        if (form.getRentId() != null) {
            return returnRepository.getOne(form.getRentId());
        }

        //        return returnRepository.findFirstByNameAndSurname(form.getName(), form.getSurname());
//        1.znaleźć klienta
//        2.przez id klienta znaleźć ostatni wynajem bez pasującego zwrotu
        ClientEntity foundClient = identifyClient(form);
        if (foundClient.getName() == null){
            return new ReturnEntity();
        }

        return returnRepository.getOne(foundClient.getId());
    }

    private ClientEntity identifyClient(ReturnForm form) {

        LinkedList<ClientEntity> potentialClients = (LinkedList<ClientEntity>) clientRepository.findAllByNameAndSurname(form.getName(), form.getSurname());
        if (potentialClients == null){
            return new ClientEntity();
        }
        if (potentialClients.size() == 1) {
            return potentialClients.get(0);
        }
        else if (potentialClients.size() > 1) {

            for (int i = 0; i < potentialClients.size(); i++) {
                Optional<RentEntity> rentsByClientId = rentRepository.getAllByClientId(potentialClients.get(i).getId());
                Optional<ReturnEntity> returnsByClientId = returnRepository.getAllByClientId(potentialClients.get(i).getId());
                rentsByClientId.ifPresent(c -> rentsOfUser = (List<RentEntity>) Collectors.toList());
                returnsByClientId.ifPresent(c -> returnsOfUser = (List<ReturnEntity>) Collectors.toList());

                if (returnsOfUser.size() < rentsOfUser.size()) {
//technically at this point potentialClients cannot be null
                    return potentialClients.get(i);
                }

            }

            return new ClientEntity();
        }
        return new ClientEntity();
    }

}

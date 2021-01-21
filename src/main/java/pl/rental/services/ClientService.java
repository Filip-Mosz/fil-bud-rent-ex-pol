package pl.rental.services;

import org.springframework.stereotype.Service;
import pl.rental.dtos.RentForm;
import pl.rental.dtos.ReturnForm;
import pl.rental.entities.ClientEntity;
import pl.rental.repositories.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private final ClientRepository clientRepository;

    public ClientEntity identifyClient(ReturnForm form) {
        if (form.getClientId() != null) {
            Optional<ClientEntity> foundClient = clientRepository.findById(form.getClientId());

            if (foundClient.isPresent()) {
                return foundClient.orElseGet(ClientEntity::new);
            }
        }

        return new ClientEntity();
        //todo searching by client's name and surname later
    }

    public ClientEntity identifyClient(RentForm form) {
        if (form.getClientId() != null) {
            Optional<ClientEntity> foundClient = clientRepository.findById(form.getClientId());
//            ok - null-free
            return foundClient.orElseGet(ClientEntity::new);

        }

        return new ClientEntity();
        //todo searching by client's name and surname later
    }
}

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
public class ClientService {

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private final ClientRepository clientRepository;

    ClientEntity identifyClient(ReturnForm form) {
        if (form.getClientId() != null){
            Optional<ClientEntity> foundClient = clientRepository.findById(form.getClientId());

            if (foundClient.isPresent()){
                return foundClient.orElseGet(ClientEntity::new);
            }
        }

        return new ClientEntity();
    }
}

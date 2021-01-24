package pl.rental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rental.dtos.RentForm;
import pl.rental.entities.EquipmentEntity;
import pl.rental.entities.RentEntity;
import pl.rental.repositories.RentRepository;
import pl.rental.services.RentService;

import java.util.List;
import java.util.Optional;

@Controller
public class RentsController {

    public RentsController(RentService rentService, RentRepository rentRepository) {
        this.rentService = rentService;
        this.rentRepository = rentRepository;
    }

    private final RentService rentService;
    private final RentRepository rentRepository;

    @GetMapping("/rents")
    public String getRents(Model model, RentForm rentForm) {

        List<EquipmentEntity> machines = rentService.getAll();

        model.addAttribute("rentForm", rentForm);
        model.addAttribute("equipments", machines);

        return "/rents";
    }

    @PostMapping("/rents")
    public RentForm createRent(RentForm rentForm, Model model) {
        List<EquipmentEntity> machines = rentService.getAll();
        model.addAttribute("rentForm", rentForm);
        model.addAttribute("equipments", machines);
//        właściwie wchodzi z formularza
        RentEntity newRent = rentRepository.save(rentService.createRent(rentForm));

        Optional<RentEntity> singleRent = rentRepository.findById(newRent.getId());
        model.addAttribute("rent", singleRent);
        model.addAttribute("newRent", newRent);
        System.out.println("RentForm wszedł");
        return rentForm;
    }

}

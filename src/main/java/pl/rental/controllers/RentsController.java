package pl.rental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rental.entities.EquipmentEntity;
import pl.rental.services.RentService;

import java.util.List;

@Controller
public class RentsController {

    public RentsController(RentService rentService) {
        this.rentService = rentService;
    }

    private final RentService rentService;

    @GetMapping("/rents")
    public String getRents(Model model){

        List<EquipmentEntity> machines = rentService.getAll();

        model.addAttribute("equipments", machines);

        return "/rents";
    }
}

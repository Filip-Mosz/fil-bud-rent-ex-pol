package pl.rental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rental.dtos.ReturnForm;
import pl.rental.entities.ReturnEntity;
import pl.rental.repositories.ReturnRepository;
import pl.rental.services.ReturnService;

import java.util.List;
import java.util.Optional;

@Controller
class ReturnsController {
    public ReturnsController(ReturnRepository returnRepository, ReturnService returnService) {
        this.returnRepository = returnRepository;
        this.returnService = returnService;
    }

    private final ReturnRepository returnRepository;
    private final ReturnService returnService;

    @GetMapping("/returns")
    public String getReturns(Model model, ReturnForm returnForm) {
        List<ReturnEntity> returnEntityList = returnRepository.findAll();

        model.addAttribute("returnForm", returnForm);
        model.addAttribute("returnsList", returnEntityList);

        return "returns";
    }


    @PostMapping("/returns")
    public ReturnForm newReturnForm(@ModelAttribute ReturnForm returnForm, Model model){
        model.addAttribute("returnForm", returnForm);
        ReturnEntity newReturn = returnRepository.save(returnService.createReturn(returnForm));

        Optional<ReturnEntity> singleReturn = returnRepository.findById(newReturn.getId());
        model.addAttribute("return", singleReturn);
        return returnForm;
    }
//public RentForm findClient( RentForm rentForm, Model model) {
//        List<EquipmentEntity> machines = rentService.getAll();
//        model.addAttribute("rentForm", rentForm);
//        model.addAttribute("equipments", machines);
////        właściwie wchodzi z formularza
//        RentEntity newRent = rentRepository.save(rentService.createRent(rentForm));
//
//        Optional<RentEntity> singleRent = rentRepository.findById(newRent.getId());
//        model.addAttribute("rent", singleRent);
//        model.addAttribute("newRent", newRent);
//        return rentForm;
//    }


}

package pl.rental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rental.dtos.ReturnForm;
import pl.rental.entities.ReturnEntity;
import pl.rental.repositories.ReturnRepository;

import java.util.List;

@Controller
class ReturnsController {
    public ReturnsController(ReturnRepository returnRepository) {
        this.returnRepository = returnRepository;
    }

    private final ReturnRepository returnRepository;

    @GetMapping("/returns")
    public String getReturns(Model model, ReturnForm returnForm) {
        List<ReturnEntity> returnEntityList = returnRepository.findAll();

//        model.addAttribute("ListOfClients", clientsList);
        model.addAttribute("returnForm", returnForm);

        return "returns";
    }

    @PostMapping("/returns")
    public ReturnForm newReturnForm(@ModelAttribute ReturnForm returnForm, Model model){
        model.addAttribute("returnForm", returnForm);

        return returnForm;
    }


}

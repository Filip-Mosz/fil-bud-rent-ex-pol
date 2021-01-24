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

    Long newReturnId = 0L;

    @GetMapping("/returns")
    public String getReturns(Model model) {
        List<ReturnEntity> returnEntityList = returnRepository.findAll();
        ReturnEntity lastReturn = returnRepository.findById(newReturnId).orElseGet(ReturnEntity::new);

        model.addAttribute("returnForm", new ReturnForm());
        model.addAttribute("returnsList", returnEntityList);
        model.addAttribute("lastReturn", lastReturn);

        return "returns";
    }


    @PostMapping("/returns")
    public String newReturnForm(@ModelAttribute ReturnForm returnForm, Model model){
        model.addAttribute("returnForm", returnForm);
        ReturnEntity newReturn = returnRepository.save(returnService.createReturn(returnForm));
        newReturnId = newReturn.getId();
        List<ReturnEntity> returnEntityList = returnRepository.findAll();
        model.addAttribute("returnsList", returnEntityList);

        Optional<ReturnEntity> singleReturn = returnRepository.findById(newReturn.getId());
        model.addAttribute("return", singleReturn);
        return "redirect:/returns";
    }

}

package pl.rental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentsController {

    @GetMapping("/rents")
    public String getRents(){
        return "/rents";
    }
}

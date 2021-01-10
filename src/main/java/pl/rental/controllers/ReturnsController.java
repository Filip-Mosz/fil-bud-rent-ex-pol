package pl.rental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ReturnsController {

    @GetMapping("/returns")
    public String getReturns(){
        return "returns";
    }
}

package fr.limayrac.ecommerce.controller;

import fr.limayrac.ecommerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/inscription")
    public String inscription() {
        return "register";
    }

    @PostMapping("/inscription")
    public String performInscription(@RequestParam String username,
                                     @RequestParam String password) {
        clientService.createClient(username, password);

        return "redirect:/login";
    }
}

package fr.limayrac.ecommerce.controller;

import fr.limayrac.ecommerce.model.Client;
import fr.limayrac.ecommerce.service.ClientService;
import fr.limayrac.ecommerce.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class CompteController {

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/mon-compte")
    public String getCompte(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<Client> client = clientService.getClientByUsername(username);

        client.ifPresent(value ->
                model.addAttribute("commandes", commandeService.getCommandesByClient(value)));

        return "profil";
    }
}

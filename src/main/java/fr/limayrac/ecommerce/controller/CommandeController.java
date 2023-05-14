package fr.limayrac.ecommerce.controller;

import fr.limayrac.ecommerce.model.Client;
import fr.limayrac.ecommerce.model.Commande;
import fr.limayrac.ecommerce.model.CommandeDetail;
import fr.limayrac.ecommerce.model.Product;
import fr.limayrac.ecommerce.service.ClientService;
import fr.limayrac.ecommerce.service.CommandeDetailService;
import fr.limayrac.ecommerce.service.CommandeService;
import fr.limayrac.ecommerce.utils.CartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CommandeController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private CommandeDetailService commandeDetailService;

    @PostMapping("/commander")
    public String performCommande(HttpServletRequest request) {
        List<Product> productsSession = CartUtils.getCartInSession(request).getProducts();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<Client> client = clientService.getClientByUsername(username);

        if (client.isPresent()) {
            Commande commande = Commande.builder()
                    .client(client.get())
                    .build();
            commande = commandeService.save(commande);

            for (Product product : productsSession) {
                CommandeDetail commandeDetail = CommandeDetail.builder()
                        .commande(commande)
                        .produit(product)
                        .build();
                commandeDetailService.save(commandeDetail);
            }
        }

        return "redirect:/mon-compte";
    }

    @GetMapping("/commande/{id}")
    public String getCommandeById(@PathVariable Integer id,
                                  Model model) {
        List<CommandeDetail> commandeDetailsList = commandeDetailService.getCommandeDetailByCommandeId(id);
        List<Product> products = new ArrayList<>();

        for (CommandeDetail commandeDetail : commandeDetailsList) {
            products.add(commandeDetail.getProduit());
        }

        model.addAttribute("products", products);

        return "commande_detail";
    }
}

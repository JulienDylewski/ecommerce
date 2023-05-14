package fr.limayrac.ecommerce.service;

import fr.limayrac.ecommerce.model.Client;
import fr.limayrac.ecommerce.model.Commande;
import fr.limayrac.ecommerce.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    public List<Commande> getCommandesByClient(Client client) {
        return commandeRepository.findCommandesByClient(client);
    }

    public Optional<Commande> getCommandeById(final Integer id) {
        return commandeRepository.findById(id);
    }
}

package fr.limayrac.ecommerce.service;

import fr.limayrac.ecommerce.model.CommandeDetail;
import fr.limayrac.ecommerce.repository.CommandeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeDetailService {

    @Autowired
    private CommandeDetailRepository commandeDetailRepository;

    public void save(CommandeDetail commandeDetail) {
        commandeDetailRepository.save(commandeDetail);
    }

    public List<CommandeDetail> getCommandeDetailByCommandeId(final Integer commandeId) {
        return commandeDetailRepository.findCommandeDetailByCommandeId(commandeId);
    }
}

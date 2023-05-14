package fr.limayrac.ecommerce.repository;

import fr.limayrac.ecommerce.model.Client;
import fr.limayrac.ecommerce.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    List<Commande> findCommandesByClient(Client client);
}

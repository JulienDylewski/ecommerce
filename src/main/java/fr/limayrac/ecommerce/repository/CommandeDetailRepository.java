package fr.limayrac.ecommerce.repository;

import fr.limayrac.ecommerce.model.CommandeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDetailRepository extends JpaRepository<CommandeDetail, Integer> {
    List<CommandeDetail> findCommandeDetailByCommandeId(final Integer commandeId);

}

package fr.limayrac.ecommerce.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "commande_detail")
public class CommandeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_commande")
    private Commande commande;

    @OneToOne
    @JoinColumn(name = "id_produit")
    private Product produit;
}

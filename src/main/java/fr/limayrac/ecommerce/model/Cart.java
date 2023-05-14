package fr.limayrac.ecommerce.model;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart {

    private Integer id;

    private List<Product> products = new ArrayList<>();
}

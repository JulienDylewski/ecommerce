package fr.limayrac.ecommerce.controller;

import fr.limayrac.ecommerce.model.Cart;
import fr.limayrac.ecommerce.model.Product;
import fr.limayrac.ecommerce.service.ProductService;
import fr.limayrac.ecommerce.utils.CartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    private static final String REDIRECT_PANIER = "redirect:/panier";

    @PostMapping("/ajouterPanier")
    public String performAjoutPanier(HttpServletRequest request,
                                      @RequestParam(value = "code", defaultValue = "") Integer id) {

        Optional<Product> product = productService.getProduct(id);

        if (product.isPresent()) {
            Cart cart = CartUtils.getCartInSession(request);
            cart.getProducts().add(product.get());
        }

        return REDIRECT_PANIER;
    }
}

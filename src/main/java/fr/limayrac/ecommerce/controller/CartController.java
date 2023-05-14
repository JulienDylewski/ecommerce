package fr.limayrac.ecommerce.controller;

import fr.limayrac.ecommerce.model.Product;
import fr.limayrac.ecommerce.utils.CartUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CartController {

    private static final String REDIRECT_PANIER = "redirect:/panier";

    @GetMapping("/panier")
    public String getPanier(Model model,
                            HttpServletRequest request) {
        model.addAttribute("products", CartUtils.getCartInSession(request).getProducts());
        return "cart";
    }

    @PostMapping("/supprimerPanier")
    public String performSupprimerPanier(HttpServletRequest request,
                                         @RequestParam(value = "code", defaultValue = "") Integer id) {
        List<Product> productsSession = CartUtils.getCartInSession(request).getProducts();

        productsSession.removeIf(product -> product.getId().equals(id));

        CartUtils.getCartInSession(request).setProducts(productsSession);

        return REDIRECT_PANIER;
    }
}

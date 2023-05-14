package fr.limayrac.ecommerce.utils;

import fr.limayrac.ecommerce.model.Cart;

import javax.servlet.http.HttpServletRequest;

public class CartUtils {

    public static Cart getCartInSession(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        return cart;
    }
}

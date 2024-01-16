package ua.com.alevel.service.cart;

import ua.com.alevel.persistence.entity.cart.Cart;
import ua.com.alevel.persistence.entity.cart.CartEntry;

import java.util.List;

public interface CartService {

    void addProductToCart(Long productVariantId, int quantity);
    Cart getActive();
    List<CartEntry> getEntriesByCart(Cart cart);
}

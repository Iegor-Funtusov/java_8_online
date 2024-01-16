package ua.com.alevel.service.cart.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.exception.EntityNotFoundException;
import ua.com.alevel.persistence.entity.cart.Cart;
import ua.com.alevel.persistence.entity.cart.CartEntry;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.persistence.entity.user.Personal;
import ua.com.alevel.persistence.repositoty.cart.CartEntryRepository;
import ua.com.alevel.persistence.repositoty.cart.CartRepository;
import ua.com.alevel.persistence.repositoty.product.ProductVariantRepository;
import ua.com.alevel.persistence.repositoty.user.PersonalRepository;
import ua.com.alevel.service.cart.CartService;
import ua.com.alevel.util.SecurityUtil;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartEntryRepository cartEntryRepository;
    private final PersonalRepository personalRepository;
    private final ProductVariantRepository productVariantRepository;

    @Override
    public void addProductToCart(Long productVariantId, int quantity) {
        String username = SecurityUtil.getUsername();
        System.out.println("username = " + username);
        Personal personal = personalRepository
                .findByLogin(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Cart cart = null;
        Optional<Cart> optionalCart = cartRepository.findByPersonalAndActiveTrue(personal);
        if (optionalCart.isEmpty()) {
            cart = new Cart();
            cart.setPersonal(personal);
        } else {
            cart = optionalCart.get();
        }
        cart = cartRepository.save(cart);
        ProductVariant productVariant = productVariantRepository
                .findById(productVariantId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        CartEntry cartEntry = null;
        Optional<CartEntry> optionalCartEntry = cartEntryRepository.findByProductVariant(productVariant);
        if (optionalCartEntry.isEmpty()) {
            cartEntry = new CartEntry();
            cartEntry.setCart(cart);
            cartEntry.setProductVariant(productVariant);
            cartEntry.setQuantity(quantity);
        } else {
            cartEntry = optionalCartEntry.get();
            int currentQuantity = cartEntry.getQuantity();
            currentQuantity = currentQuantity + quantity;
            cartEntry.setQuantity(currentQuantity);
        }
        cartEntry = cartEntryRepository.save(cartEntry);
    }

    @Override
    public Cart getActive() {
        return null;
    }

    @Override
    public List<CartEntry> getEntriesByCart(Cart cart) {
        return null;
    }
}

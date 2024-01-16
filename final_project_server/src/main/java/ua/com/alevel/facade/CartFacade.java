package ua.com.alevel.facade;

import ua.com.alevel.api.dto.response.cart.CartDto;

public interface CartFacade {

    void addProductToCart(Long productVariantId, int quantity);
    CartDto getActive();
}

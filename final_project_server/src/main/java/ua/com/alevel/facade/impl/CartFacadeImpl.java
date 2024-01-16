package ua.com.alevel.facade.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.api.dto.response.cart.CartDto;
import ua.com.alevel.facade.CartFacade;
import ua.com.alevel.service.cart.CartService;

@Service
@RequiredArgsConstructor
public class CartFacadeImpl implements CartFacade {

    private final CartService cartService;

    @Override
    public void addProductToCart(Long productVariantId, int quantity) {
        cartService.addProductToCart(productVariantId, quantity);
    }

    @Override
    public CartDto getActive() {
        return null;
    }
}

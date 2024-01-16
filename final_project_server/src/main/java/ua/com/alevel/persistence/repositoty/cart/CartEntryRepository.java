package ua.com.alevel.persistence.repositoty.cart;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.cart.Cart;
import ua.com.alevel.persistence.entity.cart.CartEntry;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.persistence.repositoty.BaseRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartEntryRepository extends BaseRepository<CartEntry> {

    List<CartEntry> findByCart(Cart cart);
    Optional<CartEntry> findByProductVariant(ProductVariant productVariant);
}

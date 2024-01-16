package ua.com.alevel.persistence.repositoty.cart;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.cart.Cart;
import ua.com.alevel.persistence.entity.user.Personal;
import ua.com.alevel.persistence.repositoty.BaseRepository;

import java.util.Optional;

@Repository
public interface CartRepository extends BaseRepository<Cart> {

    Optional<Cart> findByPersonalAndActiveTrue(Personal personal);
}

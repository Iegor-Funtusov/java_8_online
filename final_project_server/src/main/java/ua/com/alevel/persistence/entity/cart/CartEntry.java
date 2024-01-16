package ua.com.alevel.persistence.entity.cart;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.product.ProductVariant;

@Getter
@Setter
@Entity
@Table(name = "cart_entries")
public class CartEntry extends BaseEntity {

    @ManyToOne
    private Cart cart;

    @OneToOne
    private ProductVariant productVariant;

    private Integer quantity;

    public CartEntry() {
        super();
        this.quantity = 1;
    }
}

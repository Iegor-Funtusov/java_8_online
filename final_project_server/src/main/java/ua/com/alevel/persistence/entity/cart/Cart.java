package ua.com.alevel.persistence.entity.cart;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.user.Personal;

@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart extends BaseEntity {

    @ManyToOne
    private Personal personal;

    private Boolean active;

    public Cart() {
        this.active = true;
    }
}

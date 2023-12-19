package ua.com.alevel.persistence.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.entity.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "product_colors")
public class ProductColor extends BaseEntity {

    @Column(nullable = false)
    private String color;
}

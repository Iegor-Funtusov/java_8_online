package ua.com.alevel.service.product;

import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductVariant;

import java.util.List;

public interface ProductVariantService {

    List<ProductVariant> findByProduct(Product product);
}

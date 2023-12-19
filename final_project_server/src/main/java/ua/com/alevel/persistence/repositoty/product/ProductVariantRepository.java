package ua.com.alevel.persistence.repositoty.product;

import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.persistence.repositoty.BaseRepository;

import java.util.List;

public interface ProductVariantRepository extends BaseRepository<ProductVariant> {

    List<ProductVariant> findAllByProduct(Product product);
}

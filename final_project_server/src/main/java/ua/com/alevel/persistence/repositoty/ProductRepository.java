package ua.com.alevel.persistence.repositoty;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.product.Product;

@Repository
public interface ProductRepository extends BaseRepository<Product> { }

package ua.com.alevel.service.product.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.persistence.repositoty.product.ProductVariantRepository;
import ua.com.alevel.service.product.ProductVariantService;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductVariantServiceImpl implements ProductVariantService {

    private final ProductVariantRepository productVariantRepository;

    @Override
    public List<ProductVariant> findByProduct(Product product) {
        return productVariantRepository.findAllByProduct(product);
    }
}

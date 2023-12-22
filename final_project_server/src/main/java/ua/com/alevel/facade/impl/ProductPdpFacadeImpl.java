package ua.com.alevel.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.api.dto.response.product.ProductPdpDto;
import ua.com.alevel.facade.ProductPdpFacade;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.service.product.ProductService;
import ua.com.alevel.service.product.ProductVariantService;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductPdpFacadeImpl implements ProductPdpFacade {

    private final ProductVariantService productVariantService;
    private final ProductService productService;

    @Override
    public ProductPdpDto findAllByProductId(Long productId) {
        Product product = productService.findById(productId);
        List<ProductVariant> variants = productVariantService.findByProduct(product);
        return new ProductPdpDto(product, variants);
    }
}

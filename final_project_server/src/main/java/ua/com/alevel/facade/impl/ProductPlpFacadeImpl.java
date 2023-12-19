package ua.com.alevel.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.api.dto.response.product.ProductPlpDto;
import ua.com.alevel.facade.ProductPlpFacade;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.service.product.ProductService;
import ua.com.alevel.service.product.ProductVariantService;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductPlpFacadeImpl implements ProductPlpFacade {

    private final ProductService productService;
    private final ProductVariantService productVariantService;

    @Override
    public List<ProductPlpDto> findAll() {
        return productService.findAll()
                .stream()
                .map(product -> {
                    List<ProductVariant> variants = productVariantService.findByProduct(product);
                    return new ProductPlpDto(product, variants);
                })
                .toList();
    }
}

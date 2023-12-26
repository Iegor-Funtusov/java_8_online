package ua.com.alevel.facade.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.alevel.api.dto.response.product.ProductPdpDto;
import ua.com.alevel.config.bean.annotations.InjectLog;
import ua.com.alevel.config.bean.annotations.RunMethod;
import ua.com.alevel.facade.ProductPdpFacade;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.service.logging.LoggerService;
import ua.com.alevel.service.logging.LoggingLevel;
import ua.com.alevel.service.product.ProductService;
import ua.com.alevel.service.product.ProductVariantService;

import java.util.List;

@Log
@Service
public class ProductPdpFacadeImpl implements ProductPdpFacade {

    @Autowired
    private ProductVariantService productVariantService;

    @Autowired
    private ProductService productService;

    @InjectLog
    private LoggerService loggerService;

    @Override
    public ProductPdpDto findAllByProductId(Long productId) {
        loggerService.log(LoggingLevel.INFO, "User look at " + productId);
        log.info("Hello world!!!!");
        Product product = productService.findById(productId);
        List<ProductVariant> variants = productVariantService.findByProduct(product);
        return new ProductPdpDto(product, variants);
    }

    @RunMethod
    private void test() {
        System.out.println("ProductPdpFacadeImpl.test");
    }
}

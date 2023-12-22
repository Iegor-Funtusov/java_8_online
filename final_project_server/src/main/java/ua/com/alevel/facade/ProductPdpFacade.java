package ua.com.alevel.facade;

import ua.com.alevel.api.dto.response.product.ProductPdpDto;

public interface ProductPdpFacade {

    ProductPdpDto findAllByProductId(Long productId);
}

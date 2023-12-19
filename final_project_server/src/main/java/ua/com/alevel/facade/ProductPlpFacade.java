package ua.com.alevel.facade;

import ua.com.alevel.api.dto.response.product.ProductPlpDto;

import java.util.List;

public interface ProductPlpFacade {

    List<ProductPlpDto> findAll();
}

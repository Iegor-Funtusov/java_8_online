package ua.com.alevel.service.product.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.exception.EntityNotFoundException;
import ua.com.alevel.exception.EntityUnexistsException;
import ua.com.alevel.exception.NotValidFieldDataException;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.repositoty.product.ProductRepository;
import ua.com.alevel.service.product.ProductService;

import java.util.List;

import static ua.com.alevel.util.ExceptionUtil.*;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void create(Product entity) {
        if (entity == null) {
            throw new EntityUnexistsException(ENTITY_UNEXISTS_EXCEPTION);
        }
        if (entity.getName() == null) {
            throw new NotValidFieldDataException(NOT_VALID_FIELD_DATA_EXCEPTION);
        }
        productRepository.save(entity);
    }

    @Override
    public Product findById(Long id) {
        if (id == null) {
            throw new NotValidFieldDataException(NOT_VALID_ID_EXCEPTION);
        }
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND_EXCEPTION));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}

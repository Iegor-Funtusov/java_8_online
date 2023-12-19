package ua.com.alevel.service.product;

import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.service.CrudService;
import ua.com.alevel.service.FindAllService;

public interface ProductService extends CrudService<Product>, FindAllService<Product> { }

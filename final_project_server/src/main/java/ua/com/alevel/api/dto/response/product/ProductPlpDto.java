package ua.com.alevel.api.dto.response.product;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.api.dto.response.ResponseDto;
import ua.com.alevel.exception.NotValidFieldDataException;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductImage;
import ua.com.alevel.persistence.entity.product.ProductVariant;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProductPlpDto extends ResponseDto {

    private String name;
    private String image;
    private String minPrice;
    private String maxPrice;

    public ProductPlpDto(Product product, List<ProductVariant> variants) {
        setId(product.getId());
        setName(product.getName());
        Set<ProductImage> images = product.getProductImages();
        if (CollectionUtils.isNotEmpty(images)) {
            ProductImage productImage = images
                    .stream()
                    .filter(ProductImage::getMainImage)
                    .findFirst()
                    .orElseThrow(() -> new NotValidFieldDataException("Main image is not exist"));
            this.image = productImage.getImageUrl();
        }
        if (CollectionUtils.isEmpty(variants)) {
            throw new NotValidFieldDataException("Product variants is not present");
        }
        ProductVariant max = variants.stream().max(ProductVariant::compareTo).get();
        ProductVariant min = variants.stream().min(ProductVariant::compareTo).get();
        this.minPrice = min.getPrice().toString();
        this.maxPrice = max.getPrice().toString();
    }
}

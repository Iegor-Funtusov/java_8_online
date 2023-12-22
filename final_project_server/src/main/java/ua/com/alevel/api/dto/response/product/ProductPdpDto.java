package ua.com.alevel.api.dto.response.product;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.api.dto.response.ResponseDto;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductImage;
import ua.com.alevel.persistence.entity.product.ProductVariant;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProductPdpDto extends ResponseDto {

    private String name;
    private String description;
    private String displayResolution;
    private String camera;
    private String battery;
    private List<String> images;
    private List<ProductVariantDto> variants;

    public ProductPdpDto(Product product, List<ProductVariant> variants) {
        setId(product.getId());
        setName(product.getName());
        setDescription(product.getDescription());
        setDisplayResolution(product.getDisplayResolution());
        Set<ProductImage> images = product.getProductImages();
        if (CollectionUtils.isNotEmpty(images)) {
            this.images = images.stream().map(ProductImage::getImageUrl).toList();
        }
        if (CollectionUtils.isNotEmpty(variants)) {
            setCamera(variants.stream().findFirst().get().getCamera());
            setBattery(variants.stream().findFirst().get().getBattery());
            this.variants = variants.stream().map(ProductVariantDto::new).toList();
        }
    }

}

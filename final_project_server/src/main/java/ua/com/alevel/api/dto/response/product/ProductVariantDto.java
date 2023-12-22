package ua.com.alevel.api.dto.response.product;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.api.dto.response.ResponseDto;
import ua.com.alevel.persistence.entity.product.ProductColor;
import ua.com.alevel.persistence.entity.product.ProductVariant;

@Getter
@Setter
public class ProductVariantDto extends ResponseDto {
    private String cpu;
    private Integer ram;
    private Integer ssd;
    private String price;
    private String color;

    public ProductVariantDto(ProductVariant variant) {
        setId(variant.getId());
        this.cpu = variant.getCpu();
        this.ram = variant.getRam();
        this.ssd = variant.getSsd();
        this.price = variant.getPrice().toString();
        ProductColor productColor = variant.getProductColor();
        if (productColor != null) {
            this.color = productColor.getColor();
        }
    }
}

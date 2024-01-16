package ua.com.alevel.api.dto.response.cart;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.api.dto.response.ResponseDto;

@Getter
@Setter
public class CartEntryDto extends ResponseDto {

    private String name;
    private String image;
    private Integer quantity;
    private String price;
}

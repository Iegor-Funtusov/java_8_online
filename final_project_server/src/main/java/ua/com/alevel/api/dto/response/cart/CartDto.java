package ua.com.alevel.api.dto.response.cart;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.api.dto.response.ResponseDto;

import java.util.List;

@Getter
@Setter
public class CartDto extends ResponseDto {

    private Boolean active;
    private Integer totalQuantity;
    private Integer totalPrice;
    private List<CartEntryDto> entries;
}

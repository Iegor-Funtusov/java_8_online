package ua.com.alevel.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequestDto {

    private int page;
    private int size;
    private String sortBy;
    private String sortType;
}

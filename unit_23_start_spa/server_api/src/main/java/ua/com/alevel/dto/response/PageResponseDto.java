package ua.com.alevel.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class PageResponseDto<RESPONSE extends ResponseDto> {

    private int totalPages;
    private long totalElements;
    private int currentPage;
    private int pageSize;
    private boolean isFirst;
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;
    private String sortBy;
    private String sortType;
    private Collection<RESPONSE> items;
    private int[] sizes = new int[]{ 10, 25, 50, 100 };
}

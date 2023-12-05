package ua.com.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.dto.response.PageResponseDto;
import ua.com.alevel.dto.response.ResponseDto;

import java.util.Map;

public interface DataTableFacade<RESPONSE extends ResponseDto> {

    PageResponseDto<RESPONSE> findAll(WebRequest webRequest, Map<String, Object> paramMap);
}

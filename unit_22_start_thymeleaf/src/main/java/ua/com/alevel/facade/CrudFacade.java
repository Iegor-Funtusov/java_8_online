package ua.com.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.dto.request.RequestDto;
import ua.com.alevel.dto.response.PageResponseDto;
import ua.com.alevel.dto.response.ResponseDto;

public interface CrudFacade<REQUEST extends RequestDto, RESPONSE extends ResponseDto> {

    void create(REQUEST request);
    void update(REQUEST request, Long id);
    void delete(Long id);
    RESPONSE findById(Long id);
    PageResponseDto<RESPONSE> findAll(WebRequest webRequest);
}

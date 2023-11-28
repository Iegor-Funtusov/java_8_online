package ua.com.alevel.facade;

import ua.com.alevel.dto.request.RequestDto;
import ua.com.alevel.dto.response.ResponseDto;

public interface CrudFacade<REQUEST extends RequestDto, RESPONSE extends ResponseDto> {

    void create(REQUEST request);
    void update(REQUEST request, Long id);
    void delete(Long id);
    RESPONSE findById(Long id);
}

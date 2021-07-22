package sgm.test.facade.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sgm.test.facade.BookshelfFacade;
import sgm.test.mapper.BookshelfMapper;
import sgm.test.service.BookshelfService;
import sgm.test.web.dto.BookshelfWebDto;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BookshelfFacadeImp implements BookshelfFacade {

    private final BookshelfService service;
    private final BookshelfMapper mapper;

    public List<BookshelfWebDto> findAll() {
        return mapper.toWebDtoList(service.findAll());
    }
}

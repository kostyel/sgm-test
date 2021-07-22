package sgm.test.facade.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sgm.test.facade.BookshelfFacade;
import sgm.test.facade.LevelFacade;
import sgm.test.mapper.BookshelfMapper;
import sgm.test.mapper.LevelMapper;
import sgm.test.service.BookshelfService;
import sgm.test.service.LevelService;
import sgm.test.web.dto.BookshelfWebDto;
import sgm.test.web.dto.LevelWebDto;

import java.util.List;

@RequiredArgsConstructor
@Component
public class LevelFacadeImp implements LevelFacade {

    private final LevelService service;
    private final LevelMapper mapper;

    public List<LevelWebDto> findAll() {
        return mapper.toWebDtoList(service.findAll());
    }
}

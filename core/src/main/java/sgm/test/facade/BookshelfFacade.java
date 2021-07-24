package sgm.test.facade;

import sgm.test.web.dto.BookshelfWebDto;

import java.util.List;

public interface BookshelfFacade {

    /**
     * Найти все значения полок
     *
     * @return список полок
     */
    List<BookshelfWebDto> findAll();

}

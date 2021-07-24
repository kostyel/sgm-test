package sgm.test.service;

import sgm.test.dto.BookshelfDto;

import java.util.List;

public interface BookshelfService {

    /**
     * Найти все значения полок
     *
     * @return список полок
     */
    List<BookshelfDto> findAll();

    /**
     * Проверка наличия полки в хранилище
     *
     * @param id id полки
     * @return
     */
    Boolean checkBookshelf(Long id);

}

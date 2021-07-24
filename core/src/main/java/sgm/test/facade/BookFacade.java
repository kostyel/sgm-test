package sgm.test.facade;

import sgm.test.web.dto.BookWebDto;

import java.util.List;

public interface BookFacade {
    /**
     * Поиск книги по id
     *
     * @param id id книги
     * @return Веб модель книги
     */
    BookWebDto findById(Long id);

    /**
     * Поиск книг с фильтром по id полки и уровня
     *
     * @param bookshelfId id полки
     * @param levelId     id уровня
     * @param page        номер страницы
     * @param size        количество записей
     * @return Список книг
     */
    List<BookWebDto> findByBookshelfOrLevel(Long bookshelfId, Long levelId, int page, int size);

    /**
     * Добавить новую книгу
     *
     * @param webDto Веб модель книги
     * @return Веб модель книги
     */
    BookWebDto addBook(BookWebDto webDto);

    /**
     * Удаление книги по id
     *
     * @param id id книги
     */
    void deleteBook(Long id);

    /**
     * Обновление информации о книге
     *
     * @param webDto Веб модель книги
     * @return Обновленная веб модель книги
     */
    BookWebDto updateBook(BookWebDto webDto);

    /**
     * Поиск книги по названию
     *
     * @param name Название книги
     * @return Список книг
     */
    List<BookWebDto> search(String name, int page, int size);

}

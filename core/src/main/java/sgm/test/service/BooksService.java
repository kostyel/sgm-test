package sgm.test.service;

import sgm.test.dto.BookDto;

import java.util.List;

public interface BooksService {

    /**
     * Поиск книги по id
     *
     * @param id id книги
     * @return Модель книги
     */
    BookDto findById(Long id);

    /**
     * Поиск книг с фильтром по id полки и уровня
     *
     * @param bookshelfId id полки
     * @param levelId     id уровня
     * @param page        номер страницы
     * @param size        количество записей на странице
     * @return Список книг
     */
    List<BookDto> findByBookshelfOrLevel(Long bookshelfId, Long levelId, int page, int size);

    /**
     * Валидация значений книги
     *
     * @param dto Модель книги
     */
    void validBook(BookDto dto);

    /**
     * Сохранение книги
     *
     * @param dto Модель книги
     * @return Модель книги
     */
    BookDto addBook(BookDto dto);

    /**
     * Удаление книги по id
     *
     * @param id id книги
     */
    void deleteBook(Long id);

    /**
     * Обновление информации о книге
     * @param dto Модель книги
     * @return Обновленная модель книги
     */
    BookDto update(BookDto dto);

    /**
     * Поиск книги по названию
     *
     * @param name Название книги
     * @return Список книг
     */
    List<BookDto> search(String name, int page, int size);

}

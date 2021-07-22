package sgm.test.facade.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import sgm.test.dto.BookDto;
import sgm.test.facade.BookFacade;
import sgm.test.mapper.BookMapper;
import sgm.test.service.BooksService;
import sgm.test.service.BookshelfService;
import sgm.test.service.LevelService;
import sgm.test.web.dto.BookWebDto;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class BookFacadeImp implements BookFacade {

    private final BooksService booksService;
    private final BookshelfService bookshelfService;
    private final LevelService levelService;
    private final BookMapper bookMapper;

    public BookWebDto findById(Long id) {
        BookDto dto = booksService.findById(id);
        log.debug("Получена книга: {}", dto);
        return bookMapper.toWebDto(dto);
    }

    public List<BookWebDto> findByBookshelfOrLevel(Long bookshelfId, Long levelId) {
        chekBookshelfAndLevel(bookshelfId,levelId);
        List<BookDto> dtoList = booksService.findByBookshelfOrLevel(bookshelfId, levelId);
        log.debug("Получен список книг в количестве {} штук", dtoList.size());
        return bookMapper.toWebDtoList(dtoList);
    }

    public BookWebDto addBook(BookWebDto webDto) {
        booksService.validBook(bookMapper.toDto(webDto));
        chekBookshelfAndLevel(webDto.getBookshelf(), webDto.getLevel());
        BookDto bookDto = booksService.addBook(bookMapper.toDto(webDto));
        log.debug("Книга сохранена в хранилище, присвоен id {}", bookDto.getId());
        return bookMapper.toWebDto(bookDto);
    }

    public void deleteBook(Long id) {
        booksService.deleteBook(id);
        log.debug("Книга с id: {} удалена", id);
    }

    public BookWebDto updateBook(BookWebDto webDto) {
        booksService.validBook(bookMapper.toDto(webDto));
        chekBookshelfAndLevel(webDto.getBookshelf(), webDto.getLevel());
        BookDto dto = booksService.update(bookMapper.toDto(webDto));
        log.debug("Книга успешно сохранена в хранилище: {}", dto);
        return bookMapper.toWebDto(dto);
    }

    public List<BookWebDto> search(String name) {
        List<BookDto> dtoList = booksService.search(name);
        log.debug("Из хранилища получен список книг в размере: {}", dtoList.size());
        return bookMapper.toWebDtoList(dtoList);
    }

    private void chekBookshelfAndLevel(Long bookshelfId, Long levelId) {
        if (bookshelfId != null && bookshelfService.checkBookshelf(bookshelfId)) {
            //TODO Обработку ошибки
        }
        if (levelId != null && levelService.checkLevel(levelId)){
            //TODO Обработку ошибки
        }
    }
}

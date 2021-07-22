package sgm.test.web.controller.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import sgm.test.facade.BookFacade;
import sgm.test.web.controller.BooksController;
import sgm.test.web.dto.BookWebDto;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class BooksControllerImp implements BooksController {

    private final BookFacade facade;

    public ResponseEntity<BookWebDto> findById(Long id) {
        log.debug("Получен запрос на получение книги по id:{}", id);
        return ResponseEntity.ok(facade.findById(id));
    }

    public ResponseEntity<List<BookWebDto>> findByBookshelfOrLevel(Long bookshelfId, Long levelId) {
        log.debug("Получен запрос на поиск книг по id полки:{} и уровня:{}", bookshelfId, levelId);
        return ResponseEntity.ok(facade.findByBookshelfOrLevel(bookshelfId, levelId));
    }

    public ResponseEntity<BookWebDto> addBook(BookWebDto webDto) {
        log.debug("Получен запрос на сохранение книги book:{}", webDto);
        return ResponseEntity.ok(facade.addBook(webDto));
    }

    public void deleteBook(Long id) {
        log.debug("Получен запрос на удаление книги id:{}", id);
        facade.deleteBook(id);
    }

    public ResponseEntity<BookWebDto> updateBook(BookWebDto webDto) {
        log.debug("Получен запрос на обновление информации о книге book:{}", webDto);
        return ResponseEntity.ok(facade.updateBook(webDto));
    }

    public ResponseEntity<List<BookWebDto>> search(String name) {
        log.debug("Получен запрос на поиск книги по названию: {}", name);
        return ResponseEntity.ok(facade.search(name));
    }
}

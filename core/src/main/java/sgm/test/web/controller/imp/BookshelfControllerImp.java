package sgm.test.web.controller.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import sgm.test.facade.BookshelfFacade;
import sgm.test.web.controller.BookshelfController;
import sgm.test.web.dto.BookshelfWebDto;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class BookshelfControllerImp implements BookshelfController {

    private final BookshelfFacade facade;

    public ResponseEntity<List<BookshelfWebDto>> findAll() {
        log.debug("Получен запрос на получение списка Полок");
        List<BookshelfWebDto> list = facade.findAll();
        return ResponseEntity.ok(list);
    }
}

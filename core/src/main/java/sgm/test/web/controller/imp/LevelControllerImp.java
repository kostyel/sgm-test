package sgm.test.web.controller.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import sgm.test.facade.BookshelfFacade;
import sgm.test.facade.LevelFacade;
import sgm.test.web.controller.BookshelfController;
import sgm.test.web.controller.LevelController;
import sgm.test.web.dto.BookshelfWebDto;
import sgm.test.web.dto.LevelWebDto;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class LevelControllerImp implements LevelController {

    private final LevelFacade facade;

    public ResponseEntity<List<LevelWebDto>> findAll() {
        log.debug("Получен запрос на получение списка Уровней");
        List<LevelWebDto> list = facade.findAll();
        return ResponseEntity.ok(list);
    }
}

package sgm.test.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgm.test.web.dto.BookshelfWebDto;

import java.util.List;

@Tag(name = "Полки")
@RestController
@RequestMapping(value = "/api/bookshelf")
public interface BookshelfController {

    @Operation(summary = "Получение списка полок")
    @GetMapping("/all")
    ResponseEntity<List<BookshelfWebDto>> findAll();

}

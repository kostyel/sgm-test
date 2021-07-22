package sgm.test.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sgm.test.web.dto.BookWebDto;

import java.util.List;

@Tag(name = "Книги")
@RestController
@RequestMapping(path = "/api/books")
public interface BooksController {

    @Operation(summary = "Поиск книги по id")
    @GetMapping("/{id}")
    ResponseEntity<BookWebDto> findById(@PathVariable Long id);

    @Operation(summary = "Получение списка книг по id стеллажа или уровня, или и того и другого")
    @PostMapping("/findByBookshelfOrLevel")
    ResponseEntity<List<BookWebDto>> findByBookshelfOrLevel(@RequestParam(required = false) Long bookshelfId,
                                                            @RequestParam(required = false) Long levelId);

    @Operation(summary = "Добавление книги")
    @PutMapping("/add")
    ResponseEntity<BookWebDto> addBook(@RequestBody BookWebDto webDto);

    @Operation(summary = "Удаление книги по id")
    @DeleteMapping("/deleteBook")
    void deleteBook(@RequestParam Long id);

    @Operation(summary = "Обновление информации по книги")
    @PostMapping("/update")
    ResponseEntity<BookWebDto> updateBook(@RequestBody BookWebDto webDto);

    @Operation(summary = "Поиск книги по названию")
    @GetMapping("/search/{name}")
    ResponseEntity<List<BookWebDto>> search(@PathVariable String name);

}

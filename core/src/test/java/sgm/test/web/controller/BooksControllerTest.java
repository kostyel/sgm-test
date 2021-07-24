package sgm.test.web.controller;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import sgm.test.exception.*;
import sgm.test.web.dto.*;

import javax.validation.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BooksControllerTest {

    @Autowired
    private BooksController booksController;

    @Test
    public void findById() {
        try {
            this.booksController.findById(0L);
        } catch (NotFoundException exception) {
            assertThat(exception)
                    .isNotNull()
                    .matches(ex -> ex.getMessage().equals("Книга с id = 0 не найдена"), "txt err msg");
        }
    }

    @Test
    public void findByBookshelfOrLevel() {
        ResponseEntity<List<BookWebDto>> response = this.booksController
                .findByBookshelfOrLevel(1L, 1L, 0, 10);
        assertThat(response)
                .isNotNull()
                .matches(responseEntity -> responseEntity.getStatusCode().equals(HttpStatus.OK), "status code");
    }

    @Test
    public void addBook() {
        BookWebDto newBook = TestData.Book.NEW_BOOK_1;
        newBook.setBookshelf(null);
        try {
            this.booksController.addBook(newBook);
        } catch (ConstraintViolationException exception) {
            assertThat(exception)
                    .isNotNull()
                    .matches(ex -> ex.getMessage().equals("bookshelf: не должно равняться null"), "txt err msg");
        }
        newBook.setBookshelf(1L);
        newBook.setLevel(null);
        try {
            this.booksController.addBook(newBook);
        } catch (ConstraintViolationException exception) {
            assertThat(exception)
                    .isNotNull()
                    .matches(ex -> ex.getMessage().equals("level: не должно равняться null"), "txt err msg");
        }
        newBook.setLevel(1L);
        newBook.setBookshelf(0L);
        try {
            this.booksController.addBook(newBook);
        } catch (NotFoundException exception) {
            assertThat(exception)
                    .isNotNull()
                    .matches(ex -> ex.getMessage().equals("Полка с id = 0 не найдена"), "txt err msg");
        }
        newBook.setLevel(0L);
        newBook.setBookshelf(1L);
        try {
            this.booksController.addBook(newBook);
        } catch (NotFoundException exception) {
            assertThat(exception)
                    .isNotNull()
                    .matches(ex -> ex.getMessage().equals("Уровень с id = 0 не найдена"), "txt err msg");
        }
        newBook.setLevel(1L);
    }

    @Test
    public void deleteBook() {
        try {
            this.booksController.deleteBook(0L);
        } catch (NotFoundException exception) {
            assertThat(exception)
                    .isNotNull()
                    .matches(ex -> ex.getMessage().equals("Книга с id = 0 не найдена"), "txt err msg");
        }
    }

    @Test
    public void updateBook() {
        BookWebDto newBook = TestData.Book.NEW_BOOK_1;
        newBook.setId(0L);
        try {
            this.booksController.updateBook(newBook);
        } catch (NotFoundException exception) {
            assertThat(exception)
                    .isNotNull()
                    .matches(ex -> ex.getMessage().equals("Книга с id = 0 не найдена"), "txt err msg");
        }
        newBook.setId(1L);
        newBook.setBookshelf(null);
        try {
            this.booksController.updateBook(newBook);
        } catch (ConstraintViolationException exception) {
            assertThat(exception)
                    .isNotNull()
                    .matches(ex -> ex.getMessage().equals("bookshelf: не должно равняться null"), "txt err msg");
        }
        newBook.setBookshelf(1L);
        newBook.setLevel(null);
        try {
            this.booksController.updateBook(newBook);
        } catch (ConstraintViolationException exception) {
            assertThat(exception)
                    .isNotNull()
                    .matches(ex -> ex.getMessage().equals("level: не должно равняться null"), "txt err msg");
        }
        newBook.setLevel(1L);
        newBook.setBookshelf(0L);
        try {
            this.booksController.updateBook(newBook);
        } catch (NotFoundException exception) {
            assertThat(exception)
                    .isNotNull()
                    .matches(ex -> ex.getMessage().equals("Полка с id = 0 не найдена"), "txt err msg");
        }
        newBook.setLevel(0L);
        newBook.setBookshelf(1L);
        try {
            this.booksController.updateBook(newBook);
        } catch (NotFoundException exception) {
            assertThat(exception)
                    .isNotNull()
                    .matches(ex -> ex.getMessage().equals("Уровень с id = 0 не найдена"), "txt err msg");
        }
        newBook.setLevel(1L);
    }

    @Test
    public void search() {
        BookWebDto newBook = TestData.Book.NEW_BOOK_1;
        ResponseEntity<BookWebDto> responseAddBook = this.booksController.addBook(newBook);
        assertThat(responseAddBook)
                .isNotNull()
                .matches(responseEntity -> responseEntity.getStatusCode().equals(HttpStatus.OK), "status code");
        BookWebDto addWebDto = responseAddBook.getBody();
        assertThat(addWebDto).isNotNull();
        ResponseEntity<List<BookWebDto>> responseSearch = this.booksController.search(addWebDto.getName(), 0, 10);
        assertThat(responseSearch)
                .isNotNull()
                .matches(responseEntity -> responseEntity.getStatusCode().equals(HttpStatus.OK), "status code");
        List<BookWebDto> bookWebDtoList = responseSearch.getBody();
        assertThat(bookWebDtoList).isNotNull();
        assertThat(bookWebDtoList.get(0).getName()).isEqualTo(newBook.getName());
        this.booksController.deleteBook(addWebDto.getId());
    }
}
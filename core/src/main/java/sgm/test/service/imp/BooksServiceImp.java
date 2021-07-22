package sgm.test.service.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sgm.test.dto.BookDto;
import sgm.test.entity.Book;
import sgm.test.mapper.BookMapper;
import sgm.test.repository.BooksRepository;
import sgm.test.service.BooksService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class BooksServiceImp implements BooksService {

    private final BooksRepository repository;
    private final BookMapper mapper;

    public BookDto findById(Long id) {
        Optional<Book> bookOptional = repository.findById(id);
        if (!bookOptional.isPresent()){
            //TODO Добавить обработку ошибки
        }
        return mapper.toDto(bookOptional.get());
    }


    public List<BookDto> findByBookshelfOrLevel(Long bookshelfId, Long levelId) {
        return null;
    }


    public void validBook(BookDto dto) {

    }


    public BookDto addBook(BookDto dto) {
        return null;
    }


    public void deleteBook(Long id) {
        if(!repository.existsById(id)){
            //TODO Добавить обработку ошибки
        }
        repository.deleteById(id);
    }


    public BookDto update(BookDto dto) {
        return null;
    }


    public List<BookDto> search(String name) {
        return null;
    }
}

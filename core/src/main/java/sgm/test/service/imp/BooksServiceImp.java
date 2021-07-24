package sgm.test.service.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.*;
import org.springframework.stereotype.Service;
import sgm.test.dto.BookDto;
import sgm.test.entity.*;
import sgm.test.exception.*;
import sgm.test.mapper.BookMapper;
import sgm.test.repository.BooksRepository;
import sgm.test.service.BooksService;

import javax.validation.*;
import java.util.*;
import java.util.stream.*;

@RequiredArgsConstructor
@Slf4j
@Service
public class BooksServiceImp implements BooksService {

    private final BooksRepository repository;
    private final BookMapper mapper;
    private final Validator validator;

    public BookDto findById(Long id) {
        Optional<Book> bookOptional = repository.findById(id);
        if (!bookOptional.isPresent()) {
            throw new NotFoundException(String.format("Книга с id = %s не найдена", id));
        }
        return mapper.toDto(bookOptional.get());
    }


    public List<BookDto> findByBookshelfOrLevel(Long bookshelfId, Long levelId, int page, int size) {
        Specification<Book> specification = Specification.where(null);
        if (bookshelfId != null) {
            specification = specification.and((root, criteriaQuery, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get(Book_.bookshelf), bookshelfId));
        }
        if (levelId != null) {
            specification = specification.and((root, criteriaQuery, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get(Book_.level), levelId));
        }
        return mapper.toDtoList(repository.findAll(specification, PageRequest.of(page, size))
                .stream().collect(Collectors.toList()));
    }


    public void validBook(BookDto dto) {
        final Set<ConstraintViolation<BookDto>> violations = this.validator.validate(dto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }


    public BookDto addBook(BookDto dto) {
        dto.setId(null);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }


    public void deleteBook(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(String.format("Книга с id = %s не найдена", id));
        }
        repository.deleteById(id);
    }

    public BookDto update(BookDto dto) {
        if (!repository.existsById(dto.getId())){
            throw new NotFoundException(String.format("Книга с id = %s не найдена", dto.getId()));
        }
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public List<BookDto> search(String name, int page, int size) {
        return mapper.toDtoList(repository.findAllByNameLike(name,PageRequest.of(page, size))
                .stream().collect(Collectors.toList()));
    }
}
